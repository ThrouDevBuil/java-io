package br.com.guacom.java.io.teste;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

public class TesteIn {
	
	public static void main(String[] args) {
		String path = "C:";
		String directory = path + File.separator + "Users"
				+ File.separator + "elvis" + File.separator
				+ "Downloads" + File.separator + "contas.csv";
//		Scanner scanner = new Scanner(new FileInputStream(new File(directory)));

		try(Scanner scanner = new Scanner(Paths.get(directory), "UTF-8")) {
			
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				
//				String[] linhas = linha.split(",");
//				String linha4 = linhas[3];
//				System.out.println(linha4);
//				System.out.println(Arrays.toString(linhas));
				
				Scanner scan = new Scanner(linha);
				//Separa o contéudo de acordo com um regex (expressão regular)
				scan.useDelimiter(",");
				scan.useLocale(Locale.US);
				
//				alt + shift + r = Renomear atributo ou variavel
				String tipoConta = scan.next();
				int agencia = scan.nextInt();
				int numero = scan.nextInt();
				String titular = scan.next();
				double saldo = scan.nextDouble();
				
				String format = String.format(new Locale("pt", "BR"), "Tipo -  "
						+ "%s, Agência: %04d-%08d, Titular: %20s - Saldo: R$%08.2f%n",
						tipoConta, agencia, numero, titular, saldo);
				System.out.print(format);
				scan.close();
			}
		} catch(IOException ex) {
			System.err.println("Arquivo não encontrado!!n" + ex.getMessage());
		}
	}
}
