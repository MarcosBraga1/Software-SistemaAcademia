package models;

import static models.SystemAcad.quantidadeProdutos_;

/**
 * Classe de modelo para um produto.
 * 
 * <p>Essa classe serve para representar o modelo de um produto que irá compor 
 * o estoque da academia, para o uso na loja.</p>
 * @author Marcos
 */
public class Produto {
    // Atributos
    private int id;
    private String nome;
    private float precoUnitario;
    private float precoVenda;
    private String categoria;
    private String especificacoes;
    
    // Getters e Setters
    public int getId(){
        return id;
    }
    
    /* 
        Não há a necessidade de um setID pois ele é difinido dentro do contrutor
        e o usuário não deve ter acesso a alteração;
    */
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }
    
    // Construtores
    public Produto(){
        
    }
    
    public Produto(String nome, float precoUnitario, float precoVenda, String categoria, String especificacoes){
        quantidadeProdutos_ += 1;
        this.id = quantidadeProdutos_;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.precoVenda = precoVenda;
        this.categoria = categoria;
        this.especificacoes = especificacoes;
    }
    
    // toString
    @Override
    public String toString(){
        return "Produto [ID: " + id + ",\nNome: " + nome + ",\nPreco Unitario: " + precoUnitario + ",\nPreco Venda: " + precoVenda + ",\nCategoria: " + categoria + ",\nEspecificacoes: " + especificacoes + "]\n";
    }
}
