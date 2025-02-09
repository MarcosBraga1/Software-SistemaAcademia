package controller;

import java.util.ArrayList;
import models.Cliente;
import models.Item;
import static models.SystemAcad.getListaVendas;
import models.Venda;

/**
 * Classe para realizar o gerenciamento de vendas.
 * 
 * <p>Essa classe é responsável por possuir todos os métodos que estão relacionados 
 * ao gerenciamento de vendas dentro do sistema.</p>
 * @author Marcos
 */
public class GerenciamentoVenda extends GerenciamentoDados{
    // Instância de gerenciamentos para o uso dentro da classe
    GerenciamentoEstoque ge = new GerenciamentoEstoque();
    GerenciamentoCliente gc = new GerenciamentoCliente();
    GerenciamentoBD gbd = new GerenciamentoBD();
    
    // Atributos
    private ArrayList<Item> carrinho = new ArrayList<>();

    // Getters e Setters
    public ArrayList<Item> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Item> carrinho) {
        this.carrinho = carrinho;
    }
    
    /**
     * Método que adiciona um item ao carrinho de compras.
     * 
     * Esse método recebe a quantidade e o ID do item a ser adicionado ao carrinho 
     * de compras da loja.
     * @param index ID do item a compor o carrinho
     * @param quantidade Quantidade do item
     */
    public void adicionarItem(int index, int quantidade){
        Item item = new Item(ge.retornarProduto(index), quantidade);
        addLista(carrinho, item);
    }
    
    /**
     * Método para ver o valor total do carrinho.
     * 
     * Esse método soma os valores de todos os itens dentro do carrinho e retorna 
     * o total.
     * @param lista Lista dinâmica do carrinho
     * @return Valor flutuante do total da compra
     */
    public float valorCompra(ArrayList<Item> lista){
        float valor = 0;
        for (Item item : lista){
            valor = valor + (item.getQuantidade() * item.getProduto().getPrecoVenda());
        }
        return valor;
    }
    
    /**
     * Método que remove um item do carrinho.
     * 
     * Esse método recebe um ID de um item que está no carrinho e o remove de lá.
     * @param index ID do produto a ser removido do carrinho
     */
    public void removerItem(int index){
        removerLista(carrinho, f -> ((Item) f).getId() == index);
    }
    
    /**
     * Método que realiza a confirmação da compra.
     * 
     * Esse método coleta todas as informações referente a compra e cria uma instância 
     * da classe Venda, que será armazenado em um arquivo Json que guarda o histórico das vendas.
     * @param lista Carrinho com os itens comprados
     * @param valor Valor total da compra
     * @param indexPagamento 1 para "Dinheiro", 2 para "Pix", 3 para "Débito" e 4 para "Crédito"
     * @param indexCliente ID do cliente que realizou a compra
     * @return Venda realizada para realizar a impressão
     */
    public Venda confirmarCompra(ArrayList<Item> lista, float valor, int indexPagamento, int indexCliente){
        String pagamento;
        
        switch (indexPagamento) {
            case 1:
                pagamento = "Dinheiro";
                break;
            case 2:
                pagamento = "Pix";
                break;
            case 3:
                pagamento = "Debito";
                break;
            case 4:
                pagamento = "Credito";
                break;
            default:
                pagamento = "Nao Declarado";
                break;
        }
        
        Cliente cliente = gc.retornarCliente(indexCliente);
        Venda venda = new Venda(cliente, lista, valor, pagamento);
        addLista(getListaVendas(), venda);
        return venda;
    }
    
    // Construtor
    public GerenciamentoVenda(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para realizar o gerenciamento de vendas.]";
    }
}
