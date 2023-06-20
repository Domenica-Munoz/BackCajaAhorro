package ec.fin.ups.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.ICreditosService;
import ec.fin.ups.modelo.Creditos;

@RestController
@RequestMapping("/creditos")

public class CCreditos {

	@Autowired
	private ICreditosService creditosService;

	@Operation(
			summary = "Crear un nuevo credito",
			description = "Este servicio permite crear un nuevo credito con la información proporcionada. Se deben incluir los datos necesarios del credito en el cuerpo de la solicitud."
	)
	@PostMapping("/crearCredito")
	public String save(@RequestBody Creditos c) {
		creditosService.save(c);
		return "ok";
	}

	@Operation(
			summary = "Actualizar información del credito",
			description = "Este servicio permite actualizar la información del credito existente identificado por su ID.\n" +
					"        Los parámetros de la solicitud deben incluir los datos actualizados del credito."
	)
	@PostMapping("/editarCredito")
	public String editar(@RequestBody Creditos c) {
		creditosService.save(c);
		return "ok";
	}

	@Operation(
			summary = "Obtener información de un credito por su id",
			description = "Este servicio permite obtener información detallada del credito utilizando su id como identificador.\n" +
					"        Se debe proporcionar el id del cliente como parte de la ruta de la solicitud."
	)
	@GetMapping("/obtenerCredito/{id}")
	public Creditos buscar(@PathVariable int id) {
		Creditos cred = creditosService.findById(id);
		return cred;
	}

	@Operation(
			summary = "Listar todos los creditos",
			description = "Este servicio permite obtener una lista de todas los creditos registrados en el sistema.\n" +
					"        No se requieren parámetros adicionales en la solicitud."
	)
	@GetMapping("/listarCreditos")
	public List<Creditos> listar() {
		List<Creditos> creditos = creditosService.listar(); 
		return creditos;
	}

}
