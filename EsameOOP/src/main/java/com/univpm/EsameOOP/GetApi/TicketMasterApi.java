package com.univpm.EsameOOP.GetApi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TicketMasterApi {
	
	public static JSONObject ApiData() {
		String apikey = GetApiKey();
		String data = "";
		String line = "";
		try {
			String url = "https://app.ticketmaster.com/discovery/v2/events.json?apikey="+apikey;
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();
			try {
				BufferedReader buf = new BufferedReader(new InputStreamReader(in));
				while((line=buf.readLine())!=null)
					data+=line;
			}finally {
				in.close();
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"");
		}
		JSONObject json_data = new JSONObject(data);
		return json_data;
	}
	
	private static String GetApiKey() {
		String apikey;
		try {
			BufferedReader file = new BufferedReader(new FileReader("docs/"+"apikey.txt"));
			apikey = file.readLine();
			if(apikey==null) {
				file.close();
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Inserire il token nel file.");
			}
			file.close();
		}catch(IOException e) {
			e.getStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"File non trovato.");
		}
		return apikey;
	}
}
