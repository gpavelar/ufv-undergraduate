
package lista2;


public class ComprarPassagem {
    
    private String nome;
    private String cpf;
    private String dataIda;
    private String dataVolta;
    private double valor;
    private String cidadeO;
    private String cidadeD;
    
    public ComprarPassagem(){
    }
    public ComprarPassagem(String nome, String cpf, String dataIda, String dataVolta, double valor, String cidadeO, String cidadeD){
        setNome(nome);
        setCpf(cpf);
        setDataIda(dataIda);
        setDataVolta(dataVolta);
        setValor(valor);
        setCidadeO(cidadeO);
        setCidadeD(cidadeD);
        
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return this.cpf;
    }
    
    public void setDataIda(String dataIda){
        this.dataIda = dataIda;
    }
    public String getDataIda(){
        return this.dataIda;
    }
    
    public void setDataVolta(String dataVolta){
        this.dataVolta = dataVolta;
    }
    public String getDataVolta(){
        return this.dataVolta;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    public double getValor(){
        return this.valor;
    }
    
    public void setCidadeO(String cidadeO){
        this.cidadeO = cidadeO;
    }
    
    public String getCidadeO(){
        return this.cidadeO;
    }
    
    public void setCidadeD(String cidadeD){
        this.cidadeD = cidadeD;
    }
    
    public String getCidadeD(){
        return this.cidadeD;
    }
    
    public void exibirDados(){
    
        System.out.println("''Obrigado por escolher a nossa agência aérea''");
        System.out.printf("Origem: %s \t",getCidadeO());
        System.out.println("Destino: "+getCidadeD());
        System.out.println("Valor: R$ "+getValor());
        System.out.println("CPF: "+getCpf());
        System.out.println("Data de ida: "+getDataIda());
        System.out.println("Data de volta: "+getDataVolta());
        System.out.println("''Desejamos que tenha um excelente vôo!!!''");
    }
    
}

