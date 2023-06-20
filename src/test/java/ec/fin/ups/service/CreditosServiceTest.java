package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.ICreditosService;
import ec.fin.ups.interfaces.ICreditos;
import ec.fin.ups.modelo.Creditos;

import ec.fin.ups.modelo.EstadoSolicitud;
import ec.fin.ups.modelo.SolicitudCredito;
import ec.fin.ups.modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CreditosServiceTest {

	@Mock
	private ICreditos data;

	@InjectMocks
	private CreditosService creditosService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListar() {
		// Configurar el comportamiento del mock
		List<Creditos> creditosList = new ArrayList<>();
		creditosList.add(new Creditos(1, new SolicitudCredito(), new Usuario(), 'a', 10));
		creditosList.add(new Creditos(2, new SolicitudCredito(), new Usuario(), 'a', 10));

		when(data.findAll()).thenReturn(creditosList);

		// Llamar al método a probar
		List<Creditos> result = creditosService.listar();

		// Verificar el resultado
		assertNotNull(result);
		assertEquals(creditosList.size(), result.size());
	}

	@Test
	public void findById() {
		// Configurar el comportamiento del mock
		int id = 1;
		Creditos creditos = new Creditos(id, new SolicitudCredito(), new Usuario(), 'a', 10);
		when(data.findById(id)).thenReturn(Optional.of(creditos));

		// Llamar al método a probar
		Creditos result = creditosService.findById(id);

		// Verificar el resultado
		assertNotNull(result);
		assertEquals(id, result.getId());
	}

	@Test
	public void save() {
		// Configurar el comportamiento del mock
		Creditos creditos = new Creditos(1, new SolicitudCredito(), new Usuario(), 'a', 10);
		when(data.save(creditos)).thenReturn(creditos);
		when(data.save(creditos)).thenReturn(creditos);

		// Llamar al método a probar
		boolean result = creditosService.save(creditos);

		// Verificar el resultado
		assertTrue(result);
	}

	@Test
	public void testDelete() {
		// Datos de prueba
		int id = 1;
		Creditos creditos = new Creditos(id, new SolicitudCredito(), new Usuario(), 'a', 10);

		// Configurar el comportamiento del mock
		when(data.findById(id)).thenReturn(Optional.of(creditos));

		// Ejecutar el método a probar
		boolean resultado = creditosService.delete(id);

		// Verificar el resultado
		assertTrue(resultado);
		verify(data, times(1)).deleteById(id);
		// Aquí puedes agregar más verificaciones según sea necesario
	}



	public String aprobarCredito(Creditos c) {
		// TODO Auto-generated method stub
		return null;

	}
}
