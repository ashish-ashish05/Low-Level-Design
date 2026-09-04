package ride;

public class BikeRide implements Ride{

    @Override
    public void book() {
        System.out.println("Bike ride booked successfully");
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 8;
    }
}
