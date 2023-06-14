package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.ITPrestamoService;
import ec.fin.ups.modelo.Tprestamo;

@RestController
@RequestMapping("/Tprestamo")

public class CTprestamo {
	
	@Autowired
	private ITPrestamoService prestamoService;
	
	@PostMapping("/crearTPrestamo")
	public String save (Tprestamo tp) {
		
		if(prestamoService.save(tp)) {
			
			return "ok";
		}else {
			
			return "Error: No se pudo guardar";
		}
	}
	
	@PostMapping("/editarTPrestamo")
	public String editar (Tprestamo tp) {
		
		if(prestamoService.save(tp)) {
			
			return "ok";
		}else {
			
			return "Error: No se pudo guardar";
		}
	}
	
	@GetMapping("/buscarTPrestamo/{id}")
	public Tprestamo buscar (@PathVariable int id) {
		
		return  prestamoService.findById(id);
		
	}
	
	@GetMapping("/listar")
	public List<Tprestamo> listar (){
		
		return prestamoService.listar();	
		
	}
	
	
	
	
	
	

}
