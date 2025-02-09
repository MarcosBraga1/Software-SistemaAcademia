package models;

import static models.SystemAcad.quantidadeItem_;

/**
 * Classe que representa um item de uma compra.
 * 
 * Essa classe serve para representar um item que compõem uma compra ou o estoque.
 * @author Marcos
 */
public class Item {
    // Atributos
    private int id;
    private Produto produto;
    private int quantidade;
    
    // Getters e Setters
    public int getId(){
        return id;
    }
    
    /* 
        Não há a necessidade de um setID pois ele é difinido dentro do contrutor
        e o usuário não deve ter acesso a alteração;
    */
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    // Construtores
    public Item(){
        
    }
    
    public Item(Produto produto, int quantidade){
        quantidadeItem_ += 1;
        this.id = quantidadeItem_;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    // toString
    @Override
    public String toString(){
        return "Item [ID: " + produto.getId() + ",\nProduto: " + produto.getNome() + ",\nQuantidade: " + quantidade + "]\n";
    }
}
