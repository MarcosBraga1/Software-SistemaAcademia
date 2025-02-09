package models;

import static models.SystemAcad.getQuantidadeClientes;
import static models.SystemAcad.quantidadeClientes_;
import static models.SystemAcad.setQuantidadeClientes;

/**
 *Classe que representa um cliente da academia.
 * 
 *<p>Essa classe é uma subclasse de Pessoa e serve de modelo para representar um cliente 
 * da academia. Ela adiciona novos atributos sendo eles ID e cartão, junto de seus getters 
 * e setters, com exceção do ID que é definido dentro do construtor e não pode ser alterado.</p>
 * 
 * @author Marcos
 */
public class Cliente extends Pessoa{
    // Atributos
    private int id;
    private String cartao;
    
    // Getters e Setter
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    /* 
        Não há a necessidade de um setID pois ele é difinido dentro do contrutor
        e o usuário não deve ter acesso a alteração;
    */
    
    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }
    
    // Construtores
    public Cliente(){
        
    }
    
    public Cliente(int id){
        this.id = id;
    }
    
    public Cliente(String nome, String cpf, String endereco, String email, String telefone, String cartao){
        super(nome, cpf, endereco, email, telefone);
        quantidadeClientes_ += 1;
        setQuantidadeClientes(getQuantidadeClientes() + 1);
        this.id = quantidadeClientes_;
        this.cartao = cartao;
    }
    
    // toString
    @Override
    public String toString(){
        return "Cliente [ID: " + id + ",\nNome: " + getNome() + ",\nCPF: " + getCpf() + ",\nEndereco: " + getEndereco() + ",\nEmail: " + getEmail() + ",\nTelefone: " + getTelefone() + "]\n";
    }
}
