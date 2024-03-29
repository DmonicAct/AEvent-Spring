package com.pucp.aevent.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.RespuestaFormulario;

public interface IPostulacionDao  extends JpaRepository <Postulacion, Long>{
	Postulacion findByIdPostulacionAndIdEvento(Long idUsuario,Long idEvento);
	
	Page<Postulacion> findByIdUsuario(Long idUsuario,Pageable page);
	
	Boolean existsByIdUsuarioAndIdEvento(Long idUsuario,Long idEvento);
	
	List<Postulacion> findByIdPropuesta(Long idPropuesta);
	
	Postulacion findByIdPostulacion(Long idPostulacion);
	
	List<Postulacion> findByEstado(String estado);
	
	List<Postulacion> findByEstadoAndIdEventoIn(String estado, List<Long> lista);

	Postulacion findByIdPropuestaAndIdFase(Long idPropuesta, Long idFase);
}
