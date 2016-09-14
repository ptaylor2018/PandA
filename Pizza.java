
public class Pizza
{
    public static void main(String args[]){
        double smallPizza = circleArea(9);
        double largePizza = circleArea(12);
        if(2* smallPizza > largePizza){
            System.out.println("Get the 18 inch pizzas!");

        }else if (2*smallPizza < largePizza){
            System.out.println("Get the 24 inch pizza!");
        }else{
            System.out.println("Get the cheaper deal!");
        }
    }

    public static double circleArea(double r) {
        return Math.PI * r * r;
    }
}
