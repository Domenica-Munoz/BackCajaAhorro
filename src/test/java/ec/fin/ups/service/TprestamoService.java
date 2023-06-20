package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.ITPrestamoService;
import ec.fin.ups.interfaces.ITPrestamo;
import ec.fin.ups.modelo.Tprestamo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TprestamoService implements ITPrestamoService{
	
	private ITPrestamo data;

	@Override
	public List<Tprestamo> listar() {
		// TODO Auto-generated method stub
		return data.findAll();
	}

	@Override
	public Tprestamo findById(int id) {
		// TODO Auto-generated method stub
		return data.findById(id).orElse(null);
	}

	@Override
	public Boolean save(Tprestamo es) {
		// TODO Auto-generated method stub
		Tprestamo Tp= data.save(es);
		if(Tp!=null) {
			
			return true;
			
		}else {
			return false;
			
		}
		
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		Tprestamo Tp= this.findById(id);
		if(Tp!=null) {
			
			data.deleteById(id);
			
			return true;
			
		}else {
			return false;
			
		}
	}

}
