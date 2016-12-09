
/**
 * Make some factorials, yo.
 * 
 * @author Patrick Taylor <taylor.patrick@charterschool.org> 
 * @version 1.0
 */
public class Factorialio
{
    public static void main(String [] args){
        System.out.println(factorial(6));
    }

    public static int factorial(int input){
        int output;
        if(input == 1){
            output = 1;
        } else{
            output = factorial(input-1)*input;
        }
        return output;
    }
}
