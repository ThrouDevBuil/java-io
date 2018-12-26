package br.com.guacom.java.regex.util.teste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndRegex {
	
	/*		Regular Expression (RegEx) - Express�es Regulares:
	 * As express�es regulares(regex), � um recurso onde podemos efetuar busca com apenas simples caracteres 
	 * (sequ�ncia de letras, d�gitos, etc) ou com metacaracteres.
	 * Essas express�es, entre outras vantagens, s�o �teis para busca, valida��o ou substitui��o de informa��es como:
	 *		- 1. Data e hora;
 	 *		- 2. N�meros IP e endere�os MAC;
	 *		- 3. Endere�os de e-mail;
	 *		- 4. Endere�os de Internet;
	 *		- 5. Valida��o de documentos ou elementos XML;
	 *		- 6. Documentos pessoais como RG, CPF e Cart�o de Cr�dito.
	 *
	 * Para utilizarmos tais vantagens precisamos obviamente, indicar uma fonte e os caracteres de buscas.
	 * Em termos de software, express�es regulares s�o comumente utilizadas por editores de textos e em linguagens de programa��o, 
	 * tornando poss�vel a execu��o de diversas tarefas como pesquisa, valida��o, substitui��o e extra��o de informa��es sejam 
	 * simplificadas utilizando-se defini��es de sequ�ncias e padr�es de an�lise de dados, facilitando e agilizando diversas opera��es.
	 */
	
	
	public static void main(String[] args) {
		
		// \d - Corresponde a um caractere de d�gito.
		// \D - Corresponde a um caractere diferente de d�gito.
		// \s, \t, \n, \f, \r - Corresponde a qualquer espa�o em branco, incluindo espa�os, tabula��es, 
		//		caracteres de alimenta��o de formul�rio, e assim por diante.
		
		// \S - Corresponde a qualquer caractere diferente de espa�o em branco.
		// \w - Corresponde a qualquer caractere de texto, incluindo sublinhado. Essa express�o � equivalente a [A-Za-z0-9_].
		// \W - Corresponde a qualquer caractere diferente de palavra. Essa express�o � equivalente a [^A-Za-z0-9_].
		String regex = "\\w";
		String texto = "safdgbn123vsdfas456\r";
		 
		//java.util.regex.Pattern: A classe Pattern � respons�vel pela representa��o do padr�o a ser compilado 
		//e utilizado nas pesquisas.
		//Para a sua utiliza��o, deve-se obter uma refer�ncia de Pattern por meio do m�todo est�tico compile(String padrao).
		
		//Compila a express�o regular passada como par�metro, transformando-a em um padr�o de pesquisa.
		//Retorna uma inst�ncia de Pattern.
		Pattern pattern = Pattern.compile(regex);
		
		//java.util.regex.Matcher: A classe Matcher � respons�vel pelas opera��es de pesquisa e an�lise 
		//de cadeias de caracteres de entrada, possibilitando a execu��o de buscas, retorno de resultados, 
		//extra��o de �ndices de informa��es e dados agrupados. 
		//Para a sua utiliza��o, deve-se obter uma refer�ncia de Matcher por meio do m�todo matcher(String texto) de uma refer�ncia de Pattern.
		
		//Cria uma inst�ncia de Matcher que ser� respons�vel pela pesquisa na 
		//cadeia de caracteres passada como par�metro utilizando a express�o regular j� compilada.
		Matcher matcher = pattern.matcher(texto);
	
		//java.util.regex.PatternSyntaxException: A classe PatternSyntaxException permite o controle e tratamento de exce��es 
		//lan�adas durante o uso de express�es regulares. 
		//Atrav�s da verifica��o desse tipo de exce��o, � poss�vel ter um controle maior sobre os erros 
		//gerados a partir de consultas quando a sintaxe do padr�o informada � aplica��o � inv�lida.
		
		
		//Tarefa de busca iniciada
		while(matcher.find()) {
			//O motor regex efetua a busca da esquerda para a direita e ao passo que ele encontrar uma ocorr�ncia,
			//esta n�o participar� mais do processo de busca.
			
			//Obtendo o in�cio do que foi encontrado (Retorna um inteiro que corresponde ao 
			//�ndice inicial de cada sequ�ncia encontrada), 
			//a express�o regular completa (o m�todo group(), respons�vel pela extra��o do 
			//trecho da cadeia de caractere que atende � express�o regular validada.), e o fim da express�o.
			System.out.println(matcher.start() + " " + matcher.group() + " " + matcher.end());
		}
		
		//Retorna a express�o regular original, a partir da qual o padr�o foi compilado.
		System.out.println(pattern.pattern());
	}
}
