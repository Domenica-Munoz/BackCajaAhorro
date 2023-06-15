package ec.fin.ups.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.fin.ups.modelo.TablaAmortizacion;

public interface ITablaAmortizacion extends JpaRepository<TablaAmortizacion,Integer> {

}
