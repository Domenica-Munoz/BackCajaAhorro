package ec.fin.ups.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.fin.ups.modelo.Persona;


@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{

}
