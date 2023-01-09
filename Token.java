package Conecta4.Utilidades;

import java.awt.*;

public class Token {
    private char relleno;
    private Color color;
    public Token (char caracter, Color color) {
        this.relleno = caracter;
        this.color = color;
    }
    public Token(){

    }
    public char getRelleno() {
        return relleno;
    }
    public String print () {
        return " " + relleno + " ";
    }
}
