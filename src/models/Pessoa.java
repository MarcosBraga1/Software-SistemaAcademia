package models;

/**
 * Classe que representa uma pessoa comum.
 * 
 * <p>Essa classe serve de modelo para a criação de outras duas, sendo elas Funcionario 
 * e Cliente. Ela inclui métodos de acesso e modificação de seus atributos, junto do 
 * construtor e método toString.</p>
 * 
 * @author Marcos
 */
public abstract class Pessoa {
    // Atributos
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    //Construtores
    public Pessoa(){
        
    }
    
    public Pessoa(String nome, String cpf, String endereco, String email, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
    
    // toString
    @Override
    public String toString() {
        return "Pessoa [Nome: " + nome + ",\nCPF: " + cpf + ",\nEndereco: " + endereco + ",\nEmail: " + email + ",\nTelefone: " + telefone + "]\n";
    }
}
