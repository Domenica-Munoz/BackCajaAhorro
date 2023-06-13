package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.ICuentaAhorroService;
import ec.fin.ups.modelo.CuentaAhorro;


@RestController
public class CCuentaAhorro {

@Autowired
private ICuentaAhorroService cuentaa;


@PostMapping("/crearCuenta")
public String save(@RequestBody CuentaAhorro cuent) {
	cuentaa.save(cuent);
	return "ok";
}

//@GetMapping ("/obtenerCuenta/{monto}")
//public CuentaAhorro listar(@PathVariable String monto) {
	//CuentaAhorro cuenta=cuentaa.findByAhorro(monto);
	//return cuenta;
//}

@GetMapping ("/listarCuenta")
public List<CuentaAhorro> listar() {
	List<CuentaAhorro> cuentas=cuentaa.listar();
	return cuentas;
}

//@PostMapping ("/editarCuenta")
//public String editar(@RequestBody CuentaAhorro cuent) {
//	cuentaa.save(cuent);
	//return "ok";
//}
}
