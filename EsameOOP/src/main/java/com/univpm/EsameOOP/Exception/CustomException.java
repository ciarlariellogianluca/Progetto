package com.univpm.EsameOOP.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe per eccezione personalizzata, che estende Exception 
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 *
 */

@SuppressWarnings("serial") //Avvisa la mancanza di un campo serialID.
public class CustomException extends Exception{
	
	/**
	 * @param out, messaggio di errore personalizzato. 
	 */
	
	public CustomException(String out) {
		super();
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,out);
	}
	
}
