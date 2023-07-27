package ec.fin.ups.interfaceServices;

import ec.fin.ups.modelo.Analista;

import java.util.List;

public interface IAnalistaCreditoService {

    List<Analista> listar();
    Analista findById(String ced);
    int save(Analista p);
    void delete (int id);
    void update(Analista p);

}
