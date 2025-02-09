package controller.comparator;

import java.util.Comparator;
import models.Cliente;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator para a comparação 
 * entre dois CPFs de clientes distintos.</p>
 * @author Marcos
 */
public class ClienteCpfComparator implements Comparator<Cliente>{
    // Método
    /**
     * Sobrescrita do Método Compare para realizar a comparação entre dois CPFs de diferentes Clientes.
     * @param cliente1 Primeiro Cliente a verificar o CPF
     * @param cliente2 Segundo Cliente a verificar o CPF
     * @return -n e +n quando são diferentes, 0 quando são iguais 
     */
    @Override
    public int compare(Cliente cliente1, Cliente cliente2){
        return Comparador.comparador(cliente1.getCpf(), cliente2.getCpf());
    }
    
    // Construtor
    public ClienteCpfComparator(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para implementação da interface Comparator.]";
    }
}
