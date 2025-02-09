package models.chainofresponsibility;

import models.Funcionario;

/**
 * Classe interface Handler para Chain of Resposibility.
 * 
 * <p>Essa classe é interface para a construção do padrão de projeto chain of responsibility 
 * quer será aplicado no processo de autenticação de usuário.</p>
 * @author Marcos
 */
public interface Handler {
    // Métodos
    /**
     * Método que define o próximo manipulador da cadeia.
     * @param h O próximo manipulador a tentar tratar os dados.
     */
    void setNext(Handler h);
    
    /**
     * Método que tentará tratar os dados para realizar a autenticação de usuário.
     * @param usuario 
     * @param senha
     * @return 
     */
    boolean handle(String usuario, String senha, Funcionario funcionario);
}
