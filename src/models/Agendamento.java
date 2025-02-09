
package models;

import java.time.LocalDate;
import java.time.LocalTime;
import static models.SystemAcad.quantidadeAgendamentos_;

/**
 * Classe que representa um agendamento de um cliente.
 * 
 * <p>Essa classe serve de modelo para representar um agendamento de um 
 * cliente.</p>
 * 
 * @author Marcos
 */
public class Agendamento {
    // Atributos
    private int id;
    private LocalDate data;
    private LocalTime hora;
    private Cliente cliente;
    private String aula;
    private Funcionario instrutor;
    private String status;
    
    //Getters e Setters
    public int getId(){
        return id;
    }
    
    /* 
        Não há a necessidade de um setID pois ele é difinido dentro do contrutor
        e o usuário não deve ter acesso a alteração;
    */
    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Funcionario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Funcionario instrutor) {
        this.instrutor = instrutor;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    // Construtores
    public Agendamento(){
        
    }
    
    public Agendamento(LocalDate data, LocalTime hora, Cliente cliente, String aula, Funcionario instrutor, String status){
        quantidadeAgendamentos_ += 1;
        this.id = quantidadeAgendamentos_;
        this.data = data;
        this.hora = hora;
        this.cliente = cliente;
        this.aula = aula;
        this.instrutor = instrutor;
        this.status = status;
    }
    
    // toString
    @Override
    public String toString(){
        return "Agendamento [ID: " + id + ",\nData: " + data + ",\nHorario: " + hora + ",\nCliente: " + cliente.getNome() + ",\nAula: " + aula + ",\nInstrutor: " + instrutor.getNome() + ",\nStatus: " + status + "]\n";
    }
}
