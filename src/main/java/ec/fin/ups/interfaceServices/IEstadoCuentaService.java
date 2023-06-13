package ec.fin.ups.interfaceServices;

import ec.fin.ups.modelo.EstadoCuenta;

import java.util.List;

public interface IEstadoCuentaService {

    public List<EstadoCuenta> listarEstadosCuenta();
    public void guardarEstadoCuenta(EstadoCuenta estadoCuenta);
    public EstadoCuenta buscarEstadoCuenta(int id);

}
