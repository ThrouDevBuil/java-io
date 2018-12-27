package br.com.guacom.java.io.content;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileMethod {
	
	public static void main(String[] args) {
		
		File file = new File("directory");
		
		try {
			boolean execute = true;
			System.out.println(file.getName());
			System.out.println("--------------");
			System.out.println(file.getAbsolutePath());
			System.out.println("--------------");
			System.out.println(file.getPath());
			if(!(execute = file.exists()))
				System.out.println(file.createNewFile());
			
			System.out.println(file.isDirectory()); //Devolve um booleano se for um diretório sem arquivo ou com arquivo, false e true respectivamente
			System.out.println(file.isHidden());//Devolve um booleano se o arquivo for oculto ou não, true e false respectivamente.
			System.out.println(new Date(file.lastModified()));
			
			if(execute)
				System.out.println(file.delete());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}