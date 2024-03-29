package com.pucp.aevent.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.pucp.aevent.entity.response_objects.Estado;
import com.pucp.aevent.entity.response_objects.ResponseObject;
import com.pucp.aevent.service.IPersonaService;
import com.pucp.aevent.service.IUsuarioService;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.request_objects.PaginaRequest;


@RestController
@RequestMapping("/api")
public class UsuarioApi {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IPersonaService personaService;
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(path = "/usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarUsuario(@PathVariable("id") Integer id) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario lista = this.usuarioService.findById(id);
			response.setResultado(lista);
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
	
	//@Secured({"ROLE_ADMIN"})
	@GetMapping(path = "/usuarios/byUsername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarUsuario(@PathVariable("username") String username) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario lista = this.usuarioService.findByUsername(username);
			response.setResultado(lista);
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
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(path = "/usuarios/active", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarAllUsuariosActiveP(PaginaRequest page) {
		ResponseObject response = new ResponseObject();
		try {
			List<Usuario> lista = this.usuarioService.findAllActive(PageRequest.of(page.getPaginaFront(), page.getRegistros()));
			response.setResultado(lista);
			response.setPaginacion(usuarioService.getPaginacion());
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
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(path = "/usuarios/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarAllUsuariosInactiveP(PaginaRequest page) {
		ResponseObject response = new ResponseObject();
		try {
			List<Usuario> lista = this.usuarioService.findAllInactive(PageRequest.of(page.getPaginaFront(), page.getRegistros()));
			response.setResultado(lista);
			response.setPaginacion(usuarioService.getPaginacion());
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
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(path = "/usuarios/all/active", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarAllUsuariosActive() {
		ResponseObject response = new ResponseObject();
		try {
			List<Usuario> lista = this.usuarioService.findAllActive();
			response.setResultado(lista);
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
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(path = "/usuarios/all/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarAllUsuariosInactive() {
		ResponseObject response = new ResponseObject();
		try {
			List<Usuario> lista = this.usuarioService.findAllInactive();
			response.setResultado(lista);
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

	@Secured({"ROLE_ADMIN"})
	@PostMapping(path = "/usuarios",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> guardarUsuario( @Valid @RequestBody Persona persona) {
		ResponseObject response = new ResponseObject();
		try {
			String nombreCompleto = persona.getNombre() + ' ' + persona.getAppaterno();
			if(persona.getApmaterno() != null)
				nombreCompleto = nombreCompleto + ' ' + persona.getApmaterno();
			persona.setNombreCompleto(nombreCompleto);
			this.usuarioService.save(persona);
			//response.setResultado(lista);
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
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping(path = "/usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> eliminarUsuario(@PathVariable("id") Integer id) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario usuario = usuarioService.findById(id);
			usuario.setEnabled(false);
			this.usuarioService.cambioUsuario(usuario);
			
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
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping(path = "/usuarios/activate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> reactivarUsuario(@PathVariable("id") Integer id) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario usuario = usuarioService.findById(id);
			usuario.setEnabled(true);
			this.usuarioService.cambioUsuario(usuario);
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
		
	
	
	//@Secured({"ROLE_ADMIN"})
		@GetMapping(path = "/usuarios/out/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseObject> consultarEmail(@PathVariable("email") String email) {
			ResponseObject response = new ResponseObject();
			try {
				Boolean resultado= this.usuarioService.existsByEmail(email);
				response.setResultado(resultado);
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
		
//		@GetMapping(path = "/usuarios/out/dni/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<ResponseObject> consultarDni(@PathVariable("dni") String dni) {
//			ResponseObject response = new ResponseObject();
//			try {
//				Boolean resultado= this.personaService.existsByDni(dni);
//				response.setResultado(resultado);
//				response.setEstado(Estado.OK);
//				return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
//			} catch(BadRequest e) {
//				//response.setError(this.service.getError());
//				response.setEstado(Estado.ERROR);
//				return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
//			} catch(InternalServerError e) {
//				//response.setError(this.service.getError());
//				response.setEstado(Estado.ERROR);
//				return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//			} catch(Exception e) {
//				response.setError(1, "Error Interno", e.getMessage());
//				response.setEstado(Estado.ERROR);
//				return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
		
		@GetMapping(path = "/usuarios/out/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseObject> consultarUsername(@PathVariable("username") String username) {
			ResponseObject response = new ResponseObject();
			try {
				Boolean resultado= this.usuarioService.existsByUsername(username);
				response.setResultado(resultado);
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
		
		@PostMapping(path = "/usuarios/out",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseObject> guardarUsuarioOut( @Valid @RequestBody Persona persona) {
			ResponseObject response = new ResponseObject();
			try {
				String nombreCompleto = persona.getNombre() + ' ' + persona.getAppaterno();
				if(persona.getApmaterno() != null)
					nombreCompleto = nombreCompleto + ' ' + persona.getApmaterno();
				persona.setNombreCompleto(nombreCompleto);
				this.usuarioService.saveOut(persona);
				//response.setResultado(lista);
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
