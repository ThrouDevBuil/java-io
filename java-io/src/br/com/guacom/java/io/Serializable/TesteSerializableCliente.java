package br.com.guacom.java.io.Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class TesteSerializableCliente {
	//Ctrl + shift + c = Descomentar linhas selecionadas
	public static void main(String[] args) {
//		Cliente cli = new Cliente();
//		cli.setNome("Elvis");
//		cli.setCpf("860.898.535-77");
//		cli.setProfissao("Dev");
//			
//			A persistência de dados consiste no armazenamento confiável e coerente das informações em um sistema de armazenamento de dados(arquivo, B.D.)
		
//			Transformando um objeto para o fluxo de bits e bytes
//			A transformação do objeto em um fluxo binário é chamada de serialização.
//			Efetuando a persistência do objeto serializando-o em um arquivo binário
//		try(ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(new File("cliente.bin")))) {
//			oops.writeObject(cli);
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		
//		A transformação de um fluxo binário em um objeto é chamada de desserialização.
		try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("cliente.bin")))){
			//O objeto de leitura ois está associado a um fluxo de entrada de dados baseado em bytes através da classe ObjectInputStream 			
			Cliente cli = (Cliente) ois.readObject();
			System.out.println(cli);
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
