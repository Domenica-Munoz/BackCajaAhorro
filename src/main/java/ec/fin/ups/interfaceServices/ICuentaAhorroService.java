package ec.fin.ups.interfaceServices;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.fin.ups.modelo.CuentaAhorro;

public interface ICuentaAhorroService {
	public List<CuentaAhorro>listar();
	public CuentaAhorro finCuentaAhorro(String monto);
	public  Optional<CuentaAhorro>listarId(int id);
	public int save(CuentaAhorro cuen);
	public void delete (int id);
}
