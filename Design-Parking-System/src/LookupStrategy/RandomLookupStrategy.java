package LookupStrategy;

import Entity.ParkingSpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLookupStrategy
        implements ParkingSpotLookupStrategy {

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> spots) {

        List<ParkingSpot> freeSpots = new ArrayList<>();

        for (ParkingSpot spot : spots) {
            if (spot.isSpotFree()) {
                freeSpots.add(spot);
            }
        }

        if (freeSpots.isEmpty()) {
            return null;
        }

        Collections.shuffle(freeSpots);

        return freeSpots.get(0);
    }
}