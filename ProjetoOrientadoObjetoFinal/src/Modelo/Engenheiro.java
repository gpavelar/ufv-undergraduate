/*
 * Projeto1 da disciplina SIN141 - Computação Orientada a Objetos
 */
/**
 *
 * @authors Gustavo de Paula Avelar Matricula: 2481 Ebert Gurgel Melo Junior
 * Matricula: 2479
 */
package Modelo;

import java.io.Serializable;

public class Engenheiro extends Funcionario implements FuncionariosFazenda, Serializable {

    // variável para armazenar o salario do Engenheiro, salario fixo
    private final double salarioFuncionario = 4500.50;
    
    // construtor padrão
    public Engenheiro() {
    }
    
    // construtor completo
    public Engenheiro(String nome, String turno, int tempoServico, String cpf) {
        super(nome, turno, tempoServico, cpf);
    }
    
    // método set
    public void setSalarioFuncionario() {
    }
    
    // método get
    public double getSalarioFuncionario() {
        return this.salarioFuncionario;
    }
    
    // método toString
    public String toString() {
        return String.format("%s", super.toString());
    }
    
    // método para calcular salario + 15% bonus
    @Override
    public double calcularSalario() {

        return salarioFuncionario + (salarioFuncionario * 0.15);
    }
    
    // método para exibir todos os Dados
    @Override
    public void exibirTodosDados() {
        System.out.println(" Nome: " + super.getNome());
        System.out.println(" Turno de Serviço: " + super.getTurno());
        System.out.println(" Tempo de Serviço: " + super.getTempoServico());
        System.out.println(" CPF: " + super.getCpf());
        System.out.println(" Salário: " + this.getSalarioFuncionario());
        System.out.println(" Salário com adicional: " + this.calcularSalario());
    }
}
