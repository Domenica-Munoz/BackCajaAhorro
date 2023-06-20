package ec.fin.ups.interfaceServices;

import java.util.List;


import ec.fin.ups.modelo.Creditos;


public interface ICreditosService {
	
	List<Creditos> listar ();
	Creditos findById(int id);
	Boolean save (Creditos c);
	Boolean delete (int id);
	
	
}
