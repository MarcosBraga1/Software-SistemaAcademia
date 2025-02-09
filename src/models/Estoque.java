package models;

import java.util.ArrayList;

/**
 * Classe que representa o estoque da loja.
 * 
 * <p>Essa classe serve de modelo para representar um estoque da loja de produtos da academia.</p>
 * @author Marcos
 */
public class Estoque {
    // Atributos
    private static ArrayList<Produto> listaProdutosCadastrados = new ArrayList<>();
    private static ArrayList<Item> listaProdutosEstoque = new ArrayList<>();
    
    // Getters e Setters
    public static ArrayList<Produto> getListaProdutosCadastrados() {
        return listaProdutosCadastrados;
    }

    public static void setListaProdutosCadastrados(ArrayList<Produto> listaProdutos) {
        Estoque.listaProdutosCadastrados = listaProdutos;
    }

    public static ArrayList<Item> getListaProdutosEstoque() {
        return listaProdutosEstoque;
    }

    public static void setListaProdutosEstoque(ArrayList<Item> listaProdutosEstoque) {
        Estoque.listaProdutosEstoque = listaProdutosEstoque;
    }
    
    
    // Construtor
    public Estoque(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "Estoque [Lista de Produtos Cadastrados: " + listaProdutosCadastrados + ",\nLista de Produtos em Estoque: " + listaProdutosEstoque + "]\n";
    }
}