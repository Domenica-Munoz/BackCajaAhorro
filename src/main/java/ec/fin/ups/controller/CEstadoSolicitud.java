package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.IEstadoSolicitudService;
import ec.fin.ups.modelo.EstadoSolicitud;



@RestController
@RequestMapping("/EstadoSolicitud")
public class CEstadoSolicitud {
	
	@Autowired
	private IEstadoSolicitudService estadoService;
	

	@PostMapping("/crearEstadoSolicitud")
	public String save(@RequestBody EstadoSolicitud es) {
		estadoService.save(es);
		return "ok";
	}
	
	@PostMapping("/editarEstadoSolicitud")
	public String editar(@RequestBody EstadoSolicitud es) {
		
		estadoService.save(es);
		return "ok";
	}
	
	@GetMapping("/obtenerEstadoSolicutd/{id}")
	public EstadoSolicitud buscar(@PathVariable int id) {
		
		return estadoService.findById(id);
		
	}

	@GetMapping("/listarEstadoSolicitud")
	public List<EstadoSolicitud> listar (){
		return estadoService.listar();
	}
	

}
