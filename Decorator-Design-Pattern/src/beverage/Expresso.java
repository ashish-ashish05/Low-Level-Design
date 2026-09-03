package beverage;

public class Expresso implements Beverage {
    @Override
    public String getDescription() {
        return "Expresso";
    }

    @Override
    public double getCost() {
        return 120;
    }
}
