package spotManagers;

import Entity.ParkingSpot;
import LookupStrategy.ParkingSpotLookupStrategy;

import java.util.List;

public class TwoWheelerSpotManager
        extends ParkingSpotManager {

    public TwoWheelerSpotManager(
            List<ParkingSpot> spots,
            ParkingSpotLookupStrategy strategy) {

        super(spots, strategy);
    }
}