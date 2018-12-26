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
		//Padr�o de Projeto (Decorator Pattern - Um objeto est� decorando a funcionalidade de um outro objeto) 
		
		//As exce��es dessa API do java s�o checkeds e precisam ser tratadas ou lan�adas para que o c�digo compile
		//Fluxo de Entrada com Arquivo
		//Efetua a leitura dos dados do arquivo
		//InputStream is a design pattern - Template(Classes que j� definem um conte�do para o filho)
		//Input stream of bytes
		//FIS = new FileInputStream("lorem.txt"); - Thrown FileNotFoundException			
			
		//ISR = new InputStreamReader(FIS);
		
		//Join characters
		//Try-with-resources
		try(BufferedReader br = new BufferedReader(Files.newBufferedReader(Paths.get("lorem.txt")))){
			String linha = br.readLine();

			//O m�todo ready() indica se o arquivo est� pronto para ser lido!
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
