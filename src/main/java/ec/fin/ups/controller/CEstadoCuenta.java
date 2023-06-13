package ec.fin.ups.controller;

import ec.fin.ups.interfaceServices.IEstadoCuentaService;
import ec.fin.ups.modelo.EstadoCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CEstadoCuenta {

    private final IEstadoCuentaService service;


    @Autowired
    public CEstadoCuenta(IEstadoCuentaService service){
        this.service = service;
    }



    @GetMapping("/estadoCuenta")
    public List<EstadoCuenta> estadosCuenta(){
        return service.listarEstadosCuenta();
    }

    @PostMapping("/estadoCuenta")
    public void guardarEstadoCuenta(EstadoCuenta estadoCuenta){
        service.guardarEstadoCuenta(estadoCuenta);
    }

    @GetMapping("/estadoCuenta/{id}")
    public EstadoCuenta estadoCuentaById(@PathVariable String id){
        return service.buscarEstadoCuenta(Integer.parseInt(id));
    }

}
