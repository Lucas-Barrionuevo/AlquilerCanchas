package com.canchas.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table (name= "clientes")
public class Cliente {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Campo requerido")
	@Size(min = 2, max = 20, message= "Campo Requerido")
	private String nombre;
	@NotNull
	@Size(min = 2, max = 20, message= "Campo Requerido")
	private String apellido;
	@Min (value= 16, message ="No se permiten menores a 16")
	@Max(value = 110, message= "No se permiten edades que no existen")
	private int edad;
	@Email
	private String email;
	@Pattern(regexp = "[0-9]{8}", message = "Solo puede tener 8 valores numericos")
	private int dni;
	@Pattern(regexp = "[0-9]{13}", message = "Solo puede tener 8 valores numericos")
	private int celular;
	
	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, int dni, int celular, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.celular = celular;
		this.email = email;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	
}
