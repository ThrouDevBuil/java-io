package br.com.guacom.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TesteInAndOut {
	
	public static void main(String[] args) throws IOException {

//		A API java.io fornece classes abstratas genéricas tanto para leitura (InputStream e Reader) 
//		quanto para escrita (OutputStream e Writer). 
//		Com as classes abstratas não precisamos saber qual a implementação será usada na execução do código.
		
						   //Console				//Escreve no arquivo em questão.
		OutputStream fos = /*System.out;*/ new FileOutputStream(new File("lorem3.txt"), false);
		Writer ow = new /*Adaptador*/OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(ow);
						  //Console			//Esta classe pega um arquivo
		InputStream fis = /*System.in;*/ new FileInputStream("lorem2.txt");
		Reader isr = new /*Transforma os dados binários em caracteres - Adaptador*/InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		String line = br.readLine();
		while( (line != null)&&(!line.isEmpty())) {
			bw.write(line);
			bw.newLine();
			line = br.readLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
