package br.com.guacom.java.regex.util.teste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndRegex {
	
	/*		Regular Expression (RegEx) - Expressões Regulares:
	 * As expressões regulares(regex), é um recurso onde podemos efetuar busca com apenas simples caracteres 
	 * (sequência de letras, dígitos, etc) ou com metacaracteres.
	 * Essas expressões, entre outras vantagens, são úteis para busca, validação ou substituição de informações como:
	 *		- 1. Data e hora;
 	 *		- 2. Números IP e endereços MAC;
	 *		- 3. Endereços de e-mail;
	 *		- 4. Endereços de Internet;
	 *		- 5. Validação de documentos ou elementos XML;
	 *		- 6. Documentos pessoais como RG, CPF e Cartão de Crédito.
	 *
	 * Para utilizarmos tais vantagens precisamos obviamente, indicar uma fonte e os caracteres de buscas.
	 * Em termos de software, expressões regulares são comumente utilizadas por editores de textos e em linguagens de programação, 
	 * tornando possível a execução de diversas tarefas como pesquisa, validação, substituição e extração de informações sejam 
	 * simplificadas utilizando-se definições de sequências e padrões de análise de dados, facilitando e agilizando diversas operações.
	 */
	
	
	public static void main(String[] args) {
		
		// \d - Corresponde a um caractere de dígito.
		// \D - Corresponde a um caractere diferente de dígito.
		// \s, \t, \n, \f, \r - Corresponde a qualquer espaço em branco, incluindo espaços, tabulações, 
		//		caracteres de alimentação de formulário, e assim por diante.
		
		// \S - Corresponde a qualquer caractere diferente de espaço em branco.
		// \w - Corresponde a qualquer caractere de texto, incluindo sublinhado. Essa expressão é equivalente a [A-Za-z0-9_].
		// \W - Corresponde a qualquer caractere diferente de palavra. Essa expressão é equivalente a [^A-Za-z0-9_].
		String regex = "\\w";
		String texto = "safdgbn123vsdfas456\r";
		 
		//java.util.regex.Pattern: A classe Pattern é responsável pela representação do padrão a ser compilado 
		//e utilizado nas pesquisas.
		//Para a sua utilização, deve-se obter uma referência de Pattern por meio do método estático compile(String padrao).
		
		//Compila a expressão regular passada como parâmetro, transformando-a em um padrão de pesquisa.
		//Retorna uma instância de Pattern.
		Pattern pattern = Pattern.compile(regex);
		
		//java.util.regex.Matcher: A classe Matcher é responsável pelas operações de pesquisa e análise 
		//de cadeias de caracteres de entrada, possibilitando a execução de buscas, retorno de resultados, 
		//extração de índices de informações e dados agrupados. 
		//Para a sua utilização, deve-se obter uma referência de Matcher por meio do método matcher(String texto) de uma referência de Pattern.
		
		//Cria uma instância de Matcher que será responsável pela pesquisa na 
		//cadeia de caracteres passada como parâmetro utilizando a expressão regular já compilada.
		Matcher matcher = pattern.matcher(texto);
	
		//java.util.regex.PatternSyntaxException: A classe PatternSyntaxException permite o controle e tratamento de exceções 
		//lançadas durante o uso de expressões regulares. 
		//Através da verificação desse tipo de exceção, é possível ter um controle maior sobre os erros 
		//gerados a partir de consultas quando a sintaxe do padrão informada à aplicação é inválida.
		
		
		//Tarefa de busca iniciada
		while(matcher.find()) {
			//O motor regex efetua a busca da esquerda para a direita e ao passo que ele encontrar uma ocorrência,
			//esta não participará mais do processo de busca.
			
			//Obtendo o início do que foi encontrado (Retorna um inteiro que corresponde ao 
			//índice inicial de cada sequência encontrada), 
			//a expressão regular completa (o método group(), responsável pela extração do 
			//trecho da cadeia de caractere que atende à expressão regular validada.), e o fim da expressão.
			System.out.println(matcher.start() + " " + matcher.group() + " " + matcher.end());
		}
		
		//Retorna a expressão regular original, a partir da qual o padrão foi compilado.
		System.out.println(pattern.pattern());
	}
}
