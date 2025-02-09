package controller.comparator;

import java.util.Comparator;
import models.Venda;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator para a comparação 
 * entre dois ID de vendas distintas.</p>
 * @author Marcos
 */
public class VendaIdComparator implements Comparator<Venda>{
    // Método
    /**
     * Sobrescrita do Método Compare para realizar a comparação entre dois IDs de diferentes Clientes.
     * @param venda1 Primeiro Funcionário a verificar o ID
     * @param venda2 Segundo Funcionário a verificar o ID
     * @return -n quando o segundo ID é maior, 0 quando são iguais e +n quando o primeiro é maior
     */
    @Override
    public int compare(Venda venda1, Venda venda2){
        return Comparador.comparador(venda1.getId(), venda2.getId());
    }
    
    // Construtor
    public VendaIdComparator(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para implementação da interface Comparator.]";
    }
}
