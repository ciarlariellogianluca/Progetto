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

@Service
public class Filters {
	
	public ArrayList<Events> Filter(FiltersBodyClass body) throws JSONException, IOException, ParseException{
		@SuppressWarnings("unused")
		CustomException e;
		ArrayList<Events> eventi = new ArrayList<>();
		GetEvents getEvent = new GetEvents();
		eventi = getEvent.Parsing("events");
		
		if (body.getGenere() != "" && body.getGenere() != null && eventi != null) {
			for (int i=0;i<eventi.size();i++) {
				if (((Event) eventi.get(i)).getGeneri().contains(body.getGenere()) == false) {
					eventi.remove(i);
					i--;
				}
			}
		}
		
		if (body.getLuogo() != "" && body.getLuogo() != null && eventi != null) {
			for (int i=0;i<eventi.size();i++) {
				if (!((Event) eventi.get(i)).getLuogo().contains(body.getLuogo())) {
					eventi.remove(i);
					i--;
				}
			}
		}
		
		if (body.getData() != "" && body.getData() != null && eventi != null) {
			LocalDate data = LocalDate.parse(body.getData());
			System.out.println(eventi);
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
		
		if (eventi.isEmpty())
			e = new CustomException("Lista vuota");
		
		return eventi;
	}
}
