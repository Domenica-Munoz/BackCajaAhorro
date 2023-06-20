package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.ICreditosService;
import ec.fin.ups.modelo.Creditos;

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

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreditosServiceTest {

	@Mock
	private ICreditosService creditosServiceRepository;

	@InjectMocks
	private CreditosService creditosService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListar() {
		// Simular datos de prueba
		List<Creditos> listaCreditos = List.of(
				new Creditos(1, new SolicitudCredito(), new Usuario(), 'a', 0),
				new Creditos(2, new SolicitudCredito(), new Usuario(), 'b', 0)
		);

		// Configurar el comportamiento del mock
		when(creditosServiceRepository.listar()).thenReturn(listaCreditos);

		// Ejecutar el método a probar
		List<Creditos> resultado = creditosService.listar();

		// Verificar el resultado
		assertEquals(listaCreditos, resultado);
	}

	@Test
	public void testFindById() {
		int id = 1;
		Creditos credito = new Creditos(id, new SolicitudCredito(), new Usuario(), 'a', 0);

		// Configurar el comportamiento del mock
		when(creditosServiceRepository.findById(id)).thenReturn(credito);

		Creditos resultado = creditosService.findById(id);

		assertNotNull(resultado);

		// Ejecutar el método a probar
		assertEquals(id, resultado.getId());

		// Verificar el resultado
		verify(creditosServiceRepository, times(1)).findById(id);
	}

	@Test
	public void testSave() {
		Creditos credito = new Creditos(1, null, null, 'a', 0);

		// Configurar el comportamiento del mock
		when(creditosServiceRepository.save(credito)).thenReturn(true);

		// Ejecutar el método a probar
		Boolean resultado = creditosService.save(credito);

		// Verificar el resultado
		assertTrue(resultado);
		verify(creditosServiceRepository, times(1)).save(credito);
		// Aquí puedes agregar más verificaciones según sea necesario
	}

	@Test
	public void testDelete() {
		int id = 1;

		// Configurar el comportamiento del mock
		Creditos credito = new Creditos();
		credito.setId(id);
		when(creditosServiceRepository.findById(id)).thenReturn(credito);

		// Ejecutar el método a probar
		Boolean resultado = creditosService.delete(id);

		// Verificar el resultado
		assertTrue(resultado);
		verify(creditosServiceRepository, times(1)).delete(id);
		// Aquí puedes agregar más verificaciones según sea necesario
	}
	
	
	
	public String aprobarCredito(Creditos c) {
		// TODO Auto-generated method stub
		return null;
		
	}
}
