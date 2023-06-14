package ec.fin.ups.interfaceServices;

import java.util.List;

import ec.fin.ups.modelo.EstadoSolicitud;



public interface IEstadoSolicitudService {
	
	List<EstadoSolicitud> listar ();
	EstadoSolicitud findById(int id);
	Boolean save (EstadoSolicitud es);
	Boolean delete (int id);

}
