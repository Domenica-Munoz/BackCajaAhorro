package ec.fin.ups.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import ec.fin.ups.interfaceServices.IPersonaService;
import ec.fin.ups.interfaces.IPersona;
import ec.fin.ups.modelo.Persona;

@org.springframework.stereotype.Service
public class PersonaService implements IPersonaService {
	
	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		
		return data.findById(id);
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
