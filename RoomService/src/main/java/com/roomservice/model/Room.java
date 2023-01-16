package com.roomservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="rooms")
public class Room {
	
	@Id
	private int roomNumber;
	private boolean roomStatus;
	
	public Room() {
		super();
	}

	public Room(int roomNumber, boolean roomStatus) {
		super();
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(boolean roomStatus) {
		this.roomStatus = roomStatus;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", roomStatus=" + roomStatus + "]";
	}

}
