package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.ICreditosService;
import ec.fin.ups.interfaces.ICreditos;
import ec.fin.ups.modelo.Creditos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditosService implements ICreditosService {
	@Autowired
	private ICreditos data;
	
	
	public CreditosService(ICreditos creditosRepository) {
		this.data = creditosRepository;
	}

	@Override
	public List<Creditos> listar() {

		return this.data.findAll();
	}

	@Override
	public Creditos findById(int id) {
		return data.findById(id).orElse(null);
	}

	@Override
	public Boolean save(Creditos c) {
		Creditos nuevoCredito = data.save(c);
		if (nuevoCredito != null) {
			System.out.println("Crédito guardado con ID: " + nuevoCredito.getId());
			return true;
		}
		System.out.println("No se pudo guardar el credito ");
		
		return false;

	}

	@Override
	public Boolean delete(int id) {
	    Creditos credito = this.findById(id);
	    if (credito != null) {
	        data.deleteById(id);
	        System.out.println("Crédito eliminado con éxito");
	        return true;
	    } 
	        System.out.println("No se encontró ningún crédito con el ID proporcionado");
	        return false;
	}
	
	
	
	public String aprobarCredito(Creditos c) {

		
		
		return null;
		
	}
}
