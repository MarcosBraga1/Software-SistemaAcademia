package controller;

import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import models.Agendamento;
import models.Cliente;
import static models.Estoque.getListaProdutosCadastrados;
import static models.Estoque.getListaProdutosEstoque;
import static models.Estoque.setListaProdutosCadastrados;
import static models.Estoque.setListaProdutosEstoque;
import models.Funcionario;
import models.Item;
import models.Produto;
import models.RegistroES;
import static models.SystemAcad.setarIds;
import static models.SystemAcad.getListaAgendamentos;
import static models.SystemAcad.getListaClientes;
import static models.SystemAcad.getListaEntradaSaida;
import static models.SystemAcad.getListaFuncionarios;
import static models.SystemAcad.getListaVendas;
import static models.SystemAcad.setListaAgendamentos;
import static models.SystemAcad.setListaClientes;
import static models.SystemAcad.setListaEntradaSaida;
import static models.SystemAcad.setListaFuncionarios;
import static models.SystemAcad.setListaVendas;
import static models.SystemAcad.setQuantidadeClientes;
import static models.SystemAcad.setQuantidadeProdutos;
import models.Venda;

/**
 *Classe que gerencia a escrita e leitura de dados no BD.
 * 
 * <p>Essa classe é responsável por conter todos os métodos e atributos referentes a 
 * escrita e leitura de dados diretamente dos arquivos json.</p>
 * @author Marcos
 */
public class GerenciamentoBD {
    /* 
        As classes LocalDate, LocalTime e LocalDateTime utilizadas no código não possuem 
        compatibilidade para serem armazenadas em um arquivo Json, para isso é necessário
        utilizar TypeAdapters para cada classe para que o armazenamento seja possível.
    */
    
    // Adaptator da classe LocalDate
    /**
     * Método que realiza a adaptação da classe LocalDate para que os atributos que sejam 
     * instância dessa classe possam ser armazenados em um arquivo Json.
     */
    private TypeAdapter<LocalDate> localDateAdapter = new TypeAdapter<LocalDate>() {
        @Override
        public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
            jsonWriter.value(localDate.toString()); // Serializa LocalDate como String
        }

        @Override
        public LocalDate read(JsonReader jsonReader) throws IOException {
            return LocalDate.parse(jsonReader.nextString()); // Desserializa a String para LocalDate
        }
    };

    // Adaptator da classe LocalTime
    /**
     * Método que realiza a adaptação da classe LocalTime para que os atributos que sejam 
     * instância dessa classe possam ser armazenados em um arquivo Json.
     */
    private TypeAdapter<LocalTime> localTimeAdapter = new TypeAdapter<LocalTime>() {
        @Override
        public void write(JsonWriter jsonWriter, LocalTime localTime) throws IOException {
            jsonWriter.value(localTime.toString()); // Serializa LocalTime como String
        }

        @Override
        public LocalTime read(JsonReader jsonReader) throws IOException {
            return LocalTime.parse(jsonReader.nextString()); // Desserializa a String para LocalTime
        }
    };
    
    // Adaptator da classe LocalDateTime
    /**
     * Método que realiza a adaptação da classe LocalDateTime para que os atributos que sejam 
     * instância dessa classe possam ser armazenados em um arquivo Json.
     */
    private TypeAdapter<LocalDateTime> localDateTimeAdapter = new TypeAdapter<LocalDateTime>() {
        @Override
        public void write(JsonWriter jsonWriter, LocalDateTime localDateTime) throws IOException {
            jsonWriter.value(localDateTime.toString()); // Serializa LocalDateTime como String
        }

        @Override
        public LocalDateTime read(JsonReader jsonReader) throws IOException {
            return LocalDateTime.parse(jsonReader.nextString()); // Desserializa a String para LocalDateTime
        }
    };
    
    // Instânciamento do Gson para manipulação no arquivo Json
    private Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, localDateAdapter)
                .registerTypeAdapter(LocalTime.class, localTimeAdapter)
                .registerTypeAdapter(LocalDateTime.class, localDateTimeAdapter) // Registrando LocalDateTime
                .setPrettyPrinting()
                .create();
    
    /**
     * Método que carrega toda memória dinâmica do sistema com as informações armazenadas 
     * nos arquivos Json.
     */
    public void carregarMemoria(){
        setListaClientes(carregarDados("./src/db/clientes.json", Cliente.class));
        setListaAgendamentos(carregarDados("./src/db/agendamentos.json", Agendamento.class));
        setListaFuncionarios(carregarDados("./src/db/usuarios.json", Funcionario.class));
        setListaProdutosCadastrados(carregarDados("./src/db/produtos.json", Produto.class));
        setListaProdutosEstoque(carregarDados("./src/db/estoque.json", Item.class));
        setListaVendas(carregarDados("./src/db/vendas.json", Venda.class));
        setQuantidadeClientes(getListaClientes().size());
        setQuantidadeProdutos(getListaProdutosCadastrados().size());
        setListaEntradaSaida(carregarDados("./src/db/registroes.json", RegistroES.class));
        setarIds();
    }
    
    /**
     * Método que salva toda a memória dinâmica nos arquivos Json.
     */
    public void salvarAlteracoes(){
        salvarDados("./src/db/clientes.json", getListaClientes());
        salvarDados("./src/db/usuarios.json", getListaFuncionarios());
        salvarDados("./src/db/agendamentos.json", getListaAgendamentos());
        salvarDados("./src/db/produtos.json", getListaProdutosCadastrados());
        salvarDados("./src/db/estoque.json", getListaProdutosEstoque());
        salvarDados("./src/db/vendas.json", getListaVendas());
        salvarDados("./src/db/registroes.json", getListaEntradaSaida());
    }
    
    /**
     * Método genérico para ler uma lista de qualquer tipo.
     * 
     * Esse método retorna uma ArrayList com todas as informações contidas dentro de 
     * um arquivo Json.
     * @param <T> Classe genérica
     * @param caminhoArquivo Caminho do arquivo Json
     * @param classe Classe que os dados dentro do Json pertence
     * @return ArrayList com objetos da classe passada que estão armazenados no caminho passado
     */
    public <T> ArrayList<T> carregarDados(String caminhoArquivo, Class<T> classe) {
    try (FileReader reader = new FileReader(caminhoArquivo)) {
        // Utiliza TypeToken para lidar com o tipo de ArrayList genérica
        Type tipoLista = TypeToken.getParameterized(ArrayList.class, classe).getType();
        return gson.fromJson(reader, tipoLista);
    } catch (IOException e) {
        e.printStackTrace();
        return null; // Em caso de erro, retorna null
    }
}
    
    /**
     * Método genérico para salvar uma lista de qualquer tipo.
     * 
     * Esse método salva todas as informações dos objetos dentro de um ArrayList em um arquivo Json. 
     * @param <T> Classe genérica
     * @param caminhoArquivo Caminho do arquivo Json
     * @param lista ArrayList a ser salvo no caminho
     */
    public <T> void salvarDados(String caminhoArquivo, ArrayList<T> lista) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            gson.toJson(lista, writer);  // Salvar a lista de objetos no arquivo JSON
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Construtor
    public GerenciamentoBD(){
        
    }
    
    // toString
    @Override
    public String toString(){
        return "INFO [Classe que gerencia a escrita e leitura de dados no BD.]";
    }
}
