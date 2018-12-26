package br.com.guacom.java.io.exercicio.teste;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.guacom.java.io.exercicio.Cadastro;
import br.com.guacom.java.io.exercicio.Pessoa;

public class Teste {
	
	public static void main(String[] args) {
		Cadastro cadastro = null;
		try {
			cadastro = new Cadastro();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(cadastro == null)
			return;
		
		int choose = 0;
		while(choose != 1) {
			
			choose = Integer.parseInt(JOptionPane.showInputDialog("Escolha:"
					+ "\n1 - Efetuar um cadastro"
					+ "\n2 - Buscar todas as pessoas cadastradas"));
		
			switch (choose) {
				case 1:
					try {
						cadastro.cadastrar();
					} catch(IOException | NullPointerException ex) {
						System.out.println((ex instanceof NullPointerException ? "Objeto n�o foi cadastrado!" : 
							"Arquivo inv�lido!"));
					}
					break;
				case 2:
					try {
						for(Pessoa pessoa : cadastro.getPessoas()) {
							JOptionPane.showMessageDialog(null, "Nome: " + pessoa.getNome()
							+ "\nTelefone: " + pessoa.getTelefone()
							+ "\nIdade: " + pessoa.getIdade());
						}
					} catch(IOException | ClassCastException ex) {
						System.out.println((ex instanceof ClassCastException ? "Convers�o n�o suportada!" : 
							"Arquivo n�o existe ou est� corrompido!"));
					}
					break;
				default:
					throw new UnsupportedOperationException("Opera��o inv�lida!!");
			}
			choose = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
		}
	}
}
