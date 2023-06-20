package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.IEstadoCuentaService;
import ec.fin.ups.modelo.EstadoCuenta;
import ec.fin.ups.repositories.IEstadoCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCuentaService implements IEstadoCuentaService {

    private final IEstadoCuenta repository;

    @Autowired
    public EstadoCuentaService(IEstadoCuenta repository){
        this.repository = repository;
    }


    @Override
    public List<EstadoCuenta> listarEstadosCuenta() {
        return (List<EstadoCuenta>)repository.findAll();
    }

    @Override
    public void guardarEstadoCuenta(EstadoCuenta estadoCuenta) {
        repository.save(estadoCuenta);
    }

    @Override
    public EstadoCuenta buscarEstadoCuenta(int id) {
        return repository.findById(id).orElse(null);
    }
}
