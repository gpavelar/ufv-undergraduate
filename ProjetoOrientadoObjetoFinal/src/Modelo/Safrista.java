/*
 * Projeto1 da disciplina SIN141 - Computação Orientada a Objetos
 */
/**
 *
 * @authors Gustavo de Paula Avelar Matricula: 2481 Ebert Gurgel Melo Junior
 * Matricula: 2479
 */
package Modelo;

import Modelo.Funcionario;
import java.io.Serializable;

public class Safrista extends Funcionario implements FuncionariosFazenda, Serializable {
    
    // variável para armazenar a identificação do safrista (ID)
    private int identificacao;
    // variável para armazenar a quantidade de sacas panhadas pelo safrista
    private int sacasPanhadas;
    
    // construtor padrão
    public Safrista() {
    }
    
    // construtor completo
    public Safrista(String nome, String turno, int tempoServico, String cpf, int identificacao) {
        super(nome, turno, tempoServico, cpf);
        this.setIdentificacao(identificacao);
    }
    
    // método para setar a identificação do safrista
    public void setIdentificacao(int identificacao) {
        this.identificacao = ((identificacao >= 0) && (identificacao <= 100)) ? identificacao : -1;
    }
    
    // método para retornar a identificação do safrista
    public int getIdentificacao() {
        return this.identificacao;
    }
    
    // método para setar as sacas panhadas pelo safrista
    public void setSacasPanhadas(int sacas) {
        this.sacasPanhadas = ((sacas >= 0) && (sacas <= 150)) ? sacas : -1;
    }
    
    // método para retornar as sacas panhadas pelo safrista
    public int getSacasPanhadas() {
        return this.sacasPanhadas;
    }
    
    // método toString
    public String toString() {
        return String.format("%s \n ID: %d \n Sacas panhadas: %d ", super.toString(), this.getIdentificacao(), this.getSacasPanhadas());
    }
    
    // método para calcular o salário do safrista
    @Override
    public double calcularSalario() {
        return (sacasPanhadas * 19.2);
    }
    
    // método para exibir todos os dados do funcionário
    @Override
    public void exibirTodosDados() {
        System.out.println(" | ID : " + this.getIdentificacao());
        System.out.println(" Nome: " + super.getNome());
        System.out.println(" Turno de Serviço: " + super.getTurno());
        System.out.println(" Tempo de Serviço: " + super.getTempoServico());
        System.out.println(" CPF: " + super.getCpf());
        System.out.println(" Sacas Panhadas : " + this.getSacasPanhadas());
        System.out.println(" Salário final: " + this.calcularSalario());
    }
}
