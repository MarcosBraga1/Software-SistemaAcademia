package models;

import controller.comparator.AgendamentoIdComparator;
import controller.comparator.ClienteIdComparator;
import controller.comparator.Comparador;
import controller.comparator.FuncionarioIdComparator;
import controller.comparator.ProdutoCIdComparator;
import controller.comparator.ProdutoEIdComparator;
import controller.comparator.VendaIdComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import static models.Estoque.getListaProdutosCadastrados;
import static models.Estoque.getListaProdutosEstoque;

/**
 * Classe que armazena informacoes do sistema.
 * 
 * <p>Essa classe possui alguns atributos que armazenam informações úteis para a 
 * utilização do sistema.</p>
 * 
 * @author Marcos
 */
public class SystemAcad {
    // Atributos
    // Atributos Quantidade Instanciadas
    private static int quantidadeClientes;
    private static int quantidadeProdutos;
    protected static int quantidadeClientes_;
    protected static int quantidadeFuncionarios_;
    protected static int quantidadeGerentes_;
    protected static int quantidadeAgendamentos_;
    protected static int quantidadeProdutos_;
    protected static int quantidadeVendas_;
    protected static int quantidadeItem_;
    
    // Atributo Salas da Academia
    private static String[] salas = {"Spinning", "Musculacao", "Fit Dance", "Pilates"};
    
    // Atributos Para Uso Dinâmico de Memória
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    private static ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();
    private static ArrayList<Venda> listaVendas = new ArrayList<>();
    private static ArrayList<RegistroES> listaEntradaSaida = new ArrayList<>();

    // Getters e Setters Quantidade de Instâncias
    public static void setQuantidadeClientes(int quantidadeClientes){
        SystemAcad.quantidadeClientes = quantidadeClientes;
    }
    
    public static int getQuantidadeClientes(){
        return quantidadeClientes;
    }
    
    public static void setQuantidadeProdutos(int quantidadeProdutos){
        SystemAcad.quantidadeProdutos = quantidadeProdutos;
    }
    
    public static int getQuantidadeProdutos(){
        return quantidadeProdutos;
    }
    
    public static int getQuantidadeClientes_() {
        return quantidadeClientes_;
    }

    public static void setQuantidadeClientes_(int quantidadeClientes_) {
        SystemAcad.quantidadeClientes_ = quantidadeClientes_;
    }

    public static int getQuantidadeFuncionarios_() {
        return quantidadeFuncionarios_;
    }

    public static void setQuantidadeFuncionarios_(int quantidadeFuncionarios_) {
        SystemAcad.quantidadeFuncionarios_ = quantidadeFuncionarios_;
    }
    
    public static int getQuantidadeGerentes_() {
        return quantidadeGerentes_;
    }

    public static void setQuantidadeGerentes_(int quantidadeGerentes_) {
        SystemAcad.quantidadeGerentes_ = quantidadeGerentes_;
    }

    public static int getQuantidadeAgendamentos_() {
        return quantidadeAgendamentos_;
    }

    public static void setQuantidadeAgendamentos_(int quantidadeAgendamentos_) {
        SystemAcad.quantidadeAgendamentos_ = quantidadeAgendamentos_;
    }

    public static int getQuantidadeProdutos_() {
        return quantidadeProdutos_;
    }

    public static int getQuantidadeItem_() {
        return quantidadeItem_;
    }

    public static void setQuantidadeItem_(int quantidadeItem_) {
        SystemAcad.quantidadeItem_ = quantidadeItem_;
    }
    

    public static void setQuantidadeProdutos_(int quantidadeProdutos_) {
        SystemAcad.quantidadeProdutos_ = quantidadeProdutos_;
    }

    public static int getQuantidadeVendas_() {
        return quantidadeVendas_;
    }

    public static void setQuantidadeVendas_(int quantidadeVendas_) {
        SystemAcad.quantidadeVendas_ = quantidadeVendas_;
    }
    
    // Getters e Setters Listas Dinâmicas
    public static String[] getSalas(){
        return salas;
    }
    
    /**
     * Retorna a sala no index especificado no vetor de salas.
     * 
     * <p>Não há a necessidade de um método setSalas por se tratar de um vetor que não será alterado.</p>
     * 
     * @param index O indice da sala a ser retornada. Deve estar entre 0 e o tamanho do vetor de salas menos um, caso contrário retorna null.
     * @return O nome da sala no índice especificado.
     */
    public static String getSalas(int index){
        if (index >= 0 && index < salas.length){
            return salas[index];
        }
        else{
            return null;
        }
    }
    
    public static ArrayList<Cliente> getListaClientes(){
        return listaClientes;
    }
    
    /**
     * Retorna o cliente no index especificado no vetor de clientes.
     * @param index O indice da cliente a ser retornada. Deve estar entre 0 e o tamanho do vetor menos um, caso contrário retorna null.
     * @return O cliente no índice especificado.
     */
    public static Cliente getListaClientes(int index){
        if (index >= 0 && index < listaClientes.size()){
            return listaClientes.get(index);
        } else{
            return null;
        }
    }
    
