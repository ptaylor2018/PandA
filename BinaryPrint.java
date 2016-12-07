
/**
 * Write a description of class BinaryPrint here.
 * 
 * @author Patrick Taylor <taylor.patrick@charterschool.org>
 * @version 1.0
 */
public class BinaryPrint
{
    public static void main(String args[]){
        binaryPrint(35);
    }

    public static void binaryPrint(int num){

        int digit = num % 2;
        if (num != 0){ 
            binaryPrint(num / 2);

            System.out.print(digit);
        }
    }
}
