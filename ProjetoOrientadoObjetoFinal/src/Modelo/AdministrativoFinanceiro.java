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

public class AdministrativoFinanceiro extends Funcionario implements FuncionariosFazenda, Serializable {
    
    // variável para armazenar o salario fixo do funcionário administrativo
    private final double salarioFuncionario = 2300;
    
    // construtor padrão
    public AdministrativoFinanceiro() {
    }
    
    // construtor completo
    public AdministrativoFinanceiro(String nome, String turno, int tempoServico, String cpf) {
        super(nome, turno, tempoServico, cpf);
    }
    
    // método para setar o valor da variavel final, mas como já foi iniciado , não possui implementação
    public void setSalarioFuncionario() {
    }
    
    // método para retornar o valor da variável final
    public double getSalarioFuncionario() {
        return this.salarioFuncionario;
    }
    
    // método para exibir todos os dados do funcionário
    public void exibirTodosDados() {
        System.out.println(" Nome: " + super.getNome());
        System.out.println(" Turno de Serviço: " + super.getTurno());
        System.out.println(" Tempo de Serviço: " + super.getTempoServico());
        System.out.println(" CPF: " + super.getCpf());
        System.out.println(" Salario: " + this.getSalarioFuncionario());

    }
    
    // método toString
    public String toString() {
        return String.format("%s", super.toString());
    }
    
    // método para calcular o salario, neste caso retorna o salario fixo + 20% do salario
    @Override
    public double calcularSalario() {

        return (salarioFuncionario + (salarioFuncionario * 0.2));

    }
}
