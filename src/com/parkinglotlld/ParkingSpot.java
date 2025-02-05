package com.parkinglotlld;

public class ParkingSpot {
	private String parkingSpotId;
	private boolean isVacant;
	private ParkingSpotType parkingSpotType;
	private Vehicle vehicle;

	public ParkingSpot(String parkingSpotId, ParkingSpotType parkingSpotType) {
		super();
		this.parkingSpotId = parkingSpotId;
		this.isVacant = true;
		this.parkingSpotType = parkingSpotType;
		this.vehicle = null;
	}

	public boolean removeVehicle(Vehicle vehicle) {
		if (isVacant) {
			this.vehicle = null;
			this.isVacant = true;
			return true;
		}
		return false;
	}

	public boolean parkVehicle(Vehicle vehicle) {
		if (!isVacant) {
			this.vehicle = vehicle;
			this.isVacant = false;
			return true;
		}
		return false;
	}

	public String getParkingSpotId() {
		return parkingSpotId;
	}

	public void setParkingSpotId(String parkingSpotId) {
		this.parkingSpotId = parkingSpotId;
	}

	public boolean isVacant() {
		return isVacant;
	}

	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}

	public ParkingSpotType getParkingSpotType() {
		return parkingSpotType;
	}

	public void setParkingSpotType(ParkingSpotType parkingSpotType) {
		this.parkingSpotType = parkingSpotType;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
