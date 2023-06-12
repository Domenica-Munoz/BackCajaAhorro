package ec.fin.ups.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.fin.ups.interfaceServices.IEstadoCuentaService;
import ec.fin.ups.modelo.EstadoCuenta;
import ec.fin.ups.modelo.Persona;

@Service
public class EstadoCuentaService implements IEstadoCuentaService {
	@Autowired
	private IEstadoCuentaService data;

	@Override
	public List<EstadoCuenta> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<EstadoCuenta> listarId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int save(EstadoCuenta esta) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	

	

}
