package com.parkinglotlld;

public class Vehicle {
	private String liscencePlate;
	private VehicleType vehicleType;

	public Vehicle(String liscencePlate, VehicleType vehicleType) {
		super();
		this.liscencePlate = liscencePlate;
		this.vehicleType = vehicleType;
	}

	public String getLiscencePlate() {
		return liscencePlate;
	}

	public void setLiscencePlate(String liscencePlate) {
		this.liscencePlate = liscencePlate;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}
