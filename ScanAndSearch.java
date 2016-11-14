
/**
 * Scan into array! (assuming file of
 * words in order seperated by newlines)
 * 1. Count number of lines in file
 * 2. Make the array
 * 3. Actually put the stuff in the array
 * 4. binary serach for a term in the array that the user enters
 * 5. return the index if present, tell you if it is not
 * @author Patrick Taylor <taylor.patrick@charterschool.org>
 * @version v1.0
 */

import java.io.*;
import java.util.Scanner;

public class ScanAndSearch
{
    public static void main(String [] args) {
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("words.txt")));
            int size = 0;
            while(scan.hasNext()) {
                size++;
                scan.next();
            }
            String[] words = new String [size];
            scan.close();
            scan = new Scanner(new BufferedReader(new FileReader("words.txt")));
            int count = 0;
            while(scan.hasNext()) {
                words[count] = scan.next();
                count++;
            }

            Scanner scan2 = new Scanner(System.in); 
            System.out.println("Type what you want to find");
            String myWord = scan2.next();
            boolean notDone = true;
            int searchHere = count/2;
            int max = words.length;
            int min = 0;
            int preser = -1;
            while(notDone){
                searchHere = min + (max  - min)/2; //does the search
                if (myWord.compareToIgnoreCase(words[searchHere]) < 0) {
                    max = searchHere;
                }else if(myWord.compareToIgnoreCase(words[searchHere]) > 0){
                    min = searchHere;
                } else if(myWord.compareToIgnoreCase(words[searchHere]) == 0){
                    notDone = false;
                    System.out.println("Your search term is at index " + searchHere);
                }
                if(searchHere == preser){
                    notDone = false;
                    System.out.println("Your serach term is not in the array");
                }
                preser = searchHere;
            }
        } catch (Exception e) {
            System.out.println("WAT: " + e.getMessage());
        }

    }
}