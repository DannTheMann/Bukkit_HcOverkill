package me.danslayerx.overkill.exp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;

import me.danslayerx.overkill.Main;

public class XFile {
	
	public static void createFile(String name){
		
		File f = new File(Main.dir, name + ".txt");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write("0");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static int getExp(String name){
		File f = new File(Main.dir, name + ".txt");
		BufferedReader br = null;
		
		if(!f.exists()){
			createFile(name);
			return 0;
		}
		
		try {
			 br = new BufferedReader(new FileReader(f));
			int i = Integer.parseInt(br.readLine());
			br.close();
			return i;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			Bukkit.getPlayer(name).sendMessage(Main.title + "Failed to give you your EXP! Please report this message to Dann on the forums! AddOnGaming.com");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void setExp(String name, int exp){
		
		File f = new File(Main.dir, name + ".txt");
		
		if(!f.exists())
			createFile(name);
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write("" + exp);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
