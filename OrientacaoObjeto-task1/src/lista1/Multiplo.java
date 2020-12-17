package lista1;
import java.util.Scanner;

public class Multiplo{
    public static void main(String[]args)
    {
        int numero1;
        int numero2;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe 3 numeros:");
        numero1 = input.nextInt();
        numero2 = input.nextInt();
        
        
        if(numero2 % numero1 == 0)
        {
            System.out.println(+numero2+" é multiplo de "+numero1);
            System.out.println("O multiplo é "+numero1*numero2);
        }
        else
        {
            System.out.println(+numero2+" nao e multiplo de "+numero1);
        }
    }
}