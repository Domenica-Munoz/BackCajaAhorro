package ec.fin.ups.interfaceServices;

import java.util.List;

import ec.fin.ups.modelo.TablaAmortizacion;


public interface ITablaAmortizacionService {
	
	List<TablaAmortizacion> listar ();
	TablaAmortizacion findById(int id);
	Boolean save (TablaAmortizacion t);
	Boolean delete (int id);

}
