package ec.fin.ups.service;

import ec.fin.ups.interfaces.ISolicitudCredito;
import ec.fin.ups.modelo.SolicitudCredito;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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

@ExtendWith(MockitoExtension.class)
class SolicitudCreditoServiceTest {

	@Mock
	private ISolicitudCredito data;

	@InjectMocks
	private SolicitudCreditoService solicitudCreditoService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListar() {
		// Crea una lista de ejemplo de SolicitudCredito
		List<SolicitudCredito> listaSolicitudes = Arrays.asList(
				new SolicitudCredito(),
				new SolicitudCredito(),
				new SolicitudCredito()
		);

		// Configura el comportamiento del objeto mock 'data' para devolver la lista de ejemplo cuando se llama a findAll()
		when(data.findAll()).thenReturn(listaSolicitudes);

		// Llama al método a probar
		List<SolicitudCredito> resultado = solicitudCreditoService.listar();

		// Verifica que el resultado no sea nulo
		assertNotNull(resultado);

		// Verifica que el tamaño del resultado sea igual al tamaño de la lista de ejemplo
		assertEquals(listaSolicitudes.size(), resultado.size());

		// Verifica que el método findAll() del objeto mock 'data' fue llamado una vez
		verify(data, times(1)).findAll();
	}

	@Test
	public void testFindById() {
		int id = 1;
		SolicitudCredito solicitud = new SolicitudCredito();
		solicitud.setId(id);

		// Configura el comportamiento del objeto mock 'data' para devolver la solicitud de ejemplo cuando se llama a findById()
		when(data.findById(id)).thenReturn(Optional.of(solicitud));

		// Llama al método a probar
		SolicitudCredito resultado = solicitudCreditoService.findById(id);

		// Verifica que el resultado no sea nulo
		assertNotNull(resultado);

		// Verifica que el ID del resultado coincida con el ID esperado
		assertEquals(id, resultado.getId());

		// Verifica que el método findById() del objeto mock 'data' fue llamado una vez con el ID esperado
		verify(data, times(1)).findById(id);
	}

	@Test
	public void testSave() {
		SolicitudCredito solicitud = new SolicitudCredito();

		// Configura el comportamiento del objeto mock 'data' para devolver la solicitud guardada correctamente
		when(data.save(solicitud)).thenReturn(solicitud);

		// Llama al método a probar
		boolean resultado = solicitudCreditoService.save(solicitud);

		// Verifica que el resultado sea true, indicando que la solicitud se guardó correctamente
		assertTrue(resultado);

		// Verifica que el método save() del objeto mock 'data' fue llamado una vez con la solicitud
		verify(data, times(1)).save(solicitud);
	}

	@Test
	public void testDelete() {
		int id = 1;

		// Configura el comportamiento del objeto mock 'data' para devolver la solicitud encontrada
		when(data.findById(id)).thenReturn(Optional.of(new SolicitudCredito()));

		// Llama al método a probar
		boolean resultado = solicitudCreditoService.delete(id);

		// Verifica que el resultado sea true, indicando que la solicitud se eliminó correctamente
		assertTrue(resultado);

		// Verifica que el método deleteById() del objeto mock 'data' fue llamado una vez con el ID proporcionado
		verify(data, times(1)).deleteById(id);
	}

}
