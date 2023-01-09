package Conecta4.Utilidades;

import Conecta4.TipoPlayers.Player;

public class Turno {
    private final Player[] players ;
    private static final int JUGADOR0 = 0;
    private int play;

    /**
     * Constructor de la clase
     */
    public Turno(Player[] players) {
        this.play = JUGADOR0;
        this.players = players;
    }

    /**
     * Metodo que indica el jugador que tiene turno
     */
    public Player tieneTurno() {
        return players[play];
    }

    /**
     * Metodo que devuelve la posicion del siguiente jugador .
     */
    private int calculaSiguienteJugador() {
        return (play + 1) % players.length;
    }
    /**
     * Metodo que devuelve la posicion del jugador anterior
     */
    public int calculaAnteriorJugador() {
        return (players.length + (play - 1)) % players.length;
    }


    /** Método que el cambia de turno al siguiente*/
    public void cambiaTurnoSiguiente() {
        play = calculaSiguienteJugador();
    }
    /** Método que el cambia de turno al anterior*/
    public void cambiarTurnoAnterior(){
        play = calculaAnteriorJugador();
    }

    /**
     * Metodo encargado de rotar los turnos
     */
    public void cambiaTurno() {
        play = calculaSiguienteJugador();
    }

    public Player cambiarTurno () {
        cambiaTurno();
        return tieneTurno();
    }

    /**
     * metodo que muestra de quien es el turno
     */
    public void QuienTieneTurno(){
        System.out.println("Turno de "+nombrePlayerTurno()+':');
    }

    /** Metodo que con un turno, devuelve el nombre*/
    public String nombrePlayerTurno() {
        return players[play].getNombre();
    }
}
