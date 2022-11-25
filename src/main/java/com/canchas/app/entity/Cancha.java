package com.canchas.app.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
@Table (name= "canchas")
public class Cancha {
	@Column
	@Id
	private int id;
	
	private double valor;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "predio_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Predio predio;
	
	public Cancha() {
		super();
	}
	public Cancha(int id, double valor, Predio predio) {
		super();
		this.id = id;
		this.valor = valor;
		this.predio = predio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	} 
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Predio getPredio() {
		return predio;
	}
	public void setPredio(Predio predio) {
		this.predio = predio;
	}
	
}
