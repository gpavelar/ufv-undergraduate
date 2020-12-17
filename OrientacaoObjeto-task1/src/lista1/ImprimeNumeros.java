
package lista1;


public class ImprimeNumeros {
    public static void main(String args[]){
        int contador = 1;
        
       
           System.out.println(+contador);
           System.out.printf("\b");
           contador++;
           System.out.println(+contador);
           contador++;
           System.out.println(+contador);
           contador++;
           System.out.println(+contador);
           
           contador = 1;
           
           while(contador <= 4)
           {
               System.out.printf("%d",contador);
               System.out.printf(" ");
               contador++;
           }
           System.out.printf(" \n");
           contador = 1;
           
           while(contador <= 4)
           {
               System.out.print(+contador);
               System.out.printf(" ");
               contador++;
           }
    }
    
}
