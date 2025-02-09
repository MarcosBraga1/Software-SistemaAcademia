package controller;


import models.Cliente;
import models.RegistroES;
import static models.SystemAcad.getListaEntradaSaida;

/**
 * Classe para realizar o gerenciamento de entrada e saida de clientes.
 * 
 * <p>Essa classe é responsável por possuir todos os métodos que estão relacionados 
 * ao gerenciamento de entrada e saida de clientes dentro do academia.</p>
 * @author Marcos
 */
public class GerenciamentoES extends GerenciamentoDados {
    // Instância de gerenciamentos para o uso dentro da classe
    GerenciamentoCliente gc = new GerenciamentoCliente();
    
    // Métodos
    /**
     * Método chamado no momento em que um cliente passa pela catraca.
     * 
     * Esse método recebe o ID de um Cliente que será inserido pelo mesmo no momento 
     * em que for passar pela catraca, ao receber o ID ele verifica se o cliente está 
     * entrando ou saindo da academia, para que seja armazenado no Log das entradas.
     * @param index ID do cliente que está acessando a academia
     */
    public void catraca(int index) {
    Cliente cliente = gc.retornarCliente(index);
    String sentido = "Entrada";

    for (int i = getListaEntradaSaida().size() - 1; i >= 0; i--) {
        RegistroES es = getListaEntradaSaida().get(i);
        if (cliente.getId() == es.getCliente().getId()) {
            if (es.getTipo().equals("Entrada")) {
                sentido = "Saida";
            } else {
                sentido = "Entrada";
            }
            break;
        }
    }

    RegistroES res = new RegistroES(cliente, sentido);
    addLista(getListaEntradaSaida(), res);
}
    
    // Construtor
    public GerenciamentoES(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para realizar o gerenciamento de entrada e saida de clientes.]";
    }
}
