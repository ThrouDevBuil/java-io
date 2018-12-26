package br.com.guacom.java.io.Serializable;

import java.io.Serializable;
import java.util.Locale;



/*  
 *  O que é Serialização ?
 * Serialização é a técnica que permite transformar o estado de um objeto em uma sequência de bytes. 
 * Depois que um objeto for serializado ele pode ser gravado (ou persistido) em um arquivo de dados 
 * e recuperado do arquivo e desserializado para recriar o objeto na memória.
 * 
 * Um objeto serializado é um objeto representado como uma sequência de bytes que inclui os dados do objeto 
 * bem como as informações sobre o tipo do objeto e os tipos dos dados armazenados no objeto. 
 * Uma vez serializado o objeto pode ser salvo em arquivos ou transmitido remotamente usando uma rede 
 * de computadores através de um fluxo de dados ou stream via HTTP, via socket, entre outros.
 *
 * A interface Serializable é uma interface de marcação - 
 * Só efetua a marcação dos objetos sem definir nenhuma implementação
 * Ela é usada apenas para registrar a semântica de serialização para a máquina virtual Java, 
 * indicando que os objetos instanciados a partir da classe podem ser serializados (ou transformados em uma sequência de bytes).
 * 
 * Empacotamento (Serialização e desserialização)
 * 
 * O processo de serialização além de realizar o principio básico de sua característica, que é realizar a 
 * serialização e deserialização de um objeto, realiza ainda o controle de versionamento de determinado objeto, 
 * para determinar assim a compatibilidade entre objeto e classe, e assim evitar inconsistências na 
 * recuperação do estado anteriormente salvo do objeto em questão.
 * 
 * O controle de versionamento é feito através de um atributo chamado serialVersionUID, ele identifica se a 
 * versão do objeto é compatível com a versão da classe que serializou este.
 * 
 * Um atributo transiente significa que ele não será serializado ou desserializado juntamente 
 * com os demais atributos de um determinado objeto.
 * 		>As aplicações mais comuns que utilizam desse processo são:
 *			- Transmissão de objetos pela rede. Muito usado em APIs como:
 *			- JNDI: acesso a um diretório de objetos
 *			- RMI: invocação de método remoto
 *			- Servlets: distribuição de objetos na sessão entre os nós de um cluster
 * 			- Salvar objetos em arquivos ou bancos de dados. 
 *			- Esta geralmente é uma abordagem ad hoc para guardar configurações ou estado de forma "fácil"
 * 
 * 		>Você define explicitamente que não quer serializar um determinado atributo com transient basicamente nos casos a seguir:
 *			- Você quer serializar a classe, mas um atributo de um certo tipo (classe) não é serializável, 
 *			  portanto o processo iria falhar.
 *			- O valor do atributo é algum tipo de cache e você não precisa dele, 
 *			  portanto isso economiza memória e processamento.
 *			- O atributo representa alguma entidade local e não faz sentido transmiti-la, 
 *			- por exemplo uma conexão com o banco de dados (Connection) ou qualquer referência 
 *			  a um recurso que precisa ser aberto e fechado.
 * 
 * */
public class Cliente implements Serializable {

	/*InvalidClassException - É relacionado com a serialização padrão java
	 * Mesmo que o serialVersionUID não seja declarado na classe, 
	 * o java grava esta identificação automaticamente
	 * Antes de efetuar a instanciação do objeto na desserialização a JVM compara o serialVersionUID
	 * O serialVersionUID é da classe (por isso estático) e define a versão ou identificação numérica da classe. 
	 * Cada vez que alteramos algo incompatível na classe, devemos alterar o seu valor.
	 * Sempre quando serializamos o objeto, também será serializado o valor do serialVersionUID.
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
    	return String.format(new Locale("pt", "BR"), "Nome - %s%nCPF: %s, Profissão - %s",
    			nome, cpf, profissao);
    }
    /*
     * O que é e para que serve um Bean ?
     *	Em resumo:
     *		- Uma classe que contenha todos os atributos privados;
     *		- Possua getters e setters para seus atributos;
     *		- Usada para encapsular e abstrair uma entidade;
     *		- Implementa java.io.Serializable;
     *		- JavaBean é uma classe extremamente simples, o exemplo abaixo reflete um "Usuário" em algum sistema. 
     *		  Ou seja, ela é apenas uma classe que possui apenas atributos e seus respectivos getters e setters... 
     *		  em geral não possui nenhuma lógica adicional. 
     */
    
}
