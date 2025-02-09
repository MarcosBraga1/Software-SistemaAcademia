package controller.comparator;

import java.util.Comparator;
import models.Item;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator para a comparação 
 * entre dois ID de itens distintos.</p>
 * @author Marcos
 */
public class ProdutoEIdComparator implements Comparator<Item>{
    // Método
    /**
     * Sobrescrita do Método Compare para realizar a comparação entre dois IDs de diferentes itens.
     * @param item1 Primeiro item a verificar o ID
     * @param item2 Segundo item a verificar o ID
     * @return -n quando o segundo ID é maior, 0 quando são iguais e +n quando o primeiro é maior
     */
    @Override
    public int compare(Item item1, Item item2){
        return Comparador.comparador(item1.getId(), item2.getId());
    }
    
    // Construtor
    public ProdutoEIdComparator(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para implementação da interface Comparator.]";
    }
}
