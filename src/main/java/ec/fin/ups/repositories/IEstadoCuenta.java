package ec.fin.ups.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.fin.ups.modelo.EstadoCuenta;

@Repository
public interface IEstadoCuenta  extends CrudRepository<EstadoCuenta, Integer> {
}

