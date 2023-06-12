package ec.fin.ups.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ec.fin.ups.interfaceServices.ICuentaAhorroService;
import ec.fin.ups.interfaces.ICuentaAhorro;
import ec.fin.ups.modelo.CuentaAhorro;
import ec.fin.ups.modelo.Persona;


public class CuentaAhorroService implements ICuentaAhorroService{
	
	@Autowired
	private ICuentaAhorro data;

	@Override
	public List<CuentaAhorro> listar(){
		// TODO Auto-generated method stub
		return (List<CuentaAhorro>)data.findByAhorro("monto");
	}

	

	@Override
	public int save(CuentaAhorro cuent) {
		int res=0;
		CuentaAhorro cuenta=data.save(cuent);
		if(!cuenta.equals(null)) {}
		return 1;
	}
	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}



	@Override
	public Optional<CuentaAhorro> listarId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



	@Override
	public CuentaAhorro finCuentaAhorro(String monto) {
		// TODO Auto-generated method stub
		return null;
	}

}
