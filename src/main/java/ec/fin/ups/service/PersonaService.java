package ec.fin.ups.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.fin.ups.interfaceServices.IPersonaService;
import ec.fin.ups.repositories.IPersona;
import ec.fin.ups.modelo.Persona;

@Service
public class PersonaService implements IPersonaService {
	
	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return (List<Persona>)data.findAll();
	}

	@Override
	public Persona findByCedula(String ced) {
		
		return data.findByCedula(ced);
	}

	@Override
	public int save(Persona p) {
		int res=0;
		Persona persona=data.save(p);
		if(!persona.equals(null)) {}
		return 1;
	}
	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}
}
