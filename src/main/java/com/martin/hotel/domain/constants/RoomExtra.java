package com.martin.hotel.domain.constants;

public enum RoomExtra {

	BREAKFAST() {
		public double getPrice() {
			return 10.0;
		}
	},

	DINNER() {
		public double getPrice() {
			return 5.0;
		}
	},

	INTERNET() {
		public double getPrice() {
			return 5.0;
		}
	},

	CAR_PARK() {
		public double getPrice() {
			return 5.0;
		}
	},

	LATE_CHECKOUT() {
		public double getPrice() {
			return 1.0;
		}
	},

	SEA_VIEW() {
		public double getPrice() {
			return 5.0;
		}
	},

	FOOD_DISCOUNT() {
		public double getPrice() {
			return -3.0;
		}
	};

	public double getPrice() {
		return 0;
	}

}
