package com.animator.catalog.parkingLotSystem.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private Long id;
    private String name;
    private String address;
    private Long noOfFloors;
    private Map<Long, List<ParkingSpot>> floorVsSpots;

    public ParkingLot(Long id, String name, String address, Long noOfFloors) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.noOfFloors = noOfFloors;
        this.floorVsSpots = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Long getNoOfFloors() {
        return noOfFloors;
    }

    public Map<Long, List<ParkingSpot>> getFloorVsSpots() {
        return floorVsSpots;
    }

    public void addFloor(Long floor){
        noOfFloors++;
        floorVsSpots.put(floor, new ArrayList<>());
    }

    public void addSpot(Long floor, ParkingSpot spot) {
        floorVsSpots.computeIfAbsent(floor, x-> new ArrayList<>()).add(spot);
    }

}
