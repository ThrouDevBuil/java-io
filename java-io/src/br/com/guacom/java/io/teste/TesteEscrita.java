package br.com.guacom.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TesteEscrita {
	private static OutputStream os;
	
	public static void main(String[] args) {
		
		try {
			os = new FileOutputStream("lorem2.txt"); 
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		OutputStreamWriter osw = new OutputStreamWriter(os); 
		
		try(BufferedWriter bw = new BufferedWriter(osw)) {
			bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
			bw.newLine();
			bw.newLine();
			bw.write("asdadsa dsafdfdsfds fdsfdsfsf");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
