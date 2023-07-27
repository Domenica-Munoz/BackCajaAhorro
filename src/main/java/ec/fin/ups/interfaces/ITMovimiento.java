package ec.fin.ups.interfaces;

import ec.fin.ups.modelo.Tmovimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITMovimiento extends JpaRepository<Tmovimiento, Integer> {
}
