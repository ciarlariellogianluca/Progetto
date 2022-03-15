package com.univpm.EsameOOP.Model;

import org.springframework.stereotype.Service;

/**
 * Classe per visualizzare le rotte da effettuare
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 *
 */

@Service
public class EventsClass {
	
	private String titolo;
	private String events;
	
	public EventsClass() {
		this.setTitolo("Le chiamate per visualizzare gli eventi sono :");
		this.setEvents("/events, /attractions, /venues");
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
}
