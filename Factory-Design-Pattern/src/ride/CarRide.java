package ride;

public class CarRide implements Ride {

    @Override
    public void book() {
        System.out.println("Car ride booked successfully");
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 15;
    }
}
