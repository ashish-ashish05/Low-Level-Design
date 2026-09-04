import factory.RideFactory;
import ride.Ride;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ride ride = RideFactory.createRide("Car");

        ride.book();

        double distance = 10;

        double fare = ride.calculateFare(distance);

        System.out.println(
                "Distance: " + distance + " km"
        );

        System.out.println(
                "Estimated Fare: Rs." + fare
        );
    }
}