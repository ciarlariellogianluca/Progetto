package com.univpm.EsameOOP.Controller;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.univpm.EsameOOP.Filters.FiltersBodyClass;
import com.univpm.EsameOOP.Filters.Filters;
import com.univpm.EsameOOP.Model.EventsClass;
import com.univpm.EsameOOP.Service.GetEvents;
import com.univpm.EsameOOP.Statistics.Stats;

@RestController
public class Controller {
	
	@Autowired
	GetEvents parse_events;
	@Autowired
	EventsClass eventi;
	@Autowired
	Filters filter;
	@Autowired
	Stats stat;
	
	
	@GetMapping(value="/{events}")
	public ResponseEntity<Object> ShowEvents(@PathVariable("events") String events) throws JSONException, IOException {
		return new ResponseEntity<>(parse_events.Parsing(events), HttpStatus.OK);
	}
	
	 @GetMapping(value="/ShowEvents")
	 public EventsClass ShowCity() {
		return new EventsClass();
	 }
	 
	 @PostMapping(value="/filters")
	 public ResponseEntity<Object> ShowFilters(@RequestBody FiltersBodyClass body) throws JSONException, IOException, ParseException {
		 return new ResponseEntity<>(filter.Filter(body), HttpStatus.OK);
	 }
	 
	 @PostMapping(value="/stats")
	 public ResponseEntity<Object> ShowStats(@RequestBody FiltersBodyClass body) throws JSONException, IOException, ParseException {
		 return new ResponseEntity<>(stat.Statistics(body),HttpStatus.OK);
	 }
}
