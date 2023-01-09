package Conecta4.TipoPlayers;

import Conecta4.UndoRedo.CPonerToken;
import Conecta4.UndoRedo.Gestor;
import Conecta4.Utilidades.Token;

import java.awt.*;

public class PlayerH extends Player {
    public PlayerH(String nombre, char letra, Color color){
        super(nombre, letra, color);
    }
    public void put(Gestor gestor) {
        int fila;
        int columna;
        do {
            columna = this.board.pedirColumna(nombre);
            fila = this.board.filaLibre(columna);
            if(fila == -1){
                System.out.println("Error,la columna " + columna + " esta llena.\n\n");
                fila++;
            }

        } while (this.board.estaLibre(fila, columna));
        Token mitoken = new Token(this.letratoken, this.colorToken);
        this.board.ponerToken(fila,columna,mitoken);
        gestor.execute(new CPonerToken(columna, mitoken,board,fila));
    }
}
