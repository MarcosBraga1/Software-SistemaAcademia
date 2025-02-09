package models.chainofresponsibility;

import models.Funcionario;

/**
 * Subclasse de BaseHandler e segundo da cadeia.
 * 
 * <p>Essa subclasse é a segunda a ser executada e serve para verificar se senha 
 * inserida está correta com o usuário fornecido.</p>
 * @author Marcos
 */
public class CheckPasswordHandler extends BaseHandler {
    /**
     * Sobrescrida de handle, que verifica se a senha inserida é igual a do funcionário 
     * a qual o usuário de login pertence.
     * @param usuario Usuário de login inserido
     * @param senha Senha de login inserido
     * @param funcionario Funcionário a qual o usuário pertence
     * @return Falso caso a senha não seja igual, ou o próximo da cadeia caso sim
     */
    @Override
    public boolean handle(String usuario, String senha, Funcionario funcionario) {
        // Aqui não precisa procurar o usuario novamente
        if (funcionario.getSenha().equals(senha)) {
            return super.handle(usuario, senha, funcionario);
        }
        System.out.println("Senha incorreta!");
        return false;
    }
    
    // Construtores
    public CheckPasswordHandler(){
        
    }
    
    public CheckPasswordHandler(BaseHandler proximo){
        setNext(proximo);
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe concreta pertencente ao sistema de login para verificar se a senha esta correta.]";
    }
}

