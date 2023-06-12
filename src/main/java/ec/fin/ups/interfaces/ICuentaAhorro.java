package ec.fin.ups.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.fin.ups.modelo.CuentaAhorro;
import ec.fin.ups.modelo.Persona;

@Repository
public interface ICuentaAhorro extends CrudRepository<CuentaAhorro, Integer>{

	@Query(value = "SELECT * FROM cuentaahorro WHERE monto = :monto", nativeQuery = true)
    CuentaAhorro findByAhorro(@Param("monto") String monto);

	

	
}
