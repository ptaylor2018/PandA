import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class ConnectFourStar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConnectFourStar
{
    public static void main(String args []){
        String [][] board = new String [6][7];
        boolean endGame = false; 
        int turnCount = 0; // counts turn
        boardInit(board); //fills board with blanks
        boardPrint(board); //shows empty board
System.out.println("Welcome to CONNECT FOUR! Player one is X, player two is O. \r\n"+
            "To choose where to play, eenter the column number, and press enter");
        
        while(endGame == false){
            if(turnCount%2 == 0){ // determines which player is going
                takeTurn(board, "first");
                boardPrint(board);
                endGame = winCheck(board, "first");
            }else{
                takeTurn(board, "second");
                boardPrint(board);
                endGame = winCheck(board, "second");
            }
            turnCount++;
            if (turnCount == 42){ //if the whole board is full, it's a tie, game over
                System.out.println("it's a tie! game over!");
                endGame = true;
            }
        }
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
     * @param board: the board to be printed
     * @return void
     */
    public static void boardPrint(String[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] +" ");
                if (j == 6){
                    System.out.println();
                }
            }
        }

    }

    public static void takeTurn(String[][] board, String player){
        String letter = "";
        if(player.equals("first")){
            letter = "X";
        }else{
            letter = "O";
        }
        int column = -1; 
        boolean check = true;
        while(check == true){

            Scanner input = new Scanner(System.in);
            System.out.println(player + " player's column:");
            column = input.nextInt();

            if(colFill(board, column) == 6){
                System.out.println("That column is full! Try again.");
            } else{
                check = false;
            }

        }
        board[5 - colFill(board, column)][column-1] = letter;
    }

    public static int colFill(String[][] board, int columnNumber){
        int counter = 0;
        for( int i = 0; i < 6; i++){
            if (board[5-i][columnNumber].equals("O") || board[5-i][columnNumber].equals("X")){
                counter++;
            }
        }
        return counter;
    }

    public static boolean winCheck(String [][] board, String player){
        String letter = "";
        boolean win = false;
        if(player.equals("first")){
            letter = "X";
        }else{
            letter = "O";
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < 4; j++){
                if(board[i][j].equals(letter) && board[i][j+1].equals(letter) && board[i][j+2].equals(letter) && board[i][j+3].equals(letter)){
                    win = true;
                    
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].equals(letter) && board[i+1][j].equals(letter) && board[i+2][j].equals(letter) && board[i+3][j].equals(letter)){
                    win = true;
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                if(board[i][j].equals(letter) && board[i+1][j+1].equals(letter) && board[i+2][j+2].equals(letter) && board[i+3][j+3].equals(letter)){
                    win = true;
                }
            }
        }
        return win;
    }

}
