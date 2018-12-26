package br.guacom.java.io.Charsets;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeAndEncoding {
//	Unicode � um conjunto de caracteres (�character set� ou apenas �charset�), 
//	ou seja, um padr�o que define em um �nico conjunto, todos os caracteres necess�rios 
//	para escrever a maioria das l�nguas atuais em uso em computadores hoje.
//	Charset - � o conjunto de caracteres que s�o utilizados para a cria��o de documentos, banco de dados, sistemas..
//	Unicode fornece um n�mero �nico para cada caracter (codepoint),
//	n�o importa a plataforma,
//	n�o importa o programa,
//	n�o importa a l�ngua.
//	O �character encoding�, ou apenas �encoding� � a maneira com que os 
//	conjuntos de caracteres s�o mapeados e manipulados pelas m�quinas (Define como os bytes ser�o gravados nos arquivos).
//	Encodings s�o tabelas que transformam cada codepoint em seu caracter espec�fico.
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "�";
							//Valor decimal
		System.out.println(s.codePointAt(s.indexOf(s.substring(0))));
		
		//Representa um encoding
		Charset charset = Charset.defaultCharset();
		System.out.println(charset.displayName());
		
		//Transformando o caracter da String em bytes
		byte[] bytes = s.getBytes(charset);
		System.out.print(bytes.length + ", " + charset.displayName() + ", ");
		String sNovo = new String(bytes, "windows-1252");
		System.out.println(sNovo);
		
		bytes = s.getBytes(StandardCharsets.UTF_16);
		System.out.print(bytes.length + ", UTF-16, ");
		sNovo = new String(bytes, StandardCharsets.UTF_16);
		System.out.println(sNovo);
		
		
		bytes = s.getBytes(StandardCharsets.US_ASCII);
		System.out.print(bytes.length + ", " + StandardCharsets.US_ASCII.toString() + ", ");
		sNovo = new String(bytes, "windows-1252");
		System.out.println(sNovo);

		System.out.println(new String("�".getBytes("UTF-8"), "ISO-8859-1"));
		
		System.out.println(new String("�".getBytes("ISO-8859-1"), "UTF-8"));
		
//		String[] codes = { "ISO-8859-1", "UTF-8", "UTF-16" };
//		String palavra = "�";
//		 
//		for (String encoding : codes) {
//		  byte[] b = palavra.getBytes(encoding);
//		  System.out.printf("%10s\t%d\t", encoding, b.length);
//		  for (int k = 0; k < b.length; k++) {
//		    String hex = Integer.toHexString((b[k] + 256) % 256);
//		    if (hex.length() == 1)
//		      hex = "0" + hex;
//		    System.out.print(hex);
//		  }
//		  System.out.println();
//		}
//		System.out.println(Charset.availableCharsets());
	}
}
