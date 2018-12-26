package br.com.guacom.java.io.exercicio.DAO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class ConfigProperties {
	
	public static void main(String[] args) {
		//Em projetos mais complexos existem diversas configurações a fazer para a aplicação funcionar.
		//Necessário configurar usuários, senhas, endereços ou portas para acessar outros aplicativos e serviços.
		//Essas configurações podem ficar dentro do código fonte, mas isso exige a recompilação do código fonte 
		//assim que uma configuração muda. O melhor seria externalizá-las e colocá-las em um arquivo separado, 
		//Existe um mini-padrão para este tipo de arquivo que é utilizado. Eles são chamados de arquivos de propriedade
		//(properties)
		//Um arquivo properties associa o nome da configuração com o seu valor.
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
			
			//Externalizando as configurações (criando um arquivo config.properties com os dados do objeto acima)
			props.store(new PrintWriter(new File("config.properties"), "UTF-8"), "My future enterprise");
										//Adiciona o arquivo .properties à variável file.
			
			//Carrega o arquivo de propriedades na variável props.
			props.load(new FileReader(new File("config.properties")));
			login = props.getProperty("login");
			senha = props.getProperty("senha");
			endereco = props.getProperty("endereco");
		} catch(IOException e) {
			System.out.println("Arquivo não existe!");
		}
		if((!login.isEmpty())&&(!senha.isEmpty())&&(!endereco.isEmpty()))
			System.out.println("Login: " + login 
					+ "\nSenha: " + senha 
					+ "\nEndereço: " + endereco);

	}
}
