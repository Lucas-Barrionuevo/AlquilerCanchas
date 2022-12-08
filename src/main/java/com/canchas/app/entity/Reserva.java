package com.canchas.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	@JoinColumn(name = "idCancha")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cancha canchaReservada;
	@DateTimeFormat (pattern = "dd/mm/yyyy  hh:mm")
	private LocalDateTime fechaHora;
	
	private double hsReservadas;
	
	private double valor; 
	
	private boolean cliente;
	
	public Reserva() {
		super();
	}

	public Reserva( Cancha canchaReservada, double hsReservadas, LocalDateTime fechaHora, boolean cliente, double valor) {
		super();
		this.canchaReservada = canchaReservada;
		this.fechaHora = fechaHora;
		this.valor = valor;
		this.cliente = cliente;
	}

	public boolean getCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
}
