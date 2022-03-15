package com.univpm.EsameOOP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import com.univpm.EsameOOP.Filters.Filters;
import com.univpm.EsameOOP.Filters.FiltersBodyClass;
import com.univpm.EsameOOP.Model.Events;
import com.univpm.EsameOOP.Model.Event;

public class FiltersTest {
	
	Filters filter = null;
	FiltersBodyClass body = null;
	FiltersBodyClass body2 = null;
	ArrayList<Events> events = null;
	
	@BeforeEach
	void setUp() throws Exception{
		filter = new Filters();
		body = new FiltersBodyClass("Los_Angeles","","");
		body2 = new FiltersBodyClass("Ancona", "", "");
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void test() throws Exception{
		events = new ArrayList<Events>();
		events = filter.Filter(body);
		for (Events event : events) {
			assertEquals(((Event) event).getLuogo().split("/")[1], body.getLuogo());
		}
	}
	
	@Test
	void test_eccezioni() {
		ResponseStatusException e;
		e = assertThrows(ResponseStatusException.class, ()->{filter.Filter(body2);});
		assertTrue(e.getMessage().contains("Lista vuota"));
	}

}
