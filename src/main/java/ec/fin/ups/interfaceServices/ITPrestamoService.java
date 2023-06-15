package ec.fin.ups.interfaceServices;

import java.util.List;

import ec.fin.ups.modelo.Tprestamo;
public interface ITPrestamoService {
	
	List<Tprestamo> listar ();
	Tprestamo findById(int id);
	Boolean save (Tprestamo es);
	Boolean delete (int id);


}
