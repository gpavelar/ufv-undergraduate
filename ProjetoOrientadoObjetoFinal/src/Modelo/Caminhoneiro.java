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

public class Caminhoneiro extends Motorista implements FuncionariosFazenda, Serializable {
    
    // Variável para armazenar o numero de viagens efetuado pelo funcionario
    private int numeroViagens;
    
    // construtor padrão
    public Caminhoneiro() {
    }
    
    // construtor completo
    public Caminhoneiro(String nome, String turno, int tempoServico, String cpf, int numeroViagens) {
        super(nome, turno, tempoServico, cpf);
        this.numeroViagens = numeroViagens;
    }
    
    // método para setar o numero de viagens minimo 0 e maximo 100 viagens
    public void setNumeroViagens(int numeroViagens) {
        this.numeroViagens = ((numeroViagens >= 0) && (numeroViagens <= 100)) ? numeroViagens : -1;
    }
    
    // método para retornar o numero de viagens 
    public int getNumeroViagens() {
        return this.numeroViagens;
    }
    
    // Método toString
    public String toString() {
        return String.format("%s \n Numero de Viagens: %d ", super.toString(), getNumeroViagens());
    }
    
    // Método para calculo do salario
    @Override
    public double calcularSalario() {
        double salario;

        salario = (super.getSalarioFuncionario() + (numeroViagens * 1.20));

        return salario;
    }

    // Método para impressão de todos os dados
    @Override
    public void exibirTodosDados() {
        super.exibirDadosDaClasseMotorista();
        System.out.println(" Salario com adicional: " + this.calcularSalario());
        //System.out.println(" Nome: "+ super.getNome());
        //System.out.println(" Turno de Serviço: "+ super.getTurno());
        //System.out.println(" Tempo de Serviço: "+ super.getTempoServico());
        //System.out.println(" CPF: "+ super.getCpf());
        //System.out.println(" Salario Fixo: " + super.getSalarioFuncionario());
        //System.out.println("DADOS DUPLICADOS");                             
    }
}
