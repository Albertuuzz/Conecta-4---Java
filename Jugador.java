public class Jugador {

    
    int ID;
    char CHARACTER;
    int TURN;

    public Jugador(int ID){
        this.TURN = 0;
        this.ID = ID;

        
        if(ID==0){

            this.CHARACTER = 'X';

        }
        else if (ID==1){

            this.CHARACTER = 'O';

        }
        else if (ID==2){

            this.CHARACTER = '+';

        }
        else if (ID==3){

            this.CHARACTER = '-';
            
        }
    }
}
