package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.ICategoriaDao;
import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.Lugar;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService{

	@Autowired
	ICategoriaDao dao;
	
	private Error error;
	
	@Override
	public Error getError() {
		return this.error;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Categoria> findAll() {
		//return dao.findAll();
		return dao.findByEnabled(true);
	}

	@Override 
	public void save(Categoria categoria) {
		this.dao.save(categoria);
	}
	
	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	public List<Categoria> findAll(Pageable page) {
		Page<Categoria> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findAll(page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}

	@Override
	public void delete(Categoria categoria) {
		this.dao.delete(categoria);
	}

	@Override
	public List<Categoria> findByEnabled(Boolean enabled) {
		return dao.findByEnabled(enabled);
	}

	@Override
	public List<Categoria> findByEnabled(Boolean enabled, Pageable page) {
		Page<Categoria> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByEnabled(enabled, page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}

	@Override
	public List<Categoria> findByDescripcionContainingAndEnabled(String descripcion, boolean enabled, Pageable page) {
		Page<Categoria> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByDescripcionContainingAndEnabled(descripcion, enabled,page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}
	
}
