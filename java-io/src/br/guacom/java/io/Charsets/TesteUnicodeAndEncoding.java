package br.guacom.java.io.Charsets;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeAndEncoding {
//	Unicode é um conjunto de caracteres (“character set” ou apenas “charset”), 
//	ou seja, um padrão que define em um único conjunto, todos os caracteres necessários 
//	para escrever a maioria das línguas atuais em uso em computadores hoje.
//	Charset - é o conjunto de caracteres que são utilizados para a criação de documentos, banco de dados, sistemas..
//	Unicode fornece um número único para cada caracter (codepoint),
//	não importa a plataforma,
//	não importa o programa,
//	não importa a língua.
//	O “character encoding”, ou apenas “encoding” é a maneira com que os 
//	conjuntos de caracteres são mapeados e manipulados pelas máquinas (Define como os bytes serão gravados nos arquivos).
//	Encodings são tabelas que transformam cada codepoint em seu caracter específico.
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "ç";
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

		System.out.println(new String("ç".getBytes("UTF-8"), "ISO-8859-1"));
		
		System.out.println(new String("ç".getBytes("ISO-8859-1"), "UTF-8"));
		
//		String[] codes = { "ISO-8859-1", "UTF-8", "UTF-16" };
//		String palavra = "ç";
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
