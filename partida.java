import java.util.Scanner;

public class partida{

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
    
    char at;

        do{

            System.out.println("Bienvenido a Conecta4. Creando nueva partida...\n\n");

            Conecta4 c4 = new Conecta4(2, 6, 7);

            System.out.print("¿Quiere jugar otra partida?(s/n): ");

            char op = sc.next().charAt(0);

            at = op;

            if(at != 's' && at != 'n'){

                do{

                    System.out.print("Error. Escriba un parametro permitido (s/n): ");

                    op = sc.next().charAt(0);

                    at = op;

                }while(at != 'n' && at != 's');

            }    
                

        }while(at != 'n');
        
        System.out.println("Exiting...");
    }
}