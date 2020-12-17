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

public abstract class Funcionario implements Serializable {
    
    // Variáveis para armazenar os dados do funcionário
    private String nome;
    private String turno;
    private int tempoServico;
    private String cpf;
    
    // contrutor padrão
    public Funcionario() {
    }
    
    // construtor completo
    public Funcionario(String nome, String Turno, int tempoServico, String cpf) {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setTempoServico(tempoServico);
        this.setTurno(turno);
    }
    
    // método para setar o nome do funcionário
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // método para retornar o nome do funcionário
    public String getNome() {
        return this.nome;
    }
    
    // método para setar o turno do funcionário
    public void setTurno(String turno) {
        if ((turno.equals("MANHA")) || (turno.equals("NOITE")) || (turno.equals("TARDE") || turno.equals("MANHÃ")) ) {
            this.turno = turno;
        } else {
            this.turno = "-1";
        }
    }
    
    // método para retornar o turno do funcionário
    public String getTurno() {
        return this.turno;
    }
    
    // método para setar o tempo de serviço do funcionário
    public void setTempoServico(int tempoServico) {
        this.tempoServico = ((tempoServico >= 0) && (tempoServico <= 100)) ? tempoServico : -1;
    }
    
    // método para retornar o tempo de serviço do funcionário
    public int getTempoServico() {
        return this.tempoServico;
    }
    
    // método para setar o CPF do funcionário
    public void setCpf(String cpf) {
        if (cpf.length() != 11) {
            this.cpf = "-1";
        } else {
            this.cpf = cpf;
        }
    }
    
    // método para retornar o CPF do funcionário
    public String getCpf() {
        return this.cpf;
    }
    
    // método toString
    public String toString() {
        return String.format("*****************\n Nome: %s "
                + "\n Turno de Serviço: %s "
                + "\n Tempo de Serviço na empresa: %d "
                + "\n CPF: %s", this.getNome(), this.getTempoServico(), this.getTurno(), this.getCpf());
    }
}
