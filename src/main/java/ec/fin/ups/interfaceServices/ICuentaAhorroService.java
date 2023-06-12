package ec.fin.ups.interfaceServices;

import java.util.List;
import java.util.Optional;

import ec.fin.ups.modelo.CuentaAhorro;
import ec.fin.ups.modelo.Persona;

public interface ICuentaAhorroService {
	public List<CuentaAhorro>listar();
	public CuentaAhorro finCuentaAhorro(String monto);
	public  Optional<CuentaAhorro>listarId(int id);
	public int save(CuentaAhorro cuen);
	public void delete (int id);
}
