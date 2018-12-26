package br.com.guacom.java.io.Serializable;

import java.io.Serializable;
import java.util.Locale;



/*  
 *  O que � Serializa��o ?
 * Serializa��o � a t�cnica que permite transformar o estado de um objeto em uma sequ�ncia de bytes. 
 * Depois que um objeto for serializado ele pode ser gravado (ou persistido) em um arquivo de dados 
 * e recuperado do arquivo e desserializado para recriar o objeto na mem�ria.
 * 
 * Um objeto serializado � um objeto representado como uma sequ�ncia de bytes que inclui os dados do objeto 
 * bem como as informa��es sobre o tipo do objeto e os tipos dos dados armazenados no objeto. 
 * Uma vez serializado o objeto pode ser salvo em arquivos ou transmitido remotamente usando uma rede 
 * de computadores atrav�s de um fluxo de dados ou stream via HTTP, via socket, entre outros.
 *
 * A interface Serializable � uma interface de marca��o - 
 * S� efetua a marca��o dos objetos sem definir nenhuma implementa��o
 * Ela � usada apenas para registrar a sem�ntica de serializa��o para a m�quina virtual Java, 
 * indicando que os objetos instanciados a partir da classe podem ser serializados (ou transformados em uma sequ�ncia de bytes).
 * 
 * Empacotamento (Serializa��o e desserializa��o)
 * 
 * O processo de serializa��o al�m de realizar o principio b�sico de sua caracter�stica, que � realizar a 
 * serializa��o e deserializa��o de um objeto, realiza ainda o controle de versionamento de determinado objeto, 
 * para determinar assim a compatibilidade entre objeto e classe, e assim evitar inconsist�ncias na 
 * recupera��o do estado anteriormente salvo do objeto em quest�o.
 * 
 * O controle de versionamento � feito atrav�s de um atributo chamado serialVersionUID, ele identifica se a 
 * vers�o do objeto � compat�vel com a vers�o da classe que serializou este.
 * 
 * Um atributo transiente significa que ele n�o ser� serializado ou desserializado juntamente 
 * com os demais atributos de um determinado objeto.
 * 		>As aplica��es mais comuns que utilizam desse processo s�o:
 *			- Transmiss�o de objetos pela rede. Muito usado em APIs como:
 *			- JNDI: acesso a um diret�rio de objetos
 *			- RMI: invoca��o de m�todo remoto
 *			- Servlets: distribui��o de objetos na sess�o entre os n�s de um cluster
 * 			- Salvar objetos em arquivos ou bancos de dados. 
 *			- Esta geralmente � uma abordagem ad hoc para guardar configura��es ou estado de forma "f�cil"
 * 
 * 		>Voc� define explicitamente que n�o quer serializar um determinado atributo com transient basicamente nos casos a seguir:
 *			- Voc� quer serializar a classe, mas um atributo de um certo tipo (classe) n�o � serializ�vel, 
 *			  portanto o processo iria falhar.
 *			- O valor do atributo � algum tipo de cache e voc� n�o precisa dele, 
 *			  portanto isso economiza mem�ria e processamento.
 *			- O atributo representa alguma entidade local e n�o faz sentido transmiti-la, 
 *			- por exemplo uma conex�o com o banco de dados (Connection) ou qualquer refer�ncia 
 *			  a um recurso que precisa ser aberto e fechado.
 * 
 * */
public class Cliente implements Serializable {

	/*InvalidClassException - � relacionado com a serializa��o padr�o java
	 * Mesmo que o serialVersionUID n�o seja declarado na classe, 
	 * o java grava esta identifica��o automaticamente
	 * Antes de efetuar a instancia��o do objeto na desserializa��o a JVM compara o serialVersionUID
	 * O serialVersionUID � da classe (por isso est�tico) e define a vers�o ou identifica��o num�rica da classe. 
	 * Cada vez que alteramos algo incompat�vel na classe, devemos alterar o seu valor.
	 * Sempre quando serializamos o objeto, tamb�m ser� serializado o valor do serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
    private String cpf;
    private String profissao;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
    	return String.format(new Locale("pt", "BR"), "Nome - %s%nCPF: %s, Profiss�o - %s",
    			nome, cpf, profissao);
    }
    /*
     * O que � e para que serve um Bean ?
     *	Em resumo:
     *		- Uma classe que contenha todos os atributos privados;
     *		- Possua getters e setters para seus atributos;
     *		- Usada para encapsular e abstrair uma entidade;
     *		- Implementa java.io.Serializable;
     *		- JavaBean � uma classe extremamente simples, o exemplo abaixo reflete um "Usu�rio" em algum sistema. 
     *		  Ou seja, ela � apenas uma classe que possui apenas atributos e seus respectivos getters e setters... 
     *		  em geral n�o possui nenhuma l�gica adicional. 
     */
    
}
