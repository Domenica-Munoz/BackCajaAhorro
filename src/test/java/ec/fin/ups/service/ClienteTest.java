package ec.fin.ups.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import ec.fin.ups.modelo.Banco;
import ec.fin.ups.modelo.Cliente;
import ec.fin.ups.modelo.CuentaAhorro;
import ec.fin.ups.modelo.Persona;
import ec.fin.ups.repositories.ICliente;

@ExtendWith(MockitoExtension.class)
public class ClienteTest {
	
	@Mock
	private ICliente clienteservisiorepositorio;
	
	@InjectMocks
	private ClienteService clienteservicio;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void savecliente() {
	
		
		Cliente client=new Cliente();
		client.setId(1);
		client.setIngresos(2367);
		client.setPersona(null);
		
		
when(clienteservisiorepositorio.save(client)).thenReturn(client);
		
		int persona1=clienteservicio.save(client);
		
		assertEquals(1,persona1 );
		verify(clienteservisiorepositorio,times(1)).save(client);
		
	}
	
	@Test
	public void ListarCliente() {
		List<Cliente> listacliente= new ArrayList<>();
		listacliente.add(new Cliente(1, 2367, new Persona()));
		listacliente.add(new Cliente(2, 2367, new Persona()));


		when(clienteservisiorepositorio.findAll()).thenReturn(listacliente);

		List<Cliente> listarcliente1= clienteservicio.listar();

		assertEquals(listacliente, listarcliente1);
	}
	
	

}
