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
		
		//Metódo responsável por criar um diretório
		directory.mkdir();//Caso o arquivo ou diretório já existam, ele fará referência
		
		if(Files.notExists(directory.toPath().getParent()))
			Files.createDirectory(directory.toPath());
		//System.out.println( (mkdir) ? "Diretório criado!" : "Diretório não foi criado!");
		
		//Passando o diretório que o arquivo será criado
		File file = new File(directory, "arquivo.txt");
		
		if(Files.notExists(file.toPath()))
			Files.createFile(file.toPath());
		
		boolean createNewFile = file.createNewFile();
		
		Files.deleteIfExists(file.toPath());
		
		System.out.println( (createNewFile) ? "Arquivo criado!" : "Arquivo não foi criado!");
	
		File renamed = Paths.get(directory.getParent(), "\\Arquivo_renomeado.txt").toFile();
							
							//Renomeando o arquivo
		boolean renameTo = file.renameTo(renamed);
	
		System.out.println( (renameTo) ? "Arquivo foi renomeado!" : "Arquivo não foi renomeado");
		
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
