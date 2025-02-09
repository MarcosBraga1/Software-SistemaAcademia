package controller.comparator;

import java.util.Comparator;
import models.Produto;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator para a comparação 
 * entre dois ID de produtos distintos.</p>
 * @author Marcos
 */
public class ProdutoCIdComparator implements Comparator<Produto>{
    // Método
    /**
     * Sobrescrita do Método Compare para realizar a comparação entre dois IDs de diferentes Clientes.
     * @param produto1 Primeiro produto a verificar o ID
     * @param produto2 Segundo produto a verificar o ID
     * @return -n quando o segundo ID é maior, 0 quando são iguais e +n quando o primeiro é maior
     */
    @Override
    public int compare(Produto produto1, Produto produto2){
        return Comparador.comparador(produto1.getId(), produto2.getId());
    }
    
    // Construtor
    public ProdutoCIdComparator(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para implementação da interface Comparator.]";
    }
}
