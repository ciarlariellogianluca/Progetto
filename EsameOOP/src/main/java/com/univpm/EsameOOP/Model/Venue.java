package com.univpm.EsameOOP.Model;

/**
 * Classe che estende Events e modella le sedi.
 * @author Gianluca Ciarlariello
 * @author Gianmarco Di Renzo
 *
 */

public class Venue extends Events{
	
	private String luogo;
	private String citta;
	private String indirizzo;
	private String numero;
	private String info_pagamento;
	
	public Venue() {
		super();
		this.luogo = null;
		this.citta = null;
		this.indirizzo = null;
		this.numero = null;
		this.info_pagamento = null;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getInfo_pagamento() {
		return info_pagamento;
	}

	public void setInfo_pagamento(String info_pagamento) {
		this.info_pagamento = info_pagamento;
	}

}
