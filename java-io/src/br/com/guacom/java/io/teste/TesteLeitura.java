package br.com.guacom.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TesteLeitura {
	//CTRL + D = Apaga uma linha
	
	public static void main(String[] args) {
		//Padrão de Projeto (Decorator Pattern - Um objeto está decorando a funcionalidade de um outro objeto) 
		
		//As exceções dessa API do java são checkeds e precisam ser tratadas ou lançadas para que o código compile
		//Fluxo de Entrada com Arquivo
		//Efetua a leitura dos dados do arquivo
		//InputStream is a design pattern - Template(Classes que já definem um conteúdo para o filho)
		//Input stream of bytes
		//FIS = new FileInputStream("lorem.txt"); - Thrown FileNotFoundException			
			
		//ISR = new InputStreamReader(FIS);
		
		//Join characters
		//Try-with-resources
		try(BufferedReader br = new BufferedReader(Files.newBufferedReader(Paths.get("lorem.txt")))){
			String linha = br.readLine();

			//O método ready() indica se o arquivo está pronto para ser lido!
			while((linha != null)&&(br.ready())) {
				System.out.println(linha);
				linha = br.readLine();
			}			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
