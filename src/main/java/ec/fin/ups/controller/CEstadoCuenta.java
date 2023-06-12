package ec.fin.ups.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ec.fin.ups.interfaceServices.IEstadoCuentaService;
import ec.fin.ups.modelo.Cliente;
import ec.fin.ups.modelo.EstadoCuenta;

public class CEstadoCuenta {
	@Autowired
	private IEstadoCuentaService estadocuenta;
	
	
	
	@PostMapping("/crearEstadoCuenta")
	public String save(@RequestBody EstadoCuenta estad) {
		estadocuenta.save(estad);
		return "ok";
	}

}
