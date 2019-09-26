package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.response_objects.Error;

public interface IPersonaService {
	Error getError();
	List<Persona> findAll();
}
