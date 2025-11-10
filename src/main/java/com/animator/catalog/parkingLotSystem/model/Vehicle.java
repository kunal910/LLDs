package com.animator.catalog.parkingLotSystem.model;

import com.animator.catalog.parkingLotSystem.enums.VehicleType;

public class Vehicle {
    private Long id;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String model;

    public Vehicle(Long id, String vehicleNumber, VehicleType vehicleType, String model){
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getModel() {
        return model;
    }
}
