package com.univpm.EsameOOP.Filters;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.univpm.EsameOOP.Exception.CustomException;
import com.univpm.EsameOOP.Model.Event;
import com.univpm.EsameOOP.Model.Events;
import com.univpm.EsameOOP.Service.GetEvents;

/**
 * Classe per il filtraggio dei dati degli eventi in base al luogo, la data e il genere
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 */

@Service
public class Filters {
	
	/**
	 * Metodo che restituisce un lista contenente tutti gli eventi filtrati secondo un paramentro body passato dal cliente
	 * @param body
	 * @return Lista eventi filtratti
	 * @throws JSONException
	 * @throws IOException
	 * @throws ParseException
	 */
	
	public ArrayList<Events> Filter(FiltersBodyClass body) throws JSONException, IOException, ParseException{
		@SuppressWarnings("unused")
		CustomException e;
		ArrayList<Events> eventi = new ArrayList<>();
		GetEvents getEvent = new GetEvents();
		eventi = getEvent.Parsing("events");
		
		eventi = filterGenere(body, eventi);
		eventi = filterLuogo(body, eventi);
		eventi = filterData(body, eventi);
		
		if (eventi.isEmpty())
			e = new CustomException("Lista vuota");
		
		return eventi;
	}
	
	/**
	 * Metodo per il filtraggio degli eventi secondo un genere scelto dall'utente
	 * @param body
	 * @param eventi
	 * @return Eventi filtrati per genere
	 */
	
	public ArrayList<Events> filterGenere(FiltersBodyClass body, ArrayList<Events> eventi) {
		if (body.getGenere() != "" && body.getGenere() != null && eventi != null) {
			for (int i=0;i<eventi.size();i++) {
				if (((Event) eventi.get(i)).getGeneri().contains(body.getGenere()) == false) {
					eventi.remove(i);
					i--;
				}
			}
		}
		return eventi;
	}
	
	/**
	 * Metodo per il filtraggio degli eventi secondo un luogo scelto dall'utente
	 * @param body
	 * @param eventi
	 * @return Eventi filtrati per luogo
	 */
	
	public ArrayList<Events> filterLuogo(FiltersBodyClass body, ArrayList<Events> eventi) {
		if (body.getLuogo() != "" && body.getLuogo() != null && eventi != null) {
			for (int i=0;i<eventi.size();i++) {
				if (!((Event) eventi.get(i)).getLuogo().contains(body.getLuogo())) {
					eventi.remove(i);
					i--;
				}
			}
		}
		return eventi;
	}
	
	/**
	 * Metodo per il filtraggio degli eventi secondo una data scelta dall'utente
	 * @param body
	 * @param eventi
	 * @return Eventi filtrati per genere
	 */
	
	public ArrayList<Events> filterData(FiltersBodyClass body, ArrayList<Events> eventi) {
		if (body.getData() != "" && body.getData() != null && eventi != null) {
			LocalDate data = LocalDate.parse(body.getData());
			for (int i=0;i<eventi.size();i++) {
				if (((Event) eventi.get(i)).getData() != "Unavailable") {
					String data_sub = ((Event) eventi.get(i)).getData().substring(0,10);
					LocalDate data2 = LocalDate.parse(data_sub);
					if (data.isAfter(data2)) {
						eventi.remove(i);
						i--;
					}
				}
				else {
					eventi.remove(i);
					i--;
				}
			}
		}
		return eventi;
	}
	
}
