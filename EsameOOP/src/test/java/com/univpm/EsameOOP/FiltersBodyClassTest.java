package com.univpm.EsameOOP;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.univpm.EsameOOP.Filters.FiltersBodyClass;

public class FiltersBodyClassTest {
	
	private FiltersBodyClass body = null;
	
	@BeforeEach
	void setUp() throws Exception{
		body = new FiltersBodyClass("New_York", "2022-03-16", "Rock");
	}
	
	@AfterEach
	void tearDown() throws Exception{
	}
	
	@Test
	@DisplayName("test filtersBody")
	void test() {
		assertEquals(body.getLuogo(), "New_York");
		assertEquals(body.getData(), "2022-03-16");
		assertEquals(body.getGenere(), "Rock");
	}
	
	@Test
	@DisplayName("test 2 filtersBody")
	void test2() {
		assertAll("valori", ()->assertEquals(body.getLuogo(), "New_York"),  
				()->assertEquals(body.getData(), "2022-03-16"),
				()->assertEquals(body.getGenere(), "Rock"));
	}
}
