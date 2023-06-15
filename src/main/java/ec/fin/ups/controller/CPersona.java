package ec.fin.ups.controller;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.IClienteService;
import ec.fin.ups.interfaceServices.IPersonaService;
import ec.fin.ups.modelo.Cliente;
import ec.fin.ups.modelo.Persona;


@RestController
public class CPersona {

	@Autowired
	private IPersonaService personaService;

	@Operation(
			summary = "Crear una nueva persona",
			description = "Este servicio permite crear una nueva persona con la información proporcionada. Se deben incluir los datos necesarios de la persona en el cuerpo de la solicitud."
	)
	@PostMapping ("/crearPersona")
	public String save(@RequestBody Persona p) {
		personaService.save(p);
		return "ok";
	}

	@Operation(
			summary = "Obtener información de una persona por cédula",
			description = "Este servicio permite obtener información detallada de una persona utilizando su número de cédula como identificador.\n" +
					"        Se debe proporcionar la cédula de la persona como parte de la ruta de la solicitud."
	)
	@GetMapping ("/obtenerPersona/{cedula}")
	public Persona buscar(@PathVariable String cedula) {
		Persona persona=personaService.findByCedula(cedula);
		return persona;
	}

	@Operation(
			summary = "Listar todas las personas",
			description = "Este servicio permite obtener una lista de todas las personas registradas en el sistema.\n" +
					"        No se requieren parámetros adicionales en la solicitud."
	)
	@GetMapping ("/listarPersonas")
	public List<Persona> listar() {
		List<Persona> clientes=personaService.listar();
		return clientes;
	}

	@Operation(
			summary = "Actualizar información de una persona",
			description = "Este servicio permite actualizar la información de una persona existente identificada por su ID.\n" +
					"        Los parámetros de la solicitud deben incluir los datos actualizados de la persona."
	)
	@PostMapping ("/editarPersona")
	public String editar(@RequestBody Persona p) {
		personaService.save(p);
		return "ok";
	}
	
}