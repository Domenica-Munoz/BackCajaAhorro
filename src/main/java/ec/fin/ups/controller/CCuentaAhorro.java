package ec.fin.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ec.fin.ups.interfaceServices.ICuentaAhorroService;
import ec.fin.ups.modelo.CuentaAhorro;
import io.swagger.v3.oas.annotations.Operation;


@RestController
public class CCuentaAhorro {

@Autowired
private ICuentaAhorroService cuentaa;

@Operation(
			summary = "Crear cuenta de ahorros",
			description = "Este servicio permite crear una cuenta de ahorros con los parámetros establecidos previamente.\n" +
					"        Se regresa un OK al crear la cuenta."
	)
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

@Operation(
			summary = "Listar cuentas",
			description = "Este servicio permite obtener una lista de todas las cuentas registradas en el sistema.\n" +
					"        No se requieren parámetros adicionales en la solicitud."
	)
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
