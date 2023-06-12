package ec.fin.ups.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.fin.ups.modelo.Cliente;
import ec.fin.ups.modelo.EstadoCuenta;

@Repository
public interface IEstadoCuenta  extends CrudRepository<EstadoCuenta, Integer> {

;
}

