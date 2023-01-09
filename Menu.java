package Conecta4;

import java.util.Scanner;

public class Menu {
    /**
     * Presentacion de del menu en pantalla
     * @return menu
     */
    public int menu(){
        int valor = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("------MENU------");
        System.out.println("Elige el modo de juego:");
        System.out.println("1.BASICO");
        System.out.println("2.ENTRENAMIENTO ");
        System.out.println("3.DEMO");
        System.out.println("0.EXIT");
        valor = in.nextInt();
        if(valor>3 || valor<0){
            System.out.println("Valor incorrecto.");
        }

        return valor;
    }
}
