package ec.fin.ups.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/crearPersona")
	public String save(@RequestBody Persona p) {
		personaService.save(p);
		return "ok";
	}
	
	@GetMapping ("/obtenerPersona/{id}")
	public Optional<Persona> listar(@PathVariable int id) {
		Optional<Persona> personas=personaService.listarId(id);
		return personas;
	}
	
}