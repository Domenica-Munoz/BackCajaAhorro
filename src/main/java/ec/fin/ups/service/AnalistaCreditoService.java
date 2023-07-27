package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.IAnalistaCreditoService;
import ec.fin.ups.modelo.Analista;
import ec.fin.ups.repositories.IAnalistaCredito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalistaCreditoService implements IAnalistaCreditoService {

    private final IAnalistaCredito repository;

    @Autowired
    public AnalistaCreditoService(IAnalistaCredito repository) {
        this.repository = repository;
    }

    @Override
    public List<Analista> listar() {
        return (List<Analista>) repository.findAll();
    }

    @Override
    public Analista findById(String id) {
        return repository.findById(Integer.valueOf(id)).orElse(null);
    }

    @Override
    public int save(Analista p) {
        repository.save(p);
        return 0;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Analista p) {
        repository.save(p);
    }
}
