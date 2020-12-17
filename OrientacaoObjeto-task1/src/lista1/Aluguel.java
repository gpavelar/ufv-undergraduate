
package lista1;
import java.util.Scanner;

public class Aluguel{
    public static void main(String args[])
    {
        double valorAluguel;
        double valorTotal = 0.0;
        double descontoAluguel;
        int cont = 1 ;
        int anos = 0;
        
        valorAluguel = 550.0;
        
        while(anos < 4)
        {
            valorTotal = valorTotal + valorAluguel;
            //System.out.println("Valor do aluguel mes:%d "+cont+"valor somado:"+valorTotal);
            System.out.printf("Valor do mes %d e o valor da soma %.2f \n",cont,valorTotal);
            if(cont == 12)
            {
                cont = 0;
                valorAluguel = valorAluguel + (valorAluguel*0.10);
                anos = anos +1;    
            }
            cont = cont+1;
         }
         Scanner input = new Scanner(System.in);
         System.out.println("Informe o valor do desconto");
         descontoAluguel = input.nextDouble();
         valorTotal = valorTotal - descontoAluguel;
         System.out.printf("Valor total do aluguel dos 4 anos é %.2f",valorTotal);
 }
}
