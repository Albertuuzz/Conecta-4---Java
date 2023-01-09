package Conecta4;

import Conecta4.ComprobanteReglas.ComprobanteJuego;
import Conecta4.Modos.MBasico;
import Conecta4.Modos.MDemo;
import Conecta4.Modos.MEntrenamiento;
import Conecta4.Modos.Modo;
import Conecta4.TipoPlayers.Player;
import Conecta4.TipoPlayers.PlayerH;
import Conecta4.Utilidades.Board;

import java.util.logging.Logger;

import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;

public class Partida {
    private final Player[] players;
    private final Board board;
    private final Console console;
    private final Menu menu;

    private final ComprobanteJuego comprobanteJuego;

    /**
     * Metodo constructor de la clase que necesita la lista de los dos jugadores
     * que van a jugar.
     */

    public Partida(Player[] players) {
        this.players = players;
        int nfilas = 6;
        int ncolumnas = 7;
        this.board = new Board(nfilas, ncolumnas);
        this.console = new Console();
        this.comprobanteJuego = new ComprobanteJuego(nfilas, ncolumnas);
        this.menu = new Menu();
        actualizaTableroEnJugadores();
    }



    /**
     * Metodo para actualizar el tablero en los dos jugadores que participan.
     * Tras esta actualizacion, ambos jugadores pueden comenzar a colocar fichas
     * en el tablero.
     */
    private void actualizaTableroEnJugadores () {
        int NJUG = 2;
        int iBucle = 0;
        for (int indice = iBucle; indice < NJUG; indice++) {
            players[indice].setBoard(board);
        }
    }


    public void opciones(){
        Modo modo;
        int valor;

        do {
            valor = menu.menu();
            switch (valor) {
                case 1:
                    modo = new MBasico(players,board, console, comprobanteJuego);
                    modo.play();
                    break;
                case 2:
                    modo = new MEntrenamiento(board, console, comprobanteJuego);
                    modo.play();
                    break;
                case 3:
                    modo = new MDemo(board, console, comprobanteJuego);
                    modo.play();
                    break;
                default:
                    break;
            }
        }
        while (valor != 0);

    }

    public static void main( String[] args ) {
        Player jugador1 = new PlayerH("ROJO", 'R',  RED);
        Player jugador2 = new PlayerH("AMARILLO", 'Y', YELLOW);
        Player[] jugadores = {jugador1, jugador2};
        Partida partida  = new Partida(jugadores);
        partida.console.dibujar(jugadores);
        partida.opciones();
    }

}