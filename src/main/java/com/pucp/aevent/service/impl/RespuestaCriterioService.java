package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IRespuestaCriterioDao;
import com.pucp.aevent.entity.RespuestaCriterio;
import com.pucp.aevent.service.IRespuestaCriterioService;

@Service
public class RespuestaCriterioService implements IRespuestaCriterioService {

	@Autowired
	IRespuestaCriterioDao respuestaCriterioDao;

	@Override
	public List<RespuestaCriterio> findByCriterio(int id) {
		return respuestaCriterioDao.findByIdCriterio(id);
	}

	@Override
	public RespuestaCriterio save(RespuestaCriterio respuestaCriterio) {
		return respuestaCriterioDao.save(respuestaCriterio);
	}

	@Override
	public List<RespuestaCriterio> findByIdEvaluador(int idEvaluador, int idCriterio) {
		return respuestaCriterioDao.findByIdCriterioAndIdEvaluador(idCriterio, idEvaluador);
	}
}
