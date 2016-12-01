package com.martin.hotel.domain;

import com.martin.hotel.domain.constants.Occupancy;
import com.martin.hotel.domain.constants.RoomType;
import com.martin.hotel.domain.constants.Season;
import com.martin.hotel.exception.RoomTypeUnavailable;

public class SingleRoom extends MasterRoom {

	public SingleRoom(Occupancy occupancy, Season season) {		
		super(occupancy, season);
		
		if (Occupancy.DOUBLE.equals(occupancy)) {
			throw new RoomTypeUnavailable("Single Room with Double Occupancy is unavailable.");
		}
		
		setRoomType(RoomType.SINGLE);
	}

	public double getRoomPrice() {
		if (Season.HIGH.equals(getSeason())) {
			return SINGLE_HIGH_SEASON;
		}
		return SINGLE_LOW_SEASON;
	}

}
