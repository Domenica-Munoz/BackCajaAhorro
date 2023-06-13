package ec.fin.ups.controller;

import ec.fin.ups.Utils.JWTUtil;
import ec.fin.ups.interfaceServices.IEstadoCuentaService;
import ec.fin.ups.modelo.EstadoCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CEstadoCuenta {

    private final IEstadoCuentaService service;
    private final JWTUtil jwtUtil;

    @Autowired
    public CEstadoCuenta(IEstadoCuentaService service, JWTUtil jwtUtil){
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    public boolean validateToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @GetMapping("/estadoCuenta")
    public List<EstadoCuenta> estadosCuenta(@RequestHeader(value = "Authorization") String token){
        if (!validateToken(token)){ return new ArrayList<>(); }
        return service.listarEstadosCuenta();
    }

    @PostMapping("/estadoCuenta")
    public String guardarEstadoCuenta(
            @RequestHeader(value = "Authorization") String token,
            EstadoCuenta estadoCuenta
    ){
        if (!validateToken(token)){ return "FAIL"; }
        service.guardarEstadoCuenta(estadoCuenta);
        return "OK";
    }

    @GetMapping("/estadoCuenta/{id}")
    public EstadoCuenta estadoCuentaById(
            @RequestHeader(value = "Authorization") String token,
            @PathVariable String id
    ){
        if (!validateToken(token)){ return null; }
        return service.buscarEstadoCuenta(Integer.parseInt(id));
    }

}
