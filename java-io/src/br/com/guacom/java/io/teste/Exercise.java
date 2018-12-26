package br.com.guacom.java.io.teste;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise {
	
	public static void main(String[] args) throws IOException {
		//Ao criar Strings que representam informações do caminho, utilizar File.separator
		//Essa é uma constante que obtém o caractere de separador adequado do computador local.
		
		String target = "guacom";
		String old = "elvis";
		
		File file = new File("elvis.txt");

		if(file.renameTo(new File(old.replace(old, target)))) {
			System.out.println("Okay!!");
			
		}
		
		System.out.println(file.getAbsolutePath());
		
		System.out.println(file.getCanonicalPath());
		
		System.out.println(file.toURL() + "\n" + file.toPath());
		OutputStream fis = new FileOutputStream(file);
		Writer osr = new OutputStreamWriter(fis);
		BufferedWriter bw = new BufferedWriter(osr);
	
		bw.write("Elvis de Sousa da Guarda");
		bw.close();
		Scanner scan = new Scanner(Files.newInputStream(Paths.get("elvis.txt")));
		System.out.println(scan.nextLine());
		scan.close();
	}
}
