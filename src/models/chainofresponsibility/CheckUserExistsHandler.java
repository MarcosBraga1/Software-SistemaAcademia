package models.chainofresponsibility;

import models.Funcionario;
import static models.SystemAcad.getListaFuncionarios;

/**
 * Subclasse de BaseHandler e primeiro da cadeia.
 * 
 * <p>Essa subclasse é a primeira a ser executada e serve para verificar se o usuario 
 * inserido está presente dentro do banco de dados de funcionarios.</p>
 * @author Marcos
 */
public class CheckUserExistsHandler extends BaseHandler {
    /**
     * Sobrescrita de handle, que verifica se o usuário que foi inserido está 
     * presente na memória dinâmica do sistema.
     * @param usuario Usuário de login inserido
     * @param senha Senha de login inserido
     * @param funcionario Funcionário a qual o usuário pertence
     * @return Falso caso o usuário não pertença, ou o próximo da cadeia caso sim
     */
    @Override
    public boolean handle(String usuario, String senha, Funcionario funcionario) {
        for (Funcionario func : getListaFuncionarios()) {
            if (func.getUsuario().equals(usuario)) {
                return super.handle(usuario, senha, func);
            }
        }
        System.out.println("Usuário incorreto!");
        return false;
    }
    
    // Construtores
    public CheckUserExistsHandler(){
        
    }
    
    public CheckUserExistsHandler(BaseHandler proximo){
        setNext(proximo);
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe concreta pertencente ao sistema de login para verificar se o usuário existe.]";
    }
}
