package com.martin.hotel.test;

import static com.martin.hotel.domain.constants.RoomExtra.*;

import java.util.Arrays;
import java.util.List;

import com.martin.hotel.domain.DoubleRoom;
import com.martin.hotel.domain.Room;
import com.martin.hotel.domain.constants.Occupancy;
import com.martin.hotel.domain.constants.RoomExtra;
import com.martin.hotel.domain.constants.Season;
import com.martin.hotel.service.RoomQuoteService;

import junit.framework.TestCase;

public class DoubleRoomTest extends TestCase {
	private Room doubleRoom;

	public void testDoubleLowSingleOccupant() {
		doubleRoom = new DoubleRoom(Occupancy.SINGLE, Season.LOW);

		RoomQuoteService roomQuoteService = new RoomQuoteService(doubleRoom);
		double expectedRoomPrice = roomQuoteService.getQuoteTotal();
		assertEquals(40.0, expectedRoomPrice);
	}
	
	public void testDoubleHighSingleOccupant() {
		doubleRoom = new DoubleRoom(Occupancy.SINGLE, Season.HIGH);

		RoomQuoteService roomQuoteService = new RoomQuoteService(doubleRoom);
		double expectedRoomPrice = roomQuoteService.getQuoteTotal();
		assertEquals(60.0, expectedRoomPrice);
	}	
	
	public void testDoubleHighDoubleOccupant() {
		doubleRoom = new DoubleRoom(Occupancy.DOUBLE, Season.HIGH);
		List<RoomExtra> roomExtraList = Arrays.asList(BREAKFAST, INTERNET);
		doubleRoom.addRoomExtras(roomExtraList);

		RoomQuoteService roomQuoteService = new RoomQuoteService(doubleRoom);
		double expectedRoomPrice = roomQuoteService.getQuoteTotal();
		assertEquals(110.0, expectedRoomPrice);
	}		
	
	public void testDoubleLowDoubleOccupant() {
		doubleRoom = new DoubleRoom(Occupancy.DOUBLE, Season.LOW);
		List<RoomExtra> roomExtraList = Arrays.asList(BREAKFAST, DINNER, CAR_PARK);
		doubleRoom.addRoomExtras(roomExtraList);

		RoomQuoteService roomQuoteService = new RoomQuoteService(doubleRoom);
		double expectedRoomPrice = roomQuoteService.getQuoteTotal();
		assertEquals(84.0, expectedRoomPrice);
	}		

}
