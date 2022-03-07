package com.univpm.EsameOOP.Controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univpm.EsameOOP.Service.JSONParsing;

@RestController
public class Controller {
	
	@Autowired
	JSONParsing parse_events;
	
	@GetMapping(value="/events")
	public ResponseEntity<Object> ShowEvents() throws JSONException, IOException {
		return new ResponseEntity<>(parse_events.Parsing(), HttpStatus.OK);
	}
	
}
