package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Usuario;
public interface IPersonaDao  extends JpaRepository <Persona, Long>{
	public List<Persona> findAll();
	
	public Persona findByUsername(String username);
	
	public Persona findByIdUsuario(int idUsuario);
//	
//	public Boolean existsByDni(String dni);
//	
	public List<Persona> findByEnabled(Boolean enabled);
	
	//@Query("Select p from Persona p where p.nombre like :nombre%")
	public List<Persona> findByNombreStartsWith(String nombre);
	
	//@Query("Select p from Persona p,Usuario u where (p.nombre like :nombre% or p.appaterno like :nombre% or p.apmaterno like :nombre%) and p.idUsuario = u.idUsuario and u.enabled =1")
	public Page<Persona> findByNombreCompletoContaining(String nombre,Pageable page);
	
	//@Query("Select p from Persona p,Usuario u where p.idUsuario = u.idUsuario and u.username like :username% and u.enabled=1")
	public Page<Persona> findByUsernameContaining(String username,Pageable page);
	
	public Page<Persona> findByEmailContaining(String email,Pageable page);
	
	public Page<Persona> findByEnabledAndIdUsuarioNotIn(Boolean enabled, List<Integer> ids,Pageable page);
	
	public Page<Persona> findByIdUsuarioIn(List<Integer> ids,Pageable page);
	
	public Page<Persona> findByIdUsuarioNotIn(List<Integer >ids, Pageable page);
	public List<Persona> findByIdUsuarioNotIn(List<Integer >ids);
	public List<Persona> findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(List<Integer> ids,String role,boolean enabled);
	
	public Page<Persona> findByNombreCompletoContainingAndEnabled(String nombre,boolean enabled,Pageable page);
	public Page<Persona> findByEmailContainingAndEnabled(String email,boolean enabled,Pageable page);
	public Page<Persona> findByUsernameContainingAndEnabled(String username,boolean enabled,Pageable page);
}
