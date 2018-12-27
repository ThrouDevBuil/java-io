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
		
		String target = "companyGuacom.txt";
		
		
		
		File file = new File("elvis.txt");
		File f = new File(target);
		if(file.renameTo(f)) {
			System.out.println("Okay!!");
			
		}
		
		System.out.println(f.getAbsolutePath());
		
		System.out.println(f.getCanonicalPath());
		
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
