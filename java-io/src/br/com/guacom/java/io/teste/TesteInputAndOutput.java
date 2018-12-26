package br.com.guacom.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TesteInputAndOutput {

	private static String line;
	private static OutputStream os;
	
	public static void main(String[] args) throws IOException {
		
		
		try {
			os = new FileOutputStream("lorem2.txt");
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		OutputStreamWriter osw = new OutputStreamWriter(os); 
		
		BufferedWriter bw = new BufferedWriter(osw);
		
		try(BufferedReader br = Files.newBufferedReader(Paths.get("lorem3.txt"))){
			String linha = br.readLine();
			System.out.println(linha);
			while((linha != null)&&(br.ready())) {
				bw.write(linha);
				bw.newLine();
				linha = br.readLine();
			}
		} catch (IOException ex) {
			System.out.println(ex.getClass().getSimpleName() + " - " + ex.getMessage());
			ex.printStackTrace();
		}
		System.out.println();
		readAllLines();
		bw.close();
	}
	
	public static void readAllLines() {
		List<String> lines = null;
		try {
			//Efetuando a leitura da linha inteira
			lines = Files.readAllLines(Paths.get("lorem3.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(lines);
	}
}
