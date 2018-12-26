package br.com.guacom.java.io.exercicio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.guacom.java.io.exercicio.DAO.NoteIO;

public class Cadastro {
	private List<Pessoa> pessoas;
	private NoteIO note;
	
	public Cadastro() throws FileNotFoundException {
		this.pessoas = new ArrayList<Pessoa>();
		note = new NoteIO(pessoas);
	}

	public List<Pessoa> getPessoas() throws IOException {
		note.getPessoas();
		return (ArrayList<Pessoa>)pessoas;
	}
	
	public void cadastrar() throws IOException {
		
		String nome = JOptionPane.showInputDialog("Nome:");
		String telefone = JOptionPane.showInputDialog("Telefone: ");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
		Pessoa pessoa = new Pessoa(nome, telefone, idade);
		add(pessoa);
		note.setPessoa(pessoa);
	}
	
	public void add(Pessoa pessoa) {
		if(pessoa == null)
			throw new NullPointerException("Dados inválidos!");
		
		pessoas.add(pessoa);
	}
}
