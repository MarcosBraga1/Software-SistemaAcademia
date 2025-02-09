package models;

import java.time.LocalDateTime;

/**
 * Classe de modelo que representa uma entrada ou saida.
 * 
 * <p>Essa classe serve para representar o modelo de uma entrada ou saida de um 
 * cliente dentro da academia por meio da catraca.</p>
 * @author Marcos
 */
public class RegistroES {
    // Atributos
    private LocalDateTime dataHora;
    private Cliente cliente;
    String tipo;

    // Getters e Setters
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /* 
        Não há a necessidade de um setDataHora pois ele é difinido dentro do contrutor
        no momento em que a classe é instanciada;
    */

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    // Construtores
    public RegistroES(){
        
    }
    
    public RegistroES(Cliente cliente, String tipo){
        this.dataHora = LocalDateTime.now();
        this.cliente = cliente;
        this.tipo = tipo;
    }
    
    // toString
    @Override
    public String toString(){
        return "[" + tipo + ",\nCliente: " + cliente.getNome() + " - ID: " + cliente.getId() + ",\nHorario: " + dataHora + "]\n";
    }
}
