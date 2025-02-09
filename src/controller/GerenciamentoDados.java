package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Classe para realizar o gerenciamento de dados.
 * 
 * <p>Essa classe é uma superclasse responsável por possuir todos os métodos que 
 * estão relacionados ao gerenciamento de dados dentro do sistema.</p>
 * @author Marcos
 */
public class GerenciamentoDados {
    // Instância para o uso dentro da classe
    Scanner scanner = new Scanner(System.in);
    GerenciamentoBD gbd = new GerenciamentoBD();
    
    // Métodos
    /**
     * Método que adiciona um objeto a um ArrayList da mesma classe.
     * 
     * @param <T> Parâmetro que pertence ao ArrayList e Objeto a ser inserido.
     * @param lista Lista onde será inserido o objeto.
     * @param objeto Objeto que será inserido na lista.
     */
    protected <T> void addLista(ArrayList<T> lista, T objeto){
        lista.add(objeto);
    }
    
    /**
     * Remove o primeiro elemento da lista que satisfaz a condição fornecida pelo Predicate.
     * 
     * <p>Este método percorre a lista e usa o {@link Iterator} para remover o elemento que
     * atende à condição especificada. O critério de remoção é definido por um {@link Predicate}.
     * A remoção ocorre de forma segura durante a iteração.</p>
     * @param <T> O tipo de elementos contidos na lista.
     * @param lista A lista da qual o elemento será removido.
     * @param predicate um {@link Predicate} que define a condição para remoção.
     */
    protected <T> void removerLista(ArrayList<T> lista, Predicate<T> predicate) {
        Iterator<T> iterator = lista.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            T objeto = iterator.next();
            if (predicate.test(objeto)) {
                iterator.remove(); // Remove usando o iterator
                System.out.println("Elemento removido!");
                removed = true;
                break; // Sai do loop após a remoção
            }
        }

        if (!removed) {
            System.out.println("Elemento não encontrado.");
        }
    }
    
    // Construtores
    public GerenciamentoDados(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para realizar o gerenciamento de dados.]";
    }
}
