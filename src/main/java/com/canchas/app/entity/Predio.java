package com.canchas.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name= "predio")
public class Predio {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min = 2, max = 20, message= "Campo Requerido")
	private String zona;
	
	@OneToMany(mappedBy = "predio" , cascade = CascadeType.ALL)
	private Set<Cancha> canchas = new HashSet<>();
	
	public Predio() {
		super();
	}

	public Predio(String zona) {
		super();
		this.zona = zona;
	}


	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Cancha> getCanchas() {
		return canchas;
	}

	public void setCanchas(Set<Cancha> canchas) {
		this.canchas = canchas;
	}

}
