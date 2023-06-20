package ec.fin.ups.service;

import ec.fin.ups.interfaces.IGarantia;
import ec.fin.ups.modelo.Garantia;
import org.springframework.stereotype.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
class GarantiaServiceTest {

	@Mock
	private IGarantia data;
	
	@InjectMocks
	private GarantiaService service;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListar() {
		// Crea una lista de Garantia simulada para devolverla en el método findAll()
		List<Garantia> listaSimulada = Arrays.asList(
				new Garantia(1, "Garantia 1", "Direccion 1", 1000.00f, null),
				new Garantia(2, "Garantia 2", "Direccion 2", 2000.00f, null)
		);

		// Configura el comportamiento del objeto mock 'data' para devolver la lista simulada
		when(data.findAll()).thenReturn(listaSimulada);

		// Llama al método a probar
		List<Garantia> listaObtenida = service.listar();

		// Verifica que la lista obtenida sea igual a la lista simulada
		assertEquals(listaSimulada, listaObtenida);
	}

	@Test
	public void testFindById() {
		// Crea un objeto Garantia simulado para devolverlo en el método findById()
		Garantia garantiaSimulada = new Garantia(1, "Garantia 1", "Direccion 1", 1000.00f, null);

		// Configura el comportamiento del objeto mock 'data' para devolver la garantia simulada
		when(data.findById(1)).thenReturn(Optional.of(garantiaSimulada));

		// Llama al método a probar
		Garantia garantiaObtenida = service.findById(1);

		// Verifica que la garantia obtenida sea igual a la garantia simulada
		assertEquals(garantiaSimulada, garantiaObtenida);
	}

	@Test
	public void testSave() {
		// Crea un objeto Garantia simulado para guardar
		Garantia garantiaSimulada = new Garantia(1, "Garantia 1", "Direccion 1", 1000.00f, null);

		// Configura el comportamiento del objeto mock 'data' para devolver la garantia simulada al guardar
		when(data.save(garantiaSimulada)).thenReturn(garantiaSimulada);

		// Llama al método a probar
		boolean resultado = service.save(garantiaSimulada);

		// Verifica que el resultado sea verdadero (éxito en el guardado)
		assertTrue(resultado);
	}

	@Test
	public void testDelete() {
		// Crea un objeto Garantia simulado para eliminar
		Garantia garantiaSimulada = new Garantia(1, "Garantia 1", "Direccion 1", 1000.00f, null);

		// Configura el comportamiento del objeto mock 'data' para devolver la garantia simulada al buscar por ID
		when(data.findById(1)).thenReturn(Optional.of(garantiaSimulada));

		// Llama al método a probar
		boolean resultado = service.delete(1);

		// Verifica que el resultado sea verdadero (éxito en la eliminación)
		assertTrue(resultado);
	}

}
