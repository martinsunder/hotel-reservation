package com.martin.hotel.domain.constants;

public enum RoomExtra {

	BREAKFAST(10.0), DINNER(5.0), INTERNET(5.0), CAR_PARK(5.0), LATE_CHECKOUT(1.0), SEA_VIEW(5.0), FOOD_DISCOUNT(-3.0);

	private final double price;

	private RoomExtra(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

}
