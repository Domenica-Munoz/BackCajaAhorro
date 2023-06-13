package ec.fin.ups.interfaceServices;

import java.util.List;

import ec.fin.ups.modelo.Pago;

public interface IPagoService {
	List<Pago> listar ();
	Pago findById(int id);
	Boolean save (Pago p);
	Boolean delete (int id);

}
