package com.spacetur.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection= "destino")
public class DestinoModel {

	@Id 
	private String id;
	private double valor;
	private String local;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	
}