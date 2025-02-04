package com.parkinglotlld;

import java.util.Date;

public class Ticket {
	private String ticketId;
	private String spotId;
	private Date entryTime;
	private Date exitTime;

	public Ticket(String ticketId, String spotId, Date entryTime) {
		super();
		this.ticketId = ticketId;
		this.spotId = spotId;
		this.entryTime = entryTime;
		this.exitTime = null;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getSpotId() {
		return spotId;
	}

	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Date getExitTime() {
		return exitTime;
	}

	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}

}
