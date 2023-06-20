package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.IClienteService;
import ec.fin.ups.modelo.Cliente;
import ec.fin.ups.repositories.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{
	@Autowired
	private ICliente data;
	
	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return (List<Cliente>)data.findAll();
	}

	@Override
	public Cliente findByCedula(String cedula) {
		
		return data.findByCedula(cedula);
	}

	@Override
	public int save(Cliente cli) {
		int res=0;
		Cliente cliente=data.save(cli);
		if(!cliente.equals(null)) {}
		return 1;
	}
	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}
}
