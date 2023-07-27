package ec.fin.ups.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.fin.ups.modelo.Creditos;

public interface ICreditos extends JpaRepository<Creditos, Integer> {
	

}
