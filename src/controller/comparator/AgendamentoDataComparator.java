package controller.comparator;

import java.util.Comparator;
import models.Agendamento;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator para a comparação 
 * entre duas datas de agendamentos distintos.</p>
 * @author Marcos
 */
public class AgendamentoDataComparator implements Comparator<Agendamento> {
    // Método
    /**
     * Sobrescrita do Método Compare para realizar a comparação entre duas datas de diferentes agendamentos.
     * @param agendamento1 Primeira data a ser comparado com a segunda
     * @param agendamento2 Segunda data a ser comparada com a primeira
     * @return -n quando a segunda data é posterior a primeira, 0 quando são iguais e +n quando a primeira é anterior
     */
    @Override
    public int compare(Agendamento agendamento1, Agendamento agendamento2){
        return Comparador.comparador(agendamento1.getData(), agendamento2.getData());
    }
    
    // Construtor
    public AgendamentoDataComparator(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "[Classe para implementação da interface Comparator.]";
    }
}
