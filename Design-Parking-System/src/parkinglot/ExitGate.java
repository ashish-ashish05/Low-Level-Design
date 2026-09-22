package parkinglot;

public class ExitGate {

    private final ParkingLot parkingLot;

    public ExitGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void exit(String ticketId) {

        parkingLot.exit(ticketId);
    }
}