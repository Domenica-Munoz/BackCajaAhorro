package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.IGarantiaService;
import ec.fin.ups.modelo.Garantia;

@RestController
@RequestMapping("/Garantia")
public class CGarantia{
	
	@Autowired
	private IGarantiaService garantiaService;
	
	@PostMapping("/crearGarantia")
	public String save (Garantia ga) {
		
		if(garantiaService.save(ga)) {
			return "ok";
		}else {
			
			return "Error: No se pudo guardar";
		}

	}
	
	@PostMapping("/editarrGarantia")
	public String editar (Garantia ga) {
		
		if(garantiaService.save(ga)) {
			return "ok";
		}else {
			
			return "Error: No se pudo guardar";
		}
	
	}
	
	@GetMapping("/buscarGarantia/{id}")
	public Garantia buscar (@PathVariable int id) {
	
		Garantia ga = garantiaService.findById(id);
		
		return ga;
		
	}
	
	@GetMapping("/listarGarantia")
	public List<Garantia> listar (){
		
		return garantiaService.listar();
		
	}
	
	
	
	


}
