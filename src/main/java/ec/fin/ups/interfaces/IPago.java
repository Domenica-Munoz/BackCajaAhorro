package ec.fin.ups.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.fin.ups.modelo.Pago;

public interface IPago extends JpaRepository<Pago,Integer>{

}
