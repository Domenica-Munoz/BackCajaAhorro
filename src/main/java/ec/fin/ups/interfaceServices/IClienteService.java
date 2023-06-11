package ec.fin.ups.interfaceServices;

import java.util.List;
import java.util.Optional;

import ec.fin.ups.modelo.Cliente;

public interface IClienteService {
	public List<Cliente>listar();
	public Optional<Cliente>listarId(int id);
	public int save(Cliente p);
	public void delete (int id);
}
