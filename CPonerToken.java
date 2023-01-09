package Conecta4.UndoRedo;

import Conecta4.Utilidades.Board;
import Conecta4.Utilidades.Token;

public class CPonerToken implements IComando {
    private int columna;
    private int fila;
    private Token token;
    private Board board;


    public CPonerToken (int columna, Token token, Board board, int fila){
        this.columna = columna;
        this.token = token;
        this.board = board;
        this.fila = fila;
    }

    @Override
    public void execute() {
        board.ponerToken(fila,columna,token);
    }

    @Override
    public void undo() {
        board.quitarToken(fila,columna,token);
    }

    @Override
    public void redo() {
        board.ponerToken(fila,columna,token);
    }

    @Override
    public String getName() {
        return "PONER FICHA";
    }
}
