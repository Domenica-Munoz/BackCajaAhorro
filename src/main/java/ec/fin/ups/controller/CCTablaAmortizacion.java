package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.ITablaAmortizacionService;
import ec.fin.ups.modelo.TablaAmortizacion;

@RestController
@RequestMapping("/TablaAmortizacion")
public class CCTablaAmortizacion {
	@Autowired
	private ITablaAmortizacionService tablaAmortizacionService;

	@PostMapping("/crearTablaAmortizacion")
	public String save(@RequestBody TablaAmortizacion a) {

		tablaAmortizacionService.save(a);

		return "ok se guardo";

	}

	@PostMapping("/editarTablaAmortizacion")
	public String editar(@RequestBody TablaAmortizacion a) {
		tablaAmortizacionService.save(a);
		return "ok se guardo";

	}

	@GetMapping("/obtenerTablaAmortizacion/{id}")
	public TablaAmortizacion buscar(@PathVariable int id) {

		TablaAmortizacion tA = tablaAmortizacionService.findById(id);
		return tA;

	}

	@GetMapping("/listarTablaA")
	public List<TablaAmortizacion> listar() {

		List<TablaAmortizacion> listar = tablaAmortizacionService.listar();

		return listar;

	}

}
