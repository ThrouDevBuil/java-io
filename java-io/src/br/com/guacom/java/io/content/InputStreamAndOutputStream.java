package br.com.guacom.java.io.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamAndOutputStream {
	
	/*
	 * A ideia atr�s do polimorfismo no pacote java.io � de utilizar fluxos de entrada
	 * (InputStream) e de sa�da (OutputStream) para toda e qualquer opera��o, seja ela
	 * relativa a um arquivo, a um campo blob do banco de dados, a uma conex�o remota
	 * via sockets, ou at� mesmo �s entrada e sa�da padr�o de um programa (teclado e o console).
	 * Ambas as classes abstratas definem, respectivamente o comportamento padr�o dos fluxos em Java: 
	 * Em um fluxo de entrada, � poss�vel ler bytes e, no fluxo de sa�da, escrever bytes.
	 * 
	 * Unicode define codepoints (um n�mero) para cada letra (ou s�mbolo)
	 * (associa um n�mero �nico para cada caractere usado nas l�nguas escritas de todo o mundo.).
	 * A responsabilidade de codificar um codepoint(unicode) em bytes � do encoding.
	 */

	/* InputStream, InputStreamReader, BufferedReader
	 * 		Para ler um byte de um arquivo, utiliza-se o leitor de arquivo, o FileInputStream
	 * 		Para criar um objeto dessa classe que possa efetuar a leitura de um byte, ele precisa saber
	 * 		de onde ele dever� ler.
	 * 		FileInputStream - procura o arquivo no diret�rio em que a JVM fora invocada (Diret�rio do projeto).
	 * 		
	 * 		O FileOutputStream pode receber um booleano como segundo par�metro, para indicar se
	 * 		voc� quer reescrever o arquivo ou manter o que j� estava escrito (append), false e true respectivamente.
	 * 		Pode-se utilizar um caminho alternativo
	 * 		
	 * 		Diversos met�dos dessa API lan�am IOException, que � uma exception do tipo checked 
	 *      (exce��es que s�o verificadas pelo compilador), esta precisa ser tratada ou declarada.
	 *      
	 *      Para recuperar um caractere � necess�rio traduzir os bytes com o encoding dado para o respectivo c�digo unicode,
	 *      quem efetua esta decodifica��o � a classe InputStreamReader
	 *      
	 *      Readers trabalham com a manipula��o de chars
	 *      
	 *      A classe BufferedReader � um Reader que recebe outro Reader pelo construtor e efetua a concatena��o dos diversos chars
	 *      para formar uma String.
	 *      			
	 *      			System.in       ----> 
	 *      Composi��o:	InputStream		byte      (char)		char      (String)
	 *      			FileInputStream ----> InputStreamReader ----> BufferedReader
	 *      			
	 *      
	 *      Decorator Pattern
	 *
	 *		O m�todo readLine devolve a linha que foi lida e muda o cursor (ponteiro) para a pr�xima linha,
	 *		quando chega ao final do arquivo ele retornar� null
	 *
	 */
	
	/*
	 * 		Composi��o:	    String       char      (char)          byte     (byte) - Escreve
	 * 					BufferedWriter  ---->  OutputStreamWriter ---->  FileOutputStream 
	 */					
	
	
	/* Fluxos em java s�o uma sequencia ordenada de dados
	 * Prov�em um modelo de entrada e sa�da comum
	 * Detalhes abstratos da fonte subjacente ou destino
	 * Os tipos de fluxos s�o unidirecionais
	 * Fluxos s�o divididos em duas categorias:
	 * 		*Fluxos de bytes - que nos d�o a representa��o bin�ria dos dados
	 * 		*Fluxos de textos - nos d�o uma representa��o baseada em caracteres dos dados  
	 * 
	 */
	public static void main(String[] args) throws IOException {

		InputStream fis = new FileInputStream(new File("lorem3.txt")); 
		//Se o encoding n�o for passado a m�quina virtual captura o do sistema operacional
		Reader isr = new InputStreamReader(fis, "UTF-8");
		int c = isr.read();
		System.out.println(Character.toChars(c));
		
	}
}
