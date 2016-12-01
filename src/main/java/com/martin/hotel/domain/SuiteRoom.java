package com.martin.hotel.domain;

import com.martin.hotel.domain.constants.Occupancy;
import com.martin.hotel.domain.constants.RoomType;
import com.martin.hotel.domain.constants.Season;

public class SuiteRoom extends MasterRoom {

	public SuiteRoom(Occupancy occupancy, Season season) {
		super(occupancy, season);
		setRoomType(RoomType.SUITE);
	}

	public double getRoomPrice() {

		switch (getSeason()) {
		case HIGH:

			if (Occupancy.DOUBLE.equals(getOccupancy())) {
				return SUITE_HIGH_SEASON_DOUBLE_OCCUPANCY;
			}
			return SUITE_HIGH_SEASON_SINGLE_OCCUPANCY;

		case LOW:
			if (Occupancy.DOUBLE.equals(getOccupancy())) {
				return SUITE_LOW_SEASON_DOUBLE_OCCUPANCY;
			}
			return SUITE_LOW_SEASON_SINGLE_OCCUPANCY;

		default:
			return 0.0;
		}

	}

}
