package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.fin.ups.modelo.CuentaAhorro;
import ec.fin.ups.interfaces.ICuentaAhorro2;

@RestController
@RequestMapping("/cuentas-ahorro")
public class CCCuentaAhorro 
{
    @Autowired
    private ICuentaAhorro2 cuentaAhorroRepository;

    @GetMapping
    public List<CuentaAhorro> getCuentasAhorro() {
        return cuentaAhorroRepository.findAll();
    }
}
