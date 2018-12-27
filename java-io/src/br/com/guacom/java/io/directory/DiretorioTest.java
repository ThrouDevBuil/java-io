package br.com.guacom.java.io.directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DiretorioTest {
	
	public static void main(String[] args) throws IOException {
		
		File directory = Paths.get("directory2").toFile();
		
		//Met�do respons�vel por criar um diret�rio
		directory.mkdir();//Caso o arquivo ou diret�rio j� existam, ele far� refer�ncia
		
		if(Files.notExists(directory.toPath().getParent()))
			Files.createDirectory(directory.toPath());
		//System.out.println( (mkdir) ? "Diret�rio criado!" : "Diret�rio n�o foi criado!");
		
		//Passando o diret�rio que o arquivo ser� criado
		File file = new File(directory, "arquivo.txt");
		
		if(Files.notExists(file.toPath()))
			Files.createFile(file.toPath());
		
		boolean createNewFile = file.createNewFile();
		
		Files.deleteIfExists(file.toPath());
		
		System.out.println( (createNewFile) ? "Arquivo criado!" : "Arquivo n�o foi criado!");
	
		File renamed = Paths.get(directory.getParent(), "\\Arquivo_renomeado.txt").toFile();
							
							//Renomeando o arquivo
		boolean renameTo = file.renameTo(renamed);
	
		System.out.println( (renameTo) ? "Arquivo foi renomeado!" : "Arquivo n�o foi renomeado");
		
		File newDirectory = Paths.get("directory2").toFile();
		
		directory.renameTo(newDirectory);
		searchFiles();
	}
	
	public static void searchFiles() {
		List<String> files = Arrays.asList(new File("directory2").list());
		System.out.println("_____________________");
		files.forEach(action -> {
			System.out.println(action);
		});
	}
}
