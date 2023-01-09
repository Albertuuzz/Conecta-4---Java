package Conecta4.Utilidades;

public class Casilla {
    private Token token;
    private int fila;
    private int columna;
    public Casilla(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
    }
    public Token getToken() {
        if (token != null)
            return token;
        else return new Token();
    }

    /**
     * getters y setters de la clase Casilla
     */
    public void setToken(Token token) {
        this.token = token;
    }
    public int getColumna() { return columna; }
    public int getFila() { return fila; }
    public boolean isVacia() {
        return token == null;
    }

    /**
     * Metodo que crea una casilla vacia
     * @return tres espacios en blanco
     */
    public String print() {
        if (isVacia()) {
            return "   ";
        } else {
            return token.print();
        }
    }
}
