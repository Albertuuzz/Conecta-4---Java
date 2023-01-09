package Conecta4.TipoPlayers;

import Conecta4.UndoRedo.Gestor;
import Conecta4.Utilidades.Board;

import java.awt.*;

public abstract class Player {
    protected String nombre;
    protected final char letratoken;
    protected final Color colorToken;
    protected Board board;

    /**
     * getters y setters de la clase
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public char getLetraToken() {
        return letratoken;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player(String nombre, char letra, Color color) {
        this.nombre = nombre;
        this.letratoken = letra;
        this.colorToken = color;
    }

    public abstract void put(Gestor gestor);
}
