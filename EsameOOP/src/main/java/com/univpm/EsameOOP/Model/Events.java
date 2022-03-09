package com.univpm.EsameOOP.Model;

public abstract class Events {
	
	private String id;
	private String sito; 
	private String tipo; 
	private String nome; 
	
	public Events() {
		this.id = null;
		this.sito = null;
		this.tipo = null;
		this.nome = null;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSito() {
		return sito;
	}
	
	public void setSito(String sito) {
		this.sito = sito;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
