package com.jiker.keju;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxiPriceTest {
	@Test
	public void test_taxi_price_normal(){
		TaxiPrice taxiPrice = new TaxiPrice();
		assertEquals("收费6元", taxiPrice.calculate("1", "0"));
		assertEquals("收费7元", taxiPrice.calculate("3", "0"));
		assertEquals("收费13元", taxiPrice.calculate("10", "0"));
		assertEquals("收费7元", taxiPrice.calculate("2", "3"));
	}

	@Test
	public void test_taxi_price_error(){
		TaxiPrice taxiPrice = new TaxiPrice();
		assertEquals("NumberNotValid", taxiPrice.calculate("-1", "0"));
		assertEquals("NumberNotValid", taxiPrice.calculate("2", "-1"));
		assertEquals("NumberNotValid", taxiPrice.calculate("abc", "abc"));
	}
}
