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
    public Boolean guardarEstadoCuenta(EstadoCuenta estadoCuenta) {
        EstadoCuenta estado = repository.save(estadoCuenta);
        if (estado != null) {
            System.out.println("EstadoCuenta Guardado");
            return true;
        }
        System.out.println("No se pudo guardar el EstadoCuenta");
        return false;
    }

    @Override
    public EstadoCuenta buscarEstadoCuenta(int id) {
        return repository.findById(id).orElse(null);
    }
}
