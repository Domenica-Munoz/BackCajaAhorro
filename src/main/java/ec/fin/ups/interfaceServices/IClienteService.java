package ec.fin.ups.interfaceServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ec.fin.ups.interfaces.IPersona;
import ec.fin.ups.modelo.Cliente;

public interface IClienteService {
	public List<Cliente>listar();
	public Cliente findByCedula(String ced);
	public int save(Cliente p);
	public void delete (int id);
}
