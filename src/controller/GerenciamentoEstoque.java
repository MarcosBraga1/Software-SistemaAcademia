package controller;

import static models.Estoque.getListaProdutosCadastrados;
import static models.Estoque.getListaProdutosEstoque;
import models.Item;
import models.Produto;

/**
 * Classe para realizar o gerenciamento de estoque.
 * 
 * <p>Essa classe é responsável por possuir todos os métodos que estão relacionados 
 * ao gerenciamento de estoque dentro do sistema.</p>
 * @author Marcos
 */
public class GerenciamentoEstoque extends GerenciamentoDados{
    // Métodos
    /**
     * Método que realiza o cadastro de um novo produto na memória dinâmica.
     * 
     * O método coleta as informações do produto, instância um novo objeto do tipo Produto
     * e adiciona na lista dinâmica de produtos.
     * @param nome Nome do produto cadastrado
     * @param precoUnitario Preço de compra do produto cadastrado
     * @param precoVenda Preço de revenda do produto cadastrado
     * @param categoria 1 para "Acessório", 2 para "Equipamento" e 3 para "Suplemento"
     * @param especificacao Texto com informações sobre o produto
     */
    public void cadastrarProduto(String nome,float precoUnitario,float precoVenda,int categoria,String especificacao){
        String tipo;
        
        switch (categoria) {
            case 1:
                tipo = "Acessorio";
                break;
            case 2:
                tipo = "Equipamento";
                break;
            default:
                tipo = "Suplemento";
                break;
        }
        
        Produto produto = new Produto(nome, precoUnitario, precoVenda, tipo, especificacao);
        addLista(getListaProdutosCadastrados(), produto);
    }
    
    /**
     * Método que realiza a remoção de um produto.
     * 
     * O método imprime os produtos que estão na memória dinâmica e solicita o input
     * de um ID do produto para que o mesmo seja removido da memória.
     */
    public void deletarProduto(int index){
        removerLista(getListaProdutosCadastrados(), f -> ((Produto) f).getId() == index);
    }
    
    /**
     * Método que retorna um produto pelo seu id.
     * 
     * O método recbe um id e pesquisa se há um produto com o mesmo id, caso haja 
     * ele retorna o produto para que suas informações sejam alteradas.
     * @param id ID do produto a ser retornado
     * @return Objeto da classe Produto que possui o ID passado
     */
    public Produto retornarProduto(int id){
        for (Produto produto : getListaProdutosCadastrados()){
            if (id == produto.getId()){
                return produto;
            }
        }
        System.out.println("Produto nao encontrado!");
        return null;
    }
    
    /**
     * Método que atualiza as informações de um produto.
     * 
     * O método recebe um produto e novos atributos, os quais irão substituir os 
     * atributos atuais do produto que foi passado.
     * @param produto Objeto da classe Produto a ser atualizado
     * @param nome Novo nome do produto
     * @param precoUnitario Novo preço de compra do produto
     * @param precoVenda Novo preço de revenda do produto
     * @param categoria 1 para "Acessório", 2 para "Equipamento" e 3 para "Suplemento"
     * @param especificacao Novo texto com informações sobre o produto
     */
    public void atualizarProduto(Produto produto,String nome,float precoUnitario,float precoVenda,int categoria,String especificacao){
        String tipo;
        
        switch (categoria) {
            case 1:
                tipo = "Acessorio";
                break;
            case 2:
                tipo = "Equipamento";
                break;
            case 3:
                tipo = "Suplemento";
                break;
            default:
                tipo = "Nao Declarado";
                break;
        }
        
        produto.setNome(nome);
        produto.setPrecoUnitario(precoUnitario);
        produto.setPrecoVenda(precoVenda);
        produto.setCategoria(tipo);
        produto.setEspecificacoes(especificacao);
    }
    
    /**
     * Método que adiciona um produto ao estoque.
     * 
     * Esse método recebe o ID de um produto e a quantidade desse produto que está 
     * sendo adicionado ao estoque atual.
     * @param index ID do produto a dar entrada
     * @param quantidade Quantidade do produto passado
     */
    public void entradaEstoque(int index, int quantidade){
        Produto produto = retornarProduto(index);
        Item item = new Item(produto, quantidade);
        addLista(getListaProdutosEstoque(), item);
    }
    
    /**
     * Método que imprime todos os produtos cadastrados.
     * 
     * Esse método percorre toda a memória dinâmica de produtos e imprime cada 
     * um deles utilizando um ForEach.
     */
    public void percorrerProdutosCadastrados(){
        for (Produto produto : getListaProdutosCadastrados()){
            System.out.println(produto);
        }
    }
    
    /**
     * Método que imprime todos os itens no estoque.
     * 
     * Esse método percorre toda a memória dinâmica do estoque e imprime cada 
     * item utilizando um ForEach.
     */
    public void percorrerProdutosEstoque(){
        for (Item item : getListaProdutosEstoque()){
            System.out.println(item);
        }
    }
    
    // Construtor
    public GerenciamentoEstoque(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para realizar o gerenciamento de estoque.]";
    }
}
