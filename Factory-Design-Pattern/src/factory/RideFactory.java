package factory;

import ride.AutoRide;
import ride.BikeRide;
import ride.CarRide;
import ride.Ride;

public class RideFactory {
    public static Ride createRide(String rideType){
        if(rideType==null || rideType.isBlank()){
            throw new IllegalArgumentException("Ride type cannot be empty");
        }

        return switch (rideType.toUpperCase()){
            case "BIKE" -> new BikeRide();

            case "AUTO" -> new AutoRide();

            case "CAR" -> new CarRide();

            default -> throw new IllegalArgumentException(
                    "Unsupported ride type: " + rideType
            );
        };
    }
}
