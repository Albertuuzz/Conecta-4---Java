package Conecta4.ComprobanteReglas;

import Conecta4.TipoPlayers.Player;
import Conecta4.Utilidades.Board;

public class ComprobanteJuego implements comprobarDiagonal,comprobarHorizontal,comprobarTablero, comprobarVertical{
    private final int nfilas;
    private final int ncolumnas;


    public ComprobanteJuego(int nfilas, int ncolumnas) {
        this.nfilas = nfilas;
        this.ncolumnas = ncolumnas;
    }

    /**
     * Metodo que comprueba si hay 4 en raya en el tablero
     * @param board tablero en el que se comprueba la horizontal
     * @param token caracter de la ficha que se comprueba
     */
    @Override
    public boolean comprobarTablero(char token, Board board ) {
        boolean resultado;
        resultado = comprobarHorizontal(token, board);
        if (!resultado) {
            resultado = comprobarVertical(token, board);
            if (!resultado) {
                resultado = comprobarDiagonal(token, board);
            }
        }
        return resultado;

    }

    /**
     * comprobacion horizontal
     * @param board tablero en el que se comprueba la horizontal
     * @param token caracter de la ficha que se comprueba
     */
    @Override
    public boolean comprobarHorizontal(char token, Board board ) {
        boolean resultado = false;
        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncolumnas - 3; j++) {
                if (board.getToken(i,j).getToken().getRelleno() == token &&
                        board.getToken(i,j+1).getToken().getRelleno() == token &&
                        board.getToken(i,j+2).getToken().getRelleno() == token &&
                        board.getToken(i,j+3).getToken().getRelleno() == token) {
                    resultado = true;
                }
            }
        }
        return resultado;
    }

    /**
     * comprobacion vertical
     * @param board tablero en el que se comprueba la vertical
     * @param token caracter de la ficha que se comprueba
     */
    @Override
    public boolean comprobarVertical(char token, Board board ) {
        boolean resultado = false;
        for (int i = 0; i < nfilas - 3; i++) {
            for (int j = 0; j < ncolumnas; j++) {
                if (board.getToken(i,j).getToken().getRelleno() == token &&
                        board.getToken(i+1,j).getToken().getRelleno() == token &&
                        board.getToken(i+2,j).getToken().getRelleno() == token &&
                        board.getToken(i+3,j).getToken().getRelleno() == token) {
                    resultado = true;
                }
            }
        }
        return resultado;
    }

    /**
     * comprobacion diagonal
     * @param board tablero en el que se comprueba la diagonal
     * @param token caracter de la ficha que se comprueba
     */
    @Override
    public boolean comprobarDiagonal(char token, Board board) {
        boolean resultado = false;
        for (int i = 0; i < nfilas - 3; i++) {
            for (int j = 0; j < ncolumnas - 3; j++) {
                if (board.getToken(i,j).getToken().getRelleno() == token &&
                        board.getToken(i+1,j+1).getToken().getRelleno() == token &&
                        board.getToken(i+2,j+2).getToken().getRelleno() == token &&
                        board.getToken(i+3,j+3).getToken().getRelleno() == token) {
                    resultado = true;
                }
            }
        }
        for (int i = ncolumnas; i > 3; i--) {
            for (int j = 0; j < nfilas - 3; j++) {
                if (board.getToken(j,i-1).getToken().getRelleno() == token &&
                        board.getToken(j+1,i-2).getToken().getRelleno() == token &&
                        board.getToken(j+2,i-3).getToken().getRelleno() == token &&
                        board.getToken(j+3,i-4).getToken().getRelleno() == token) {
                    resultado = true;
                }
            }
        }
        return resultado;
    }
    /**
     * metodo que llama a la funcion comprobarTablero para saber si hay un ganador o no
     * @param board tablero en el que se comprueba
     * @param letra caracter de la ficha que se comprueba
     */
    public boolean hayGanador(char letra, Board board   ) {
        boolean hayganador;
        hayganador = comprobarTablero(letra, board  );
        return hayganador;
    }
    /**
     * metodo que llama a la funcion hayGanador para averiguar que jugador es el que tiene la victoria
     * @param board tablero en el que se comprueba
     * @param players jugadores entre los que puede estar el ganador de la partida
     */
    public Player Ganador(Player[] players, Board board) {
        Player ganador = null;
        if (hayGanador(players[0].getLetraToken(),board)) {
            ganador = players[0];
        } else if (hayGanador(players[1].getLetraToken(), board )) {
            ganador = players[1];
        }
        return ganador;

    }
    /**
     * metodo que llama a la funcion Ganador que devuelve el jugador ganador o el estado lleno del tablero
     * @param board tablero en el que se comprueba
     * @param players jugador ganador de la partida
     */
    public boolean finPartida(Player[] players, Board board) {
        return Ganador(players,board) != null || board.boardLleno();
    }


}
