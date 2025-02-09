package controller.comparator;

import java.util.Comparator;
import models.Funcionario;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator para a comparação 
 * entre dois CPFs de funcionários distintos.</p>
 * @author Marcos
 */
public class FuncionarioCpfComparator implements Comparator<Funcionario>{
    // Método
    /**
     * Sobrescrita do Método Compare para realizar a comparação entre dois CPFs de diferentes Clientes.
     * @param funcionario1 Primeiro Funcionário a verificar o CPF
     * @param funcionario2 Segundo Funcionário a verificar o CPF
     * @return -n e +n quando são diferentes, 0 quando são iguais 
     */
    @Override
    public int compare(Funcionario funcionario1, Funcionario funcionario2){
        return Comparador.comparador(funcionario1.getCpf(), funcionario2.getCpf());
    }
    
    // Construtor
    public FuncionarioCpfComparator(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para implementação da interface Comparator.]";
    }
}
