package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.IPagoService;
import ec.fin.ups.interfaces.IPago;
import ec.fin.ups.modelo.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PagoService  implements IPagoService{
	
	@Autowired
	private IPago data;

	public PagoService(IPago dataRepo) {
		this.data=dataRepo;

	}

	@Override
	public List<Pago> listar() {
		
		return this.data.findAll();
	}

	@Override
	public Pago findById(int id) {
		// TODO Auto-generated method stub
		return data.findById(id).orElse(null);
	}

	@Override
	public Boolean save(Pago p) {
		// TODO Auto-generated method stub
		Pago pa = data.save(p);
		if (pa != null) {
			System.out.println("guardado con ID: " + pa.getId());
			return true;
		}
		System.out.println("No se pudo guardar");
		
		return false;
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		Pago pago = this.findById(id);
		if (pago != null) {
	        System.out.println("eliminado con éxito");
	        data.deleteById(id);
	        return true;
			
		}
		
		return false;
	}
	

}
