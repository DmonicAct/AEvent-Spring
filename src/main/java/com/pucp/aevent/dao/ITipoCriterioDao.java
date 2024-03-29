package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Lugar;
import com.pucp.aevent.entity.TipoCriterio;

public interface ITipoCriterioDao extends JpaRepository <TipoCriterio, Long>{
	public List<TipoCriterio> findAll();
	
	public Page<TipoCriterio> findAll(Pageable pageable);
	
	public List<TipoCriterio> findByEnabled(Boolean enabled);
	
	public Page<TipoCriterio> findByEnabled(Boolean enabled,Pageable page);
	
	public Page<TipoCriterio> findByDescripcionContainingAndEnabled(String descripcion,boolean enabled,Pageable page);
}
