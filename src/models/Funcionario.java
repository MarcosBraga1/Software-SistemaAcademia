package models;

import static models.SystemAcad.quantidadeFuncionarios_;

/**
 *Classe que representa um usuário do sistema.
 * 
 *<p>Essa classe é subclasse de Pessoa e serve de modelo para representar um usuário 
 * do sistema e funcionário da academia. Ela adiciona novos atributos sendo eles ID, cargo 
 * usuário e senha, junto de seus getters e setters, com exceção do ID que possui o setId()
 * protected para que Gerente tenha um ID próprio de acordo com a quantidade de Gerentes instanciados.</p>
 * 
 * @author Marcos
 */
public class Funcionario extends Pessoa{
    // Atributos
    private int id;
    private String cargo;
    private String usuario;
    private String senha;
    
    // Getters e Setters
    public int getId(){
        return id;
    }
    
    protected void setId(int id){
        this.id = id;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // Construtores
    public Funcionario(){
        
    }
    
    public Funcionario(String nome, String cpf, String endereco, String email, String telefone, String cargo, String usuario, String senha){
        super(nome, cpf, endereco, email, telefone);
        quantidadeFuncionarios_ += 1;
        this.id = quantidadeFuncionarios_;
        this.cargo = cargo;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    // toString
    @Override
    public String toString(){
        return "Funcionario [ID: " + id + ",\nNome: " + getNome() + ",\nCPF: " + getCpf() + ",\nEndereco: " + getEndereco() + ",\nEmail: " + getEmail() + ",\nTelefone: " + getTelefone() + ",\nCargo: " + cargo + "]\n";
    }
}
