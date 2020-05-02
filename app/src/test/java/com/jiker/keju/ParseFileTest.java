package com.jiker.keju;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParseFileTest {
	@Test
	public void test_parse_all(){
		String content = "1公里,等待0分钟\n3公里,等待0分钟\n10公里,等待0分钟\n2公里,等待3分钟\n";
		String expected = "收费6元\n" + "收费7元\n" + "收费13元\n" + "收费7元\n";
		assertEquals(expected, new ParseFile().parseAll(content));
	}
	@Test
	public void test_parse_all_error(){
		assertEquals("", new ParseFile().parseAll(null));
		assertEquals("", new ParseFile().parseAll(""));
		assertEquals("\n", new ParseFile().parseAll("abc"));
	}
	@Test
	public void test_parse_line_one(){
		Travel travel = new ParseFile().parseLine("1公里,等待0分钟");
		assertEquals("1", travel.getMileage());
		assertEquals("0", travel.getTime());
	}
	@Test
	public void test_parse_line_two(){
		Travel travel = new ParseFile().parseLine("3公里,等待0分钟");
		assertEquals("3", travel.getMileage());
		assertEquals("0", travel.getTime());
	}
	@Test
	public void test_parse_line_three(){
		Travel travel = new ParseFile().parseLine("10公里,等待0分钟");
		assertEquals("10", travel.getMileage());
		assertEquals("0", travel.getTime());
	}
	@Test
	public void test_parse_line_four(){
		Travel travel = new ParseFile().parseLine("2公里,等待3分钟");
		assertEquals("2", travel.getMileage());
		assertEquals("3", travel.getTime());
	}
	@Test
	public void test_parse_line_error(){
		Travel travel = new ParseFile().parseLine("");
		assertEquals(null, new ParseFile().parseLine(null));
		assertEquals(null, new ParseFile().parseLine(""));
		assertEquals(null, new ParseFile().parseLine("abc"));
	}
}
