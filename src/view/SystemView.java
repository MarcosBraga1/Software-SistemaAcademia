package view;

import controller.GerenciamentoAgendamento;
import controller.GerenciamentoBD;
import controller.GerenciamentoCliente;
import controller.GerenciamentoEstoque;
import controller.GerenciamentoVenda;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import models.Agendamento;
import models.Cliente;
import static models.Estoque.getListaProdutosCadastrados;
import static models.Estoque.getListaProdutosEstoque;
import models.Produto;
import static models.SystemAcad.getListaAgendamentos;
import static models.SystemAcad.getListaAgendamentosPeliminar;
import static models.SystemAcad.getListaClientes;
import static models.SystemAcad.getListaFuncionarios;
import models.Venda;

/**
 * Classe que armazena o método da view padrão
 * 
 * <p>Essa classe é responsável por possuir um método que cria a view para o sistema
 * de um usuário comum do sistema.</p>
 * @author Marcos
 */
public class SystemView {
    // Instância de gerenciamentos para o uso dentro da classe
    GerenciamentoBD gbd = new GerenciamentoBD();
    GerenciamentoCliente gc = new GerenciamentoCliente();
    GerenciamentoAgendamento ga = new GerenciamentoAgendamento();
    GerenciamentoEstoque ge = new GerenciamentoEstoque();
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
    
