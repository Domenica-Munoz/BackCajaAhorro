package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.ICuentaAhorroService;
import ec.fin.ups.interfaces.ICuentaAhorro;
import ec.fin.ups.modelo.CuentaAhorro;
import ec.fin.ups.service.CuentaAhorroService;


@RestController
public class CCuentaAhorro {

@Autowired
private ICuentaAhorro cuentaa;


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

//@GetMapping ("/listarCuenta")
//public List<CuentaAhorro> listar() {
	//List<CuentaAhorro> cuenta=cuentaa.list;
	//return cuenta;
//}

//@PostMapping ("/editarCuenta")
//public String editar(@RequestBody CuentaAhorro cuent) {
//	cuentaa.save(cuent);
	//return "ok";
//}
}
