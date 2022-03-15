package com.univpm.EsameOOP;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.univpm.EsameOOP.Model.Event;

public class EventTest {
	
	private Event e = null;
	
	@BeforeEach
	void setUp() throws Exception{
		e = new Event("New_York","67/100","2022-03-16","2022-02-28",null,"NBA",null);
	}
	
	@AfterEach
	void tearDown() throws Exception{
	}
	
	@Test
	@DisplayName("test event")
	void test() {
		assertEquals(e.getLuogo(), "New_York");
		assertEquals(e.getPrezzo_range(), "67/100");
		assertEquals(e.getData(), "2022-03-16");
		assertEquals(e.getSale(), "2022-02-28");
		assertEquals(e.getPresale(), null);
		assertEquals(e.getPromotore(), "NBA");
		assertEquals(e.getGeneri(), null);
	}
	
	@Test
	@DisplayName("test 2 event")
	void test2() {
		assertAll("valori", ()->assertEquals(e.getLuogo(), "New_York"),  
				()->assertEquals(e.getPrezzo_range(), "67/100"),
				()->assertEquals(e.getData(), "2022-03-16"),
				()->assertEquals(e.getSale(), "2022-02-28"),
				()->assertEquals(e.getPresale(), null),
				()->assertEquals(e.getPromotore(), "NBA"),
				()->assertEquals(e.getGeneri(), null));
	}
}
