package ec.fin.ups.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
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

	@Operation(
			summary = "Crear una nueva solicitud",
			description = "Este servicio permite crear una nueva solicitud según los datos proporcionados.\n" +
					"        Se espera recibir un objeto JSON en el cuerpo de la solicitud que contenga la información de la solicitud a crear."
	)
	@PostMapping("/crearSolicitud")
	public String save (SolicitudCredito sc) {
		
		if(solicitudService.save(sc)) {
			
			return "ok";
			
		}else {
			
			return "No se pudo crear la solicitud";
		}
	}

	@Operation(
			summary = "Editar una solicitud existente",
			description = "Este servicio permite editar una solicitud existente utilizando su identificador único.\n" +
					"        Se espera recibir un objeto JSON en el cuerpo de la solicitud que contenga los datos actualizados de la solicitud."
	)
	@PostMapping("/editarSolicitud")
	public String editar (SolicitudCredito sc) {
		
		if(solicitudService.save(sc)) {
			
			return "ok";
			
		}else {
			
			return "No se pudo editar la solicitud";
		}
	}

	@Operation(
			summary = "Obtener una solicitud por su identificador",
			description = "Este servicio permite obtener los detalles de una solicitud existente utilizando su identificador único.\n" +
					"        Se debe proporcionar el identificador de la solicitud como parámetro en la URL."
	)
	@GetMapping ("/obtenerSolicitud/{id}")
	public SolicitudCredito buscar (int id) {
		
		return solicitudService.findById(id);
		
	}

	@Operation(
			summary = "Listar todas las solicitudes",
			description = "Este servicio permite obtener una lista de todas las solicitudes registradas en el sistema.\n" +
					"        Retorna un arreglo de objetos JSON, donde cada objeto representa una solicitud con sus detalles correspondientes."
	)
	@GetMapping("/listarSolicitudes")
	public List<SolicitudCredito> listar(){

		return solicitudService.listar();
	}
	
	
	
	
}
