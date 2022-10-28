public class Tablero{

    char [][] TABLE;
    
    
    
    public Tablero(int ROW, int COL){
        
        this.TABLE = new char[ROW][COL];

    }
    
    
    
    public Tablero(){

        this.TABLE = new char[7][6];

    }



    public int ColocarFicha(char CHAR, int COL){

        int i = this.TABLE.length-1;

       if (COL > -1 && COL < (this.TABLE[0].length) ){

            while(i > -1 && TABLE[i][COL] != '\0' ){ 
                
                i--;

            };

            if(i != -1){

                this.TABLE[i][COL] = CHAR;
                System.out.println("Ficha Insertada en la columna " + COL + "\n");
                PrintTablero();
                return 0;
            }

           
            if(i == -1){

                System.out.println("Columna " + COL + " Llena, Introduce otra columna" + "\n");
                PrintTablero();
                return -1;
            }
       } 
       
       else if(COL <= -1){

        System.out.println("No Acepta valores negativos de columna" + "\n");

       }
       
       else if(COL >= (this.TABLE[0].length)){

        System.out.println("Columna " + COL + " No es valida, Introduce otra columna" + "\n");

       }
        return -1; 
    }




    
    public void PrintTablero()
    {
        System.out.println("---------------");

     
        for(int i = 0 ; i < this.TABLE.length ; i++)
        {
            for(int j = 0 ; j < this.TABLE[0].length ; j++)
            {
                if(this.TABLE[i][j] != '\0')
                {
                    System.out.print("|" + this.TABLE[i][j]);
                }
                else
                {
                    System.out.print("|" + "~");
                }                
            }
            System.out.print("|" + "\n");

        }
        System.out.println("---------------" + "\n");
    }



    public int getRows()
    {
        return this.TABLE.length;
    }



    public int getCols()
    {
        return this.TABLE[0].length;
    }


}
