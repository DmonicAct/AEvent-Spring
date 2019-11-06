package com.pucp.aevent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;

public interface IPreferenciaDao extends JpaRepository <Preferencia, Long> {
//	public List<Preferencia> findByUsuario(Usuario user);
	public List<Preferencia> findByIdUsuario(int idUsuario);
//	public Preferencia findByUsuarioAndPropuesta(Usuario user,Propuesta prop);
}