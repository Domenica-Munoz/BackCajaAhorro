package ec.fin.ups.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.fin.ups.modelo.CuentaAhorro;

public interface ICuentaAhorro extends JpaRepository<CuentaAhorro, Integer> {

}
