/*
 * Projeto1 da disciplina SIN141 - Computação Orientada a Objetos
 */
/**
 *
 * @authors Gustavo de Paula Avelar Matricula: 2481 Ebert Gurgel Melo Junior
 * Matricula: 2479
 */
package Visao;

// importando pacotes necessários para a execução
import Modelo.*;
import Persistência.GravarDados;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Criação da classe principal Fazenda que implementa a serialização
public class Fazenda implements Serializable {

    // Main que propaga duas exceções
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Declaração das variaveis necessarias para pedir os dados dos funcionários
        String nomeFuncionario;
        String turnoFuncionario;
        String cpfFuncionario;
        int tempoServicoFuncionario;
        int identificacaoFuncionario;
        int qtdSacas;
        int numeroViagens;
        int tempDirigindo;

        // Declaração das duas coleções exigidas no projeto

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();//ArrayList para cadastros de funcionários gerais
        ArrayList<Safrista> funcionariosSafristas = new ArrayList<Safrista>();//ArrayList para Cadastro de Safristas

        // Declaração da variavel que será utilizada para gravar os dados no arquivo, exigencia do projeto
        GravarDados gravador = new GravarDados();

        //GravarDados Leitor1 ;
        //GravarDados Leitor2 ;

        // Declaração de variáveis para o menu Principal e demais menus

        int opcaoMenuPrincipal = 0;
        int opcaoMenuFixo = 0;
        int opcaoMenu;
        int opcaoCadastro;

        // Declaração de alguns Scanners para entrada de dados
        Scanner entradaMenuPrincipal = new Scanner(System.in);
        Scanner entradaMenuFixo = new Scanner(System.in);
        Scanner entradaMenu = new Scanner(System.in);
        Scanner entradaCadastro = new Scanner(System.in);

        // Desearilização dos Funcionarios
        gravador.deserializarFuncionario();
        // Desearilização dos Funcionarios Safristas
        gravador.deserializarSafrista();
        // Coleção recebe a desearilização dos funcionarios 
        funcionarios = gravador.getFuncionariosCopia();
        // Coleção recebe a desearilização dos funcionarios Safristas
        funcionariosSafristas = gravador.getFuncionariosSafristasCopia();

        // Inicio do Sistema
        System.out.println(" ### Bem vindo ao Sistema da Fazenda do Pezão ### ");
        System.out.println("        ### Seu café de qualidade ###             ");
        System.out.println("");


