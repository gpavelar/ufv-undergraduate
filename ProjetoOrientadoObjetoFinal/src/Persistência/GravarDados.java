/*
 * Projeto1 da disciplina SIN141 - Computação Orientada a Objetos
 */

/**
 *
 * @authors Gustavo de Paula Avelar 
 *          Matricula: 2481
 *          Ebert Gurgel Melo Junior
 *          Matricula: 2479
 */
package Persistência;

import Modelo.Funcionario;
import Modelo.Safrista;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GravarDados {
    // criação de 2 coleções e inicializações para armazenar os dados dos funcionários e auxiliar na desearilização
    private ArrayList<Funcionario> funcionariosCopia = new ArrayList<Funcionario>();//ArrayList para cadastros de funcionários.
    private ArrayList<Safrista> funcionariosSafristasCopia = new ArrayList<Safrista>();//ArrayList para Cadastro de Safristas

    // método para setar coleção de funcionários valor já iniciado na classe 
    public void setFuncionariosCopia(){
        this.funcionariosCopia = funcionariosCopia;
    }
    // método para retornar a coleção de funcionários
    public ArrayList<Funcionario> getFuncionariosCopia() {
        return this.funcionariosCopia;
    }
    // método para setar coleção de funcionários safristas com o valor já iniciado no inicio da classe
    public void setFuncionariosSafristasCopia(){
        this.funcionariosSafristasCopia = funcionariosSafristasCopia;
    }
    // método para retornar a coleção de funcionários safristas
    public ArrayList<Safrista> getFuncionariosSafristasCopia() {
        return this.funcionariosSafristasCopia;
    }
    // método para gravar os dados no arquivo
    public void gravarDadosFuncionarios(ArrayList<Funcionario> funcionarios, ArrayList<Safrista> funcionariosSafristas) throws FileNotFoundException, IOException {
        // Serialização, obtida no slide 25 da aula 15, apenas com alteração para serialização de 2 arquivos
        try {
            // Gerar o arquivo para armazenar o objeto funcionarios
            FileOutputStream arquivoGrav = new FileOutputStream("Funcionarios.txt");
            // Gerar a saída dos dados no arquivo
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            // Gerar o arquivo para armazenar o objeto safristas
            FileOutputStream arquivoGrav2 = new FileOutputStream("Safristas.txt");
            // Gerar a saída dos dados no arquivo
            ObjectOutputStream objGravar2 = new ObjectOutputStream(arquivoGrav2);

            // Salvar os dados dos funcionarios no arquivo
            for (Funcionario obj : funcionarios) {
                objGravar.writeObject(obj);
            }
            // Salvar os dados Safrista no arquivo
            for (Safrista obj2 : funcionariosSafristas) {
                objGravar2.writeObject(obj2);
            }
            // Fechar fluxo, o que faz o envio de todos os dados no exato momento
            objGravar.flush();
            //Fecha objGravar
            objGravar.close();
            // Fecha fluxo, o que faz o envio de todos os dados no exato momento
            arquivoGrav.flush();
            //Fecha  arquivoGrav
            arquivoGrav.close();
            
            // Fecha fluxo, o que faz o envio de todos os dados no exato momento
            objGravar2.flush();
            // Fecha objGravar2
            objGravar2.close();
            // Fecha fluxo, o que faz o envio de todos os dados no exato momento
            arquivoGrav2.flush();
            // Fecha escrita no arquivo
            arquivoGrav2.close();

            System.out.println(" Objeto Gravado com sucesso !!!! ");

        } catch (FileNotFoundException e) {
            // Exceção caso o arquivo não seja encontrado
            System.err.print(" Arquivo não encontrado ");
        } catch (IOException e) {
            // Exceção caso ocorra algum erro ao gravar objeto
            System.err.print(" Erro ao gravar objeto ");
        }


    }
    // método para deserializar Funcionários
    public void deserializarFuncionario() throws IOException {
        // retirado do slide 28 aula 15, algumas alterações foram efetuadas
        try {
            //Gera o arquivo para armazenar o objeto 
            FileInputStream arquivoLeitura = new FileInputStream("Funcionarios.txt");
            //Recupera os objetos do arquivo
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            // Cria um objeto do tipo Funcionario
            Funcionario funcionarioAux;

            try {
                // Enquanto for verdade ocorrerá os proximos passos
                while (true) {
                    //Coloca FuncionarioAux um objeto do tipo Funcionario
                    funcionarioAux = (Funcionario) objLeitura.readObject();
                    // Armazena o objeto obtido pela leitura do arquivo na coleção auxiliar criada na classe
                    this.funcionariosCopia.add(funcionarioAux);
                    
                    //Imprime as informações de um objeto, metodo toString()
                    //System.out.println( funcionarioAux+ "\n");
                }
            } catch (ClassNotFoundException ex) {
                // exceção caso não encontre a classe desejada
                System.out.println(" Erro de classe ");
            } catch (EOFException ex) {
                // exceção caso o arquivo seja carregado com sucesso
                System.out.println(" @@ Arquivos Carregados com Sucesso!! @@ ");
                System.out.println("");
                return;
            } finally {
                // bloco finally sempre executado 
                // fechar objLeitura para leitura de objetos
                objLeitura.close();
                // fechar arquivoLeitura para leitura 
                arquivoLeitura.close();
            }

        } catch (FileNotFoundException e) {
            // exceção caso o aqruivo não seja encontrado
            System.err.print(" Arquivo não encontrado ");
        } catch (IOException e) {
            // exceção caso ocorra algum erro ao recupar dados
            System.err.println(" Erro ao recuperar dados do arquivo ");
        }

    }
    // método para deserealização dos funcionários Safristas
    public void deserializarSafrista() {
        // retirado do slide 28 aula 15, algumas alterações foram efetuadas
        try {
            //Gera o arquivo para armazenar o objeto 
            FileInputStream arquivoLeitura2 = new FileInputStream("Safristas.txt");
            //Recupera os objetos do arquivo
            ObjectInputStream objLeitura2 = new ObjectInputStream(arquivoLeitura2);
            // Criação de um objeto do tipo Safrista
            Safrista safristaAux2;

            try {
                // Enquanto for verdade executa os proximos passos
                while (true) {
                    //Coloca FuncionarioAux um objeto do tipo Funcionario
                    safristaAux2 = (Safrista) objLeitura2.readObject();
                    // insere o safrista recuperado do arquivo na coleção auxiliar para funcionários Safristas
                    this.funcionariosSafristasCopia.add(safristaAux2);
                    
                    //Imprime as informações de um objeto, metodo toString()
                    //System.out.println( safristaAux2+ "\n");
                    
                }
            } catch (ClassNotFoundException ex) {
                // exceção caso encontre erro na classe obtida/recuperada
                System.out.println(" Erro de classe ");
            } catch (EOFException ex) {
                // exceção caso os arquivos sejam carregados com sucesso
                System.out.println(" @@ Arquivos2 Carregados com Sucesso!! @@ ");
                System.out.println("");
                return;
            } finally {
                // bloco finally sempre executado
                // fecha objLeitura2 para leitura de objetos
                objLeitura2.close();
                // fecha arquivoLeitura para leitura 
                arquivoLeitura2.close();
            }

        } catch (FileNotFoundException e) {
            // exceção caso arquivo não seja encontrado
            System.err.print(" Arquivo não encontrado ");
        } catch (IOException e) {
            // exceção caso ocorra erro ao recuperar dados do arquivo
            System.err.println(" Erro ao recuperar dados do arquivo ");
        }
    }
}
