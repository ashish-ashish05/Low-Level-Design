package parkinglot;

import Entity.ParkingSpot;
import Entity.Ticket;
import Entity.Vehicle;
import enums.VehicleType;
import payment.Payment;
import pricing.CostComputation;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private final ParkingBuilding parkingBuilding;

    private final CostComputation costComputation;

    private final Payment payment;

    private final Map<String, Ticket> activeTickets;

    public ParkingLot(
            ParkingBuilding parkingBuilding,
            CostComputation costComputation,
            Payment payment) {

        this.parkingBuilding = parkingBuilding;
        this.costComputation = costComputation;
        this.payment = payment;

        this.activeTickets =
                new ConcurrentHashMap<>();
    }

    /*
     * Called by EntranceGate.
     */
    public ParkingSpot findParkingSpot(
            VehicleType type) {

        return parkingBuilding.park(type);
    }

    /*
     * Complete entry operation.
     */
    public Ticket parkVehicle(
            Vehicle vehicle) {

        ParkingSpot spot =
                parkingBuilding.park(
                        vehicle.getVehicleType()
                );

        int levelNumber =
                findLevelNumber(spot);

        Ticket ticket = new Ticket(
                UUID.randomUUID().toString(),
                vehicle,
                levelNumber,
                spot,
                LocalDateTime.now()
        );

        activeTickets.put(
                ticket.getTicketId(),
                ticket
        );

        System.out.println(
                "Vehicle parked successfully"
        );

        System.out.println(ticket);

        return ticket;
    }

    /*
     * Called by ExitGate.
     */
    public void exit(String ticketId) {

        Ticket ticket =
                activeTickets.get(ticketId);

        if (ticket == null) {
            throw new IllegalArgumentException(
                    "Invalid ticket: " + ticketId
            );
        }

        LocalDateTime exitTime =
                LocalDateTime.now();

        double cost =
                costComputation.calculateCost(
                        ticket.getVehicle(),
                        ticket.getEntryTime(),
                        exitTime
                );

        System.out.println(
                "Parking cost = ₹" + cost
        );

        boolean paymentSuccessful =
                payment.pay(cost);

        if (!paymentSuccessful) {
            throw new IllegalStateException(
                    "Payment failed"
            );
        }

        parkingBuilding.unPark(
                ticket.getParkingLevel(),
                ticket.getVehicle().getVehicleType(),
                ticket.getParkingSpot()
        );

        activeTickets.remove(ticketId);

        System.out.println(
                "Vehicle exited successfully"
        );
    }

    private int findLevelNumber(
            ParkingSpot targetSpot) {

        for (ParkingLevel level :
                parkingBuilding.getLevels()) {

            for (ParkingSpotManagerEntry entry :
                    ParkingSpotManagerEntry.from(level)) {

                if (entry.contains(targetSpot)) {
                    return level.getLevelNumber();
                }
            }
        }

        throw new IllegalStateException(
                "Parking spot does not belong to building"
        );
    }

    /*
     * Helper used only to avoid exposing internal
     * manager implementation from ParkingLevel.
     */
    private static class ParkingSpotManagerEntry {

        private final spotManagers.ParkingSpotManager manager;

        private ParkingSpotManagerEntry(
                spotManagers.ParkingSpotManager manager) {

            this.manager = manager;
        }

        static java.util.List<ParkingSpotManagerEntry> from(
                ParkingLevel level) {

            java.util.List<ParkingSpotManagerEntry> result =
                    new java.util.ArrayList<>();

            for (VehicleType type : VehicleType.values()) {

                spotManagers.ParkingSpotManager manager =
                        level.getManager(type);

                if (manager != null) {
                    result.add(
                            new ParkingSpotManagerEntry(manager)
                    );
                }
            }

            return result;
        }

        boolean contains(ParkingSpot spot) {

            /*
             * We don't have to expose the internal list.
             * Better approach: add containsSpot() to manager.
             */
            return manager.containsSpot(spot);
        }
    }
}