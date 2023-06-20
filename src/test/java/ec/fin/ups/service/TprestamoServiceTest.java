package ec.fin.ups.service;

import ec.fin.ups.interfaces.ITPrestamo;
import ec.fin.ups.modelo.Tprestamo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TprestamoServiceTest {

	@Mock
	private ITPrestamo data;

	@InjectMocks
	private TprestamoService service;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListar() {
		// Crea una lista simulada de objetos Tprestamo
		List<Tprestamo> tprestamoListSimulada = new ArrayList<>();
		tprestamoListSimulada.add(new Tprestamo(1, 1000f, 0.1f, 2));
		tprestamoListSimulada.add(new Tprestamo(2, 2000f, 0.2f, 4));

		// Configura el comportamiento del objeto mock 'data' para devolver la lista simulada
		when(data.findAll()).thenReturn(tprestamoListSimulada);

		// Llama al método a probar
		List<Tprestamo> resultado = service.listar();

		// Verifica que la lista devuelta sea igual a la lista simulada
		assertEquals(tprestamoListSimulada, resultado);
	}

	@Test
	public void testFindById() {
		int id = 1;
		Tprestamo tprestamoSimulado = new Tprestamo(id, 1000f, 0.1f, 2);

		// Configura el comportamiento del objeto mock 'data' para devolver el tprestamo simulado
		when(data.findById(id)).thenReturn(Optional.of(tprestamoSimulado));

		// Llama al método a probar
		Tprestamo resultado = service.findById(id);

		// Verifica que el objeto devuelto sea igual al tprestamo simulado
		assertEquals(tprestamoSimulado, resultado);
	}

	@Test
	public void testSave() {
		Tprestamo tprestamo = new Tprestamo(1, 1000f, 0.1f, 2);
		// Configura el comportamiento del objeto mock 'data' para devolver un tprestamo simulado
		when(data.save(tprestamo)).thenReturn(tprestamo);

		// Llama al método a probar
		boolean resultado = service.save(tprestamo);

		// Verifica que el resultado sea 'true'
		assertTrue(resultado);
	}

	@Test
	public void testDelete() {
		int id = 1;
		Tprestamo tprestamo = new Tprestamo(id, 1000f, 0.1f, 2);
		// Configura el comportamiento del objeto mock 'data' para devolver un tprestamo simulado al buscar por ID
		when(data.findById(id)).thenReturn(java.util.Optional.of(tprestamo));

		// Llama al método a probar
		boolean resultado = service.delete(id);

		// Verifica que el resultado sea 'true'
		assertTrue(resultado);
	}

}
