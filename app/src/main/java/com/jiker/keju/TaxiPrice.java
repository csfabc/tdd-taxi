package com.jiker.keju;
class TaxiPrice {
	private final int MILEAGE_FIRST = 2;
	private final int MILEAGE_SECOND = 8;
	private final int BASE_PRICE = 6;
	private final float UNIT_PRICE_MILEAGE = 0.8f;
	private final float UNIT_PRICE_TIME = 0.25f;
	private final float PERCENT_LONG = 0.5f;
	public String calculate(String m, String t) {
		float mileage = parseFloat(m);
		float time = parseFloat(t);
		if (mileage < 0 || time < 0){
			return "NumberNotValid";
		}
		return getResult(calculatePrice(mileage, time));
	}
	private float parseFloat(String s){
		try {
			float mileage = Float.parseFloat(s);
			return mileage<0?-1:mileage;
		} catch (Exception e){
			return -2;
		}
	}
	private float calculatePrice(float m, float t){
		if (m <= MILEAGE_FIRST){
			return priceLessTwo(t);
		} else if (m <= MILEAGE_SECOND){
			return priceLessEight(m, t);
		} else {
			return priceGreaterEight(m, t);
		}
	}
	private float priceTime(float t){
		return t * UNIT_PRICE_TIME;
	}
	private float priceLessTwo(float t){
		return priceTime(t) + BASE_PRICE;
	}
	private float priceLessEight(float m, float t){
		return priceLessTwo(t) + (m - MILEAGE_FIRST) * UNIT_PRICE_MILEAGE;
	}
	private float priceGreaterEight(float m, float t){
		return priceLessEight(m, t) + (m - MILEAGE_SECOND) * UNIT_PRICE_MILEAGE * PERCENT_LONG;
	}
	private String getResult(float price){
		return "收费" + Math.round(price) + "元";
	}
}