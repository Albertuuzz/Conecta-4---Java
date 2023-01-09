package Conecta4.Modos;

import Conecta4.*;
import Conecta4.ComprobanteReglas.ComprobanteJuego;
import Conecta4.TipoPlayers.Player;
import Conecta4.TipoPlayers.PlayerIA;
import Conecta4.UndoRedo.CCambiarTurno;
import Conecta4.UndoRedo.Gestor;
import Conecta4.Utilidades.Board;
import Conecta4.Utilidades.Turno;

import java.util.Scanner;

import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;

public class MDemo implements Modo {
    private final Turno turno;
    private final Player[] players;
    private final Board board;
    Console console;
    ComprobanteJuego comprobanteJuego;
    private Player play;
    /**
     * Constructor de la clase
     * @param board tablero utilizado
     * @param console consola utilizada para mejorar la visualización de las funcionalidades
     * @param comprobanteJuego clase utilizada para comprobar las reglas del Conecta4
     */
    public MDemo(Board board, Console console, ComprobanteJuego comprobanteJuego) {
        this.players = new Player[2];
        this.board = board;
        this.console = console;
        this.comprobanteJuego = comprobanteJuego;
        players[0] = new PlayerIA("IA1", 'Y', YELLOW );
        players[1] = new PlayerIA("IA2", 'R', RED );
        players[0].setBoard(board);
        players[1].setBoard(board);
        this.turno = new Turno(players);
    }
    /**
     * Metodo utilizado para jugar en el modo basico del Conecta4
     */
    @Override
    public void play() {
        Player play = players[0];
        boolean fin;
        Gestor gestor = Gestor.getInstance();
        Gestor gestorTurno = Gestor.getInstance();
        do {
            board.print();
            turno.QuienTieneTurno();
            play.put(gestor);
            gestorTurno.execute(new CCambiarTurno(turno));
            play = turno.tieneTurno();
            fin = comprobanteJuego.finPartida(players, board);
        } while (!fin);
        board.print();
        console.mostrarResultadoPartida(comprobanteJuego.Ganador(players,board));
        System.out.println("Partida finalizada!");
        board.inicializarBoard();
    }
}