    // Método
    /**
     * Método responsável por criar a view do sistema para um usuário comum.
     */
    public void systemView(){
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("Insira um numero para realizar a funcao: ");
            System.out.println("[1] - Gerenciar Clientes");
            System.out.println("[2] - Gerenciar Agendamentos");
            System.out.println("[3] - Realizar Venda");
            System.out.println("[4] - Gerenciar Estoque");
            System.out.println("[5] - Salvar alteracoes");
            System.out.println("-----------------------");
            System.out.println("[0] - Encerrar Programa");
            int resposta = scanner.nextInt();
            
            // Condição de saida
            if (resposta == 0){
                System.out.println("\n\nEncerrando o programa...");
                break;
            }
            
            switch (resposta){
                case 1:
                    boolean aux1 = true;
                    
                    while (aux1){
                        System.out.println("Gerenciar Clientes: ");
                        System.out.println("[1] - Ver Clientes Cadastrados");
                        System.out.println("[2] - Cadastrar Cliente");
                        System.out.println("[3] - Atualizar Cliente");
                        System.out.println("[4] - Remover Cliente");
                        System.out.println("[0] - Voltar");
                        int escolha1 = scanner.nextInt();

                        switch (escolha1){
                            case 0:
                                aux1 = false;
                                break;

                            case 1:
                                gc.percorrerClientesForEach();
                                break;

                            case 2:
                                System.out.println("Insira o nome do cliente: ");
                                scanner.nextLine();
                                String nome = scanner.nextLine();

                                System.out.println("Insira o CPF: ");
                                String cpf = scanner.nextLine();

                                System.out.println("Insira o endereco: ");
                                String endereco = scanner.nextLine();

                                System.out.println("Insira o email: ");
                                String email = scanner.nextLine();

                                System.out.println("Insira o telefone: ");
                                String telefone = scanner.nextLine();

                                System.out.println("Insira o numero do cartao: ");
                                String cartao = scanner.nextLine();

                                gc.cadastrarCliente(nome,cpf,endereco,email,telefone,cartao);
                                break;

                            case 3:
                                System.out.println("Lista de Clientes:\n" + getListaClientes() + "\n");
                                System.out.println("Insira o ID do cliente a ser atualizado: ");
                                int input1 = scanner.nextInt();

                                if (gc.retornarCliente(input1)== null){
                                    break;
                                }

                                Cliente c1 = gc.retornarCliente(input1);
                                System.out.println("Nome: " + c1.getNome() + "\nInsira um novo valor: ");
                                scanner.nextLine();
                                String c1Nome = scanner.nextLine();
                                System.out.println("CPF: " + c1.getCpf() + "\nInsira um novo valor: ");
                                String c1Cpf = scanner.nextLine();
                                System.out.println("Endereco: " + c1.getEndereco() + "\nInsira um novo valor: ");
                                String c1Endereco = scanner.nextLine();
                                System.out.println("Email: " + c1.getEmail() + "\nInsira um novo valor: ");
                                String c1Email = scanner.nextLine();
                                System.out.println("Telefone: " + c1.getTelefone() + "\nInsira um novo valor: ");
                                String c1Telefone = scanner.nextLine();
                                System.out.println("Cartao: " + c1.getCartao() + "\nInsira um novo valor: ");
                                String c1Cartao = scanner.nextLine();
                                gc.atualizarCliente(c1, c1Nome, c1Cpf, c1Endereco, c1Email, c1Telefone, c1Cartao);
                                break;

                            case 4:
                                System.out.println("Lista de Clientes:\n" + getListaClientes() + "\n");
                                System.out.println("Insira o ID do cliente a ser deletado: ");
                                int input2 = scanner.nextInt();

                                gc.deletarCliente(input2);
                                break;

                            default:
                                System.out.println("Valor inserido invalido!");
                                break;
                        }
                    }
                    break;
                    
                case 2:
                    boolean aux2 = true;
                    
                    while (aux2){
                        System.out.println("Gerenciar Agendamentos: ");
                        System.out.println("[1] - Ver Agendamentos");
                        System.out.println("[2] - Realizar Agendamento");
                        System.out.println("[3] - Atualizar Agendamento");
                        System.out.println("[4] - Confirmar Agendamento");
                        System.out.println("[5] - Cancelar Agendamento");
                        System.out.println("[0] - Voltar");
                        int escolha2 = scanner.nextInt();

                        switch (escolha2){
                            case 0:
                                aux2 = false;
                                break;

                            case 1:
                                ga.percorrerAgendamentosForEach();
                                break;

                            case 2:
                                System.out.print("Insira a data do agendamento (no formato dd/MM/yyyy): ");
                                scanner.nextLine();
                                String dataInput = scanner.nextLine();
                                LocalDate data = LocalDate.parse(dataInput, formatoData);

                                System.out.print("Insira a hora do agendamento (no formato HH:mm): ");
                                String timeInput = scanner.nextLine();
                                LocalTime hora = LocalTime.parse(timeInput, formatoHora);

                                System.out.println("Lista de Clientes:\n" + getListaClientes() + "\n");
                                System.out.println("Insira o ID do cliente: ");
                                int clienteId = scanner.nextInt();

                                System.out.println("Insira a aula: ");
                                System.out.println("[1] - Spinning");
                                System.out.println("[2] - Musculacao");
                                System.out.println("[3] - Fit Dance");
                                System.out.println("[4] - Pilates");
                                int aulaIndex = scanner.nextInt();

                                System.out.println("Lista de Instrutores:\n" + getListaFuncionarios() + "\n");
                                System.out.println("Insira o ID do instrutor: ");
                                int funcionarioId = scanner.nextInt();

                                System.out.println("Qual o status do agendamento: ");
                                System.out.println("[1] - Preliminar");
                                System.out.println("[2] - Confirmado");
                                int status = scanner.nextInt();

                                ga.cadastrarAgendamento(data, hora, clienteId, aulaIndex, funcionarioId, status);
                                break;

                            case 3:
                                System.out.println("Lista de Agendamentos:\n" + getListaAgendamentos() + "\n");
                                System.out.println("Insira o ID do agendamento a ser atualizado: ");
                                int input1 = scanner.nextInt();

                                if (ga.retornarAgendamento(input1)== null){
                                    break;
                                }

                                Agendamento agendamento = ga.retornarAgendamento(input1);

                                System.out.println("Data: " + agendamento.getData() + "\nInsira um nova data (no formato dd/MM/yyyy): ");
                                scanner.nextLine();
                                String dataAtualizar = scanner.nextLine();
                                LocalDate data1 = LocalDate.parse(dataAtualizar, formatoData);

                                System.out.print("Hora: " + agendamento.getHora() + "\nInsira uma nova hora (no formato HH:mm): ");
                                String horaAtualizar = scanner.nextLine();
                                LocalTime hora1 = LocalTime.parse(horaAtualizar, formatoHora);

                                System.out.println("Lista de Clientes:\n" + getListaClientes());
                                System.out.println("Cliente: " + agendamento.getCliente() + "\nInsira um novo ID: ");
                                int clientId = scanner.nextInt();

                                System.out.println("Aula: " + agendamento.getAula());
                                System.out.println("Insira a nova aula: ");
                                System.out.println("[1] - Spinning");
                                System.out.println("[2] - Musculacao");
                                System.out.println("[3] - Fit Dance");
                                System.out.println("[4] - Pilates");
                                int aula = scanner.nextInt();

                                System.out.println("Instrutor: " + agendamento.getInstrutor() + "\nInsira um novo ID: ");
                                System.out.println("Lista de Instrutores:\n" + getListaFuncionarios() + "\n");
                                int funcId = scanner.nextInt();

                                System.out.println("Qual o status do agendamento: ");
                                System.out.println("[1] - Preliminar");
                                System.out.println("[2] - Confirmado");
                                int st = scanner.nextInt();

                                ga.atualizarAgendamento(agendamento, data1, hora1, clientId, aula, funcId, st);
                                break;

                            case 4:
                                System.out.println("Lista de agendamentos nao confirmados: ");
                                System.out.println(getListaAgendamentosPeliminar());
                                System.out.println("Insira o ID do agendamento a ser confirmado: ");
                                int id = scanner.nextInt();
                                ga.confirmarAgendamento(id);
                                break;

                            case 5:
                                System.out.println("Lista de Agendamentos:\n" + getListaAgendamentos() + "\n");
                                System.out.println("Insira o ID do agendamento a ser cancelado: ");
                                int input2 = scanner.nextInt();

                                ga.deletarAgendamento(input2);
                                break;

                            default:
                                System.out.println("Valor inserido invalido!");
                                break;
                        }
                    }
                    break;
                
                case 3:
                    GerenciamentoVenda gv = new GerenciamentoVenda();
                    boolean aux3 = true;
                    
                    while (aux3){
                        System.out.println("Realizar Venda: ");
                        System.out.println("[1] - Ver Carrinho");
                        System.out.println("[2] - Adicionar Item");
                        System.out.println("[3] - Remover Item");
                        System.out.println("[4] - Confirmar Compra");
                        System.out.println("[0] - Cancelar Compra");
                        int escolha3 = scanner.nextInt();

                        switch (escolha3){
                            case 0:
                                aux3 = false;
                                break;

                            case 1:
                                System.out.println(gv.getCarrinho());
                                System.out.println("Valot Total: " + gv.valorCompra(gv.getCarrinho()));
                                break;

                            case 2:
                                System.out.println("Lista de Produtos:\n" + getListaProdutosEstoque() + "\n");
                                System.out.println("Insira o ID do produto a ser atualizado: ");
                                int produto = scanner.nextInt();

                                System.out.println("Quantidade: ");
                                int quantidade = scanner.nextInt();

                                gv.adicionarItem(produto, quantidade);
                                System.out.println("Item adicionado ao carrinho.");
                                break;

                            case 3:
                                System.out.println("Lista de Itens:\n" + gv.getCarrinho() + "\n");
                                System.out.println("Insira o ID do item a ser removido: ");
                                int input2 = scanner.nextInt();

                                gv.removerItem(input2);
                                break;

                            case 4:
                                System.out.println("Valot Total: " + gv.valorCompra(gv.getCarrinho()));

                                System.out.println("Lista de Clientes:\n" + getListaClientes() + "\n");
                                System.out.println("Insira o ID do cliente que esta comprando: ");
                                int cliente = scanner.nextInt();

                                System.out.println("Selecione a forma de pagamento: ");
                                System.out.println("[1] - Dinheiro");
                                System.out.println("[2] - Pix");
                                System.out.println("[3] - Debito");
                                System.out.println("[4] - Credito");
                                int pagamento = scanner.nextInt();
                                Venda venda = gv.confirmarCompra(gv.getCarrinho(), gv.valorCompra(gv.getCarrinho()), pagamento, cliente);
                                System.out.println("Compra Confirmada.");
                                System.out.println(venda);
                                break;
                                
                            default:
                                System.out.println("Valor inserido invalido!");
                                break;
                        }
                    }
                    break;
                    
                case 4:
                    boolean aux4 = true;
                    
                    while (aux4){
                        System.out.println("Gerenciar Estoque: ");
                        System.out.println("[1] - Ver Produtos Cadastrados");
                        System.out.println("[2] - Ver Produtos em Estoque");
                        System.out.println("[3] - Cadastrar Produto");
                        System.out.println("[4] - Atualizar Produto");
                        System.out.println("[5] - Remover Produto");
                        System.out.println("[6] - Dar Entrada Estoque");
                        System.out.println("[0] - Voltar");
                        int escolha4 = scanner.nextInt();

                        switch (escolha4){
                            case 0:
                                aux4 = false;
                                break;

                            case 1:
                                ge.percorrerProdutosCadastrados();
                                break;

                            case 2:
                                ge.percorrerProdutosEstoque();
                                break;

                            case 3:
                                System.out.println("Insira o nome do poduto: ");
                                scanner.nextLine();
                                String nome = scanner.nextLine();

                                System.out.println("Insira o preco unitario de compra: ");
                                float precoUnitario = scanner.nextFloat();

                                System.out.println("Insira o preco unitario de venda: ");
                                float precoVenda = scanner.nextFloat();

                                System.out.println("Insira a categoria: ");
                                System.out.println("[1] - Acessorio");
                                System.out.println("[2] - Equipamento");
                                System.out.println("[3] - Suplemento");
                                int categoria = scanner.nextInt();

                                scanner.nextLine();
                                System.out.println("Insira especificacoes sobre o produto: ");
                                String especificacao = scanner.nextLine();

                                ge.cadastrarProduto(nome,precoUnitario,precoVenda,categoria,especificacao);
                                break;

                            case 4:
                                System.out.println("Lista de Produtos:\n" + getListaProdutosCadastrados() + "\n");
                                System.out.println("Insira o ID do produto a ser atualizado: ");
                                int input1 = scanner.nextInt();

                                if (ge.retornarProduto(input1)== null){
                                    break;
                                }

                                Produto produto = ge.retornarProduto(input1);
                                System.out.println("Nome: " + produto.getNome() + "\nInsira um novo valor: ");
                                scanner.nextLine();
                                String p1Nome = scanner.nextLine();
                                System.out.println("Preco Unitario: " + produto.getPrecoUnitario() + "\nInsira um novo valor: ");
                                float p1precoUnitario = scanner.nextFloat();
                                System.out.println("Preco Venda: " + produto.getPrecoVenda() + "\nInsira um novo valor: ");
                                float p1precoVenda = scanner.nextFloat();
                                System.out.println("Categoria: " + produto.getCategoria() + "\nInsira um novo valor: ");
                                System.out.println("[1] - Acessorio");
                                System.out.println("[2] - Equipamento");
                                System.out.println("[3] - Suplemento");
                                int p1categoria = scanner.nextInt();
                                System.out.println("Especificacao: " + produto.getEspecificacoes() + "\nInsira um novo valor: ");
                                String p1especificacoes = scanner.nextLine();
                                ge.atualizarProduto(produto, p1Nome, p1precoUnitario, p1precoVenda, p1categoria, p1especificacoes);
                                break;

                            case 5:
                                System.out.println("Lista de Produtos:\n" + getListaProdutosCadastrados() + "\n");
                                System.out.println("Insira o ID do produto a ser deletado: ");
                                int input2 = scanner.nextInt();

                                ge.deletarProduto(input2);
                                break;

                            case 6:
                                System.out.println("Lista de Produtos:\n" + getListaProdutosCadastrados() + "\n");
                                System.out.println("Insira o ID do produto a dar entrada: ");
                                int input3 = scanner.nextInt();

                                System.out.println("Insira a quantidade: ");
                                int entrada = scanner.nextInt();
                                ge.entradaEstoque(input3, entrada);
                                break;

                            default:
                                System.out.println("Valor inserido invalido!");
                                break;
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("Salvando alteracoes...");
                    gbd.salvarAlteracoes();
                    System.out.println("Alteracoes salvas.\n");
                    break;
                    
                default:
                    System.out.println("Valor inserido invalido!");
                    break;
            }
        }
    }
}
