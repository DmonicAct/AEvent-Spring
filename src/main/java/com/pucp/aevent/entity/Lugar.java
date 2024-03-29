package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Lugar")
public class Lugar implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLugar")
	private Integer id;
	
	@Column(name="descripcion")
	private String descripcion;

	@Column(name="estado")
	private Boolean enabled;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
