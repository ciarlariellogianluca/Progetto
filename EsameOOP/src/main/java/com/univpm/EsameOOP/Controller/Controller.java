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

/**
 * Classe per la gestione di tutte le chiamate al server
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 */

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
	
	
	/**
	 * Rotta di tipo GET che restituisce una lista di eventi e attrazioni attraverso un paramentro passato dall'utente.
	 * @param events
	 * @return Lista di eventi/attrazioni
	 * @throws JSONException
	 * @throws IOException
	 */
	
	@GetMapping(value="/{events}")
	public ResponseEntity<Object> ShowEvents(@PathVariable("events") String events) throws JSONException, IOException {
		return new ResponseEntity<>(parse_events.Parsing(events), HttpStatus.OK);
	}
	
	/**
	 * Rotta di tipo GET che mostra le chiamate da fare per mostrare gli eventi
	 * @return Chiamate da effettuare
	 */
	
	 @GetMapping(value="/ShowEvents")
	 public EventsClass ShowCity() {
		return new EventsClass();
	 }
	 
	 /**
	  * Rotta di tipo POST che restituisce il filtraggio dei dati in base a dei parametri passati
	  * @param body Tipo di parametro che dichiara quali eventi verranno mostrati
	  * @return Filtraggio dei dati secondo il parametro body
	  * @throws JSONException
	  * @throws IOException
	  * @throws ParseException
	  */
	 
	 @PostMapping(value="/filters")
	 public ResponseEntity<Object> ShowFilters(@RequestBody FiltersBodyClass body) throws JSONException, IOException, ParseException {
		 return new ResponseEntity<>(filter.Filter(body), HttpStatus.OK);
	 }
	 
	 /**
	  * Rotta di tipo POST che restituisce le statistiche dei dati filtrati in base a dei parametri passati
	  * @param body Tipo di parametro che dichiara di quali eventi verranno mostrate le statistiche
	  * @return Statistiche dei dati filtrati
	  * @throws JSONException
	  * @throws IOException
	  * @throws ParseException
	  */
	 
	 @PostMapping(value="/stats")
	 public ResponseEntity<Object> ShowStats(@RequestBody FiltersBodyClass body) throws JSONException, IOException, ParseException {
		 return new ResponseEntity<>(stat.Statistics(body),HttpStatus.OK);
	 }
}
