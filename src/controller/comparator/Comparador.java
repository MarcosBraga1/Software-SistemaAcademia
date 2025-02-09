package controller.comparator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe para implementação da interface Comparator.
 * 
 * <p>Essa classe serve para a implementação da interface Comparator.</p>
 * @author Marcos
 */
public class Comparador {
    // Métodos
    /**
     * Método que realiza a comparação entre duas Strings.
     * 
     * Esse método compara duas Strings para verificar se há diferença entre elas 
     * ou se são iguais.
     * @param string1 Uma String a ser comparada com a segunda
     * @param string2 Uma String a ser comparada com a primeira
     * @return -n quando a segunda String é maior, 0 quando são iguais e +n quando a primeira é maior
     */
    public static int comparador(String string1, String string2){
        int minLength = Math.min(string1.length(), string2.length());
        for (int i = 0; i < minLength; i++){
            char char1 = string1.charAt(i);
            char char2 = string2.charAt(i);
            
            if (char1 != char2){
                return char1 - char2;
            }
        }
        return string1.length() - string2.length();
    }
    
    /**
     * Método que realiza a comparação entre duas datas.
     * 
     * Esse método compara duas datas para verificar se há diferença entre elas 
     * ou se são iguais.
     * @param dataInicial Data inicial a ser comparada com a final
     * @param dataFinal Data final a ser comparada com a inicial
     * @return -n quando a segunda data é posterior a primeira, 0 quando são iguais e +n quando a primeira é posterior
     */
    public static int comparador(LocalDate dataInicial, LocalDate dataFinal){
        long diferencaAnos = ChronoUnit.YEARS.between(dataInicial, dataFinal);
        if (diferencaAnos != 0){
            return (int) diferencaAnos * -1;
        }
        long diferencaMeses = ChronoUnit.MONTHS.between(dataInicial, dataFinal);
        if (diferencaMeses != 0){
            return (int) diferencaMeses * -1;
        }
        long diferencaDias = ChronoUnit.DAYS.between(dataInicial, dataFinal);
        return (int) diferencaDias * -1;
    }
    
    /**
     * Método que realiza a comparação entre dois IDs.
     * 
     * Esse método compara dois IDs para verificar se há diferença entre elas 
     * ou se são iguais.
     * @param id1 Primeiro ID a ser comparado com o segundo
     * @param id2 Segundo ID a ser comparado com o primeiro
     * @return -n quando o segundo ID é maior, 0 quando são iguais e +n quando o primeiro é maior
     */
    public static int comparador(int id1, int id2){
        return id1 - id2;
    }
    
    // Construtor
    public Comparador(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para implementação da interface Comparator.]";
    }
}
