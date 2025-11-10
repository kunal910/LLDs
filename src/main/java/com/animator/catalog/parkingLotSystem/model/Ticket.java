package com.animator.catalog.parkingLotSystem.model;

import java.sql.Timestamp;

public class Ticket {
    private Long id;
    private Long floor;
    private ParkingSpot spot;
    private Vehicle vehicle;
    private Timestamp timeStamp;

    public Ticket(Long id, Long floor, ParkingSpot spot, Vehicle vehicle, Timestamp timeStamp) {
        this.id = id;
        this.floor = floor;
        this.spot = spot;
        this.vehicle = vehicle;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public Long getFloor() {
        return floor;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
}
