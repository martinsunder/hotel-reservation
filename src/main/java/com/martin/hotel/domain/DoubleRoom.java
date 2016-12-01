package com.martin.hotel.domain;

import com.martin.hotel.domain.constants.Occupancy;
import com.martin.hotel.domain.constants.RoomType;
import com.martin.hotel.domain.constants.Season;

public class DoubleRoom extends MasterRoom {

	public DoubleRoom(Occupancy occupancy, Season season) {
		super(occupancy, season);
		setRoomType(RoomType.DOUBLE);
	}

	public double getRoomPrice() {

		switch (getSeason()) {
		case HIGH:

			if (Occupancy.DOUBLE.equals(getOccupancy())) {
				return DOUBLE_HIGH_SEASON_DOUBLE_OCCUPANCY;
			}
			return DOUBLE_HIGH_SEASON_SINGLE_OCCUPANCY;

		case LOW:
			if (Occupancy.DOUBLE.equals(getOccupancy())) {
				return DOUBLE_LOW_SEASON_DOUBLE_OCCUPANCY;
			}
			return DOUBLE_LOW_SEASON_SINGLE_OCCUPANCY;

		default:
			return 0.0;
		}

	}

}
