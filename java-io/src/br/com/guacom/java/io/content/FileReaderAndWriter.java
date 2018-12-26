package br.com.guacom.java.io.content;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriter {
	/*	Buffer
	 * 		
	 *		Buffer é uma quantidade de memória de uma mídia mais rápida, usada para armazenar parte dos dados de uma mídia mais lenta.
	 *      Ele é usado para otimizar a leitura ou a gravação no caso de mídias de alta latência ou baixa velocidade 
	 *      (HD, redes, outra aplicação pesada). 
	 *      Considere, por exemplo, a escrita num HD. O HD tem um braço, que faz uma deslocamento mecânico até o ponto 
	 *      onde o dado deve ser gravado. Se você gravar byte-a-byte, forçará com que esse braço se locomova. 
	 *      Além disso, a gravação no HD é lenta.
	 *		O que você faz então? Cria uma área de memória, escreve nessa área. 
	 *		Essa é uma operação rápida, que libera o processador de sua máquina para fazer outras tarefas mais interessantes, 
	 *		como continuar a execução do seu programa. Nesse meio tempo, o hardware do HD faz a leitura dessa área, 
	 *		na velocidade dele, até que o buffer se esvazie.
	 * 		É uma região de memória us. 
	 * 		Como área de armazenamento temporário de dados durante sua transferência 
	 * 		entre dispositivos de diferentes taxas de transferência 
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
