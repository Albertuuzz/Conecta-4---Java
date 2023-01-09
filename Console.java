package Conecta4;

import Conecta4.TipoPlayers.Player;

public class Console {
    /**
     * Método que saca por pantalla los jugadores participantes
     */
    public void dibujar (Player[] players) {
        System.out.println ("CONECTA 4");
        System.out.println("El jugador 1 es: " + players[0].getNombre());
        System.out.println("El jugador 2 es: " + players[1].getNombre());
    }
    public void mostrarResultadoPartida (Player ganador) {
        if (ganador!=null) {
            System.out.println("HA GANADO " +  ganador.getNombre());
        } else {
            System.out.println("¡Empate!");
        }
    }
}
