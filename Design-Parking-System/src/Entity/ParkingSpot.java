package Entity;

public class ParkingSpot {
    private final String spotId;
    private boolean free;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.free = true;
    }

    public boolean isSpotFree() {
        return free;
    }

    public void occupySpot() {
        if (!free) {
            throw new IllegalStateException(
                    "Parking spot " + spotId + " is already occupied"
            );
        }

        free = false;
    }

    public void releaseSpot() {
        if (free) {
            throw new IllegalStateException(
                    "Parking spot " + spotId + " is already free"
            );
        }

        free = true;
    }

    public String getSpotId() {
        return spotId;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId='" + spotId + '\'' +
                ", free=" + free +
                '}';
    }

}
