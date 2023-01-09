package Conecta4.TipoPlayers;

import Conecta4.UndoRedo.Gestor;
import Conecta4.Utilidades.Token;

import java.awt.*;

public class PlayerIA extends Player {
    public PlayerIA(String nombre, char letra, Color color){
        super(nombre, letra, color);
    }
    public void put(Gestor gestor) {
        int fila;
        int columna ;
        do {
            columna = eleccionMaquina();
            fila = this.board.filaLibre(columna);
            if(fila == -1){
                System.out.println("Error,la columna " + columna + " esta llena.\n\n");
                fila++;
            }

        } while (this.board.estaLibre(fila, columna));
        Token mificha = new Token(this.letratoken, this.colorToken);
        this.board.ponerToken(fila,columna,mificha);
    }

    private int eleccionMaquina(){
        return (int) Math.floor(Math.random() * board.getncolumnas()+1);
    }
}
