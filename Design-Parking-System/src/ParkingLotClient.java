import Entity.ParkingSpot;
import Entity.Ticket;
import Entity.Vehicle;
import LookupStrategy.RandomLookupStrategy;
import enums.VehicleType;
import parkinglot.EntranceGate;
import parkinglot.ExitGate;
import parkinglot.ParkingBuilding;
import parkinglot.ParkingLevel;
import parkinglot.ParkingLot;
import payment.UPIPayment;
import pricing.CostComputation;
import pricing.FixedPricingStrategy;
import spotManagers.FourWheelerSpotManager;
import spotManagers.TwoWheelerSpotManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotClient {

    public static void main(String[] args) {

        /*
         * ============================
         * LEVEL 1
         * ============================
         */

        List<ParkingSpot> twoWheelerSpotsLevel1 =
                Arrays.asList(
                        new ParkingSpot("L1-TW-1"),
                        new ParkingSpot("L1-TW-2"),
                        new ParkingSpot("L1-TW-3")
                );

        List<ParkingSpot> fourWheelerSpotsLevel1 =
                Arrays.asList(
                        new ParkingSpot("L1-FW-1"),
                        new ParkingSpot("L1-FW-2"),
                        new ParkingSpot("L1-FW-3")
                );

        TwoWheelerSpotManager twoWheelerManager1 =
                new TwoWheelerSpotManager(
                        twoWheelerSpotsLevel1,
                        new RandomLookupStrategy()
                );

        FourWheelerSpotManager fourWheelerManager1 =
                new FourWheelerSpotManager(
                        fourWheelerSpotsLevel1,
                        new RandomLookupStrategy()
                );

        Map<VehicleType, spotManagers.ParkingSpotManager>
                level1Managers = new HashMap<>();

        level1Managers.put(
                VehicleType.TWO_WHEELER,
                twoWheelerManager1
        );

        level1Managers.put(
                VehicleType.FOUR_WHEELER,
                fourWheelerManager1
        );

        ParkingLevel level1 =
                new ParkingLevel(
                        1,
                        level1Managers
                );


        /*
         * ============================
         * LEVEL 2
         * ============================
         */

        List<ParkingSpot> twoWheelerSpotsLevel2 =
                Arrays.asList(
                        new ParkingSpot("L2-TW-1"),
                        new ParkingSpot("L2-TW-2"),
                        new ParkingSpot("L2-TW-3")
                );

        List<ParkingSpot> fourWheelerSpotsLevel2 =
                Arrays.asList(
                        new ParkingSpot("L2-FW-1"),
                        new ParkingSpot("L2-FW-2"),
                        new ParkingSpot("L2-FW-3")
                );

        TwoWheelerSpotManager twoWheelerManager2 =
                new TwoWheelerSpotManager(
                        twoWheelerSpotsLevel2,
                        new RandomLookupStrategy()
                );

        FourWheelerSpotManager fourWheelerManager2 =
                new FourWheelerSpotManager(
                        fourWheelerSpotsLevel2,
                        new RandomLookupStrategy()
                );

        Map<VehicleType, spotManagers.ParkingSpotManager>
                level2Managers = new HashMap<>();

        level2Managers.put(
                VehicleType.TWO_WHEELER,
                twoWheelerManager2
        );

        level2Managers.put(
                VehicleType.FOUR_WHEELER,
                fourWheelerManager2
        );

        ParkingLevel level2 =
                new ParkingLevel(
                        2,
                        level2Managers
                );


        /*
         * ============================
         * BUILDING
         * ============================
         */

        ParkingBuilding building =
                new ParkingBuilding(
                        Arrays.asList(
                                level1,
                                level2
                        )
                );


        /*
         * ============================
         * PRICING
         * ============================
         */

        CostComputation costComputation =
                new CostComputation(
                        new FixedPricingStrategy(50)
                );


        /*
         * ============================
         * PAYMENT
         * ============================
         */

        UPIPayment payment =
                new UPIPayment();


        /*
         * ============================
         * PARKING LOT
         * ============================
         */

        ParkingLot parkingLot =
                new ParkingLot(
                        building,
                        costComputation,
                        payment
                );


        /*
         * ============================
         * ONE ENTRY + ONE EXIT
         * ============================
         */

        EntranceGate entranceGate =
                new EntranceGate(parkingLot);

        ExitGate exitGate =
                new ExitGate(parkingLot);


        /*
         * ============================
         * VEHICLE ARRIVES
         * ============================
         */

        Vehicle car =
                new Vehicle(
                        "KA01AB1234",
                        VehicleType.FOUR_WHEELER
                );


        /*
         * ENTRY
         */

        Ticket ticket =
                parkingLot.parkVehicle(car);


        /*
         * EXIT
         */

        exitGate.exit(
                ticket.getTicketId()
        );
    }
}