package controller.comparator;

import java.util.Comparator;
import models.Funcionario;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator para a comparação 
 * entre dois ID de funcionários distintos.</p>
 * @author Marcos
 */
public class FuncionarioIdComparator implements Comparator<Funcionario>{
    // Método
    /**
     * Sobrescrita do Método Compare para realizar a comparação entre dois IDs de diferentes Clientes.
     * @param funcionario1 Primeiro Funcionário a verificar o ID
     * @param funcionario2 Segundo Funcionário a verificar o ID
     * @return -n quando o segundo ID é maior, 0 quando são iguais e +n quando o primeiro é maior
     */
    @Override
    public int compare(Funcionario funcionario1, Funcionario funcionario2){
        return Comparador.comparador(funcionario1.getId(), funcionario2.getId());
    }
    
    // Construtor
    public FuncionarioIdComparator(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para implementação da interface Comparator.]";
    }
}
