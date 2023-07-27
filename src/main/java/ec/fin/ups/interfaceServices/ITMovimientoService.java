package ec.fin.ups.interfaceServices;

import ec.fin.ups.modelo.Tmovimiento;

import java.util.List;

public interface ITMovimientoService {

    List<Tmovimiento> listar();
    Tmovimiento listarId(int id);
    Tmovimiento save(Tmovimiento p);

    void update(Tmovimiento p);

    void delete(int id);

}
