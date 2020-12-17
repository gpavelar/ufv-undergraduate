package lista1;
import java.util.Scanner;


public class Onda{
    public static void main(String []args)
    {
        float velocidade = 20;
        float tempo;
        float kmPercorrido = 0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe a distancia, para calcular o tempo gasto pela onda para percorrer");
        kmPercorrido = input.nextFloat();
        
        while((kmPercorrido < 0) || (kmPercorrido >12))
        {
            System.out.println("Informe a distancia valida, para calcular o tempo gasto pela onda para percorrer");
            kmPercorrido = input.nextFloat();
        }
        /*do
        {
            System.out.println("Informe a distancia, para calcular o tempo gasto pela onda para percorrer");
            kmPercorrido = input.nextFloat();
        }while((kmPercorrido > 0) || (kmPercorrido < 12));
        */
        
        tempo = (kmPercorrido / velocidade);
        
        System.out.printf("Foi gasto %.2f horas para percorrer o percurso de %.2f",tempo,kmPercorrido);
    }
}

