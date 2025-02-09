    package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import models.Agendamento;
import models.Cliente;
import models.Funcionario;
import static models.SystemAcad.getListaAgendamentos;
import static models.SystemAcad.getListaAgendamentosPeliminar;
import static models.SystemAcad.getSalas;

/**
 * Classe para realizar o gerenciamento de agendamentos.
 * 
 * <p>Essa classe é responsável por possuir todos os métodos que estão relacionados 
 * ao gerenciamento de agendamentos dentro do sistema.</p>
 * @author Marcos
 */
public class GerenciamentoAgendamento extends GerenciamentoDados{
    // Instância de gerenciamentos para o uso dentro da classe
    GerenciamentoCliente gc = new GerenciamentoCliente();
    GerenciamentoFuncionario gf = new GerenciamentoFuncionario();
    
    // Métodos
    /**
     * Método que realiza o cadastro de um novo agendamento na memória dinâmica.
     * 
     * O método coleta as informações do agendamento, instância um novo objeto do tipo Agendamento
     * e adiciona na lista dinâmica de clientes.
     * @param data Data do agendamento
     * @param hora Hora do Agendamento
     * @param clienteId ID do cliente que está agendando
     * @param aulaIndex Index da aula na memória estática
     * @param funcionarioId ID do funcionário que irá lecionar
     * @param status 1 para "Preliminar", 2 para "Confirmado"
     */
    public void cadastrarAgendamento(LocalDate data, LocalTime hora, int clienteId, int aulaIndex, int funcionarioId, int status){
        String tipo;
        Cliente aluno;
        Funcionario instrutor;
        String aula;
        
        aluno = gc.retornarCliente(clienteId);
        instrutor = gf.retornarFuncionario(funcionarioId);
        
        switch (status) {
            case 1:
                tipo = "Preliminar";
                break;
            case 2:
                tipo = "Confirmado";
                break;
            default:
                tipo = "Indefinido";
                break;
        }
        
        aula = getSalas(aulaIndex - 1);
        
        Agendamento agendamento = new Agendamento(data, hora, aluno, aula, instrutor, tipo);
        addLista(getListaAgendamentos(), agendamento);
    }
    
    /**
     * Método que realiza o cancelamento de um agendamento na memória dinâmica.
     * 
     * O método coleta o id do agendamento, e percorre a memória dinâmica em busca 
     * de um agendamento que possua o mesmo id, o removendo da memória caso encontre.
     * @param index ID do agendamento a ser deletado
     */
    public void deletarAgendamento(int index){
        removerLista(getListaAgendamentos(), f -> ((Agendamento) f).getId() == index);
    }
    
    /**
     * Método que retorna um agendamento pelo seu id.
     * 
     * O método recbe um id e pesquisa se há um agendamento com o mesmo id, caso haja 
     * ele retorna o agendamento para que suas informações sejam alteradas.
     * @param id ID do agendamento a ser retornado
     * @return Objeto da classe Agendamento que possui o ID passado
     */
    public Agendamento retornarAgendamento(int id){
        for (Iterator it = getListaAgendamentos().iterator(); it.hasNext();) {
            Agendamento agendamento = (Agendamento) it.next();
            if (id == agendamento.getId()){
                return agendamento;
            }
        }
        System.out.println("Agendamento nao encontrado!");
        return null;
    }
    
    /**
     * Método que atualiza as informações de um agendamento.
     * 
     * O método recebe um agendamento e novos atributos, os quais irão substituir os 
     * atributos atuais do agendamento que foi passado.
     * @param agendamento Objeto da classe Agendamento a ser atualizado
     * @param data Nova data do agendamento
     * @param hora Nova Hora do agendamento
     * @param clienteId ID do novo cliente agendado
     * @param aula Index da aula na memória estática
     * @param funcionarioId ID do novo funcionário que irá instruir
     * @param status 1 para "Preliminar", 2 para "Confirmado"
     */
    public void atualizarAgendamento(Agendamento agendamento, LocalDate data, LocalTime hora, int clienteId, int aula, int funcionarioId, int status){
        String tipo;
        switch (status) {
            case 1:
                tipo = "Preliminar";
                break;
            case 2:
                tipo = "Confirmado";
                break;
            default:
                tipo = "Indefinido";
                break;
        }
        
        agendamento.setData(data);
        agendamento.setHora(hora);
        agendamento.setCliente(gc.retornarCliente(clienteId));
        agendamento.setAula(getSalas(aula-1));
        agendamento.setInstrutor(gf.retornarFuncionario(funcionarioId));
        agendamento.setStatus(tipo);
    }
    
    /**
     * Método que confirma um agendamento pelo seu id.
     * 
     * O método recebe um ID e pesquisa se há um agendamento preliminar com o mesmo ID, caso haja 
     * ele altera o status do agendamento para "Confirmado".
     * @param id ID do agendamento a ser confirmado
     */
    public void confirmarAgendamento(int id){
        for (Iterator it = getListaAgendamentosPeliminar().iterator(); it.hasNext();) {
            Agendamento agendamento = (Agendamento) it.next();
            if (id == agendamento.getId()){
                agendamento.setStatus("Confirmado");
            }
        }
    }
    
    /**
     * Método que imprime todos os funcionarios cadastrados.
     * 
     * Esse método percorre toda a memória dinâmica de funcionarios e imprime cada 
     * um deles utilizando um iterator.
     */
    public void percorrerAgendamentosIterator(){
        Iterator<Agendamento> iterator = getListaAgendamentos().iterator();
        
        while (iterator.hasNext()) {
            Agendamento agendamento = iterator.next();
            System.out.println(agendamento);
        }
    }
    
    /**
     * Método que imprime todos os funcionarios cadastrados.
     * 
     * Esse método percorre toda a memória dinâmica de funcionarios e imprime cada 
     * um deles utilizando um ForEach.
     */
    public void percorrerAgendamentosForEach(){
        for (Object agendamento : getListaAgendamentos()){
            System.out.println(agendamento);
        }
    }
    
    // Construtor
    public GerenciamentoAgendamento(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe para realizar o gerenciamento de agendamentos.]";
    }
}
