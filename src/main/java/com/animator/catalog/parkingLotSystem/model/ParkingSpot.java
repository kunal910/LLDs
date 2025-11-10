package com.animator.catalog.parkingLotSystem.model;

import com.animator.catalog.parkingLotSystem.enums.ParkingSpotStatus;
import com.animator.catalog.parkingLotSystem.enums.VehicleType;

public class ParkingSpot {
    private Long id;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;
    private ParkingSpotStatus spotStatus;

    public ParkingSpot(Long id, VehicleType vehicleType, ParkingSpotStatus spotStatus) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.spotStatus = spotStatus;
    }

    public Long getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public Boolean isAvailable() {
        return spotStatus==ParkingSpotStatus.AVAILABLE;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.spotStatus = ParkingSpotStatus.NOT_AVAILABLE;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.spotStatus = ParkingSpotStatus.AVAILABLE;
    }
}
