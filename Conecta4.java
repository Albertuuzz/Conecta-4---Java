import java.util.Scanner;

public class Conecta4{

    
    Tablero TABLE;
    Jugador[] PLAYERS;
    int MAXTURNS;
    int TURNO = 0;
    Boolean END = false;
    int WINNER;
    int CONTADOR_TURNO = 1;


    Scanner SC = new Scanner(System.in);


    
    
    public Conecta4(int NUMPLAYERS, int ROW, int COL){
    
    this.TABLE = new Tablero(ROW,COL); 
    MAXTURNS = ROW*COL; 

    this.PLAYERS = new Jugador[NUMPLAYERS];

        
    for (int i = 0 ; i < PLAYERS.length ; i++){

        PLAYERS[i] = new Jugador(i);
        
        }
        
       

        for(int i = 0 ; i < MAXTURNS ; i++){

            CONTADOR_TURNO = CONTADOR_TURNO % 2; //Esto es porque si contador_turno = 1 entonces 1 % 2 es 1. Turno del J1. Una vez ha pasado su turno entonces
                                                     //contador_turno = 2 entonces 2 % 2 = 0. Turno del J2

            Turno(this.PLAYERS[CONTADOR_TURNO], COL);
            CONTADOR_TURNO++;
            this.TURNO++;
                
            //Si el turno es mayor al numero de jugadores entonces vuelves al turno del J0 (Por si da error)
            if(this.TURNO > this.PLAYERS.length-1){

                this.TURNO = 0;

            }
                   
            }

            System.out.println("Tablero lleno");

           
               

    }
    

 //Si volvemos a la clase tablero y al metodo colocar ficha, tenemos que devuelve un -1. Si la ficha ha sido insertada correctamente devuelve un 0 y entonces saldríamos
//del bucle while. Esto es para que si el usuario no puede colocar la ficha en una posición, le vuelva a ofrecer colocarla en otra posición.
    
    private void Turno(Jugador PLAYER, int COL){
        int i = -1;
       
        while(i != 0){

            System.out.println("Turno del Jugador " + (PLAYER.ID+1) + "\n");

            System.out.println("Introduzca una columna (0-" + (this.TABLE.getCols()-1) + ")");
            i = SC.nextInt();


            i = this.TABLE.ColocarFicha(PLAYER.CHARACTER,i);
        }

    }
    


}


