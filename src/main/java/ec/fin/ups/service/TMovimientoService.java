package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.ITMovimientoService;
import ec.fin.ups.interfaces.ITMovimiento;
import ec.fin.ups.modelo.Tmovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMovimientoService implements ITMovimientoService {

    private final ITMovimiento repository;

    @Autowired
    public TMovimientoService(ITMovimiento repository){
        this.repository = repository;
    }

    @Override
    public List<Tmovimiento> listar() {
        return repository.findAll();
    }

    @Override
    public Tmovimiento listarId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Tmovimiento save(Tmovimiento p) {
        if (p != null) {
            System.out.println("Movimiento Guardado");
            return repository.save(p);
        }
        return null;
    }

    @Override
    public void update(Tmovimiento p) {
        if (repository.findById(p.getId()).orElse(null) != null){
            repository.save(p);
        }
    }

    @Override
    public void delete(int id) {
        if (repository.findById(id).orElse(null) != null){
            repository.deleteById(id);
        }
    }
}
