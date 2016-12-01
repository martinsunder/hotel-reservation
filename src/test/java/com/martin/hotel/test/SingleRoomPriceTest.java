package com.martin.hotel.test;

import static com.martin.hotel.domain.constants.RoomExtra.*;

import java.util.Arrays;
import java.util.List;

import com.martin.hotel.domain.Room;
import com.martin.hotel.domain.SingleRoom;
import com.martin.hotel.domain.constants.Occupancy;
import com.martin.hotel.domain.constants.RoomExtra;
import com.martin.hotel.domain.constants.Season;
import com.martin.hotel.service.RoomQuoteService;

import junit.framework.TestCase;

public class SingleRoomPriceTest extends TestCase {

	public void testSingleRoomLowSeason() {
		Room singleRoom = new SingleRoom(Occupancy.SINGLE, Season.LOW);
		double price = singleRoom.getRoomPrice();
		assertEquals(20.0, price);
	}

	public void testSingleRoomHighSeason() {
		Room singleRoom = new SingleRoom(Occupancy.SINGLE, Season.HIGH);
		double price = singleRoom.getRoomPrice();
		assertEquals(30.0, price);
	}

	public void testSingleRoomDoubleOccupancy() {
		try {
			new SingleRoom(Occupancy.DOUBLE, Season.HIGH);
			throw new AssertionError("Single Room Unavailable with Double Occupancy");
		} catch (IllegalStateException illegalStateException) {
			System.out.println(illegalStateException.getMessage());
			assertEquals("Single Room with Double Occupancy is unavailable.", illegalStateException.getMessage());
		}
	}


	public void testSingleRoomQuote() {
		Room singleRoom = new SingleRoom(Occupancy.SINGLE, Season.HIGH);
		List<RoomExtra> roomExtraList = Arrays.asList(BREAKFAST, INTERNET, LATE_CHECKOUT);
		singleRoom.addRoomExtras(roomExtraList);

		RoomQuoteService roomQuoteService = new RoomQuoteService(singleRoom);
		double expectedQuoteTotal = roomQuoteService.getQuoteTotal();
		assertEquals(46.0, expectedQuoteTotal);
	}

	public void testSingleRoomQuoteSeaView() {
		Room singleRoom = new SingleRoom(Occupancy.SINGLE, Season.HIGH);
		List<RoomExtra> roomExtraList = Arrays.asList(BREAKFAST, INTERNET, LATE_CHECKOUT, SEA_VIEW);
		singleRoom.addRoomExtras(roomExtraList);
		
		RoomQuoteService roomQuoteService = new RoomQuoteService(singleRoom);
		double expectedQuoteTotal = roomQuoteService.getQuoteTotal();
		assertEquals(51.0, expectedQuoteTotal);
	}

}
