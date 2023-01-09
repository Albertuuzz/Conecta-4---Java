package Conecta4.Modos;

import Conecta4.*;
import Conecta4.ComprobanteReglas.ComprobanteJuego;
import Conecta4.TipoPlayers.Player;
import Conecta4.UndoRedo.CCambiarTurno;
import Conecta4.UndoRedo.Gestor;
import Conecta4.Utilidades.Board;
import Conecta4.Utilidades.Turno;

import java.util.Scanner;

public class MBasico implements Modo {
    private final Turno turno;
    private final Player[] players;
    private final Board board;
    private final Console console;
    private final ComprobanteJuego comprobanteJuego;
    private Player play;

    /**
     * Constructor de la clase
     * @param players jugadores que participan en el juego
     * @param board tablero utilizado
     * @param console consola utilizada para mejorar la visualización de las funcionalidades
     * @param comprobanteJuego clase utilizada para comprobar las reglas del Conecta4
     */
    public MBasico(Player[] players, Board board, Console console, ComprobanteJuego comprobanteJuego) {
        this.turno = new Turno(players);
        this.players = players;
        this.board = board;
        this.console = console;
        this.comprobanteJuego = comprobanteJuego;

    }

    /**
     * Metodo utilizado para jugar en el modo basico del Conecta4
     */
    @Override
    public void play() {
        Player play = turno.tieneTurno();
        boolean fin;
        Gestor gestor = Gestor.getInstance();
        Gestor gestorTurno = Gestor.getInstance();
        do {
            board.print();
            turno.QuienTieneTurno();
            play.put(gestor);
            board.print();
            undoRedo(gestor,gestorTurno);
            gestorTurno.execute(new CCambiarTurno(turno));
            play = turno.tieneTurno();
            fin = comprobanteJuego.finPartida(players, board);
        } while (!fin);
        board.print();
        console.mostrarResultadoPartida(comprobanteJuego.Ganador(players,board));
        System.out.println("Partida finalizada!");
        board.inicializarBoard();

    }
    private void undoRedo (Gestor gestor, Gestor gestorTurno){
        if (!gestor.isVacia()){
            String opcion;
            do {
                Scanner teclado = new Scanner(System.in);
                System.out.println("¿UNDO/REDO?");
                System.out.println("1. UNDO");
                System.out.println("2. REDO");
                System.out.println("3. SEGUIR");
                opcion = teclado.next();
                while(!opcion.equals("1") && !opcion.equals( "2") && !opcion.equals("3") ){

                    System.out.println("Error, escriba una opción válida: ");
                    opcion = teclado.nextLine();

                }
                if (opcion.equals("1")) {
                    if (gestor.getPilaundo().isVacia()){ System.out.println("No se puede ejecutar UNDO"); }
                    else {
                        gestor.undo();
                        board.print();
                        play = turno.tieneTurno();
                        String col;
                        Scanner sc = new Scanner(System.in);
                        System.out.println("En que columna deseas colocar la ficha: ");
                        play.put(gestor);
                        gestor.vaciarRedo();
                        board.print();
                    }
                } else if (opcion.equals("2")) {
                    if (gestor.getPilaredo().isVacia()) System.out.println("No se puede ejecutar REDO");
                    else {
                        gestor.redo();
                        gestorTurno.redo();
                        board.print();
                        play = turno.tieneTurno();
                    }
                }
            }
            while (opcion.equals("1") || opcion.equals("2"));
        }
    }
}
