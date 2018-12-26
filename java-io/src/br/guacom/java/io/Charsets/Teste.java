package br.guacom.java.io.Charsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Teste {
	
	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String linha = null;
		
		//Ctrl + z = End of File
		do {
			linha = br.readLine();
			System.out.println(linha);
		} while(linha != null);
		br.close();

	}
}
