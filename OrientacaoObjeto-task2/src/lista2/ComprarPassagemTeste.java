package lista2;
import java.util.Scanner;

public class ComprarPassagemTeste {

    public static void main(String []args){
        String n1;
        String n2;
        String n3;
        String n4;
        String n5;
        String n6;
        double valor1;
        
        Scanner entDados = new Scanner(System.in);
        
        System.out.println("Informe Cidade e país de origem (ex: Buenos Aires - Argentina");
        n1 = entDados.nextLine();
        
        System.out.println("Informe Cidade e país de destino (ex: Sao Paulo - Brasil)");
        n2 = entDados.nextLine();
        
        System.out.println("Informe o nome do passageiro");
        n3 = entDados.nextLine();
        
        System.out.println("Informe o CPF do passageiro");
        n4 = entDados.nextLine();
        
        System.out.println("Informe a data de ida");
        n5 = entDados.nextLine();
        
        System.out.println("Informe a data de volta");
        n6 = entDados.nextLine();
        
        System.out.println("Informe o valor da passagem");
        valor1 = entDados.nextDouble();
        
        ComprarPassagem obj1 = new ComprarPassagem(n3, n4 ,n5, n6, valor1, n1, n2);
        
        obj1.exibirDados();
        
        
    }
}
