import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class InsertionNotAssertion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InsertionNotAssertion
{ 
    public static void main(String args[]){
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("sortMe.txt")));
            int size = 0;
            while(scan.hasNext()) {
                size++;
                scan.next();
            }
            String[] words = new String[size];
            scan.close();
            scan = new Scanner(new BufferedReader(new FileReader("sortMe.txt")));
            int count = 0;
            while(scan.hasNext()) {
                words[count] = scan.next();
                count++;
            }
            //String[] newWords = new String[size];
            //newWords[0] = words[0];
            for(int j = 0; j < words.length -1 ; j++){
                for(int i = 0; i < words.length -1 ; i++){
                    if(words[i].compareToIgnoreCase(words[i+1]) > 0){
                        String inAir = words[i];
                        words[i] = words[i+1];
                        words[i+1] = inAir;
                    }
                }
                
            }
            for(int k = 0; k < words.length -1 ; k++){
            System.out.println(words[k]);
        }
        }catch (Exception e) {
            System.out.println("WAT: " + e.getMessage());
        }

    }
}

