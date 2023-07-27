package ec.fin.ups.controller;

import ec.fin.ups.interfaceServices.IAnalistaCreditoService;
import ec.fin.ups.modelo.Analista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analista")
public class CAnalistaCredito {

    private final IAnalistaCreditoService service;

    @Autowired
    public CAnalistaCredito(IAnalistaCreditoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Analista> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Analista listarPorId(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public String crear(@RequestBody Analista analista) {
        service.save(analista);
        return "ok";
    }

    @PutMapping("/{id}")
    public String actualizar(@RequestBody Analista analista, @PathVariable("id") String id) {
        service.save(analista);
        return "ok";
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") String id) {
        service.delete(Integer.parseInt(id));
        return "ok";
    }

}
