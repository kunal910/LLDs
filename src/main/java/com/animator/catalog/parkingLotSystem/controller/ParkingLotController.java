package com.animator.catalog.parkingLotSystem.controller;

import com.animator.catalog.parkingLotSystem.model.ParkingLot;
import com.animator.catalog.parkingLotSystem.model.ParkingSpot;
import com.animator.catalog.parkingLotSystem.model.Ticket;
import com.animator.catalog.parkingLotSystem.model.Vehicle;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class ParkingLotController {
    private ParkingLot parkingLot;
    private Long ticketId = 1L;

    public ParkingLotController(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public void addFloor(Long floor){
        parkingLot.addFloor(floor);
    }

    public void addSpot(Long floor, ParkingSpot spot){
        parkingLot.addSpot(floor, spot);
    }

    public Ticket parkVehicle(Vehicle vehicle){
        Long parkFloor = null;
        ParkingSpot parkSpot = null;
        for(Map.Entry<Long, List<ParkingSpot>> element : parkingLot.getFloorVsSpots().entrySet()){
            Long floor = element.getKey();
            ParkingSpot spot = null;
            for(ParkingSpot newSpot : element.getValue()){
                if(newSpot.isAvailable() && newSpot.getVehicleType().equals(vehicle.getVehicleType())){
                    if(spot == null || spot.getId() > newSpot.getId()){
                        spot = newSpot;
                    }
                }
            }
            if(spot != null){
                if(parkFloor == null || parkFloor > floor){
                    parkFloor = floor;
                    parkSpot = spot;
                }
            }
        }
        if (parkSpot == null){
            System.out.println("No parking spot is empty, Please wait...");
            return null;
        }
        parkSpot.assignVehicle(vehicle);
        Ticket ticket = generateTicket(parkFloor, parkSpot, vehicle, new Timestamp(System.currentTimeMillis()));
        System.out.println("Assigned parking spot to vehicle, vehicleNo: " + vehicle.getVehicleNumber() + ", floor: " + parkFloor + ", spot: " + parkSpot.getId() + ", ticketId: " + ticket.getId());
        return ticket;
    }

    public void unparkVehicle(Ticket ticket){
        System.out.println("Unparked vehicle, vehicleNo: " + ticket.getVehicle().getVehicleNumber() + " from floor: " + ticket.getFloor() + ", spot: " + ticket.getSpot().getId());
        ticket.getSpot().removeVehicle();
    }

    private Ticket generateTicket(Long parkFloor, ParkingSpot parkSpot, Vehicle vehicle, Timestamp timestamp) {
        Ticket ticket = new Ticket(ticketId, parkFloor, parkSpot, vehicle, timestamp);
        ticketId++;
        return ticket;
    }
}
