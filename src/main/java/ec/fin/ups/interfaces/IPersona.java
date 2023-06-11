package ec.fin.ups.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.fin.ups.modelo.Persona;


@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{
	
	@Query(value = "SELECT * FROM persona WHERE cedula = :cedula", nativeQuery = true)
    Persona findByCedula(@Param("cedula") String cedula);
}
