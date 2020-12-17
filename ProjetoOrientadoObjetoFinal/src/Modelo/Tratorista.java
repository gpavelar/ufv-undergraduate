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

public class Tratorista extends Motorista implements FuncionariosFazenda, Serializable {

    // variável para armazenar a quantidade de horas que o funcionario passou dirigindo
    private int horasDirigindo;
    
    //contrutor padrão
    public Tratorista() {
    }
    
    // construtor completo
    public Tratorista(String nome, String turno, int tempoServico, String cpf, int horasDirigindo) {
        super(nome, turno, tempoServico, cpf);
        this.horasDirigindo = horasDirigindo;
    }
    
    // método para setar o valor de horas dirigindo
    public void sethorasDirigindo(int horas) {
        this.horasDirigindo = ((horas >= 0) && (horas <= 100)) ? horas : -1;
    }
    
    // método para retornar o valor de horas dirigindo
    public int getHorasDirigindo() {
        return this.horasDirigindo;
    }
    
    // método toString
    public String toString() {
        return String.format("%s \n Horas dirigindo: %d ", super.toString(), getHorasDirigindo());
    }
    
    // método calcular salário
    public double calcularSalario() {

        return (super.getSalarioFuncionario() + (this.horasDirigindo * 0.80));

        // variável para receber o salario final
        //double salario;
        // calculando salario final do funcionário
        //salario = (super.getSalarioFuncionario() + ( horasDirigindo * 0.80));
        // retorno do salário final do funcionario
        //return salario;

    }
    
    // método para exibir todos os dados do Funcionário
    @Override
    public void exibirTodosDados() {
        super.exibirDadosDaClasseMotorista();
        System.out.println(" Salario com adicional: " + this.calcularSalario());
        //System.out.println(" Nome: "+ super.getNome());
        //System.out.println(" Turno de Serviço: "+ super.getTurno());
        //System.out.println(" Tempo de Serviço: "+ super.getTempoServico());
        //System.out.println(" CPF: "+ super.getCpf());
        //System.out.println(" Salario Fixo: " + super.getSalarioFuncionario());
        //System.out.println("");

    }
}
