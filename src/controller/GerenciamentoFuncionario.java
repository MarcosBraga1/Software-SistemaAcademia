package controller;

import java.util.Iterator;
import models.Funcionario;
import static models.SystemAcad.getListaFuncionarios;

/**
 * Classe para realizar o gerenciamento de funcionários.
 * 
 * <p>Essa classe é responsável por possuir todos os métodos que estão relacionados 
 * ao gerenciamento de funcionários dentro do sistema.</p>
 * @author Marcos
 */
public class GerenciamentoFuncionario extends GerenciamentoDados{
    // Métodos
    /**
     * Método que realiza o cadastro de um novo funcionário na memória dinâmica.
     * 
     * O método coleta as informações do funcionário, instância um novo objeto do tipo Funcionario
     * e adiciona na lista dinâmica de funcionários.
     * @param nome Nome do funcionário que está sendo cadastrado
     * @param cpf CPF do funcionário que está sendo cadastrado
     * @param endereco Endereço do funcionário que está sendo cadastrado
     * @param email E-mail do funcionário que está sendo cadastrado
     * @param telefone Telefone do funcionário que está sendo cadastrado
     * @param cargo 1 para "Funcionario" e 2 para "Gerente"
     * @param usuario Usuário do funcionário para logar no sistema
     * @param senha Senha do funcionário para logar no sistema
     */
    public void cadastrarFuncionario(String nome, String cpf, String endereco, String email, String telefone, int cargo, String usuario, String senha){
        String aux;
        switch (cargo) {
            case 1:
                aux = "Funcionario";
                break;
            case 2:
                aux = "Gerente";
                break;
            default:
                aux = "Funcionario";
                break;
        }
        Funcionario funcionario = new Funcionario(nome, cpf, endereco, email, telefone, aux, usuario, senha);
        addLista(getListaFuncionarios(), funcionario);
    }
    
    /**
     * Método que realiza a remoção de um funcionário.
     * 
     * O método imprime os funcionários que estão na memória dinâmica e solicita o input
     * de um ID do funcionários para que o mesmo seja removido da memória.
     * @param index ID do funcionário a ser deletado
     */
    public void deletarFuncionario(int index){
        removerLista(getListaFuncionarios(), f -> ((Funcionario) f).getId() == index);
    }
    
    /**
     * Método que retorna um funcionário pelo seu id.
     * 
     * O método recbe um ID e pesquisa se há um funcionário com o mesmo ID, caso haja 
     * ele retorna o funcionário para que suas informações sejam alteradas.
     * @param id ID do funcionário a ser retornado
     * @return Objeto da classe Funcionario que possui o ID passado
     */
    public Funcionario retornarFuncionario(int id){
        for (Funcionario funcionario : getListaFuncionarios()){
            if (id == funcionario.getId()){
                return funcionario;
            }
        }
        System.out.println("Funcionario nao encontrado!");
        return null;
    }
    
    /**
     * Método que atualiza as informações de um funcionário.
     * 
     * O método recebe um funcionário e novos atributos, os quais irão substituir os 
     * atributos atuais do funcionário que foi passado.
     * @param funcionario Objeto da classe Funcionario que será atualizado
     * @param nome Novo nome que irá substituir
     * @param cpf Novo CPF que irá substituir
     * @param endereco Novo endereço que irá substituir
     * @param email Novo e-mail que irá substituir
     * @param telefone Novo telefone que irá substituir
     * @param cargo Novo cargo que irá substituir
     * @param usuario Novo usuário que irá substituir
     * @param senha Nova senha que irá substituir
     */
    public void atualizarFuncionario(Funcionario funcionario, String nome, String cpf, String endereco, String email, String telefone, int cargo, String usuario, String senha){
        String aux;
        switch (cargo) {
            case 1:
                aux = "Funcionario";
                break;
            case 2:
                aux = "Gerente";
                break;
            default:
                aux = "Funcionario";
                break;
        }
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setEndereco(endereco);
        funcionario.setEmail(email);
        funcionario.setTelefone(telefone);
        funcionario.setCargo(aux);
        funcionario.setUsuario(usuario);
        funcionario.setSenha(senha);
    }
    
    /**
     * Método que imprime todos os funcionarios cadastrados.
     * 
     * Esse método percorre toda a memória dinâmica de funcionarios e imprime cada 
     * um deles utilizando um iterator.
     */
    public void percorrerFuncionariosIterator(){
        Iterator<Funcionario> iterator = getListaFuncionarios().iterator();
        
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            System.out.println(funcionario);
        }
    }
    
    /**
     * Método que imprime todos os funcionarios cadastrados.
     * 
     * Esse método percorre toda a memória dinâmica de funcionarios e imprime cada 
     * um deles utilizando um ForEach.
     */
    public void percorrerFuncionariosForEach(){
        for (Funcionario funcionario : getListaFuncionarios()){
            System.out.println(funcionario);
        }
    }
    
    // Construtor
    public GerenciamentoFuncionario(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para realizar o gerenciamento de funcionários.]";
    }
}
