package com.martin.hotel.test;

import static com.martin.hotel.domain.constants.RoomExtra.BREAKFAST;
import static com.martin.hotel.domain.constants.RoomExtra.DINNER;
import static com.martin.hotel.domain.constants.RoomExtra.INTERNET;
import static com.martin.hotel.domain.constants.RoomExtra.LATE_CHECKOUT;
import static com.martin.hotel.domain.constants.RoomExtra.SEA_VIEW;

import java.util.Arrays;
import java.util.List;

import com.martin.hotel.domain.Room;
import com.martin.hotel.domain.SuiteRoom;
import com.martin.hotel.domain.constants.Occupancy;
import com.martin.hotel.domain.constants.RoomExtra;
import com.martin.hotel.domain.constants.Season;
import com.martin.hotel.service.RoomQuoteService;

import junit.framework.TestCase;

public class SuiteRoomTest extends TestCase {

	private Room suiteRoom;

	public void testSuiteHighSeasonSingleOccupantNoExtras() {
		suiteRoom = new SuiteRoom(Occupancy.SINGLE, Season.HIGH);
		double actualRoomPrice = suiteRoom.getRoomPrice();
		assertEquals(80.0, actualRoomPrice);
	}

	public void testSuiteLowSeasonDoubleOccupantNoExtras() {
		suiteRoom = new SuiteRoom(Occupancy.DOUBLE, Season.LOW);
		double actualRoomPrice = suiteRoom.getRoomPrice();
		assertEquals(120.0, actualRoomPrice);
	}

	public void testSuiteLowSeasonSingleOccupantNoExtras() {
		suiteRoom = new SuiteRoom(Occupancy.SINGLE, Season.LOW);
		double actualRoomPrice = suiteRoom.getRoomPrice();
		assertEquals(60.0, actualRoomPrice);
	}

	public void testSuiteLowSeasonDoubleOccupantFreeInternetAndSeaView() {
		suiteRoom = new SuiteRoom(Occupancy.DOUBLE, Season.LOW);
		suiteRoom.addRoomExtra(INTERNET);
		suiteRoom.addRoomExtra(SEA_VIEW);

		RoomQuoteService roomQuoteService = new RoomQuoteService(suiteRoom);
		double actualRoomPrice = roomQuoteService.getQuoteTotal();
		assertEquals(120.0, actualRoomPrice);
	}

	public void testSuiteHighSeasonDoubleOccupantExtras() {
		suiteRoom = new SuiteRoom(Occupancy.DOUBLE, Season.HIGH);
		List<RoomExtra> roomExtraList = Arrays.asList(BREAKFAST, DINNER, INTERNET, LATE_CHECKOUT);
		suiteRoom.addRoomExtras(roomExtraList);

		RoomQuoteService roomQuoteService = new RoomQuoteService(suiteRoom);
		double actualRoomPrice = roomQuoteService.getQuoteTotal();
		assertEquals(186.0, actualRoomPrice);
	}

}
