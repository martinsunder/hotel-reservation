package com.martin.hotel.test;

import com.martin.hotel.domain.DoubleRoom;
import com.martin.hotel.domain.Room;
import com.martin.hotel.domain.constants.Occupancy;
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

}
