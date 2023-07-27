package ec.fin.ups.repositories;

import ec.fin.ups.modelo.Analista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnalistaCredito extends CrudRepository<Analista, Integer> {

}
