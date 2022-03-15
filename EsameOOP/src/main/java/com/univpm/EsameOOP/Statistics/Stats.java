
package com.univpm.EsameOOP.Statistics;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.univpm.EsameOOP.Filters.Filters;
import com.univpm.EsameOOP.Filters.FiltersBodyClass;
import com.univpm.EsameOOP.Model.Events;
import com.univpm.EsameOOP.Model.Event;
import com.univpm.EsameOOP.Model.StatsClass;
import com.univpm.EsameOOP.Service.GetEvents;

/**
 * Classe per visualizzare le statistiche su eventi filtrati
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 *
 */

@Service
public class Stats {
	
	public StatsClass Statistics(FiltersBodyClass body) throws JSONException, IOException, ParseException {		
		
		StatsClass stat = new StatsClass();
		GetEvents get_events = new GetEvents();
		ArrayList<Events> events = new ArrayList<>();
		ArrayList<Events> filters = new ArrayList<>();
		Filters filter = new Filters();
		
		events = get_events.Parsing("events");
		filters = filter.Filter(body);
		
		stat.setNumEvents(filters.size());
		stat.setNumTotale(events.size());
		
		HashMap<String,Integer> genere = new HashMap<>();
		if(body.getGenere() != "" && body.getGenere() != null) {
			genere.put(body.getGenere(), filters.size());
			stat.setNumPerGenere(genere);
		}
		else {
			for(int i=0;i<filters.size();i++) {
				if(genere.containsKey(((Event)filters.get(i)).getGeneri())) {
					genere.put(((Event)filters.get(i)).getGeneri(), genere.get(((Event)filters.get(i)).getGeneri())+1);
				}
				else {
					genere.put(((Event)filters.get(i)).getGeneri(),1);
				}
			}
			stat.setNumPerGenere(genere);
		}
		
		HashMap<String,Integer> luogo = new HashMap<>();
		if(body.getLuogo() != "" && body.getLuogo() != null) {
			luogo.put(body.getLuogo(), filters.size());
			stat.setNumPerLuogo(luogo);
		}
		else {
			for(int i=0;i<filters.size();i++) {
				if(luogo.containsKey(((Event)filters.get(i)).getLuogo())) {
					luogo.put(((Event)filters.get(i)).getLuogo(), luogo.get(((Event)filters.get(i)).getLuogo())+1);
				}
				else {
					luogo.put(((Event)filters.get(i)).getLuogo(),1);
				}
			}
			stat.setNumPerLuogo(luogo);
		}
		
		HashMap<String, Integer> date = new HashMap<>();
		String data;
		for(Events event : events) {
			if(((Event) event).getData() != "Unavailable") {
				data = ((Event) event).getData().substring(0,7);
				if(date.containsKey(data)) {
					date.put(data, date.get(data)+1);
				}
				else {
					date.put(data, 1);
				}
			}
		}
		stat.setNumEventForMese(date);
		DecimalFormat frmt = new DecimalFormat();
		frmt.setMaximumFractionDigits(2);
		stat.setMedia("La media degli eventi ogni mese è dell'"+frmt.format((float)stat.getNumEvents()/12)+"%");
		
		return stat;
	}
}
