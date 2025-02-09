package controller.comparator;

import java.util.Comparator;
import models.Cliente;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator para a comparação 
 * entre dois ID de clientes distintos.</p>
 * @author Marcos
 */
public class ClienteIdComparator implements Comparator<Cliente> {
    // Método
    /**
     * Sobrescrita do Método Compare para realizar a comparação entre dois IDs de diferentes Clientes.
     * @param cliente1 Primeiro Cliente a verificar o ID
     * @param cliente2 Segundo Cliente a verificar o ID
     * @return -n quando o segundo ID é maior, 0 quando são iguais e +n quando o primeiro é maior
     */
    @Override
    public int compare(Cliente cliente1, Cliente cliente2){
        return Comparador.comparador(cliente1.getId(), cliente2.getId());
    }
    
    // Construtor
    public ClienteIdComparator(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para implementação da interface Comparator.]";
    }
}