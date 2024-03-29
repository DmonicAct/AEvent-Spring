package com.pucp.aevent.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.pucp.aevent.entity.ListaFormulario;
import com.pucp.aevent.entity.response_objects.Estado;
import com.pucp.aevent.entity.response_objects.ResponseObject;
import com.pucp.aevent.service.IDivisionService;
import com.pucp.aevent.service.IPreguntaService;
import com.pucp.aevent.service.ISeccionService;

@RestController
@RequestMapping("/api")
public class FromularioApi {
	@Autowired
	IPreguntaService servicePregunta;
	
	@Autowired
	ISeccionService serviceSeccion;
	
	@Autowired
	IDivisionService serviceDivision;
	
	@Secured({"ROLE_ORGANIZER"})
	@PostMapping(path = "/formulario/eliminar",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> eliminar(@RequestBody ListaFormulario lista) {
		ResponseObject response = new ResponseObject();
		try {
			for(Long idPregunta: lista.getListaPregunta()) {
				this.servicePregunta.deleteByIdPregunta(idPregunta);
			}
			for(Long idSeccion: lista.getListaSeccion()) {
				this.serviceSeccion.deleteByIdSeccion(idSeccion);
			}
			for(Long idDivision: lista.getListaDivision()) {
				this.serviceDivision.deleteByIdDivision(idDivision);
			}
			response.setEstado(Estado.OK);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
		} catch(BadRequest e) {
			//response.setError(this.service.getError());
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
		} catch(InternalServerError e) {
			//response.setError(this.service.getError());
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(Exception e) {
			response.setError(1, "Error Interno", e.getMessage());
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
