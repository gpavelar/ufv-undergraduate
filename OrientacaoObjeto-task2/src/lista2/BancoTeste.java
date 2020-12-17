
package lista2;
import java.util.Scanner;

public class BancoTeste {

    public static void main(String []args)
    {
        double valorSD;
        Banco obj1 = new Banco();
        
        obj1.mostraSaldo();
        
        System.out.println("Informe o valor de que deseja depositar");
        Scanner input = new Scanner(System.in);
        valorSD = input.nextDouble();
        obj1.setDeposito(valorSD);
        obj1.mostraSaldo();
        System.out.println("O seu saldo é:"+obj1.getSaldo());
        
        System.out.println("Informe o valor de que deseja sacar");
        valorSD = input.nextDouble();
        obj1.saque(valorSD);
        obj1.mostraSaldo();
        
        
        String nome1;
        String nome2;
        Scanner nome1S = new Scanner( System.in );
        Scanner nome2S = new Scanner( System.in );
        
        System.out.println("Informe o primeiro nome");
        nome1 = nome1S.nextLine();
        nome2 = nome2S.nextLine();
        
        if(nome1.equals(nome2))
        {
            System.out.println("Deu certo");
        }
        else
        {
            System.out.println("Não deu certo");
        }
        
     }
}
