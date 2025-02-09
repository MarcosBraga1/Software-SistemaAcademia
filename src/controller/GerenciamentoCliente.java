package controller;

import controller.comparator.ClienteIdComparator;
import controller.comparator.Comparador;
import java.util.Collections;
import java.util.Iterator;
import models.Cliente;
import static models.SystemAcad.getListaClientes;

/**
 * Classe para realizar o gerenciamento de clientes.
 * 
 * <p>Essa classe é responsável por possuir todos os métodos que estão relacionados 
 * ao gerenciamento de clientes dentro do sistema.</p>
 * @author Marcos
 */
public class GerenciamentoCliente extends GerenciamentoDados{
    // Métodos
    /**
     * Método que realiza o cadastro de um novo cliente na memória dinâmica.
     * 
     * O método coleta as informações do cliente, instância um novo objeto do tipo Cliente
     * e adiciona na lista dinâmica de clientes.
     * @param nome Nome do cliente que está sendo cadastrado
     * @param cpf CPF do cliente que está sendo cadastrado
     * @param endereco Endereço do cliente que está sendo cadastrado
     * @param email E-mail do cliente que está sendo cadastrado
     * @param telefone Telefone do cliente que está sendo cadastrado
     * @param cartao Cartao do cliente que está sendo cadastrado
     */
    public void cadastrarCliente(String nome, String cpf, String endereco, String email, String telefone, String cartao){
        Cliente cliente = new Cliente(nome,cpf,endereco,email,telefone,cartao);
        addLista(getListaClientes(), cliente);
    }
    
    /**
     * Método que realiza a remoção de um cliente.
     * 
     * O método imprime os clientes que estão na memória dinâmica e solicita o input
     * de um ID do cliente para que o mesmo seja removido da memória.
     * @param index ID do cliente a ser deletado
     */
    public void deletarCliente(int index){
        removerLista(getListaClientes(), f -> ((Cliente) f).getId() == index);
    }
    
    /**
     * Método que retorna um cliente pelo seu id.
     * 
     * O método recbe um ID e pesquisa se há um cliente com o mesmo ID, caso haja 
     * ele retorna o cliente para que suas informações sejam alteradas.
     * @param id ID do cliente a ser retornado
     * @return Objeto da classe Cliente que possui o ID passado
     */
    public Cliente retornarCliente(int id){
        Iterator<Cliente> iterator = getListaClientes().iterator();
        while (iterator.hasNext()){
            Cliente cliente = iterator.next();
            if (Comparador.comparador(id, cliente.getId()) == 0){
                // System.out.println("Cliente encontrado: " + cliente);
                return cliente;
            }
        }
        
        System.out.println("Cliente nao encontrado.");
        return null;
        
        /*
        for (Cliente cliente : getListaClientes()){
            if (id == cliente.getId()){
                return cliente;
            }
        }
        System.out.println("Cliente nao encontrado!");
        return null;
        */
    }
    
    public Cliente retornarClienteBinarySearch(int id){
        Cliente cliente = new Cliente(id);
        Collections.sort(getListaClientes(), new ClienteIdComparator());
        int index = Collections.binarySearch(getListaClientes(), cliente, new ClienteIdComparator());
            if (index >= 0){
                System.out.println("Cliente encontrado: " + getListaClientes(index));
                cliente = getListaClientes(index);
                return cliente;
            }
            else{
                System.out.println("CLiente nao encontrado.");
                return null;
            }
    }
    
    /**
     * Método que atualiza as informações de um cliente.
     * 
     * O método recebe um cliente e novos atributos, os quais irão substituir os 
     * atributos atuais do cliente que foi passado.
     * @param cliente Objeto da classe Cliente que será atualizado
     * @param nome Novo nome que irá substituir
     * @param cpf Novo CPF que irá substituir
     * @param endereco Novo Endereço que irá substituir
     * @param email Novo E-mail que irá substituir
     * @param telefone Novo telefone que irá substituir
     * @param cartao Novo cartão que irá substituir
     */
    public void atualizarCliente(Cliente cliente, String nome, String cpf, String endereco, String email, String telefone, String cartao){
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCartao(cartao);
    }
    
    /**
     * Método que imprime todos os clientes cadastrados.
     * 
     * Esse método percorre toda a memória dinâmica de clientes e imprime cada 
     * um deles utilizando um iterator.
     */
    public void percorrerClientesIterator(){
        Iterator<Cliente> iterator = getListaClientes().iterator();
        
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            System.out.println(cliente);
        }
    }
    
    /**
     * Método que imprime todos os clientes cadastrados.
     * 
     * Esse método percorre toda a memória dinâmica de clientes e imprime cada 
     * um deles utilizando um ForEach.
     */
    public void percorrerClientesForEach(){
        for (Cliente cliente : getListaClientes()){
            System.out.println(cliente);
        }
    }
    
    // Construtor
    public GerenciamentoCliente(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para realizar o gerenciamento de clientes.]";
    }
}
