package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "PROPUESTA")
@NamedQueries({ @NamedQuery(name = "Propuesta.findAll", query = "SELECT p FROM Propuesta p") })
public class Propuesta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPropuesta")
	private Integer idPropuesta;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idEvento",referencedColumnName = "idEvento")
	private Evento evento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPostulante",referencedColumnName = "idUsuario")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario postulante;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_postulacion")
	private Date fecha_postulacion= new Date();
	
	@Column(name = "fase_actual")
	private Long fase_actual;
		
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "estado")
	private String estado;
	
	@Transient
	private List<Persona> evaluadoresAsignados;
		
	private static final long serialVersionUID = 1L;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Persona> getEvaluadoresAsignados() {
		return evaluadoresAsignados;
	}

	public void setEvaluadoresAsignados(List<Persona> evaluadoresAsignados) {
		this.evaluadoresAsignados = evaluadoresAsignados;
	}

	public Usuario getPostulante() {
		return this.postulante;
	}

	public void setPostulante(Usuario postulante) {
		this.postulante = postulante;
	}

	public Date getFecha_postulacion() {
		return fecha_postulacion;
	}

	public void setFecha_postulacion(Date fecha_postulacion) {
		this.fecha_postulacion = fecha_postulacion;
	}

	public Integer getIdPropuesta() {
		return idPropuesta;
	}

	public void setIdPropuesta(Integer idPropuesta) {
		this.idPropuesta = idPropuesta;
	}

	public Long getFase_actual() {
		return fase_actual;
	}

	public void setFase_actual(Long fase_actual) {
		this.fase_actual = fase_actual;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
