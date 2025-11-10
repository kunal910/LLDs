package com.animator.catalog.parkingLotSystem;


import com.animator.catalog.parkingLotSystem.controller.ParkingLotController;
import com.animator.catalog.parkingLotSystem.enums.ParkingSpotStatus;
import com.animator.catalog.parkingLotSystem.enums.VehicleType;
import com.animator.catalog.parkingLotSystem.model.ParkingLot;
import com.animator.catalog.parkingLotSystem.model.ParkingSpot;
import com.animator.catalog.parkingLotSystem.model.Ticket;
import com.animator.catalog.parkingLotSystem.model.Vehicle;

public class ParkingLotMain {

    public static void main(String[] args) {

        ParkingSpot spot1 = new ParkingSpot(1L, VehicleType.TWO_WHEELER, ParkingSpotStatus.AVAILABLE);
        ParkingSpot spot2 = new ParkingSpot(2L, VehicleType.FOUR_WHEELER, ParkingSpotStatus.AVAILABLE);
        ParkingSpot spot3 = new ParkingSpot(3L, VehicleType.TWO_WHEELER, ParkingSpotStatus.AVAILABLE);
        ParkingSpot spot4 = new ParkingSpot(4L, VehicleType.FOUR_WHEELER, ParkingSpotStatus.AVAILABLE);
        ParkingSpot spot5 = new ParkingSpot(5L, VehicleType.TRUCK, ParkingSpotStatus.AVAILABLE);

        ParkingSpot spot6 = new ParkingSpot(1L, VehicleType.TWO_WHEELER, ParkingSpotStatus.AVAILABLE);
        ParkingSpot spot7 = new ParkingSpot(2L, VehicleType.FOUR_WHEELER, ParkingSpotStatus.AVAILABLE);
        ParkingSpot spot8 = new ParkingSpot(3L, VehicleType.TWO_WHEELER, ParkingSpotStatus.AVAILABLE);
        ParkingSpot spot9 = new ParkingSpot(4L, VehicleType.FOUR_WHEELER, ParkingSpotStatus.AVAILABLE);
        ParkingSpot spot10 = new ParkingSpot(5L, VehicleType.TRUCK, ParkingSpotStatus.AVAILABLE);

        ParkingLot parkingLot = new ParkingLot(1L, "GO-Parking", "abd colony", 2L);
        ParkingLotController parkingLotController = new ParkingLotController(parkingLot);
        parkingLotController.addSpot(1L, spot1);
        parkingLotController.addSpot(1L, spot2);
        parkingLotController.addSpot(1L, spot3);
        parkingLotController.addSpot(1L, spot4);
        parkingLotController.addSpot(1L, spot5);
        parkingLotController.addSpot(2L, spot6);
        parkingLotController.addSpot(2L, spot7);
        parkingLotController.addSpot(2L, spot8);
        parkingLotController.addSpot(2L, spot9);
        parkingLotController.addSpot(2L, spot10);

        Vehicle vehicle1 = new Vehicle(1L, "123", VehicleType.TWO_WHEELER, "honda");
        Vehicle vehicle2 = new Vehicle(2L, "124", VehicleType.TWO_WHEELER, "tvs");
        Vehicle vehicle3 = new Vehicle(3L, "125", VehicleType.FOUR_WHEELER, "i10");
        Vehicle vehicle4 = new Vehicle(3L, "126", VehicleType.TWO_WHEELER, "activa");
        Vehicle vehicle5 = new Vehicle(3L, "127", VehicleType.FOUR_WHEELER, "thar");

        Ticket ticket1 = parkingLotController.parkVehicle(vehicle1);
        System.out.println("------------------------------------");
        Ticket ticket2 = parkingLotController.parkVehicle(vehicle2);
        System.out.println("------------------------------------");
        Ticket ticket3 = parkingLotController.parkVehicle(vehicle3);
        System.out.println("------------------------------------");
        Ticket ticket4 = parkingLotController.parkVehicle(vehicle4);
        System.out.println("------------------------------------");
        Ticket ticket5 = parkingLotController.parkVehicle(vehicle5);
        System.out.println("------------------------------------");

        parkingLotController.unparkVehicle(ticket3);
        System.out.println("------------------------------------");
        parkingLotController.parkVehicle(vehicle5);
    }
}