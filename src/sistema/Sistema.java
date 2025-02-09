package sistema;

//  Importações para o funcionamento do sistema
import controller.GerenciamentoBD;
import view.LoginView;

/**
 * Classe main do sistema
 * @author Marcos
 */
public class Sistema {
    public static void main(String[] args) {
        //  Instâncias para Funcionamento do Sistema
        GerenciamentoBD gbd = new GerenciamentoBD();
        LoginView lv = new LoginView();
        
        gbd.carregarMemoria();
        lv.loginView();
        
        /*-=-=-=-=-=-=-=-=-=-=-=- SISTEMA -=-=-=-=-=-=-=-=-=-=-=-*/
        
        /*  ( <-- Remova o comentário)
        //  Usuário comum:
        //  usuário: marcos     senha: 12345
        
        //  Usuário administrador:
        //  usuário: admin      senha: 12345
        */
    }
}

