package com.parkinglotlld;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
	private String name;
	private int totalSpots;
	private int availableSpots;
	private Map<String, ParkingSpot> parkingSpots;
	private Map<String, Ticket> tickets;

	public ParkingLot(String name, int totalSpots) {
		this.name = name;
		this.totalSpots = totalSpots;
		this.availableSpots = totalSpots;
		this.parkingSpots = new HashMap<>();
		this.tickets = new HashMap<>();
	}

	public void addParkingSpot(String spotId, ParkingSpotType spotType) {
		if (!parkingSpots.containsKey(spotId)) {
			parkingSpots.put(spotId, new ParkingSpot(spotId, spotType));
		}
	}

	public Ticket parkVehicle(Vehicle vehicle) {
	    	 if (availableSpots > 0) {
	    	        for (Map.Entry<String, ParkingSpot> entry : parkingSpots.entrySet()) {
	    	            ParkingSpot spot = entry.getValue();

	    	            // Debugging log
	    	            System.out.println("Checking spot: " + spot.getParkingSpotId() + " | Type: " + spot.getParkingSpotType() + " | Vacant : " + spot.isVacant());

	    	            if (spot.isVacant() && isSpotSuitable(spot, vehicle)) {
	    	                spot.parkVehicle(vehicle);
	    	                availableSpots--;

	    	                Ticket ticket = generateTicket(spot.getParkingSpotId());
	    	                System.out.println("Vehicle parked at: " + spot.getParkingSpotId() + " | Ticket ID: " + ticket.getTicketId());
	    	                return ticket;
	    	            }
	    	        }
	    }
	    	 return null;
	}

	private boolean isSpotSuitable(ParkingSpot spot, Vehicle vehicle) {
		switch (vehicle.getVehicleType()) {
		case Car:
			return spot.getParkingSpotType() == ParkingSpotType.Compact
					|| spot.getParkingSpotType() == ParkingSpotType.Large;
		case MotorBike:
			return spot.getParkingSpotType() == ParkingSpotType.MotorCycle;
		case Truck:
			return spot.getParkingSpotType() == ParkingSpotType.Large;
		default:
			return false;
		}
	}

	private Ticket generateTicket(String spotId) {
		String ticketId = "TICKET_" + UUID.randomUUID().toString().substring(0, 6);
		Ticket ticket = new Ticket(ticketId, spotId, new Date());
		tickets.put(ticketId, ticket);
		return ticket;
	}

	public boolean exitVehicle(String ticketId) {
		if (tickets.containsKey(ticketId)) {
			Ticket ticket = tickets.get(ticketId);
			ParkingSpot spot = parkingSpots.get(ticket.getSpotId());
			if (spot != null && !spot.isVacant()) {
				spot.removeVehicle(null);
				availableSpots++;
				ticket.setExitTime(new Date());
				return true;
			}
		}
		return false;
	}
}
