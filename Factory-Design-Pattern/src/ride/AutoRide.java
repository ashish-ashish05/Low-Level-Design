package ride;

public class Auto implements Ride{

    @Override
    public void book() {
        System.out.println("Auto ride booked successfully");
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 12;
    }
}
