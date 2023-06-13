package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.ISolicitudCreditoService;
import ec.fin.ups.modelo.SolicitudCredito;

@RestController
@RequestMapping("/solicitudCredito")
public class CSolicitudCredito {
	
	@Autowired
	private ISolicitudCreditoService solicitudService;
	
	@PostMapping("/crearSolicitud")
	public String save (SolicitudCredito sc) {
		
		if(solicitudService.save(sc)) {
			
			return "ok";
			
		}else {
			
			return "No se pudo crear la solicitud";
		}
	}
	
	@PostMapping("/editarSolicitud")
	public String editar (SolicitudCredito sc) {
		
		if(solicitudService.save(sc)) {
			
			return "ok";
			
		}else {
			
			return "No se pudo editar la solicitud";
		}
	}
	
	@GetMapping ("/obtenerSolicitud/{id}")
	public SolicitudCredito buscar (int id) {
		
		return solicitudService.findById(id);
		
	}
	

	@GetMapping("/listarSolicitudes")
	public List<SolicitudCredito> listar(){

		return solicitudService.listar();
	}
	
	
	
	
}
