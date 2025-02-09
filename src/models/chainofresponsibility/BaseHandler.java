package models.chainofresponsibility;

import models.Funcionario;

/**
 * Classe abstrata BaseHandler para Chain of Resposibility.
 * 
 * <p>Essa classe abstrata implementa a interface Handler e serve para armazenar a 
 * referência para o próximo manipulador, permitindo que cada etapa passe a 
 * solicitação adiante caso não consiga processá-la.</p>
 * @author Marcos
 */
public abstract class BaseHandler implements Handler {
    // Atributo
    private Handler proximo;
    
    // Métodos
    /**
     * Método que define o próximo manipulador da cadeia.
     * @param proximo O próximo manipulador a tentar tratar os dados.
     */
    @Override
    public void setNext(Handler proximo){
        this.proximo = proximo;
    }
    
    /**
     * Método que verifica se há um próximo manipulador a ser chamado, e o chama caso haja.
     * @param usuario Usuário de login inserido
     * @param senha Senha de login inserido
     * @param funcionario Funcionário a qual o usuário pertence
     * @return Verdadeiro caso todos os manipuladores obtiverem sucesso
     */
    @Override
    public boolean handle(String usuario, String senha, Funcionario funcionario){
        if (proximo != null){
            return proximo.handle(usuario, senha, funcionario);
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "INFO [Classe abstrata para realização do login por meio do padrão de projeto Chain of Responsibility.]";
    }
}
