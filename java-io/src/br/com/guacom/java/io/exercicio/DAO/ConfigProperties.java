package br.com.guacom.java.io.exercicio.DAO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class ConfigProperties {
	
	public static void main(String[] args) {
		//Em projetos mais complexos existem diversas configura��es a fazer para a aplica��o funcionar.
		//Necess�rio configurar usu�rios, senhas, endere�os ou portas para acessar outros aplicativos e servi�os.
		//Essas configura��es podem ficar dentro do c�digo fonte, mas isso exige a recompila��o do c�digo fonte 
		//assim que uma configura��o muda. O melhor seria externaliz�-las e coloc�-las em um arquivo separado, 
		//Existe um mini-padr�o para este tipo de arquivo que � utilizado. Eles s�o chamados de arquivos de propriedade
		//(properties)
		//Um arquivo properties associa o nome da configura��o com o seu valor.
		//	Exemplo:
		//		login = guacom; senha = guacompass; endereco = www.guacom.com.br
		//Sempre tem uma chave (key) e um valor (value) associados.
		String login = null;
		String senha = null;
		String endereco = null;
		
		Properties props = new Properties();
		props.setProperty("login", "guacom");
		props.setProperty("senha", "guacompass");
		props.setProperty("endereco", "www.guacom.com");
		try {
//			props.store(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("config.properties")))), "My future enterprise");
			
			//Externalizando as configura��es (criando um arquivo config.properties com os dados do objeto acima)
			props.store(new PrintWriter(new File("config.properties"), "UTF-8"), "My future enterprise");
										//Adiciona o arquivo .properties � vari�vel file.
			
			//Carrega o arquivo de propriedades na vari�vel props.
			props.load(new FileReader(new File("config.properties")));
			login = props.getProperty("login");
			senha = props.getProperty("senha");
			endereco = props.getProperty("endereco");
		} catch(IOException e) {
			System.out.println("Arquivo n�o existe!");
		}
		if((!login.isEmpty())&&(!senha.isEmpty())&&(!endereco.isEmpty()))
			System.out.println("Login: " + login 
					+ "\nSenha: " + senha 
					+ "\nEndere�o: " + endereco);

	}
}
