package Conecta4.Utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {
    private final Casilla[][] casillas;
    private final int nfilas;
    private final int ncolumnas;
    private final int init = 0;
    private final String SEPARADORC = "|";

    /**
     * Constructor del tablero basado en el número de filas y de columnas.
     * El tablero inicializado todas las casillas vacías.
     */
    public Board(int nfilas, int ncolumnas) {
        this.nfilas = nfilas;
        this.ncolumnas = ncolumnas;
        this.casillas = new Casilla[this.nfilas][this.ncolumnas];
        inicializarBoard();
    }


    /**
     * Método que inicializa un tablero vacío. Crea tantas casillas vacías como necesite el tablero.
     */
    public void inicializarBoard() {
        int fila;
        int columna;
        for (fila = init; fila < this.nfilas; fila++) {
            for (columna = init; columna < this.ncolumnas; columna++) {
                casillas[fila][columna] = new Casilla(fila,columna);
            }
        }
    }

    /**
     * Metodo que dibuja un tablero.
     * Cada fila está separada por el carácter "_" y cada columna está separada por el caracter "|"
     */
    public void print() {
        int fila;
        int columna;
        this.dibujaCabecera();
        this.dibujaBordeSuperior();
        for (fila = init; fila < this.nfilas; fila++) {
            for (columna = init; columna < this.ncolumnas; columna++) {
                dibujaContenidoCasilla(casillas[fila][columna].print());
            }
            dibujarFilaFinal();
        }
        this.dibujaBordeInferior();
    }

    /**
     * Metodo que escribe el texto que aparece justo encima del tablero
     */
    private void dibujaCabecera() {
        String TEXTOCABECERA = "Estado del Tablero";
        System.out.println(TEXTOCABECERA);
    }

    /**
     * Metodo que dibuja la linea superior del tablero
     */
    private void dibujaBordeSuperior() {
        int indice;
        char SEPARADORSUPERIOR = '_';
        for (indice = init; indice < this.ncolumnas * 4; indice++) {
            System.out.print(SEPARADORSUPERIOR);
        }
        System.out.println(SEPARADORSUPERIOR);
    }

    /**
     * Metodo que dibuja la linea inferior del tablero
     */
    private void dibujaBordeInferior() {
        int indice;
        char SEPARADORINFERIOR = '-';
        for (indice = init; indice < this.ncolumnas * 4; indice++) {
            System.out.print(SEPARADORINFERIOR);
        }
        System.out.println(SEPARADORINFERIOR);
    }

    /**
     * Metodo que encapsula la lógica de mostrar el final de una fila.
     * Las filas terminan con el carácter pipe "|" representado por SEPARADORCOLUMNA
     */
    private void dibujarFilaFinal() {
        System.out.println(this.SEPARADORC);
    }

    /**
     * Metodo que encapsula la lógica de mostrar el contenido de una casilla.
     * Las casillas se separan con el carácter pipe "|" representado por SEPARADORCOLUMNA
     */
    private void dibujaContenidoCasilla(String contenido) {
        System.out.print(this.SEPARADORC +"\u001B[34m" + contenido+ "\u001B[0m");
    }

    /**
     * Metodo que comprueba si una casilla del tablero tiene o no tiene asignada una ficha.
     */
    public boolean estaLibre(int fila, int columna) {
        return !casillas[fila][columna - 1].isVacia();
    }

    /**
     * Metodo que pone una ficha en una determinada posición del tablero.
     * @param fila fila donde se quiere poner la ficha
     * @param columna columna donde se quiere poner la ficha
     * @param token tipo de ficha que se quiere colocar
     */
    public void ponerToken(int fila, int columna, Token token) {
            casillas[fila][columna - 1].setToken(token);
    }

    /**
     * Metodo que quita una ficha en una determinada posición del tablero.
     * @param fila fila donde se quiere quitar la ficha
     * @param columna columna donde se quiere quitar la ficha
     * @param token tipo de ficha que se quiere borrar
     */
    public void quitarToken(int fila, int columna, Token token) {
        casillas[fila][columna - 1].setToken(null);
    }
    /**
     * Metodo que comprueba si una columna está llena o no.
     * @param columna columna que se comprueba si esta ocupada
     */
    public int filaLibre(int columna) {
        int i = this.nfilas - 1;
        boolean libre = false;
        while (i >= 0 && !libre) {
            if (!casillas[i][columna - 1].isVacia())
                i--;
            else libre = true;
        }
        return i;
    }

    /**
     * Metodo que pide la columna en la que se quiere insertar
     * @param jugador tipo de jugador del que se va a colocar la ficha
     */
    public int pedirColumna(String jugador) {
        return elegirPosicion(this.init + 1, this.ncolumnas, jugador);
    }

    /**
     * Método para leer un valor correcto dentro de un rango.
     * Se pide por teclado un valor numerico entre los limites inferior y superior.
     * En el caso de que el valor no sea correcto se repite la petición del valor hasta que esté en el rango pedido.
     * @param jugador tipo de jugador que elige la posición de su ficha
     * @param inferior numero minimo posible de columna
     * @param superior numero maximo posible de columna
     */
    private int elegirPosicion(int inferior, int superior, String jugador) {
        Scanner in = new Scanner(System.in);
        int valor = -1;
        boolean correcto = false;
        do {
            System.out.println("Jugador " + jugador + ", dame un valor " + "para la columna" + " entre " + inferior + " y " + superior + ": ");
            try {
                valor = in.nextInt();
                if (!limites(valor, inferior, superior)) {
                    System.out.println("Jugador " + jugador + ", valor no válido; tiene que estar en el rango [" +
                            inferior + ".." + superior + "]");
                } else {
                    correcto = true;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Jugador " + jugador + ", valor no válido, se pide un valor entero");
                in.next();
            }
        } while (!correcto);
        return valor;
    }

    /**
     * Metodo que comprueba si el valor leído por teclado está dentro de un rango.
     * @param valor numero insertado por el jugador
     * @param inferior numero minimo posible de columna
     * @param superior numero maximo posible de columna
     */
    private boolean limites(int valor, int inferior, int superior) {
        return valor >= inferior && valor <= superior;
    }

    /**
     * Metodo que comprueba si se han rellenado todas las casillas con fichas.
     */
    public boolean boardLleno() {
        boolean lleno = true;
        int fila = init;
        int columna;
        do {
            columna = init;
            do {
                lleno = !casillas[fila][columna].isVacia();
                columna++;
            } while ((lleno) && columna < this.ncolumnas);
            fila++;
        } while ((lleno) && (fila < this.nfilas));
        return lleno;
    }

    public Casilla getToken (int fila, int columna){
        return casillas[fila][columna];
    }

    public int getncolumnas() {
        return ncolumnas;
    }
}
