package ec.fin.ups.interfaceServices;

import java.util.List;

import ec.fin.ups.modelo.SolicitudCredito;



public interface ISolicitudCreditoService {
	
	List<SolicitudCredito> listar ();
	SolicitudCredito findById(int id);
	Boolean save (SolicitudCredito sc);
	Boolean delete (int id);

}
