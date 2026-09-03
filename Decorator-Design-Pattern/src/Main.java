import beverage.*;
import decorator.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Order 1
        Beverage coffee = new Expresso();

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        coffee = new CaramelDecorator(coffee);

        System.out.println("Order 1");
        System.out.println("Item: " + coffee.getDescription());
        System.out.println("Total: Rs." + coffee.getCost());


        // Order 2
        Beverage coffee2 = new Cappuccino();

        coffee2 = new MilkDecorator(coffee2);
        coffee2 = new ChocolateDecorator(coffee2);
        coffee2 = new WhippedCreamDecorator(coffee2);

        System.out.println("\nOrder 2");
        System.out.println("Item: " + coffee2.getDescription());
        System.out.println("Total: Rs." + coffee2.getCost());
    }
}