package com.canchas.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "clientes")
public class Cliente {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int membresia;
	
	private String nombre;

	private String apellido;

	private String dni;

	private String celular;
	
	public Cliente(String nombre, String apellido, String dni, String celular) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.celular = celular;
	}
	
	public int getMembresia() {
		return membresia;
	}
	public void setMembresia(int membresia) {
		this.membresia = membresia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
