package LookupStrategy;

import Entity.ParkingSpot;

import java.util.List;

public class NearestToEntryGateLookupStrategy
        implements ParkingSpotLookupStrategy {

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> spots) {

        /*
         * Assumption:
         * spots are stored from nearest to farthest
         * from the entry gate.
         */

        for (ParkingSpot spot : spots) {

            if (spot.isSpotFree()) {
                return spot;
            }
        }

        return null;
    }
}