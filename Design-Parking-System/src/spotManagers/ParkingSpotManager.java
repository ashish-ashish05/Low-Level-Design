package spotManagers;

import Entity.ParkingSpot;
import LookupStrategy.ParkingSpotLookupStrategy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpotManager {

    protected final List<ParkingSpot> spots;

    protected ParkingSpotLookupStrategy strategy;

    protected final ReentrantLock lock;

    public ParkingSpotManager(
            List<ParkingSpot> spots,
            ParkingSpotLookupStrategy strategy) {

        this.spots = spots;
        this.strategy = strategy;
        this.lock = new ReentrantLock();
    }

    public ParkingSpot park() {

        lock.lock();

        try {

            ParkingSpot spot =
                    strategy.selectSpot(spots);

            if (spot == null) {
                throw new IllegalStateException(
                        "No parking spot available"
                );
            }

            spot.occupySpot();

            return spot;

        } finally {

            lock.unlock();
        }
    }

    public void unPark(ParkingSpot spot) {

        lock.lock();

        try {

            spot.releaseSpot();

        } finally {

            lock.unlock();
        }
    }

    public boolean hasFreeSpot() {

        lock.lock();

        try {

            for (ParkingSpot spot : spots) {

                if (spot.isSpotFree()) {
                    return true;
                }
            }

            return false;

        } finally {

            lock.unlock();
        }
    }

    public void setStrategy(
            ParkingSpotLookupStrategy strategy) {

        lock.lock();

        try {
            this.strategy = strategy;
        } finally {
            lock.unlock();
        }
    }

    public boolean containsSpot(ParkingSpot target) {

        lock.lock();

        try {
            return spots.contains(target);
        } finally {
            lock.unlock();
        }
    }
}