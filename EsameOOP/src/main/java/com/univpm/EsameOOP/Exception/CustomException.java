package com.univpm.EsameOOP.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SuppressWarnings("serial")
public class CustomException extends Exception{
	
	public CustomException(String out) {
		super();
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,out);
	}
	
}
