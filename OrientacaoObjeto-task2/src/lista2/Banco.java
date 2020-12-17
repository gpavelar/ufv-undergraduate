package lista2;

public class Banco {
    
    private double saldo;
    
    //Construtor padrão
    public Banco(){
    }
    
    //Contrutor completo
    public Banco(double deposito){
        this.saldo = deposito;
    }
    
    //Metodo set
    public void setDeposito(double deposito){
        this.saldo = saldo + deposito;
    }
    
    //Metodo get
    public double getSaldo(){
        return this.saldo;
    }
    
    //Metodo Saque
    public void saque(double saque){
        if(saldo > saque){
            this.saldo = saldo - saque;
        }
        else
        {
            System.out.println("O seu saldo é insuficiente para esse saque");
        }
        
    }
    
    //Metodo deposito
    public void deposito(double deposito){
        this.saldo = saldo + deposito;
    }
    
    //Metodo mostraSaldo
    public void mostraSaldo(){
        
        System.out.println("O seu saldo é:"+saldo);
        
    }
}
