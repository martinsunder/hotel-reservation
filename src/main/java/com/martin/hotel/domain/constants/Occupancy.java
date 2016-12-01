package com.martin.hotel.domain.constants;

public enum Occupancy {

	SINGLE(1), DOUBLE(2);

	private final int occupantCount;

	private Occupancy(int occupantCount) {
		this.occupantCount = occupantCount;
	}

	public int getOccupantCount() {
		return occupantCount;
	}

}