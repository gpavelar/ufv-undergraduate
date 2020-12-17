package lista1;
import java.util.Scanner;

public class TresNumeros{
    public static void main(String[]args)
    {
        int numero1;
        int numero2;
        int numero3;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe 3 numeros:");
        numero1 = input.nextInt();
        numero2 = input.nextInt();
        numero3 = input.nextInt();
        
        
        System.out.printf("Soma é %d \n", numero1+numero2+numero3);
        float media = (numero1+numero2+numero3)/3;
        System.out.printf("Media é %.0f \n", media);
        
        System.out.printf("Multiplicação é %d\n", numero1*numero2*numero3);
        
        
        if(numero1>numero2)
        {
            if(numero1>numero3)
            {
                System.out.println(+numero1+" is larger");
                if(numero2>numero3)
                {
                    System.out.println(+numero2+" segundo maior ");
                    System.out.println(+numero3+" e o menor numero ");
                }
                else
                {
                    System.out.println(+numero3+" segundo maior ");
                    System.out.println(+numero2+" e o menor numero ");
                }
            }
        }
        else
        if(numero2>numero1)
        {
            if(numero2>numero3)
            {
                ////Aqui
                System.out.println(+numero2+" is larger");
                if(numero1>numero3)
                {
                    System.out.println(+numero1+" segundo maior ");
                    System.out.println(+numero3+" e o menor numero ");
                }
                else
                {
                    System.out.println(+numero3+" segundo maior ");
                    System.out.println(+numero1+" e o menor numero ");
                }
            }
        }
        else
        if(numero3>numero1)
        {
            if(numero3>numero2)
            {
               System.out.println(+numero3+" is larger");
               if(numero1>numero2)
               {
                   System.out.println(+numero1+" segundo maior ");
                   System.out.println(+numero2+" e o menor numero ");
               }
               else
               {
                   System.out.println(+numero2+" segundo maior ");
                   System.out.println(+numero1+" e o menor numero ");
               }
            }
        }
        if((numero1== numero2)&&(numero1==numero3))
        {
            System.out.println("These numbers are equal");
        }
     }
}