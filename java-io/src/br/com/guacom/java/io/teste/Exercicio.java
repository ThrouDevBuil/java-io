package br.com.guacom.java.io.teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Exercicio {
	
	public static void main(String[] args) throws IOException {
		InputStream fis = null;
		Reader isr = null;
		BufferedReader br = null;
		
		String path = "C:";
		String directory = path + File.separator + "Users" + File.separator 
				+ "elvis" + File.separator + "Documents" 
				+ File.separator + "pattern.txt";
		
		try {
			fis = new FileInputStream(new File(directory));
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}		
	}
}
