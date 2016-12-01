package com.martin.hotel.service;

import java.util.List;

import com.martin.hotel.domain.Room;
import com.martin.hotel.domain.constants.RoomExtra;
import com.martin.hotel.domain.constants.RoomType;
import static com.martin.hotel.domain.Room.FOOD_EXTRAS;
import static com.martin.hotel.domain.constants.RoomExtra.INTERNET;
import static com.martin.hotel.domain.constants.RoomExtra.SEA_VIEW;

public class RoomQuoteService {

	private Room room;

	public RoomQuoteService(Room room) {
		super();
		this.room = room;
	}

	public double getExtrasTotal() {

		double extraTotal = 0;
		int occupantCount = room.getOccupancy().getOccupantCount();

		List<RoomExtra> roomExtras = room.getRoomExtras();
		if (isEligilbleForDiscount()) {
			roomExtras.add(RoomExtra.FOOD_DISCOUNT);
		}

		for (RoomExtra extra : roomExtras) {
			if (isRoomExtraSuiteAddOn(extra)) {
				continue;
			}
			extraTotal += (extra.getPrice() * occupantCount);
		}
		return extraTotal;
	}

	private boolean isRoomExtraSuiteAddOn(RoomExtra roomExtra) {
		return RoomType.SUITE.equals(room.getRoomType()) && (INTERNET.equals(roomExtra) || SEA_VIEW.equals(roomExtra));
	}

	private boolean isEligilbleForDiscount() {
		List<RoomExtra> roomExtras = room.getRoomExtras();
		if (roomExtras != null) {
			return roomExtras.containsAll(FOOD_EXTRAS);
		}
		return false;
	}

	public double getQuoteTotal() {
		return room.getRoomPrice() + this.getExtrasTotal();
	}

}
