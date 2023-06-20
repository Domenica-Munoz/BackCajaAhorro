package ec.fin.ups.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.fin.ups.interfaceServices.ITablaAmortizacionService;
import ec.fin.ups.interfaces.ITablaAmortizacion;
import ec.fin.ups.modelo.TablaAmortizacion;

@Service
public class TablaAmortizacionService implements ITablaAmortizacionService{
	
	@Autowired
	private ITablaAmortizacion data;
	
	
	public TablaAmortizacionService (ITablaAmortizacion tAmorRepo) {
		this.data=tAmorRepo;
		
	}

	@Override
	public List<TablaAmortizacion> listar() {
	
		return this.data.findAll();
	}

	@Override
	public TablaAmortizacion findById(int id) {
		// TODO Auto-generated method stub
		return data.findById(id).orElse(null);
	}

	@Override
	public Boolean save(TablaAmortizacion t) {
		// TODO Auto-generated method stub
		TablaAmortizacion tA = data.save(t);
		if (tA != null) {
			System.out.println("Crédito guardado con ID: " + tA.getId());
			return true;
		}
		System.out.println("No se pudo guardar el credito ");
		
		return false;
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		TablaAmortizacion tA = this.findById(id);
		if (tA != null) {
	        System.out.println("eliminado con éxito");
	        data.deleteById(id);
	        return true;
	    } 
	        System.out.println("No se encontró ningún  con el ID proporcionado");
	        return false;
		

	}

}
