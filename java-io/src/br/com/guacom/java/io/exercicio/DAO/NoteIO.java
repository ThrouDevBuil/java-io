package br.com.guacom.java.io.exercicio.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.guacom.java.io.exercicio.Pessoa;


//Exceções unchecked = o compilador não checa se você está tratando essas exceções.
public class NoteIO {
	String path = "C:";
	String directory = path + File.separator + "Users" + File.separator 
			+ "elvis" + File.separator + "Documents" 
			+ File.separator + "PessoaDAO.txt";
	private List<Pessoa> pessoas;
	
	public NoteIO(List<Pessoa> pessoas) {
		if(pessoas != null) {
			this.pessoas = pessoas;			
		}
	}
	
	public ArrayList<Pessoa> getPessoas() throws IOException, ClassCastException {
		long ini = System.currentTimeMillis();
//		InputStream fis = new FileInputStream(new File(directory));
//		Reader inr = new InputStreamReader(fis);
//		BufferedReader bRead = new BufferedReader(inr);
//		FileReader fr = new FileReader(new File(directory));
//		BufferedReader bRead = new BufferedReader(fr);
		try (Scanner scan = new Scanner(new FileInputStream(new File(directory)), "UTF-8")) {
			while(scan.hasNextLine()) {
				String nome = scan.nextLine();
				String telefone = scan.nextLine();
				int idade = Integer.parseInt(scan.nextLine());
				Pessoa pessoa = new Pessoa(nome, telefone, idade);
				if(comparePeople(pessoa))
					pessoas.add(pessoa);
			}			
		} catch(IOException e) {
			System.err.println(e.getMessage());
			for(Throwable t : e.getSuppressed()) {
				System.err.println(t.getMessage());
			}
		}
//		do {
//			
//			if(line != null) {
//				String nome = line;
//				line = bRead.readLine();
//				String telefone = line;
//				line = bRead.readLine();
//				int idade = Integer.parseInt(line);
//				Pessoa pessoa = new Pessoa(nome, telefone, idade);
//				if(comparePeople(pessoas, pessoa))
//					pessoas.add(pessoa);				
//			}
//			
//		} while( (line = bRead.readLine()) != null);
		
		long fim = System.currentTimeMillis();
		System.out.println("Passaram - " + (fim - ini) );
		return (ArrayList<Pessoa>) pessoas;
	}
	
	private boolean comparePeople(Pessoa pessoa) {
		if(pessoas.size() >= 1) {

			for(Pessoa person : pessoas) {
				
				if(!person.equals(pessoa))
					return false;
				
			}
		}
		return true;
	}

	public void setPessoa(Pessoa pessoa) {
//		Várias alternativas para estabelecer uma saída para um arquivo de texto.
		
//		OutputStream fos = new FileOutputStream(new File(directory), true);
//		Writer osw = new OutputStreamWriter(fos);

//		FileWriter - Foi criada com o propósito de estabelecer uma entrada com um arquivo de texto.

//		System.lineSeparator() - Capturando o caractere de nova linha do SO.
		
//		FileWriter fw = new FileWriter(new File(directory), true);
//		BufferedWriter bw = new BufferedWriter(fw);
//		PrintStream ps = new PrintStream();
		
		//PrintWriter tem métodos de mais alto nível que já cuidam da nova linha, independente do SO.
		try(PrintStream writer = new PrintStream(new FileOutputStream(new File(directory), true), true, "UTF-8")) {
			writer.println(pessoa.getNome());							//Efetuando a leitura de um arquivo
			writer.println(pessoa.getTelefone());
			writer.println(Integer.toString(pessoa.getIdade()));
			
		} catch(IOException e) {
			System.err.println(e.getMessage());
			for(Throwable t : e.getSuppressed()) {
				System.err.println(t.getMessage());
			}
		}
	}
}
