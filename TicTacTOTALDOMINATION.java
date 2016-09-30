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
        String [] [] board = new String [3][3]; //makes the board
        boolean endGame = false; 
        int turnCount = 0; // counts turn
        boardInit(board); //fills board with blanks
        boardPrint(board); //shows empty board
        System.out.println("Welcome to tictactoe! Player one is X, player two is O. \r\n"+
            "To choose where to play, enter the row number, press enter, then enter the column number, and press enter");
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
            if (turnCount == 9){ //if the whole board is full, it's a tie, game over
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
                if (j == 2){
                    System.out.println();
                }
            }
        }

    }

    /**
     * goes through the move of one player, either one
     * @param board: the board being played on
     * @param player: the player taking the turn
     * @return void
     */
    public static void takeTurn(String[][] board, String player){
        String letter = "";
        if(player.equals("first")){
            letter = "X";
        }else{
            letter = "O";
        }
        String r1 = ""; //row entered
        String c1 = ""; // column entered

        int r1i = 0; //integer form of row entered
        int c1i = 0; //integer form of column entered

        boolean check = true;
        while(check == true){
            while(check == true){ // checks if row input is good
                Scanner input = new Scanner(System.in);
                System.out.println(player + "player's row:");
                r1 = input.next();
                if( !(r1.equals("1") || r1.equals("2") || r1.equals("3"))){
                    System.out.println("That input is no good! Try again.");
                }else{
                    check = false;
                }
            }
            check = true;
            while(check == true){ // checks if column input is good
                Scanner input = new Scanner(System.in);
                System.out.println(player + "player's column:");
                c1 = input.next();
                if( !(c1.equals("1") || c1.equals("2") || c1.equals("3"))){
                    System.out.println("That input is no good! Try again.");
                }else{
                    check = false;
                }

            }
            check = true;
            r1i = Integer.parseInt(r1);
            c1i = Integer.parseInt(c1);
            if(board[r1i-1][c1i-1] != "_"){ //checks if spot is already taken
                System.out.println("That spot is already taken! Try again");
            }else{
                check = false;
            }
        }
        board[r1i-1][c1i-1] = letter; //if the input is OK, it puts the correct character in that spot
    }

    /**
     * checks if a player has won
     * @param board: which board to check
     * @param player: player to see if one(always the one who just took their turn)
     * @ return boolean: if true, the game ends. if not, the next player goes.
     */
    public static boolean winCheck(String [][] board, String player){
        String letter = "";
        boolean win = false;
        if(player.equals("first")){
            letter = "X";
        }else{
            letter = "O";
        }
        for(int i = 0; i < board.length; i++){ //checks rows for win
            if(board[i][0].equals(letter) && board[i][1].equals(letter) && board[i][2].equals(letter)){
                win = true;
            }
        }
        for(int i = 0; i < board.length; i++){ //cehcks columns for win
            if(board[0][i].equals(letter) && board[1][i].equals(letter) && board[2][i].equals(letter)){
                win = true;
            }
        }
        if(board[0][0].equals(letter) && board[1][1].equals(letter) && board[2][2].equals(letter)){ // checks neagtive slope diagonal
            win = true;
        }else if(board[0][2].equals(letter) && board[1][1].equals(letter) && board[2][0].equals(letter)){ // checks positive slope diagonal
            win = true;
        }
        if(win == true){ //if one of the scenarios above is met, the game ends and the winner is announced
            System.out.println("The "+ player + " player wins");
            return true;
        }else{
            return false;	
        }
    }
}
