package com.canchas.app.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private int tipoDeCancha; 
	@Column(nullable = false)
	private double valorXHora;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "predio_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Predio predio;
	
	public Cancha() {
		super();
	}
	public Cancha(int id, double valorXHora, Predio predio, int tipoDeCancha) {
		super();
		this.id = id;
		this.tipoDeCancha = tipoDeCancha;
		this.valorXHora = valorXHora;
		this.predio = predio;
	}
	
	public int getTipoDeCancha() {
		return tipoDeCancha;
	}
	public void setTipoDeCancha(int tipoDeCancha) {
		this.tipoDeCancha = tipoDeCancha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorXHora() {
		return valorXHora;
	} 
	public void setValorXHora(double valorXHora) {
		this.valorXHora = valorXHora;
	}
	public Predio getPredio() {
		return predio;
	}
	public void setPredio(Predio predio) {
		this.predio = predio;
	}
	
}
