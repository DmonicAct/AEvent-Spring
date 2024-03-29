package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USUARIO")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private int idUsuario;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=6, max=20, message="el tama�o tiene que estar entre 6 y 20")
	@Column(unique = true, length = 20, name="usuario")
	private String username;
	
	@Column(length = 60, name="contrasena")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Column(length = 30,name="usuarioActivo")
	private Boolean enabled;
	
	@NotEmpty(message ="no puede estar vacio")
	@Email(message="no es una dirección de correo bien formada")
	@Column(length = 30,name="correo")
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fechaCreacion")
	private Date fechaCreacion= new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fechaModificacion")
	private Date fechaModificacion= new Date();
	
	@Column(length = 90, name="nombre_completo")
	private String nombreCompleto;

	@Column(name="modoInicioSesion")
	private Integer modoInicioSesion;
	
	@Column(name="eval_sin_leer")
	private Boolean evaluacionSinLeer;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuario_role", joinColumns= @JoinColumn(name="idUsuario"),
	inverseJoinColumns=@JoinColumn(name="idRol"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"idUsuario", "idRol"})})
	private List<Role> roles;
	
	public Boolean getEvaluacionSinLeer() {
		return evaluacionSinLeer;
	}


	public void setEvaluacionSinLeer(Boolean evaluacionSinLeer) {
		this.evaluacionSinLeer = evaluacionSinLeer;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public Integer getModoInicioSesion() {
		return modoInicioSesion;
	}


	public void setModoInicioSesion(Integer modoInicioSesion) {
		this.modoInicioSesion = modoInicioSesion;
	}


	public int getIdUsuario() {
		return idUsuario;
	}
	

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	//Fechas de creacion y modificacion
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	@PreUpdate
	public void setLastUpdate() {  this.fechaModificacion = new Date(); }
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