        do {
            try {
                System.out.println(" #### MENU PRINCIPAL ####");
                System.out.println("");

                System.out.println(" ## Escolha a Opção desejada ##");
                System.out.println(" # 1 - Cadastro de Funcionarios ");
                System.out.println(" # 2 - Consulta de Funcionario ");
                System.out.println(" # 3 - Alterar dados do Funcionario ");
                System.out.println(" # 4 - Remoção de Funcionario ");
                opcaoMenuPrincipal = entradaMenuPrincipal.nextInt();
                // Se não for nenhuma das opções acima mostrará ao usuário para que informe uma opção válida
                if ((opcaoMenuPrincipal <= 0) || (opcaoMenuPrincipal > 4)) {
                    System.out.println(" opção inválida ! ");
                } else {
                    switch (opcaoMenuPrincipal) {
                        case 1:

                            try {
                                // OPCAO DE CADASTRO DOS FUNCIONARIOS DA FAZENDA
                                do {
                                    System.out.println(" ### MENU DE CADASTRO DE FUNCIONARIOS ### ");
                                    System.out.println(" ## Escolha a opcao desejada ## ");

                                    System.out.println(" # 1 - Cadastrar Administrativo-Financeiro ");
                                    System.out.println(" # 2 - Cadastrar Safrista ");
                                    System.out.println(" # 3 - Cadastrar Motorista ");
                                    System.out.println(" # 4 - Cadastrar Engenheiro Agronomo ");
                                    System.out.println(" # 5 - Voltar ao Menu Principal  ");
                                    // Entrada do numero da opção desejada
                                    opcaoCadastro = entradaCadastro.nextInt();
                                    // parar remover o \n do buffer
                                    entradaCadastro.nextLine();


                                    switch (opcaoCadastro) {
                                        case 1:
                                            // Cadastrar Administrativo - Financeiro
                                            // Criação do objeto funcionarioAdministrativo do tipo AdministrativoFinanceiro
                                            System.out.println(" @Area de Cadastro Administrativo - Financeiro ");
                                            AdministrativoFinanceiro funcionarioAdministrativo = new AdministrativoFinanceiro();

                                            // Solicitação do nome do funcionário a ser cadastrado
                                            do {

                                                System.out.println(" Informe o nome do Funcionario ");
                                                nomeFuncionario = entradaCadastro.nextLine();
                                                nomeFuncionario = nomeFuncionario.toUpperCase();
                                                funcionarioAdministrativo.setNome(nomeFuncionario);
                                            } while (funcionarioAdministrativo.getNome().equals(""));

                                            // Solicitação do turno de serviço do funcionário
                                            do {
                                                System.out.println(" Informe Turno de Serviço do Funcionario (Manha, tarde, noite)");
                                                turnoFuncionario = entradaCadastro.nextLine();
                                                turnoFuncionario = turnoFuncionario.toUpperCase();
                                                funcionarioAdministrativo.setTurno(turnoFuncionario);
                                                //System.out.println(" turno : " + funcionarioAdministrativo.getTurno());
                                            } while (funcionarioAdministrativo.getTurno().equals("-1") || funcionarioAdministrativo.getTurno().equals(""));

                                            // Solicitação do tempo de serviço do funcionário
                                            do {
                                                System.out.println(" Informe o Tempo qe serviço que o funcionário possui (Meses) ");
                                                tempoServicoFuncionario = entradaCadastro.nextInt();
                                                entradaCadastro.nextLine();
                                                funcionarioAdministrativo.setTempoServico(tempoServicoFuncionario);
                                            } while (funcionarioAdministrativo.getTempoServico() == -1);

                                            // Solicitação do CPF do funcionário a ser cadastrado
                                            do {
                                                System.out.println(" Informe o CPF do Funcionario ");
                                                cpfFuncionario = entradaCadastro.nextLine();
                                                funcionarioAdministrativo.setCpf(cpfFuncionario);
                                            } while (funcionarioAdministrativo.getCpf().equals("-1") || funcionarioAdministrativo.getCpf().equals(""));

                                            // Adicionando funcionario  Administrativo na coleção de funcionarios    
                                            funcionarios.add(funcionarioAdministrativo);
                                            break;

                                        case 2:
                                            // Cadastrar Safrista
                                            // Criação do objeto funcionarioSafrista do tipo Safrista
                                            System.out.println(" @Area de Cadastro Safristas ");
                                            Safrista funcionarioSafrista = new Safrista();
                                            // Solicitação do nome do funcionário a ser cadastrado                              
                                            do {
                                                System.out.println(" Informe o nome do Funcionario ");
                                                nomeFuncionario = entradaCadastro.nextLine();
                                                nomeFuncionario = nomeFuncionario.toUpperCase();
                                                funcionarioSafrista.setNome(nomeFuncionario);
                                            } while (funcionarioSafrista.getNome().equals(""));
                                            // Solicitação do turno de serviço do funcionário
                                            // "manha", acento removido porque não estava lendo corretamente
                                            do {
                                                System.out.println(" Informe Turno de Serviço do Funcionario (Manha, tarde, noite)");
                                                turnoFuncionario = entradaCadastro.nextLine();
                                                turnoFuncionario = turnoFuncionario.toUpperCase();
                                                funcionarioSafrista.setTurno(turnoFuncionario);
                                            } while (funcionarioSafrista.getTurno().equals("-1") || funcionarioSafrista.getTurno().equals(""));
                                            // Solicitação do tempo de serviço do funcionário
                                            do {
                                                System.out.println(" Informe o Tempo qe serviço que o funcionário possui (Meses) ");
                                                tempoServicoFuncionario = entradaCadastro.nextInt();
                                                // remover \n do buffer
                                                entradaCadastro.nextLine();
                                                funcionarioSafrista.setTempoServico(tempoServicoFuncionario);
                                            } while (funcionarioSafrista.getTempoServico() == -1);

                                            // Solicitação do CPF do funcionário a ser cadastrado

                                            do {
                                                System.out.println(" Informe o CPF do Funcionario ");
                                                cpfFuncionario = entradaCadastro.nextLine();
                                                funcionarioSafrista.setCpf(cpfFuncionario);
                                            } while (funcionarioSafrista.getCpf().equals("-1") || funcionarioSafrista.getCpf().equals(""));
                                            // Solicitação da ID do safrista
                                            do {
                                                System.out.println(" Informe a sua identificação (ID) ");
                                                identificacaoFuncionario = entradaCadastro.nextInt();
                                                // inserção da ID do safrista
                                                funcionarioSafrista.setIdentificacao(identificacaoFuncionario);
                                            } while (funcionarioSafrista.getIdentificacao() == -1);
                                            // Solicitação da quantidade de sacas panhadas pelo Safrista
                                            do {
                                                System.out.println(" Informe a quantidade de sacas panhadas ");
                                                qtdSacas = entradaCadastro.nextInt();
                                                // inserção da quantidade de sacas panhadas pelo safrista
                                                funcionarioSafrista.setSacasPanhadas(qtdSacas);
                                            } while (funcionarioSafrista.getSacasPanhadas() == -1);
                                            // Adicionando Safrista na coleção de safristas
                                            funcionariosSafristas.add(funcionarioSafrista);
                                            //funcionarios.add(funcionarioSafrista);
                                            break;

                                        case 3:
                                            // Cadastrar Motorista
                                            // Criação do objeto funcionarioMotorista do tipo Motorista
                                            System.out.println(" @Area de Cadastro Motorista ");
                                            //Motorista funcionarioMotorista = new Motorista();
                                            System.out.println(" # 1 - Caminhoneiro ");
                                            System.out.println(" # 2 - Tratorista ");
                                            int leituraMotorista;
                                            Scanner scanMotorista = new Scanner(System.in);
                                            // leitura da opcao do menu
                                            leituraMotorista = scanMotorista.nextInt();

                                            switch (leituraMotorista) {
                                                case 1:
                                                    // Criação do objeto Caminhoneiro em uma variavel do tipo do PAI( Motorista )
                                                    Motorista funcionarioMotorista = new Caminhoneiro();
                                                    Caminhoneiro auxCam;
                                                    auxCam = (Caminhoneiro) funcionarioMotorista; // Downcast
                                                    // Solicitação do nome do funcionário a ser cadastrado
                                                    do {
                                                        System.out.println(" Informe o nome do Funcionario ");
                                                        nomeFuncionario = entradaCadastro.nextLine();
                                                        nomeFuncionario = nomeFuncionario.toUpperCase();
                                                        funcionarioMotorista.setNome(nomeFuncionario);
                                                    } while (funcionarioMotorista.getNome().equals(""));
                                                    // Solicitação do turno de serviço do funcionário
                                                    do {
                                                        System.out.println(" Informe Turno de Serviço do Funcionario (Manha, tarde, noite) ");
                                                        turnoFuncionario = entradaCadastro.nextLine();
                                                        turnoFuncionario = turnoFuncionario.toUpperCase();
                                                        funcionarioMotorista.setTurno(turnoFuncionario);
                                                    } while (funcionarioMotorista.getTurno().equals("-1") || funcionarioMotorista.getTurno().equals(""));
                                                    // Solicitação do tempo de serviço do funcionário
                                                    do {
                                                        System.out.println(" Informe o Tempo qe serviço que o funcionário possui (Meses) ");
                                                        tempoServicoFuncionario = entradaCadastro.nextInt();
                                                        entradaCadastro.nextLine();
                                                        funcionarioMotorista.setTempoServico(tempoServicoFuncionario);
                                                    } while (funcionarioMotorista.getTempoServico() == -1);
                                                    // Solicitação do CPF do funcionário a ser cadastrado
                                                    do {
                                                        System.out.println(" Informe o CPF do Funcionario ");
                                                        cpfFuncionario = entradaCadastro.nextLine();
                                                        funcionarioMotorista.setCpf(cpfFuncionario);
                                                    } while (funcionarioMotorista.getCpf().equals("-1") || funcionarioMotorista.getCpf().equals(""));


                                                    do {
                                                        System.out.println(" Informe o numero de viagens efetuadas ");
                                                        numeroViagens = entradaCadastro.nextInt();
                                                        auxCam.setNumeroViagens(numeroViagens); // setando numero de viagens
                                                    } while (auxCam.getNumeroViagens() == -1);



                                                    // Adicionando Motorista na coleção de funcionarios
                                                    funcionarios.add(funcionarioMotorista);

                                                    break;
                                                case 2:
                                                    // Criação de um objeto do tipo Tratorista em uma variavel do tipo pai( Motorista )
                                                    Motorista funcionarioMotorista2 = new Tratorista();
                                                    Tratorista auxTrat = (Tratorista) funcionarioMotorista2;

                                                    // Solicitação do nome do funcionário a ser cadastrado
                                                    do {
                                                        System.out.println(" Informe o nome do Funcionario ");
                                                        nomeFuncionario = entradaCadastro.nextLine();
                                                        nomeFuncionario = nomeFuncionario.toUpperCase();
                                                        funcionarioMotorista2.setNome(nomeFuncionario);
                                                    } while (funcionarioMotorista2.getNome().equals(""));
                                                    // Solicitação do turno de serviço do funcionário
                                                    do {
                                                        System.out.println(" Informe Turno de Serviço do Funcionario (Manha, tarde, noite)");
                                                        turnoFuncionario = entradaCadastro.nextLine();
                                                        turnoFuncionario = turnoFuncionario.toUpperCase();
                                                        funcionarioMotorista2.setTurno(turnoFuncionario);
                                                    } while (funcionarioMotorista2.getTurno().equals("-1") || funcionarioMotorista2.getTurno().equals(""));
                                                    // Solicitação do tempo de serviço do funcionário
                                                    do {
                                                        System.out.println(" Informe o Tempo qe serviço que o funcionário possui (Meses) ");
                                                        tempoServicoFuncionario = entradaCadastro.nextInt();
                                                        entradaCadastro.nextLine();
                                                        funcionarioMotorista2.setTempoServico(tempoServicoFuncionario);
                                                    } while (funcionarioMotorista2.getTempoServico() == -1);
                                                    // Solicitação do CPF do funcionário a ser cadastrado
                                                    do {
                                                        System.out.println(" Informe o CPF do funcionário ");
                                                        cpfFuncionario = entradaCadastro.nextLine();
                                                        funcionarioMotorista2.setCpf(cpfFuncionario);
                                                    } while (funcionarioMotorista2.getCpf().equals("-1") || funcionarioMotorista2.getCpf().equals(""));

                                                    do {
                                                        System.out.println(" Informe a quantidade de horas dirigindo do funcionário");
                                                        tempDirigindo = entradaCadastro.nextInt();
                                                        auxTrat.sethorasDirigindo(tempDirigindo);
                                                    } while (auxTrat.getHorasDirigindo() == -1);

                                                    // Adicionando Motorista na coleção de funcionarios
                                                    funcionarios.add(funcionarioMotorista2);

                                                    break;
                                            }
                                            break;

                                        case 4:
                                            // Cadastrar Engenheiro
                                            // Criação do objeto funcionarioEngenheiro do tipo Engenheiro
                                            System.out.println(" @Area de Cadastro Engenheiro ");
                                            Engenheiro funcionarioEngenheiro = new Engenheiro();
                                            // Solicitação do nome do funcionário a ser cadastrado 
                                            do {
                                                System.out.println(" Informe o nome do Funcionario ");
                                                nomeFuncionario = entradaCadastro.nextLine();
                                                nomeFuncionario = nomeFuncionario.toUpperCase();
                                                funcionarioEngenheiro.setNome(nomeFuncionario);
                                            } while (funcionarioEngenheiro.getNome().equals(""));
                                            // Solicitação do turno de serviço do funcionário
                                            do {
                                                System.out.println(" Informe Turno de Serviço do Funcionario (Manha, tarde, noite) ");
                                                turnoFuncionario = entradaCadastro.nextLine();
                                                turnoFuncionario = turnoFuncionario.toUpperCase();
                                                funcionarioEngenheiro.setTurno(turnoFuncionario);
                                            } while (funcionarioEngenheiro.getTurno().equals("-1") || funcionarioEngenheiro.getTurno().equals(""));

                                            // Solicitação do tempo de serviço do funcionário
                                            do {
                                                System.out.println(" Informe o Tempo qe serviço que o funcionário possui (Meses) ");
                                                tempoServicoFuncionario = entradaCadastro.nextInt();
                                                entradaCadastro.nextLine();
                                                funcionarioEngenheiro.setTempoServico(tempoServicoFuncionario);
                                            } while (funcionarioEngenheiro.getTempoServico() == -1);
                                            // Solicitação do CPF do funcionário a ser cadastrado
                                            do {
                                                System.out.println(" Informe o CPF do Funcionario ");
                                                cpfFuncionario = entradaCadastro.nextLine();
                                                funcionarioEngenheiro.setCpf(cpfFuncionario);
                                            } while (funcionarioEngenheiro.getCpf().equals("-1") || funcionarioEngenheiro.getCpf().equals(""));

                                            // Adicionando funcionario engenheiro na coleção de funcionarios
                                            funcionarios.add(funcionarioEngenheiro);
                                            break;
                                    }
                                    // If para verificação se o usuario deseja continuar cadastrando funcionarios
                                    if (opcaoCadastro == 5) {
                                        opcaoMenu = 2;
                                    } else {
                                        System.out.println("");
                                        System.out.println(" [ Deseja cadastrar mais funcionarios? ]");
                                        System.out.printf("  1 - Sim  2 - Não \n");
                                        // Leitura da opcao
                                        opcaoMenu = entradaMenu.nextInt();
                                    }


                                } while (opcaoMenu == 1);
                            } catch (InputMismatchException ermenu) {
                                System.err.println(ermenu);
                                System.out.println(" Informe um opção válida para o menu cadastrar funcionários ! ");
                                entradaCadastro.next();

                            }
                            break;

                        case 2:

                            try {
                                // OPCAO DE CONSULTA AO FUNCIONÁRIO
                                System.out.println(" ### CONSULTA/VISUALIZAÇÃO DE FUNCIONÁRIOS ### ");
                                // Opcao de funcionarios a ser consultado
                                System.out.println(" # 1 - Safristas ");
                                System.out.println(" # 2 - Funcionários Administrativo/Motorista/Engenheiro ");
                                System.out.println(" # 3 - Todos Funcionarios ");
                                // Leitura da opcao do menu
                                opcaoMenu = entradaMenu.nextInt();

                                if ((opcaoMenu > 0) && (opcaoMenu <= 3)) {

                                    switch (opcaoMenu) {
                                        case 1:
                                            // Variaveis criadas para obter a opcao da consulta e leitura da consulta
                                            int opcaoConsulta = 1;
                                            Scanner entradaConsulta = new Scanner(System.in);
                                            do {
                                                // menu consulta
                                                System.out.println(" ### Tipos de Consulta/Visualização ### ");
                                                System.out.println(" # 1 - Visualização Safrista especifico ");
                                                System.out.println(" # 2 - Visualizar todos Safristas ");
                                                // leitura da opcao desejada da visualização dos safristas
                                                opcaoConsulta = entradaConsulta.nextInt();

                                                switch (opcaoConsulta) {
                                                    case 1:
                                                        int ident;
                                                        int i = 0;
                                                        // caso a coleção esteja vazia
                                                        if (funcionariosSafristas.isEmpty()) {
                                                            System.out.println(" Nenhum Safrista Cadastrado ");
                                                        } else {
                                                            // Solicitação da ID para consulta de safrista
                                                            System.out.println(" Informe o ID do safrista que deseja Visualizar/Consultar ");
                                                            try {
                                                                // Obtenção da ID a ser consultada
                                                                ident = entradaMenu.nextInt();
                                                                // Exception IndexOutOfBoundsException
                                                                // Objeto do tipo Safrista recebe o primeiro safrista da coleção

                                                                Safrista s = funcionariosSafristas.get(i);
                                                                // Enquanto a ID do safrista representado pelo objeto S for diferente da ID
                                                                // que deseja visualizar, a variavel s recebera o proximo safrista
                                                                while (s.getIdentificacao() != ident) {
                                                                    i++;
                                                                    s = funcionariosSafristas.get(i);
                                                                }
                                                                // Verifica de a ID é igual a ID inserida e imprime os seus dados
                                                                if (s.getIdentificacao() == ident) {
                                                                    System.out.println("  #Funcionario Encontrado# ");
                                                                    System.out.println(" ## Dados do Funcionario ## ");
                                                                    s.exibirTodosDados();

                                                                    //System.out.printf("%s",s.toString());
                                                                    //System.out.printf(" | ID: %d |\n", s.getIdentificacao());
                                                                    //System.out.printf("Nome: %s \n", s.getNome());
                                                                    //System.out.printf("Turno de Serviço: %s \n", s.getTurno());
                                                                    //System.out.printf("Tempo de Serviço: %d \n", s.getTempoServico());
                                                                    //System.out.printf("CPF: %s \n", s.getCpf());
                                                                    //System.out.printf("Sacas Panhadas: %d \n", s.getSacasPanhadas());
                                                                    //System.out.printf("Salario Final: %.2f \n", s.calcularSalario());
                                                                }
                                                                // exceção IndexOutOfBoundsException quando não encontra a ID desejada
                                                                // exceção InputMismatchException quando o usuario não informa uma opcao valida
                                                            } catch (IndexOutOfBoundsException er) {
                                                                System.err.println(er);
                                                                System.out.println(" INFORME UMA IDENTIFICAÇÃO EXISTENTE PARA VISUALIZAÇÃO ! ");
                                                            } catch (InputMismatchException ermis) {
                                                                System.err.println(ermis);
                                                                System.out.println(" INFORME UM NUMERO ! ");
                                                                entradaMenu.next();
                                                            }
                                                        }

                                                        break;
                                                    case 2:
                                                        // Visualização completa dos Safristas, mostra todos os dados dos mesmos.
                                                        System.out.println(" ## Visualização Completa dos Safristas ## ");
                                                        // Caso a coleção esteja vazia não existira funcionarios para visualização
                                                        if (funcionariosSafristas.isEmpty()) {
                                                            System.out.println(" Nenhum Safrista Cadastrado ");
                                                        } else {
                                                            // For para percorrer toda a coleção de funcionariosSafristas e imprimir os seus dados
                                                            for (Safrista SafristasFuncionarios : funcionariosSafristas) {
                                                                SafristasFuncionarios.exibirTodosDados();

                                                                //System.out.println(" ## Dados do Funcionario ## ");
                                                                //System.out.printf("%s",s.toString());
                                                                //System.out.printf(" | ID: %d |\n ", SafristasFuncionarios.getIdentificacao());
                                                                //System.out.printf("Nome: %s \n", SafristasFuncionarios.getNome());
                                                                //System.out.printf("Turno de Serviço: %s\n", SafristasFuncionarios.getTurno());
                                                                //System.out.printf("Tempo de Serviço: %d\n", SafristasFuncionarios.getTempoServico());
                                                                //System.out.printf("CPF: %s\n", SafristasFuncionarios.getCpf());
                                                                //System.out.printf("Sacas Panhadas: %d\n ", SafristasFuncionarios.getSacasPanhadas());
                                                                //System.out.printf("Salario Final: %.2f \n", SafristasFuncionarios.calcularSalario());
                                                            }
                                                        }


                                                        break;
                                                }

                                                System.out.println("Deseja visualizar outro Safrista?");
                                                System.out.println(" 1 - Sim  2 - Não");
                                                opcaoConsulta = entradaConsulta.nextInt();

                                            } while (opcaoConsulta == 1);


                                            break;
                                        case 2:
                                            // Criação de variaveis para o auxilio da consulta dos outros funcionarios
                                            Scanner entradaConsulta2 = new Scanner(System.in);
                                            String nomeFuncio;
                                            int i = 0;
                                            // Se a coleção de funcionarios estiver vazia mostrara a mensagem ao usuario
                                            if (funcionarios.isEmpty()) {
                                                System.out.println(" VAZIO FUNCIONARIOS ");
                                            } else {
                                                // Caso não esteja vazia, será solicitado um nome de funcionarios para verificação
                                                System.out.println("Informe o Nome do Funcionario que Deseja visualizar");
                                                // leitura do nome para consulta
                                                nomeFuncio = entradaConsulta2.nextLine();
                                                nomeFuncio = nomeFuncio.toUpperCase();
                                                //nomeFuncio = nomeFuncio.toUpperCase();
                                                // criação de uma variável/objeto do tipo Funcionario
                                                Funcionario p;
                                                try {
                                                    // insere o primeiro funcionario na variavel p
                                                    p = funcionarios.get(i);
                                                    // enquanto o nome presente no objeto p for diferente do nome que deseja consultar
                                                    // a variável receberá o proximo funcionario
                                                    while (!(p.getNome().equals(nomeFuncio))) {
                                                        i++;
                                                        p = funcionarios.get(i);
                                                    }
                                                    // Verificação se o nome é mesmo igual ao nome inserido para consulta
                                                    if (p.getNome().equals(nomeFuncio)) {
                                                        // Verifica se o funcionario p é uma instancia do funcionario AdministrativoFinanceiro
                                                        if (p instanceof AdministrativoFinanceiro) {
                                                            AdministrativoFinanceiro auxAdmin = (AdministrativoFinanceiro) p; // Downcast
                                                            auxAdmin.exibirTodosDados();
                                                            System.out.printf(" Salario com adicioinal: %.2f \n", auxAdmin.calcularSalario());//Calcular Salario
                                                        } else if (p instanceof Engenheiro) {
                                                            Engenheiro auxEng = (Engenheiro) p; // Downcast
                                                            auxEng.exibirTodosDados();
                                                            System.out.printf(" Salario: %.2f \n", auxEng.calcularSalario());//Calcular Salario
                                                        } else if (p instanceof Motorista) {
                                                            //Motorista auxMotorista = (Motorista) p;
                                                            if (p instanceof Caminhoneiro) {
                                                                // variavel pai recebe cast da variavel filho para impressão dos dados
                                                                Motorista auxMotorista = (Motorista) p; // 
                                                                auxMotorista.exibirDadosDaClasseMotorista();
                                                                //auxMotorista.exibirTodosDados();        //UPCast
                                                                // variavel do tipo Caminhoneiro para impressão dos metodos existente no mesmo
                                                                Caminhoneiro auxCaminhoneiro = (Caminhoneiro) auxMotorista;
                                                                System.out.printf(" Salario fixo mais adicional de viagens: %.2f \n", auxCaminhoneiro.calcularSalario());//Calcular Salario classe filha
                                                                System.out.printf(" Numero de Viagens: %d \n", auxCaminhoneiro.getNumeroViagens());// Impressao do numero de Viagens

                                                                //Caminhoneiro funCaminho;
                                                                //funCaminho = (Caminhoneiro) auxMotorista;
                                                                //System.out.printf("Numero de Viagens: %d \n", funCaminho.getNumeroViagens());
                                                            } else if (p instanceof Tratorista) {
                                                                // variavel pai recebe cast da variavel filho para impressão dos dados
                                                                Motorista auxMotorista2 = (Motorista) p;
                                                                auxMotorista2.exibirDadosDaClasseMotorista();
                                                                // variavel do tipo Tratorista para impressão dos metodos existente no mesmo
                                                                Tratorista auxTratorista = (Tratorista) auxMotorista2;
                                                                // impressão do salario do tratorista com o seu determinado adicional
                                                                System.out.println(" Salario fixo mais adicional de horas trabalhadas: " + auxTratorista.calcularSalario());
                                                                //auxMotorista.exibirTodosDados();
                                                                //System.out.printf("Salario: %f \n", auxMotorista.calcularSalario());//Calcular Salario
                                                            }
                                                        }
                                                    }
                                                    // exceção IndexOutofBoundsException caso não exista o nome para consulta 
                                                } catch (IndexOutOfBoundsException er1) {
                                                    System.err.println(er1);
                                                    System.out.println(" Informe um nome existente ! ");
                                                }
                                            }
                                            break;
                                        case 3:
                                            // impressão dos dados de todos os funcionarios existentes nas coleções de funcionarios e funcionariosSafristas
                                            System.out.println(" ### Dados de todos os Funcionarios ### ");
                                            //Funcionario p2;
                                            // Verificação se as 2 coleções não estão vazias 
                                            if (funcionarios.isEmpty() && funcionariosSafristas.isEmpty()) {
                                                System.out.println(" Nenhum Funcionário Cadastrado !! ");
                                            } else {
                                                // for para percorrer a coleção de funcionarios
                                                for (Funcionario obj2 : funcionarios) {
                                                    // verificações se o obj2 é uma instancia AdministrativoFinanceiro, Engenheiro ou Motorista
                                                    if (obj2 instanceof AdministrativoFinanceiro) {
                                                        // Criação de uma variável auxiliar para fazer o downcast e impressão dos dados do objeto
                                                        AdministrativoFinanceiro auxAdmin = (AdministrativoFinanceiro) obj2; // Downcast
                                                        auxAdmin.exibirTodosDados();
                                                        //System.out.printf("Salario: %f \n", auxAdmin.calcularSalario());//Calcular Salario
                                                        System.out.println("");

                                                    } else if (obj2 instanceof Engenheiro) {
                                                        // Criação de uma variável auxiliar para fazer o downcast e impressão dos dados do objeto
                                                        Engenheiro auxEng = (Engenheiro) obj2;
                                                        auxEng.exibirTodosDados();
                                                        //System.out.printf("Salario: %f \n", auxEng.calcularSalario());//Calcular Salario
                                                        System.out.println("");
                                                    } else if (obj2 instanceof Motorista) {
                                                        //Motorista auxMotorista = (Motorista) obj2;
                                                        if (obj2 instanceof Caminhoneiro) {
                                                            // Criação de uma variável auxiliar para fazer o downcast e impressão dos dados do objeto
                                                            Caminhoneiro auxCaminhoneiro = (Caminhoneiro) obj2;
                                                            auxCaminhoneiro.exibirTodosDados();
                                                            //System.out.printf("Salario: %f \n", auxCaminhoneiro.calcularSalario());//Calcular Salario
                                                            System.out.println("");
                                                        } else if (obj2 instanceof Tratorista) {
                                                            // Criação de uma variável auxiliar para fazer o downcast e impressão dos dados do objeto
                                                            Tratorista auxTratorista = (Tratorista) obj2;
                                                            auxTratorista.exibirTodosDados();
                                                            //System.out.printf("Salario: %f \n", auxTratorista.calcularSalario());//Calcular Salario
                                                            System.out.println("");
                                                        }

                                                        System.out.println("");
                                                    }
                                                }
                                                // For para percorrer a coleção de safristas
                                                for (Safrista SafristasFuncionarios : funcionariosSafristas) {
                                                    // impressão dos dados dos funcionarios safristas
                                                    SafristasFuncionarios.exibirTodosDados();

                                                    //System.out.println(" ## Dados do Funcionario ## ");
                                                    //System.out.printf("%s",s.toString());
                                                    //System.out.printf(" | ID: %d |\n ", SafristasFuncionarios.getIdentificacao());
                                                    //System.out.printf("Nome: %s \n", SafristasFuncionarios.getNome());
                                                    //System.out.printf("Turno de Serviço: %s\n", SafristasFuncionarios.getTurno());
                                                    //System.out.printf("Tempo de Serviço: %d\n", SafristasFuncionarios.getTempoServico());
                                                    //System.out.printf("CPF: %s\n", SafristasFuncionarios.getCpf());
                                                    //System.out.printf("Sacas Panhadas: %d\n ", SafristasFuncionarios.getSacasPanhadas());
                                                }
                                            }


                                    }
                                } else {
                                    System.out.println(" Informe um opção válida para o menu ");
                                }
                            } catch (InputMismatchException exceptm) {
                                System.err.println(exceptm);
                                System.out.println(" Informe uma opção válida para o menu consulta de funcionários");
                                entradaMenu.next();
                            } finally {
                                break;
                            }


                        case 3:

                            try {
                                // OPÇÃO DE ALTERAÇÃO DOS DADOS DO FUNCIONARIO
                                System.out.println(" ### ALTERAR DADOS DE FUNCIONÁRIOS ### ");

                                System.out.println(" # 1 - Safrista ");
                                System.out.println(" # 2 - Demais funcionários ");
                                // Leitura da opcao desejada
                                opcaoMenu = entradaMenu.nextInt();

                                switch (opcaoMenu) {
                                    case 1:
                                        // criação de variaveis para auxilio no menu
                                        int opcaoEscolha;
                                        int ident;
                                        int i = 0;
                                        // Solicitação do ID do safrista a ser alterado
                                        System.out.println(" Informe o ID do safrista que deseja Alterar os dados ");
                                        // leitura do ID
                                        ident = entradaMenu.nextInt();
                                        // Exception IndexOutOfBoundsException
                                        // variável do tipo Safrista para percorrer a coleção de safristas e iniciada com o primeiro safrista
                                        // da coleção
                                        Safrista s = funcionariosSafristas.get(i);
                                        // Enquanto a ID informada for diferente da ID da variável s, variável i sera incrementada e s recebera
                                        // o proximo objeto funcionarioSafrista
                                        while (s.getIdentificacao() != ident) {
                                            i++;
                                            s = funcionariosSafristas.get(i);
                                        }
                                        /*if(funcionariosSafristas.isEmpty()){
                                         System.out.println(" Nenhum Safrista Cadastrado ");
                                         }*/
                                        // Pergunta ao usuário se deseja alterar os dados do funcionario informado através do ID
                                        System.out.println(" Deseja Alterar os dados? "
                                                + "(1) - Sim (2) - Não ");
                                        // Leitura da opção
                                        opcaoEscolha = entradaMenu.nextInt();
                                        switch (opcaoEscolha) {
                                            // caso deseja alterar
                                            case 1:
                                                // criação de variáveis para auxiliar na alteração dos dados
                                                String nomeAlterado;
                                                String turnoAlterado;
                                                int tempoServicoAlterado;
                                                String cpfAlterado;
                                                int idAlterado;
                                                int sacasAlterado;
                                                // criação de Scanners para os dados especificos
                                                Scanner entNome = new Scanner(System.in);
                                                Scanner entTurno = new Scanner(System.in);
                                                Scanner entTempo = new Scanner(System.in);
                                                Scanner entCpf = new Scanner(System.in);
                                                Scanner entId = new Scanner(System.in);
                                                Scanner entSacas = new Scanner(System.in);
                                                // Exibição dos dados do Safrista
                                                System.out.println(" ##### DADOS ATUAIS ##### ");
                                                s.exibirTodosDados();
                                                // Solicitação dos novos dados
                                                System.out.println(" ### INFORME OS NOVOS DADOS ### ");
                                                do{
                                                    System.out.println(" Informe o novo nome ");
                                                    nomeAlterado = entNome.nextLine();
                                                    s.setNome(nomeAlterado);
                                                } while( s.getNome().equals(""));
                                                // Solicitação dos novos dados
                                                do{
                                                    System.out.println(" Informe o novo turno (Manhã, Tarde, Noite) ");
                                                    turnoAlterado = entTurno.nextLine();
                                                    // Inserção dos novos dados
                                                    s.setTurno(turnoAlterado);
                                                } while( s.getTurno().equals("-1") || s.getTurno().equals(""));
                                                // Solicitação dos novos dados
                                                do{
                                                    System.out.println(" Informe o novo tempo de Serviço ");
                                                    tempoServicoAlterado = entTempo.nextInt();
                                                    // Inserção dos novos dados
                                                    s.setTempoServico(tempoServicoAlterado);
                                                } while ( s.getTempoServico() == -1);
                                                // Solicitação dos novos dados
                                                do{
                                                    System.out.println(" Informe o novo CPF ");
                                                    cpfAlterado = entCpf.nextLine();
                                                    // Inserção dos novos dados
                                                    s.setCpf(cpfAlterado);
                                                } while( s.getCpf().equals("-1") || s.getCpf().equals(""));
                                                // Solicitação dos novos dados
                                                do{
                                                    System.out.println(" Informe a nova ID ");
                                                    idAlterado = entId.nextInt();
                                                    // Inserção dos novos dados
                                                    s.setIdentificacao(idAlterado);
                                                } while ( s.getIdentificacao() == -1 );
                                                // Solicitação dos novos dados
                                                do{
                                                    System.out.println(" Informe a nova quantidade de sacas panhadas ");
                                                    sacasAlterado = entSacas.nextInt();
                                                    // Inserção dos novos dados
                                                    s.setSacasPanhadas(sacasAlterado);
                                                } while( s.getSacasPanhadas() == -1);

                                                System.out.println(" #### Alteração feita com Sucesso!! ####");
                                                break;
                                            // caso 2 não irá efetuar nenhuma alteração
                                            case 2:
                                                break;
                                        }



                                        break;
                                    // caso 2 alteração de demais funcionarios
                                    case 2:
                                        // Criação de variaveis para o auxilio das alterações
                                        String nomeAlterado;
                                        String turnoAlterado;
                                        int tempoServicoAlterado;
                                        String cpfAlterado;
                                        int horasAlterado;
                                        int viagensAlterado;
                                        String nomeFuncio;
                                        int auxI = 0;

                                        // Criação de Scanners para auxilio na inserção dos dados
                                        Scanner entNome = new Scanner(System.in);
                                        Scanner entTurno = new Scanner(System.in);
                                        Scanner entTempo = new Scanner(System.in);
                                        Scanner entCpf = new Scanner(System.in);
                                        Scanner entHoras = new Scanner(System.in);
                                        Scanner entViagens = new Scanner(System.in);
                                        Scanner entradaAlterarDados = new Scanner(System.in);

                                        // Solicitação do nome do funcionário que deseja alterar os dados
                                        System.out.println("Informe o Nome do Funcionario que Deseja alterar os dados ");
                                        // leitura do nome informado pelo usuário
                                        nomeFuncio = entradaAlterarDados.nextLine();
                                        nomeFuncio = nomeFuncio.toUpperCase();
                                        // Criação de uma variavel/objeto p tipo Funcionario
                                        Funcionario p;
                                        // p recebe o primeiro funcionário da coleção de funcionarios
                                        p = funcionarios.get(auxI);
                                        // Enquanto o nome for diferente do nome informado será incrimentada a variavel auxI e p recebe o proximo funcionário
                                        while (!(p.getNome().equals(nomeFuncio))) {
                                            auxI++;
                                            p = funcionarios.get(auxI);
                                        }

                                        System.out.println("Deseja Alterar os dados? "
                                                + "(1) - Sim (2) - Não ");
                                        // Leitura da opcao
                                        opcaoEscolha = entradaMenu.nextInt();

                                        switch (opcaoEscolha) {
                                            // Caso 1 deseja alterar os dados
                                            case 1:
                                                // Vericações de qual tipo de funcionario a variavel p é instancia

                                                if (p instanceof AdministrativoFinanceiro) {
                                                    // Criação de uma variável auxiliar para efetuar o downcast
                                                    AdministrativoFinanceiro auxAdmin = (AdministrativoFinanceiro) p; // Downcast
                                                    // impressão dos dados atuais do funcionário 
                                                    System.out.println(" ##### DADOS ATUAIS ##### ");
                                                    auxAdmin.exibirTodosDados();
                                                    System.out.println(" ## INSIRA DADOS PARA ALTERAÇÃO ## ");
                                                    // inserção dos novos dados do funcionário
                                                    do{
                                                        System.out.println(" Informe o novo nome: ");
                                                        nomeAlterado = entNome.nextLine();
                                                        nomeAlterado = nomeAlterado.toUpperCase();
                                                        // inserção dos novos dados para o funcionário
                                                        auxAdmin.setNome(nomeAlterado);
                                                    }while( auxAdmin.getNome().equals(""));
                                                    do{
                                                        System.out.println(" Informe o novo turno (Manha,Tarde,Noite): ");
                                                        turnoAlterado = entTurno.nextLine();
                                                        turnoAlterado = turnoAlterado.toUpperCase();
                                                        // inserção dos novos dados para o funcionário
                                                        auxAdmin.setTurno(turnoAlterado);
                                                    }while( auxAdmin.getTurno().equals("-1") || auxAdmin.getTurno().equals(""));
                                                    do{
                                                        System.out.println(" Informe o novo tempo de Serviço: ");
                                                        tempoServicoAlterado = entTempo.nextInt();
                                                        // inserção dos novos dados para o funcionário
                                                        auxAdmin.setTempoServico(tempoServicoAlterado);
                                                    }while( auxAdmin.getTempoServico() == -1 );
                                                    do{
                                                        System.out.println(" Informe o novo CPF: ");
                                                        cpfAlterado = entCpf.nextLine();
                                                        // inserção dos novos dados para o funcionário
                                                        auxAdmin.setCpf(cpfAlterado);
                                                    }while( auxAdmin.getCpf().equals("-1") || auxAdmin.getCpf().equals(""));

                                                    System.out.println(" #### Alteração do Administrador-Financeiro feita com Sucesso!! ####");

                                                    //System.out.printf("Salario: %2.f \n",auxAdmin.calcularSalario());//Calcular Salario
                                                    System.out.println("");
                                                } else if (p instanceof Engenheiro) {
                                                    // Criação de uma variável auxiliar para efetuar o downcast
                                                    Engenheiro auxEng = (Engenheiro) p;
                                                    // impressão dos dados atuais do funcionário
                                                    System.out.println(" ##### DADOS ATUAIS ##### ");
                                                    auxEng.exibirTodosDados();
                                                    System.out.println("");
                                                    System.out.println(" ## INSIRA DADOS PARA ALTERAÇÃO ## ");
                                                    // solicitação dos novos dados para alteração
                                                    do{
                                                        System.out.println(" Informe o novo nome ");
                                                        nomeAlterado = entNome.nextLine();
                                                        nomeAlterado = nomeAlterado.toUpperCase();
                                                        // inserção dos novos dados do funcionário
                                                        auxEng.setNome(nomeAlterado);
                                                    }while ( auxEng.getNome().equals(""));
                                                    // solicitação dos novos dados para alteração
                                                    do{
                                                        System.out.println(" Informe o novo turno (Manha,Tarde,Noite) ");
                                                        turnoAlterado = entTurno.nextLine();
                                                        // inserção dos novos dados do funcionário
                                                        auxEng.setTurno(turnoAlterado);
                                                    }while( auxEng.getTurno().equals("-1") || auxEng.getTurno().equals(""));
                                                    // solicitação dos novos dados para alteração
                                                    do{
                                                        System.out.println(" Informe o novo tempo de Serviço ");
                                                        tempoServicoAlterado = entTempo.nextInt();
                                                        // inserção dos novos dados do funcionário
                                                        auxEng.setTempoServico(tempoServicoAlterado);
                                                    }while( auxEng.getTempoServico() == -1);
                                                    // solicitação dos novos dados para alteração
                                                    do{
                                                        System.out.println(" Informe o novo CPF ");
                                                        cpfAlterado = entCpf.nextLine();
                                                        auxEng.setCpf(cpfAlterado);
                                                    }while( auxEng.getCpf().equals("-1") || auxEng.getCpf().equals(""));

                                                    System.out.println(" #### Alteração do Engenheiro feita com Sucesso!! ####");
                                                    //System.out.printf("Salario: %2.f \n",auxEng.calcularSalario());//Calcular Salario
                                                    System.out.println("");
                                                } else if (p instanceof Motorista) {
                                                    // Criação de uma variável auxiliar para efetuar o downcast do objeto
                                                    Motorista auxMotorista = (Motorista) p;
                                                    // exibição dos dados atuais do funcionario
                                                    System.out.println(" ##### DADOS ATUAIS ##### ");
                                                    auxMotorista.exibirDadosDaClasseMotorista();

                                                    System.out.println(" ## INSIRA DADOS PARA ALTERAÇÃO ## ");
                                                    // Solicitação dos novos dados do funcionário
                                                    do{
                                                        System.out.println(" Informe o novo nome ");
                                                        nomeAlterado = entNome.nextLine();
                                                        nomeAlterado = nomeAlterado.toUpperCase();
                                                        // inserção dos novos dados do funcionário
                                                        auxMotorista.setNome(nomeAlterado);
                                                    }while( auxMotorista.getNome().equals(""));
                                                    // Solicitação dos novos dados do funcionário
                                                    do{
                                                        System.out.println(" Informe o novo turno (Manha,Tarde,Noite) ");
                                                        turnoAlterado = entTurno.nextLine();
                                                        turnoAlterado = turnoAlterado.toUpperCase();
                                                        // inserção dos novos dados do funcionário
                                                        auxMotorista.setTurno(turnoAlterado);
                                                    }while( auxMotorista.getTurno().equals("-1") || auxMotorista.getTurno().equals(""));
                                                    // Solicitação dos novos dados do funcionário
                                                    do{
                                                        System.out.println(" Informe o novo tempo de Serviço ");
                                                        tempoServicoAlterado = entTempo.nextInt();
                                                        // inserção dos novos dados do funcionário
                                                        auxMotorista.setTempoServico(tempoServicoAlterado);
                                                    }while( auxMotorista.getTempoServico() == -1);
                                                    // Solicitação dos novos dados do funcionário
                                                    do{
                                                        System.out.println(" Informe o novo CPF ");
                                                        cpfAlterado = entCpf.nextLine();
                                                        // inserção dos novos dados do funcionário
                                                        auxMotorista.setCpf(cpfAlterado);
                                                    }while ( auxMotorista.getCpf().equals("-1")|| auxMotorista.getCpf().equals(""));
                                                    
                                                    // verificação se é tratorista ou caminhoneiro para alterar horas dirigindo ou
                                                    // alterar a quantidade de viagens, faz-se um downcast para o mesmo ser setado
                                                    if (auxMotorista instanceof Tratorista) {
                                                        Tratorista auxTAltera;
                                                        auxTAltera = (Tratorista) auxMotorista;
                                                        do{
                                                            System.out.println(" Informe a nova quantidade de horas dirigindo: ");
                                                            horasAlterado = entHoras.nextInt();
                                                            auxTAltera.sethorasDirigindo(horasAlterado);
                                                        }while( auxTAltera.getHorasDirigindo() == -1);
                                                    } else if (auxMotorista instanceof Caminhoneiro) {
                                                        Caminhoneiro auxCaminhoneiro;
                                                        auxCaminhoneiro = (Caminhoneiro) auxMotorista;
                                                        do{
                                                        System.out.println(" Informe a nova quantidade de Viagens feitas: ");
                                                        viagensAlterado = entViagens.nextInt();
                                                        auxCaminhoneiro.setNumeroViagens(viagensAlterado);
                                                        }while( auxCaminhoneiro.getNumeroViagens() == -1);
                                                    }

                                                    System.out.println(" #### Alteração do Motorista feita com Sucesso!! ####");
                                                    //System.out.printf("Salario: %2.f \n", auxMotorista.calcularSalario());//Calcular Salario
                                                    System.out.println("");
                                                }
                                                break;
                                            // caso 2 nenhuma alteração será efetuada
                                            case 2:
                                                break;
                                        }
                                        break;
                                    default:
                                        System.out.println(" Informe um opção válida para o menu alterar dados de funcionários");
                                }
                            } catch (InputMismatchException exceptmis) {
                                System.err.println(exceptmis);
                                System.out.println(" Insira a informação correta para completar a operação ");
                                entradaMenu.next();
                            } finally {
                                break;
                            }
                        case 4:
                            try {
                                // OPÇÃO DE REMOÇÃO DE FUNCIONÁRIO
                                System.out.println(" ### REMOVER FUNCIONARIOS ### ");

                                System.out.println(" # 1 - Safrista ");
                                System.out.println(" # 2 - Demais funcionários ");
                                // leitura da opcao
                                opcaoMenu = entradaMenu.nextInt();
                                if ((opcaoMenu <= 0) || (opcaoMenu > 2)) {

                                    System.out.println(" Esta opção de menu não é válida !!! ");

                                } else {
                                    switch (opcaoMenu) {
                                        // caso 1 Remoção de funcionarios Safristas
                                        case 1:
                                            // Se a coleção está vazia
                                            if (funcionariosSafristas.isEmpty()) {
                                                System.out.println(" Nenhum funcionário cadastrado ! ");
                                            } else {
                                                // criação de variaveis para auxiliar na obtenção da ID do safrista e percorrer a coleção
                                                int ident;
                                                int i = 0;
                                                System.out.println(" Informe o ID do safrista que deseja remover ");
                                                // Leitura do ID a ser removido
                                                ident = entradaMenu.nextInt();
                                                // Exception IndexOutOfBoundsException
                                                // Criação de uma variável/objeto do tipo safrista iniciado com o primeiro safrista da coleção
                                                Safrista s = funcionariosSafristas.get(i);
                                                // Enquanto o ID informado for diferente do ID do objeto s será incrementado valor na variavel i
                                                // e s receberá o proximo objeto da coleção
                                                while (s.getIdentificacao() != ident) {
                                                    i++;
                                                    s = funcionariosSafristas.get(i);
                                                }
                                                // Se ID informada for igual a ID do objeto S então objeto será removido o safrista na possição i
                                                if (s.getIdentificacao() == ident) {
                                                    System.out.println(" Funcionário encontrado ! ");
                                                    funcionariosSafristas.remove(i);
                                                    System.out.println(" Funcionário SAFRISTA removido com sucesso !!! ");
                                                }
                                            }

                                            break;
                                        // caso 2 Remoção de demais funcionários
                                        case 2:
                                            // Se a coleção de funcionarios está vazia
                                            if (funcionarios.isEmpty()) {
                                                System.out.println(" Nenhum funcionário cadastrado !");

                                            } else {
                                                // Criação de variáveis para auxiliar na busca do funcionario que o usuário deseja remover
                                                Scanner entradaAlterarDados = new Scanner(System.in);
                                                String nomeFuncio;
                                                int auxI = 0;
                                                try {
                                                    System.out.println(" Informe o Nome do Funcionario que Deseja visualizar");
                                                    // Leitura do nome do funcionario a ser procurado para remoção
                                                    nomeFuncio = entradaAlterarDados.nextLine();
                                                    nomeFuncio = nomeFuncio.toUpperCase();
                                                    // Criação de um objeto p do tipo Funcionario 
                                                    Funcionario p;
                                                    // inicialização do objeto p com o primeiro objeto da coleção de funcionarios
                                                    p = funcionarios.get(auxI);
                                                    // Enquanto o nome informado for diferente do nome do objeto p será incrementado valor da variavel
                                                    // auxI e p receberá o proximo elemento da coleção
                                                    while (!(p.getNome().equals(nomeFuncio))) {
                                                        auxI++;
                                                        p = funcionarios.get(auxI);
                                                    }
                                                    // Se o nome informado for igual ao nome do objeto p então será removido o funcionario na posiçao auxI
                                                    if (p.getNome().equals(nomeFuncio)) {
                                                        System.out.println(" Funcionario encontrado ! ");
                                                        funcionarios.remove(auxI);
                                                        System.out.println(" FUNCIONÁRIO removido com sucesso !!! ");
                                                    }
                                                } catch (IndexOutOfBoundsException erroremove) {
                                                    System.err.println(erroremove);
                                                    System.out.println(" Informe um nome existente !! ");
                                                } finally {
                                                    break;
                                                }
                                            }
                                    }
                                }
                            } catch (InputMismatchException ermismatch) {
                                System.err.println(ermismatch);
                                System.out.println(" Informe opção ao invés de caracteres ! ");
                                entradaMenu.next();
                            }

                    }
                }
                //Verificar (opcaoCadastro == 5) vai direto para o menuPrincipal
                // Do/while para definir que o usuario tem que informar uma das 2 opções para prosseguir
                boolean passar = true;
                do {
                    System.out.println("[ Deseja ir para o Menu Principal? ] ");
                    System.out.println(" 1 - Sim  2 - Não ");
                    try {
                        // Leitura da opcao do menu Principal
                        opcaoMenuFixo = entradaMenuFixo.nextInt();
                        if ((opcaoMenuFixo <= 0) || (opcaoMenuFixo > 2)) {
                            //System.out.println(" Entre com uma opção válida !!! (1) ou (2)");
                            passar = true;
                            throw new NumberFormatException();
                        } else {
                            passar = false;
                            //System.out.println("Passou para false");
                        }
                    } catch (InputMismatchException e) {
                        // exceção caso o usuário informe outro valor para opção, diferente de 1 ou 2
                        System.err.println(e);
                        entradaMenuFixo.next();
                    } catch ( NumberFormatException ernumber){
                        System.err.println(ernumber);
                        System.out.println(" Informe uma opção valida ! (1) ou (2) ");
                    }
                } while (passar);


            } catch (InputMismatchException ermenuprincipal) {
                System.err.println(ermenuprincipal);
                System.out.println(" Informe um opção valida para o menu principal ");
                entradaMenuPrincipal.next();
                //opcaoMenuFixo = 1;
            }
        } while (opcaoMenuFixo == 1);

        // Gravação dos dados inseridos no arquivo. Ocorre quando a opção do menu principal for igual a 2
        gravador.gravarDadosFuncionarios(funcionarios, funcionariosSafristas);
    }
}
