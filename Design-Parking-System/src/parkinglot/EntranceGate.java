package parkinglot;

import Entity.ParkingSpot;
import Entity.Vehicle;
import enums.VehicleType;

public class EntranceGate {

    private final ParkingLot parkingLot;

    public EntranceGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpot findParkingSpot(
            Vehicle vehicle) {

        VehicleType type =
                vehicle.getVehicleType();

        return parkingLot.findParkingSpot(type);
    }
}