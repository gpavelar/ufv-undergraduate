package lista1;
import java.util.Scanner;

public class InverteNumero
{

    public static void main(String args[])
    {
        String numero;
        String numeroInverso = "";
        int cont = 0;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Informe um numero:");
        numero = input.nextLine();
        
        System.out.printf("O valor é %s \n",numero);
        
        for (int i = numero.length(); i > 0; i--)
        {    
            numeroInverso += numero.substring(i - 1, i);    
        }    
            
        System.out.println("numero invertido:" +numeroInverso); 
    }
}
