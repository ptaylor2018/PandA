import java.io.*;
import java.util.Scanner;
/**
 * Player connect four!
 * 
 * @author Patrick Taylor <taylor.patrick@charterschool.org>
 * @version 1.0
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
            "To choose where to play, enter the column number, and press enter");

        while(endGame == false){
            if(turnCount % 2 == 0){ // determines which player is going
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
     * @param board: board to be initialized
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
                System.out.print(board[i][j] + " ");
                if (j == 6){
                    System.out.println();
                }
            }
        }

    }

    /** 
     * scans player input, sees if place is in a valid column, if so, puts chip in that column
     * @param board: the board being played on 
     * @param player: the player whose turn is being took
     * @return void
     */
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

            if(colFill(board, column - 1) == 6){
                System.out.println("That column is full! Try again.");
            } else{
                check = false;
            }

        }
        board[5 - colFill(board, column - 1)][column - 1] = letter;
    }

    /**
     * sees how many spots in  a column are filled
     * @param board: board being played on
     * @param columnNumber: column that is being checked
     * @return int: number of spots taken in a column
     */
    public static int colFill(String[][] board, int columnNumber){
        int counter = 0;
        for( int i = 0; i < 6; i++){
            if (board[5 - i][columnNumber].equals("O") || board[5 - i][columnNumber].equals("X")){
                counter++;
            }
        }
        return counter;
    }

    /**
     * sees if a player has won
     * @param board: board being checked
     * @param player: player being checked for win
     * @return boolean: if a player has won, = true
     */
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
                if(board[i][j].equals(letter) && board[i][j + 1].equals(letter) && board[i][j + 2].equals(letter) && board[i][j + 3].equals(letter)){
                    win = true;

                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].equals(letter) && board[i + 1][j].equals(letter) && board[i + 2][j].equals(letter) && board[i + 3][j].equals(letter)){
                    win = true;
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                if(board[i][j].equals(letter) && board[i + 1][j + 1].equals(letter) && board[i + 2][j + 2].equals(letter) && board[i + 3][j + 3].equals(letter)){
                    win = true;
                }
            }
        }
        if(win == true){
            System.out.println(player + " player wins!");
        }
        return win;
    }

}
