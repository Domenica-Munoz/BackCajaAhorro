package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.IGarantiaService;
import ec.fin.ups.interfaces.IGarantia;
import ec.fin.ups.modelo.Garantia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarantiaService implements IGarantiaService{
	
	@Autowired
	private IGarantia data;

	@Override
	public List<Garantia> listar() {
		// TODO Auto-generated method stub
		return data.findAll();
	}

	@Override
	public Garantia findById(int id) {
		// TODO Auto-generated method stub
		return data.findById(id).orElse(null);
	}

	@Override
	public Boolean save(Garantia g) {
		// TODO Auto-generated method stub
		Garantia ga = data.save(g);
		
	    if (ga != null) {
	   	 
	        System.out.println("GarantiaGuardado");
	        return true;
	    } 
	        System.out.println("No se pudo guardar el Garantia");
	        return false;
		
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		
		Garantia ga = this.findById(id);
		
	    if (ga != null) {
	    	
	    	data.delete(ga);
	   	 
	        System.out.println("GarantiaElminada");
	        return true;
	    } 
	        System.out.println("No se pudo Eliminar el Garantia No se pudoe encontrar");
	        return false;
		
	}

}
