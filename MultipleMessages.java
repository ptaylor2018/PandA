
public class MultipleMessages
{
    public static void main(String args[]){
        for(int x = 50; x>0; x--){
            System.out.print(x+ ": ");
            if(x%6==0 && x%5==0){
                System.out.println("You're a multiple of 30!");
            }
            else if(x%5==0){
                System.out.println("You're a multiple of 5!");
            }
            else if(x%6==0){
                System.out.println("You're a multiple of 6!");
            }
            else{
                System.out.println("No one cares");
            }
        }

    }
}
