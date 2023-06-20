package ec.fin.ups.interfaceServices;

import java.util.List;

import ec.fin.ups.modelo.Garantia;

public interface IGarantiaService {
	
	List<Garantia> listar ();
	Garantia findById(int id);
	Boolean save (Garantia g);
	Boolean delete (int id);

}
