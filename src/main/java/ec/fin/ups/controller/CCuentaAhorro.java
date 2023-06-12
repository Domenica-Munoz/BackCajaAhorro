package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.fin.ups.modelo.CuentaAhorro;
import ec.fin.ups.interfaces.ICuentaAhorro;

@RestController
@RequestMapping("/cuentas-ahorro")
public class CCuentaAhorro 
{
    @Autowired
    private ICuentaAhorro cuentaAhorroRepository;

    @GetMapping
    public List<CuentaAhorro> getCuentasAhorro() {
        return cuentaAhorroRepository.findAll();
    }
    
    @PostMapping("/{id}/depositar")
    public CuentaAhorro depositar(@PathVariable int id, @RequestBody float monto) {
        CuentaAhorro cuentaAhorro = cuentaAhorroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta de ahorro no encontrada con ID: " + id));
        
        float nuevoMonto = cuentaAhorro.getMonto() + monto;
        cuentaAhorro.setMonto(nuevoMonto);
        
        return cuentaAhorroRepository.save(cuentaAhorro);
    }

    @PostMapping("/{id}/retirar")
    public CuentaAhorro retirar(@PathVariable int id, @RequestBody float monto) {
        CuentaAhorro cuentaAhorro = cuentaAhorroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta de ahorro no encontrada con ID: " + id));
        
        float saldoActual = cuentaAhorro.getMonto();
        
        if (monto > saldoActual) {
            throw new RuntimeException("Fondos insuficientes en la cuenta de ahorro");
        }
        
        float nuevoMonto = saldoActual - monto;
        cuentaAhorro.setMonto(nuevoMonto);
        
        return cuentaAhorroRepository.save(cuentaAhorro);
    }
    
    @GetMapping("/{id}/monto")
    public float consultarMonto(@PathVariable int id) {
        CuentaAhorro cuentaAhorro = cuentaAhorroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta de ahorro no encontrada con ID: " + id));

        return cuentaAhorro.getMonto();
    }
}
