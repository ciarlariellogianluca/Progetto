package com.univpm.EsameOOP.Model;

public class Venue extends Events{
	
	private String luogo;
	private String città;
	private String indirizzo;
	private String numero;
	private String info_pagamento;
	
	public Venue() {
		super();
		this.luogo = null;
		this.città = null;
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
	
	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
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
