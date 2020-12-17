package lista1;
import java.util.Scanner;

public class MaiorNumero{
    public static void main(String[]args)
    {
        int numero1;
        int numero2;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe 2 numeros:");
        numero1 = input.nextInt();
        numero2 = input.nextInt();
        
        if(numero1>numero2)
        {
            System.out.println(+numero1+" is larger");
        }
        else
        if(numero2>numero1)
        {
            System.out.println(+numero2+" is larger");
        }
        else
        if(numero1==numero2)
        {
            System.out.println("These numbers are equal");
        }
     }
}