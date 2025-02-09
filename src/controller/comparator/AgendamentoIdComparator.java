package controller.comparator;

import java.util.Comparator;
import models.Agendamento;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator para a comparação 
 * entre dois ID de agendamentos distintos.</p>
 * @author Marcos
 */
public class AgendamentoIdComparator implements Comparator<Agendamento>{
    // Método
    /**
     * Sobrescrita do Método Compare para realizar a comparação entre dois IDs de diferentes Agendamentos.
     * @param agendamento1 Primeiro Agendamento a verificar o ID
     * @param agendamento2 Segundo Agendamento a verificar o ID
     * @return -n quando o segundo ID é maior, 0 quando são iguais e +n quando o primeiro é maior
     */
    @Override
    public int compare(Agendamento agendamento1, Agendamento agendamento2){
        return Comparador.comparador(agendamento1.getId(), agendamento2.getId());
    }
    
    // Construtor
    public AgendamentoIdComparator(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para implementação da interface Comparator.]";
    }
}
