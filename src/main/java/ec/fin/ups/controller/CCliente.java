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
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.IClienteService;
import ec.fin.ups.modelo.Cliente;
import ec.fin.ups.modelo.Persona;

@RestController
public class CCliente {
	@Autowired
	private IClienteService clienteService;

	@Operation(
			summary = "Crear un nuevo cliente",
			description = "Este servicio permite crear un nuevo cliente con la información proporcionada. Se deben incluir los datos necesarios del cliente en el cuerpo de la solicitud."
	)
	@PostMapping("/crearCliente")
	public String save(@RequestBody Cliente cli) {
		clienteService.save(cli);
		return "ok";
	}

	@Operation(
			summary = "Obtener información de un cliente por cédula",
			description = "Este servicio permite obtener información detallada del cliente utilizando su número de cédula como identificador.\n" +
					"        Se debe proporcionar la cédula del cliente como parte de la ruta de la solicitud."
	)
	@GetMapping ("/obtenerCliente/{cedula}")
	public Cliente listar(@PathVariable String cedula) {
		Cliente cliente=clienteService.findByCedula(cedula);
		return cliente;
	}

	@Operation(
			summary = "Listar todos los clientes",
			description = "Este servicio permite obtener una lista de todas los clientes registrados en el sistema.\n" +
					"        No se requieren parámetros adicionales en la solicitud."
	)
	@GetMapping ("/listarClientes")
	public List<Cliente> listar() {
		List<Cliente> clientes=clienteService.listar();
		return clientes;
	}

	@Operation(
			summary = "Actualizar información del cliente",
			description = "Este servicio permite actualizar la información del cliente existente identificado por su ID.\n" +
					"        Los parámetros de la solicitud deben incluir los datos actualizados del cliente."
	)
	@PostMapping ("/editarCliente")
	public String editar(@RequestBody Cliente cli) {
		clienteService.save(cli);
		return "ok";
	}
}
