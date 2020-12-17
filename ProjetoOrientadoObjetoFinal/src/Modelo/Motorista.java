package Modelo;

/*
 * Projeto1 da disciplina SIN141 - Computação Orientada a Objetos
 */
/**
 *
 * @authors Gustavo de Paula Avelar Matricula: 2481 Ebert Gurgel Melo Junior
 * Matricula: 2479
 */
import Modelo.Funcionario;
import java.io.Serializable;

public abstract class Motorista extends Funcionario implements Serializable {
    
    // variavel para armazenar o salario do funcionário
    private final double salarioFuncionario = 950.50;
    
    // Construtor padrão
    public Motorista() {
    }
    
    // Construtor comlpeto
    public Motorista(String nome, String turno, int tempoServico, String cpf) {
        super(nome, turno, tempoServico, cpf);
    }
    
    // método toString
    public String toString() {
        return String.format("%s", super.toString());
    }
    
    // método para setar o salário do funcionário, sem nenhum parametro pois esse salario é fixo e já iniciado;
    public void setSalarioFuncionario() {
        //this.salarioFuncionario = 950.50;
    }
    
    // método para retornar o salário do funcionário 
    public double getSalarioFuncionario() {
        return this.salarioFuncionario;
    }
    
    // método para exibir todos dados da classe 
    public void exibirDadosDaClasseMotorista() {
        System.out.println(" Nome: " + super.getNome());
        System.out.println(" Turno de Serviço: " + super.getTurno());
        System.out.println(" Tempo de Serviço: " + super.getTempoServico());
        System.out.println(" CPF: " + super.getCpf());
        System.out.println(" Salario Fixo: " + this.getSalarioFuncionario());
        System.out.println("");
    }
    /*public void exibirTodosDados() {
     System.out.println(" Nome: "+ super.getNome());
     System.out.println(" Turno de Serviço: "+ super.getTurno());
     System.out.println(" Tempo de Serviço: "+ super.getTempoServico());
     System.out.println(" CPF: "+ super.getCpf());
     System.out.println("");
     }*/
}