    public static void setListaClientes(ArrayList<Cliente> lista){
        listaClientes = lista;
    }
    
    public static ArrayList<Funcionario> getListaFuncionarios(){
        return listaFuncionarios;
    }
    
    /**
     * Retorna o funcionário no index especificado no vetor de funcionários.
     * @param index O indice da funcionário a ser retornada. Deve estar entre 0 e o tamanho do vetor menos um, caso contrário retorna null.
     * @return O funcionário no índice especificado.
     */
    public static Funcionario getListaFuncionarios(int index){
        if (index >= 0 && index < listaFuncionarios.size()){
            return listaFuncionarios.get(index);
        } else{
            return null;
        }
    }
    
    public static void setListaFuncionarios(ArrayList<Funcionario> lista){
        listaFuncionarios = lista;
    }
    
    public static ArrayList getListaAgendamentos(){
        return listaAgendamentos;
    }
    
    /**
     * Retorna o agendamnto no index especificado no vetor de funcionários.
     * @param index O indice da agendamento a ser retornada. Deve estar entre 0 e o tamanho do vetor menos um, caso contrário retorna null.
     * @return O agendamento no índice especificado.
     */
    public static Agendamento getListaAgendamentos(int index){
        if (index >= 0 && index < listaAgendamentos.size()){
            return listaAgendamentos.get(index);
        } else{
            return null;
        }
    }
    
    /**
     * Método que retorna uma lista de agendamentos preliminares.
     * 
     * O método percorre toda lista de agendamentos na memória dinâmica em busca 
     * de agendamentos que possuam o estado de "Preliminar".
     * @return ArrayList de agendamentos preliminares.
     */
    public static ArrayList getListaAgendamentosPeliminar(){
        ArrayList<Agendamento> lista = new ArrayList<>();
        for (Iterator it = getListaAgendamentos().iterator(); it.hasNext();) {
            Agendamento agendamento = (Agendamento) it.next();
            if (agendamento.getStatus().equals("Preliminar")){
                lista.add(agendamento);
            }
        }
        return lista;
    }
    
    public static void setListaAgendamentos(ArrayList<Agendamento> lista){
        listaAgendamentos = lista;
    }

    public static ArrayList<Venda> getListaVendas() {
        return listaVendas;
    }

    public static void setListaVendas(ArrayList<Venda> listaVendas) {
        SystemAcad.listaVendas = listaVendas;
    }

    public static ArrayList<RegistroES> getListaEntradaSaida() {
        return listaEntradaSaida;
    }

    public static void setListaEntradaSaida(ArrayList<RegistroES> listaEntradaSaida) {
        SystemAcad.listaEntradaSaida = listaEntradaSaida;
    }
    
    public static void setarIds(){
        Collections.sort(getListaClientes(), new ClienteIdComparator());
        Collections.sort(getListaFuncionarios(), new FuncionarioIdComparator());
        Collections.sort(getListaAgendamentos(), new AgendamentoIdComparator());
        Collections.sort(getListaVendas(), new VendaIdComparator());
        Collections.sort(getListaProdutosCadastrados(), new ProdutoCIdComparator());
        Collections.sort(getListaProdutosEstoque(), new ProdutoEIdComparator());
        
        if(!listaClientes.isEmpty()){
            Cliente id = listaClientes.get(listaClientes.size() - 1);
            setQuantidadeClientes_(id.getId());
        }
        if(!listaFuncionarios.isEmpty()){
            Funcionario id = listaFuncionarios.get(listaFuncionarios.size() - 1);
            setQuantidadeFuncionarios_(id.getId());
        }
        if(!listaAgendamentos.isEmpty()){
            Agendamento id = listaAgendamentos.get(listaAgendamentos.size() - 1);
            setQuantidadeAgendamentos_(id.getId());
        }
        if(!listaVendas.isEmpty()){
            Venda id = listaVendas.get(listaVendas.size() - 1);
            setQuantidadeVendas_(id.getId());
        }
        if(!getListaProdutosCadastrados().isEmpty()){
            Produto id = getListaProdutosCadastrados().get(getListaProdutosCadastrados().size() - 1);
            setQuantidadeProdutos_(id.getId());
        }
        if(!getListaProdutosEstoque().isEmpty()){
            Item id = getListaProdutosEstoque().get(getListaProdutosEstoque().size() - 1);
            setQuantidadeItem_(id.getId());
        }
    }
    
    // Construtores
    public SystemAcad(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "SystemAcad [Quantidade de Clientes: " + quantidadeClientes + ",\nQuantidade de Funcionarios: " + quantidadeFuncionarios_ + ",\nQuantidade de Agendamentos: " + quantidadeAgendamentos_ + "]\n";
    }
}
