package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.IPagoService;
import ec.fin.ups.modelo.Pago;

@RestController
@RequestMapping("/Pagos")
public class CPagos {
	@Autowired
	private IPagoService pagoService; 
	
	@PostMapping("/crearPago")
	public String save (Pago p){
		
		pagoService.save(p);
		return "ok";

	}
	
	@PostMapping("/editarPago")
	public String editar(@RequestBody Pago p) {
		
		pagoService.save(p);
		return "ok";
		
	}
	
	@GetMapping("/obtenerPago/{id}")
	public Pago buscar(@PathVariable int id) {
		Pago pago= pagoService.findById(id);
		return pago;
	}
	
	@GetMapping("/listarCreditos")
	public List<Pago> listar() {
		List<Pago> creditos = pagoService.listar(); 
		return creditos;
	}

	
	

}
