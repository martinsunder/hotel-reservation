package com.martin.hotel.domain;

import java.util.Arrays;
import java.util.List;

import com.martin.hotel.domain.constants.Occupancy;
import com.martin.hotel.domain.constants.RoomExtra;
import com.martin.hotel.domain.constants.RoomType;

public interface Room {

	public static final double SINGLE_LOW_SEASON = 20.0;
	public static final double SINGLE_HIGH_SEASON = 30.0;

	public static final double DOUBLE_LOW_SEASON_SINGLE_OCCUPANCY = 40.0;
	public static final double DOUBLE_LOW_SEASON_DOUBLE_OCCUPANCY = 50.0;
	public static final double DOUBLE_HIGH_SEASON_SINGLE_OCCUPANCY = 60.0;
	public static final double DOUBLE_HIGH_SEASON_DOUBLE_OCCUPANCY = 80.0;

	public static final double SUITE_LOW_SEASON_SINGLE_OCCUPANCY = 60.0;
	public static final double SUITE_LOW_SEASON_DOUBLE_OCCUPANCY = 120.0;
	public static final double SUITE_HIGH_SEASON_SINGLE_OCCUPANCY = 80.0;
	public static final double SUITE_HIGH_SEASON_DOUBLE_OCCUPANCY = 160.0;

	public static final List<RoomExtra> FOOD_EXTRAS = Arrays.asList(RoomExtra.BREAKFAST, RoomExtra.DINNER);

	public double getRoomPrice();

	public boolean addRoomExtra(RoomExtra roomExtra);

	public boolean addRoomExtras(List<RoomExtra> allRoomExtras);

	public RoomType getRoomType();

	public List<RoomExtra> getRoomExtras();
	
	public Occupancy getOccupancy();
	/*
	 * public double getExtrasTotal();
	 * 
	 * public double getQuoteTotal();
	 * 
	 * public Season getSeason();
	 * 
	 * 
	 * 
	 * public boolean addRoomExtra(RoomExtra roomExtra);
	 * 
	 * public boolean addRoomExtras(List<RoomExtra> allRoomExtras);
	 */

}
