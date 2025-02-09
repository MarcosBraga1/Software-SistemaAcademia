package models;

import models.Funcionario;
import static models.SystemAcad.quantidadeFuncionarios_;
import static models.SystemAcad.quantidadeGerentes_;

/**
 *Classe que representa um administrador do sistema.
 * 
 *<p>Essa classe é uma subclasse de Funcionario e serve de modelo para diferenciar um 
 * usuário de um administrador da academia. Ela não adiciona novos atributos ou métodos, 
 * contém apenas seu Construtor e método toString, pois é uma classe apenas de diferenciação.</p>
 * 
 * @author Marcos
 */
public class Gerente extends Funcionario{   
    // Construtores
    public Gerente(){
        
    }
    
    public Gerente(String nome, String cpf, String endereco, String email, String telefone, String cargo, String usuario, String senha){
        quantidadeFuncionarios_ -= 1;
        super(nome, cpf, endereco, email, telefone, cargo, usuario, senha);
        quantidadeGerentes_ += 1;
        setId(quantidadeGerentes_);
    }
    
    // toString
    @Override
    public String toString(){
        return "Gerente [ID: " + getId() + ",\nNome: " + getNome() + ",\nCPF: " + getCpf() + ",\nEndereco: " + getEndereco() + ",\nEmail: " + getEmail() + ",\nTelefone: " + getTelefone() + ",\nCargo: " + getCargo() + "]\n";
    }
}
