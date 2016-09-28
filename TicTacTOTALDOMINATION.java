import java.io.*;
import java.util.Scanner;
/**
 * The game of tictactoe
 * 
 * @author Patrick Taylor <taylor.patrick@charterschool.org>
 * 
 */
public class TicTacTOTALDOMINATION
{
    public static void main(String args []){
        String [] [] board = new String [3][3];
        boardInit(board);
        boardPrint(board);
        System.out.println("Welcome to tictactoe! Player one is X, player two is O. \r\n"+
            "To choose where to play, enter the row number, press enter, then enter the column number, and press enter");
        takeTurn();
    }
    /**
     * Fills board with blank spots
     * @param board to be initialized
     * @return void
     */
    public static void boardInit(String[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = "_";
            }
        }
    }

    /**
     * prints out the current state of the board
     * @param the board to be printed
     * @return void
     */
    public static void boardPrint(String[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] +" ");
                if (j == 2){
                    System.out.println();
                }
            }
        }

    }

    public static void takeTurn(){
        boolean yurOK = true;
        while(yurOK == true){
            Scanner input = new Scanner(System.in);
            System.out.println("First Player's Row:");
            String p1r = input.next();
            if( !(p1r.equals("1") || p1r.equals("2") || p1r.equals("3"))){
                System.out.println("That input is no good! Try again.");
            }else{
                yurOK = false;
            }
        }
        yurOK = true;
        while(yurOK == true){
            Scanner input = new Scanner(System.in);
            System.out.println("First Player's Column:");
            String p1c = input.next();
            if( !(p1c.equals("1") || p1c.equals("2") || p1c.equals("3"))){
                System.out.println("That input is no good! Try again.");
            }else{
                yurOK = false;
            }
        
        }
    }
}
