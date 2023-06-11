package ec.fin.ups.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ec.fin.ups.modelo.Cliente;

@Repository
public interface ICliente extends CrudRepository<Cliente, Integer>{

}
