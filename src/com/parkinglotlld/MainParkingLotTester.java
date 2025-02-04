package com.parkinglotlld;

public class MainParkingLotTester {
    public static void main(String[] args) {
        try {
            ParkingLot parkingLot = new ParkingLot("My Parking Lot", 10);

            // Add parking spots
            parkingLot.addParkingSpot("SPOT1", ParkingSpotType.Compact);
            parkingLot.addParkingSpot("SPOT2", ParkingSpotType.Large);
            parkingLot.addParkingSpot("SPOT3", ParkingSpotType.MotorCycle);

            // Park vehicles
            Vehicle car = new Vehicle("CAR123", VehicleType.Car);
            Vehicle bike = new Vehicle("BIKE456", VehicleType.MotorBike);
            Vehicle truck = new Vehicle("TRUCK789", VehicleType.Truck);

            Ticket carTicket = null, bikeTicket = null, truckTicket = null;

            try {
                carTicket = parkingLot.parkVehicle(car);
                System.out.println("Car parked with ticket: " + (carTicket != null ? carTicket.getTicketId() : "Failed"));
            } catch (Exception e) {
                System.out.println("Error while parking car: " + e.getMessage());
            }

            try {
                bikeTicket = parkingLot.parkVehicle(bike);
                System.out.println("Bike parked with ticket: " + (bikeTicket != null ? bikeTicket.getTicketId() : "Failed"));
            } catch (Exception e) {
                System.out.println("Error while parking bike: " + e.getMessage());
            }

            try {
                truckTicket = parkingLot.parkVehicle(truck);
                System.out.println("Truck parked with ticket: " + (truckTicket != null ? truckTicket.getTicketId() : "Failed"));
            } catch (Exception e) {
                System.out.println("Error while parking truck: " + e.getMessage());
            }

            // Exit vehicles
            try {
                boolean carExited = carTicket != null && parkingLot.exitVehicle(carTicket.getTicketId());
                System.out.println("Car exited: " + carExited);
            } catch (Exception e) {
                System.out.println("Error while exiting car: " + e.getMessage());
            }

            try {
                boolean bikeExited = bikeTicket != null && parkingLot.exitVehicle(bikeTicket.getTicketId());
                System.out.println("Bike exited: " + bikeExited);
            } catch (Exception e) {
                System.out.println("Error while exiting bike: " + e.getMessage());
            }

            try {
                boolean truckExited = truckTicket != null && parkingLot.exitVehicle(truckTicket.getTicketId());
                System.out.println("Truck exited: " + truckExited);
            } catch (Exception e) {
                System.out.println("Error while exiting truck: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
