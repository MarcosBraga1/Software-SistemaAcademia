package view;

import java.util.Scanner;
import models.chainofresponsibility.BaseHandler;
import models.chainofresponsibility.CheckPasswordHandler;
import models.chainofresponsibility.CheckUserExistsHandler;
import models.chainofresponsibility.RoleCheckHandler;

/**
 * Classe que armazena o método da view de login
 * 
 * <p>Essa classe é responsável por possuir um método que cria a view para o login
 * de um usuário no sistema.</p>
 * @author Marcos
 */
public class LoginView {
    // Instância de gerenciamentos para o uso dentro da classe
    Scanner scanner = new Scanner(System.in);    
    BaseHandler roleHandler = new RoleCheckHandler();
    BaseHandler passwordHandler = new CheckPasswordHandler(roleHandler);
    BaseHandler userHandler = new CheckUserExistsHandler(passwordHandler);
    
    // Método
    /**
     * Método responsável por criar a view do login de um usuário no sistema.
     */
    public void loginView(){
        System.out.println("-----Login no Sistema-----");
        System.out.println("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.println("Senha: ");
        String senha = scanner.nextLine();
        
        userHandler.handle(usuario, senha, null);
    }
    
}
