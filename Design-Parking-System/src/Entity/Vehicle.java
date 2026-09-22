package Entity;

import enums.VehicleType;

public class Vehicle {
    private final String vehicleNo;
    private final VehicleType vehicleType;

    public Vehicle(String vehicleNo, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }
    public String getVehicleNo() {
        return vehicleNo;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
