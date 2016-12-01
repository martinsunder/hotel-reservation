package com.martin.hotel.domain;

import java.util.ArrayList;
import java.util.List;

import com.martin.hotel.domain.constants.Occupancy;
import com.martin.hotel.domain.constants.RoomExtra;
import com.martin.hotel.domain.constants.RoomType;
import com.martin.hotel.domain.constants.Season;

public abstract class MasterRoom implements Room {

	private Season season;
	private RoomType roomType;
	private Occupancy occupancy;
	private List<RoomExtra> roomExtras;

	public MasterRoom(Occupancy occupancy, Season season) {
		this.occupancy = occupancy;
		this.season = season;
		roomExtras = new ArrayList<RoomExtra>();
	}

	public Season getSeason() {
		return this.season;
	}

	public boolean addRoomExtra(RoomExtra roomExtra) {
		return roomExtras.add(roomExtra);
	}

	public boolean addRoomExtras(List<RoomExtra> allRoomExtras) {
		return roomExtras.addAll(allRoomExtras);
	}

	public List<RoomExtra> getRoomExtras() {
		return roomExtras;
	}

	public void setOccupancy(Occupancy occupancy) {
		this.occupancy = occupancy;
	}

	public Occupancy getOccupancy() {
		return occupancy;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public RoomType getRoomType() {
		return this.roomType;
	}

}
	