package parkinglot;

import Entity.ParkingSpot;
import enums.VehicleType;

import java.util.List;

public class ParkingBuilding {

    private final List<ParkingLevel> levels;

    public ParkingBuilding(List<ParkingLevel> levels) {
        this.levels = levels;
    }

    public ParkingSpot park(VehicleType type) {

        for (ParkingLevel level : levels) {

            if (!level.hasAvailability()) {
                continue;
            }

            ParkingSpot spot = tryPark(level, type);

            if (spot != null) {
                return spot;
            }
        }

        throw new IllegalStateException(
                "No parking spot available"
        );
    }

    private ParkingSpot tryPark(
            ParkingLevel level,
            VehicleType type) {

        try {
            return level.park(type);
        } catch (IllegalStateException e) {
            return null;
        }
    }

    public void unPark(
            int levelNumber,
            VehicleType type,
            ParkingSpot spot) {

        ParkingLevel level =
                levels.get(levelNumber - 1);

        level.unPark(type, spot);
    }

    public List<ParkingLevel> getLevels() {
        return levels;
    }
}