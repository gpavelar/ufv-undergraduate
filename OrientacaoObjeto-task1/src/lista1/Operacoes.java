package lista1;
import java.util.Scanner;

public class Operacoes{
    public static void main(String[]args)
    {
        int numero1;
        int numero2;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe 2 numeros:");
        numero1 = input.nextInt();
        numero2 = input.nextInt();
        
        System.out.printf("A soma é : %d \n", numero1+numero2);
        
        System.out.printf("Subtração: %d \n",numero1-numero2);
        
        System.out.printf("Produto: %d \n",numero1*numero2);
        
        float quociente = numero1/numero2;
        
        System.out.printf("Divisão : %.2f \n",quociente);
     }
}

