package ec.fin.ups.interfaceServices;

import java.util.List;
import java.util.Optional;



import ec.fin.ups.modelo.EstadoCuenta;



public interface IEstadoCuentaService {
	public List<EstadoCuenta>listar();
	public Optional<EstadoCuenta>listarId(int id);
	public int save(EstadoCuenta esta);
	public void delete (int id);

}
