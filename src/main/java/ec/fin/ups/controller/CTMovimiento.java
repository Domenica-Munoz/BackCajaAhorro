package ec.fin.ups.controller;

import ec.fin.ups.interfaceServices.ITMovimientoService;
import ec.fin.ups.modelo.Tmovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CTMovimiento {

    private final ITMovimientoService service;

    @Autowired
    public CTMovimiento(ITMovimientoService service){
        this.service = service;
    }

    @GetMapping("/movimientos")
    public List<Tmovimiento> getTMovimientos (){
        return service.listar();
    }

    @GetMapping("/movimientos/{id}")
    public Tmovimiento getTMovimientoById (@PathVariable String id){
        return service.listarId(Integer.parseInt(id));
    }

    @DeleteMapping("/movimientos/{id}")
    public void deleteTMovimiento (@PathVariable String id){
        service.delete(Integer.parseInt(id));
    }

    @PostMapping("/movimientos")
    public void saveMovimiento (@RequestBody Tmovimiento tmovimiento){
        service.save(tmovimiento);
    }

    @PutMapping("/movimientos")
    public void updateMovimiento (@RequestBody Tmovimiento tmovimiento){
        service.update(tmovimiento);
    }

}
