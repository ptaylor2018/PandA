import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class TheSelectFew here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheSelectFew
{
    public static void main(String args[]){
        try{
            Scanner scan = new Scanner(new BufferedReader(new FileReader("sortMe.txt")));
            int size = 0;
            while(scan.hasNext()) {
                size++;
                scan.next();
            }
            ArrayList words = new ArrayList();
            scan.close();
            scan = new Scanner(new BufferedReader(new FileReader("sortMe.txt")));
            int count = 0;
            while(scan.hasNext()) {
                words[count] = scan.next();
                count++;
            }
            String[] newWords = new String[size];

            for(int i = 0; i < size; i++){
                newWords[i] = getMinValue(words);
                words[i] = null;
            }
            /*for(int i = 0; i< size; i++){
            int checks = 0;
            for(int j = 1; j < size; j++){
            if(words[i].compareToIgnoreCase(words[j]) > 0){
            checks++;
            }
            }
            if(checks == size){
            newWords[i] = words[i];
            }
            }*/
            for(int k = 0; k < words.length -1 ; k++){
                System.out.println(newWords[k]);
            }

        }
        catch(Exception e) {
            System.out.println("WAT: " + e.getMessage());
        }
    }

    public static String getMinValue(String[] words){
        String minValue = words[0];
        for(int j = 0; j < words.length; j++){
            if (words[j].compareToIgnoreCase(minValue) < 0){
                minValue = words[j];
            }
        }
        System.out.println(minValue);
        return minValue;
    }
}

