package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.IEstadoSolicitudService;
import ec.fin.ups.interfaces.IEstadoSolicitud;
import ec.fin.ups.modelo.EstadoSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadoSolicitudService implements IEstadoSolicitudService{
	@Autowired
	private IEstadoSolicitud data;
	
	
	public EstadoSolicitudService(IEstadoSolicitud repo) {
		this.data=repo;
		
	}
	

	@Override
	public List<EstadoSolicitud> listar() {
		// TODO Auto-generated method stub
		return data.findAll();
	}

	@Override
	public EstadoSolicitud findById(int id) {
		// TODO Auto-generated method stub
		
		return data.findById(id).orElse(null);
	}

	@Override
	public Boolean save(EstadoSolicitud es) {
		// TODO Auto-generated method stub
		EstadoSolicitud estadoS = data.save(es);
	    if (estadoS != null) {
	 
	        System.out.println("EstadoSolicitud Guardado");
	        return true;
	    } 
	        System.out.println("No se pudo guardar el EstadoSolicitud");
	        return false;
		
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		EstadoSolicitud estadoS= this.findById(id);
	    if (estadoS != null) {
	    	
	    	data.deleteById(id);
	   	 
	        System.out.println("EstadoSolicitud Eliminado");
	        return true;
	    } 
	        System.out.println("No se pudo eliminar el EstadoSolicitud");
	        return false;
		

	}

}
