package ec.fin.ups.service;



import java.util.List;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash = argon2.hash(1, 1024, 1, p.getPassword().toCharArray());
		p.setPassword(hash);
		Persona persona=data.save(p);
		if(!persona.equals(null)) {}
		return 1;
	}
	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

	@Override
	public Persona getUserByEmailPassword(String email, String password) {
		Persona p = data.findByCorreo(email);

		if (p == null){
			return null;
		}

		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		if (argon2.verify(p.getPassword(), password.toCharArray())){
			return p;
		}
		return null;
	}
}
