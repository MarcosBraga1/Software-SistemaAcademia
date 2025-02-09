package models;

import java.util.ArrayList;
import java.time.LocalDateTime;
import static models.SystemAcad.quantidadeVendas_;

/**
 * Classe que representa uma venda da loja.
 * 
 * Essa classe serve para representar uma venda que foi realizada dentro da loja da academia.
 * @author Marcos
 */
public class Venda {
    // Atributos
    private int id;
    private Cliente cliente;
    private ArrayList<Item> listaItens;
    private float valor;
    private LocalDateTime dataHora;
    private String formaPagamento;
    
    // Getters e Setters
    public int getId(){
        return id;
    }
    
    /* 
        Não há a necessidade de um setID pois ele é difinido dentro do contrutor
        e o usuário não deve ter acesso a alteração;
    */
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<Item> listaItems) {
        this.listaItens = listaItems;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    
    /*
        Não há necessidade de um setDataHora pois são definidos no momento em que a compra
        é finalizada, momento em que o construtor é chamado.
    */

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    // Construtores
    public Venda(){
        
    }
    
    public Venda(Cliente cliente, ArrayList<Item> listaItens, float valor, String formaPagamento){
        quantidadeVendas_ += 1;
        this.id = quantidadeVendas_;
        this.cliente = cliente;
        this.listaItens = listaItens;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.dataHora = LocalDateTime.now();
    }
    
    // toString
    @Override
    public String toString(){
        return "Venda [ID: " + id + ",\nCliente: " + cliente.getNome() + ",\nValor: " + valor + ",\nItens: " + listaItens + ",\nHora: " + dataHora + ",\nPagamento: " + formaPagamento + "]\n";
    }
}
