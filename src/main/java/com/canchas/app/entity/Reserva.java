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
@Table (name= "reserva")
public class Reserva {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "cancha_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cancha canchaReservada;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idPredio")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Predio predioReservado;
	
	private double hsReservadas;
	
	private double dia;
	
	private double mes;
	
	private double año;
	
	public Reserva(int idReserva, Cancha canchaReservada, double hsReservadas, double dia, double mes, double año) {
		super();
		this.idReserva = idReserva;
		this.canchaReservada = canchaReservada;
		this.hsReservadas = hsReservadas;
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}
	
	public Predio getPredioReservado() {
		return predioReservado;
	}

	public void setPredioReservado(Predio predioReservado) {
		this.predioReservado = predioReservado;
	}

	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Cancha getCanchaReservada() {
		return canchaReservada;
	}
	public void setCanchaReservada(Cancha canchaReservada) {
		this.canchaReservada = canchaReservada;
	}
	public double getHsReservadas() {
		return hsReservadas;
	}
	public void setHsReservadas(double hsReservadas) {
		this.hsReservadas = hsReservadas;
	}
	public double getDia() {
		return dia;
	}
	public void setDia(double dia) {
		this.dia = dia;
	}
	public double getMes() {
		return mes;
	}
	public void setMes(double mes) {
		this.mes = mes;
	}
	public double getAño() {
		return año;
	}
	public void setAño(double año) {
		this.año = año;
	}
	
	
}
