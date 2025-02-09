package models.chainofresponsibility;

import models.Funcionario;
import view.SystemView;
import view.AdminView;

/**
 * Subclasse de BaseHandler e terceiro da cadeia.
 * 
 * <p>Essa subclasse é a terceira a ser executada e serve para verificar se o usuario 
 * inserida possui acesso de administrador ou usuario comum.</p>
 * @author Marcos
 */
public class RoleCheckHandler extends BaseHandler {
    /**
     * Sobrescrita de handle, que verifica o cargo do funcionário dentro do sistema.
     * @param usuario Usuário de login inserido
     * @param senha Senha de login inserido
     * @param funcionario Funcionário a qual o usuário pertence
     * @return Falso caso não tenha um cargo definido, ou a interface do sistema de acordo com o cargo.
     */
    @Override
    public boolean handle(String usuario, String senha, Funcionario funcionario) {
        if (funcionario != null) {
            if (funcionario.getCargo().equals("Gerente")) {
                System.out.println("Acesso concedido como Gerente.");
                AdminView sv = new AdminView();
                sv.adminView();
            } else if (funcionario.getCargo().equals("Funcionario")) {
                System.out.println("Acesso concedido como Funcionario.");
                SystemView sv = new SystemView();
                sv.systemView();
            } else {
                System.out.println("Tipo de usuário desconhecido.");
                return false;
            }
        }
        return false;
    }
    
    // Construtor
    public RoleCheckHandler(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe concreta pertencente ao sistema de login para verificar o cargo do usuário logado.]";
    }
}

