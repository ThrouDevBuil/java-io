package br.com.guacom.java.io.exercicio;

public class Pessoa {
	private String nome;
	private String telefone;
	private int idade;
	

	public Pessoa(String nome, String telefone, int idade) {
		if((telefone == null)||(nome == null))
			throw new NullPointerException("Dados inválidos!!");			
		
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
	}
	
	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public boolean equals(Object obj) throws NullPointerException {
		
		if(obj == null)
			throw new NullPointerException("Objeto não foi cadastrado!");
		
		if(!(obj instanceof Pessoa))
			return false;
		
		Pessoa person = (Pessoa) obj;
		boolean equal = false;
		if(this.nome.compareToIgnoreCase(person.getNome()) == 0)
			equal = true;
		
		if( (Integer.compare(this.idade, person.idade) == 0)&&(equal) )
			return false;
		
		return true;
	}
}
