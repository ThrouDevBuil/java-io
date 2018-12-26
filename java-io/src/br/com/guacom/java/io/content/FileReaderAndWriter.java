package br.com.guacom.java.io.content;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriter {
	/*	Buffer
	 * 		
	 *		Buffer � uma quantidade de mem�ria de uma m�dia mais r�pida, usada para armazenar parte dos dados de uma m�dia mais lenta.
	 *      Ele � usado para otimizar a leitura ou a grava��o no caso de m�dias de alta lat�ncia ou baixa velocidade 
	 *      (HD, redes, outra aplica��o pesada). 
	 *      Considere, por exemplo, a escrita num HD. O HD tem um bra�o, que faz uma deslocamento mec�nico at� o ponto 
	 *      onde o dado deve ser gravado. Se voc� gravar byte-a-byte, for�ar� com que esse bra�o se locomova. 
	 *      Al�m disso, a grava��o no HD � lenta.
	 *		O que voc� faz ent�o? Cria uma �rea de mem�ria, escreve nessa �rea. 
	 *		Essa � uma opera��o r�pida, que libera o processador de sua m�quina para fazer outras tarefas mais interessantes, 
	 *		como continuar a execu��o do seu programa. Nesse meio tempo, o hardware do HD faz a leitura dessa �rea, 
	 *		na velocidade dele, at� que o buffer se esvazie.
	 * 		� uma regi�o de mem�ria us. 
	 * 		Como �rea de armazenamento tempor�rio de dados durante sua transfer�ncia 
	 * 		entre dispositivos de diferentes taxas de transfer�ncia 
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		File file =  new File("Arquivo.txt");
	
		try(FileWriter writer = new FileWriter(file, true);
			FileReader reader = new FileReader(file)) {
			
			writer.write("Escrevendo uma mensagem no arquivo\nE pulando uma linha 1");
			writer.flush();//Liberando o buffer
			char[] in = new char[500];
			
			int size = reader.read(in);
			System.out.println("Tamanho - " + size);
			for(char c : in)
				System.out.print(c);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
