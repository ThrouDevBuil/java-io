package br.com.guacom.java.io.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamAndOutputStream {
	
	/*
	 * A ideia atrás do polimorfismo no pacote java.io é de utilizar fluxos de entrada
	 * (InputStream) e de saída (OutputStream) para toda e qualquer operação, seja ela
	 * relativa a um arquivo, a um campo blob do banco de dados, a uma conexão remota
	 * via sockets, ou até mesmo às entrada e saída padrão de um programa (teclado e o console).
	 * Ambas as classes abstratas definem, respectivamente o comportamento padrão dos fluxos em Java: 
	 * Em um fluxo de entrada, é possível ler bytes e, no fluxo de saída, escrever bytes.
	 * 
	 * Unicode define codepoints (um número) para cada letra (ou símbolo)
	 * (associa um número único para cada caractere usado nas línguas escritas de todo o mundo.).
	 * A responsabilidade de codificar um codepoint(unicode) em bytes é do encoding.
	 */

	/* InputStream, InputStreamReader, BufferedReader
	 * 		Para ler um byte de um arquivo, utiliza-se o leitor de arquivo, o FileInputStream
	 * 		Para criar um objeto dessa classe que possa efetuar a leitura de um byte, ele precisa saber
	 * 		de onde ele deverá ler.
	 * 		FileInputStream - procura o arquivo no diretório em que a JVM fora invocada (Diretório do projeto).
	 * 		
	 * 		O FileOutputStream pode receber um booleano como segundo parâmetro, para indicar se
	 * 		você quer reescrever o arquivo ou manter o que já estava escrito (append), false e true respectivamente.
	 * 		Pode-se utilizar um caminho alternativo
	 * 		
	 * 		Diversos metódos dessa API lançam IOException, que é uma exception do tipo checked 
	 *      (exceções que são verificadas pelo compilador), esta precisa ser tratada ou declarada.
	 *      
	 *      Para recuperar um caractere é necessário traduzir os bytes com o encoding dado para o respectivo código unicode,
	 *      quem efetua esta decodificação é a classe InputStreamReader
	 *      
	 *      Readers trabalham com a manipulação de chars
	 *      
	 *      A classe BufferedReader é um Reader que recebe outro Reader pelo construtor e efetua a concatenação dos diversos chars
	 *      para formar uma String.
	 *      			
	 *      			System.in       ----> 
	 *      Composição:	InputStream		byte      (char)		char      (String)
	 *      			FileInputStream ----> InputStreamReader ----> BufferedReader
	 *      			
	 *      
	 *      Decorator Pattern
	 *
	 *		O método readLine devolve a linha que foi lida e muda o cursor (ponteiro) para a próxima linha,
	 *		quando chega ao final do arquivo ele retornará null
	 *
	 */
	
	/*
	 * 		Composição:	    String       char      (char)          byte     (byte) - Escreve
	 * 					BufferedWriter  ---->  OutputStreamWriter ---->  FileOutputStream 
	 */					
	
	
	/* Fluxos em java são uma sequencia ordenada de dados
	 * Provêem um modelo de entrada e saída comum
	 * Detalhes abstratos da fonte subjacente ou destino
	 * Os tipos de fluxos são unidirecionais
	 * Fluxos são divididos em duas categorias:
	 * 		*Fluxos de bytes - que nos dão a representação binária dos dados
	 * 		*Fluxos de textos - nos dão uma representação baseada em caracteres dos dados  
	 * 
	 */
	public static void main(String[] args) throws IOException {

		InputStream fis = new FileInputStream(new File("lorem3.txt")); 
		//Se o encoding não for passado a máquina virtual captura o do sistema operacional
		Reader isr = new InputStreamReader(fis, "UTF-8");
		int c = isr.read();
		System.out.println(Character.toChars(c));
		
	}
}
