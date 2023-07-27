package ec.fin.ups.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.fin.ups.interfaceServices.ISolicitudCreditoService;
import ec.fin.ups.interfaces.ISolicitudCredito;
import ec.fin.ups.modelo.SolicitudCredito;
@Service
public class SolicitudCreditoService implements ISolicitudCreditoService {
	
	@Autowired
	private ISolicitudCredito data;
	
	public SolicitudCreditoService (ISolicitudCredito repo) {
		this.data=repo;
	}

	@Override
	public List<SolicitudCredito> listar() {
		// TODO Auto-generated method stub
		return (List<SolicitudCredito>)data.findAll();
		
	}

	@Override
	public SolicitudCredito findById(int id) {
		// TODO Auto-generated method stub
		return data.findById(id).orElse(null);
	}

	@Override
	public Boolean save(SolicitudCredito sc) {
		// TODO Auto-generated method stub
		SolicitudCredito s = data.save(sc);
		if (s != null) {
			System.out.println("Solicitud guardada con ID: " + s.getId());
			return true;
		}
		System.out.println("No se pudo guardar la solicitud ");
		
		return false;
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		SolicitudCredito s = this.findById(id);
	    if (s != null) {
	        data.deleteById(id);
	        System.out.println("Solicitud de credito eliminado con éxito");
	        return true;
	    } 
	        System.out.println("No se encontró ningúna solicitud con el ID proporcionado");
	        return false;
	}

}
