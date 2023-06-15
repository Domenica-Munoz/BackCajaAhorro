package ec.fin.ups.controller;

import java.util.List;

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

	@PostMapping("/crearCredito")
	public String save(@RequestBody Creditos c) {
		creditosService.save(c);
		return "ok";
	}

	@PostMapping("/editarCredito")
	public String editar(@RequestBody Creditos c) {
		creditosService.save(c);
		return "ok";
	}

	@GetMapping("/obtenerCredito/{id}")
	public Creditos buscar(@PathVariable int id) {
		Creditos cred = creditosService.findById(id);
		return cred;
	}

	@GetMapping("/listarCreditos")
	public List<Creditos> listar() {
		List<Creditos> creditos = creditosService.listar(); 
		return creditos;
	}

}
