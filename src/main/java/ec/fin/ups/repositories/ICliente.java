package ec.fin.ups.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.fin.ups.modelo.Cliente;

@Repository
public interface ICliente extends CrudRepository<Cliente, Integer>{
	
	@Query(value = "select c.* from cliente c inner join persona p on c.pesonaid=p.id where p.cedula = :cedula", nativeQuery = true)
    Cliente findByCedula(@Param("cedula") String cedula);
}
