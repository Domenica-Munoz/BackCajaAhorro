package ec.fin.ups.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.IClienteService;
import ec.fin.ups.modelo.Cliente;

@RestController
public class CCliente {
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/crearCliente")
	public String save(@RequestBody Cliente cli) {
		clienteService.save(cli);
		return "ok";
	}
	
	@GetMapping ("/obtenerCliente/{id}")
	public Optional<Cliente> listar(@PathVariable int id) {
		Optional<Cliente> cliente=clienteService.listarId(id);
		return cliente;
	}
	
	@GetMapping ("/listarClientes")
	public List<Cliente> listar() {
		List<Cliente> clientes=clienteService.listar();
		return clientes;
	}
}
