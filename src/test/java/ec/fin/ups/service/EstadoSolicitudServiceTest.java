package ec.fin.ups.service;

import ec.fin.ups.interfaces.IEstadoSolicitud;
import ec.fin.ups.modelo.EstadoSolicitud;

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
class EstadoSolicitudServiceTest {

	@Mock
	private IEstadoSolicitud data;

	@InjectMocks
	private EstadoSolicitudService estadoSolicitudService;

	@BeforeEach
	void setUp() {MockitoAnnotations.initMocks(this);}

	@Test
	public void listar() {
		// Configurar el comportamiento del mock
		List<EstadoSolicitud> estadoSolicitudList = new ArrayList<>();
		estadoSolicitudList.add(new EstadoSolicitud(1, "Pendiente"));
		estadoSolicitudList.add(new EstadoSolicitud(2, "Aprobado"));

		when(data.findAll()).thenReturn(estadoSolicitudList);

		// Llamar al método a probar
		List<EstadoSolicitud> result = estadoSolicitudService.listar();

		// Verificar el resultado
		assertNotNull(result);
		assertEquals(estadoSolicitudList.size(), result.size());
	}

	@Test
	public void findById() {
		// Configurar el comportamiento del mock
		int id = 1;
		EstadoSolicitud estadoSolicitud = new EstadoSolicitud(id, "Pendiente");
		when(data.findById(id)).thenReturn(Optional.of(estadoSolicitud));

		// Llamar al método a probar
		EstadoSolicitud result = estadoSolicitudService.findById(id);

		// Verificar el resultado
		assertNotNull(result);
		assertEquals(id, result.getId());
	}

	@Test
	public void save() {
		// Configurar el comportamiento del mock
		EstadoSolicitud estadoSolicitud = new EstadoSolicitud(1, "Pendiente");
		when(data.save(estadoSolicitud)).thenReturn(estadoSolicitud);

		// Llamar al método a probar
		boolean result = estadoSolicitudService.save(estadoSolicitud);

		// Verificar el resultado
		assertTrue(result);
	}

	@Test
	public void testDelete() {
		// Datos de prueba
		int id = 1;
		EstadoSolicitud estado = new EstadoSolicitud();
		estado.setId(id);

		// Configurar el comportamiento del mock
		when(data.findById(id)).thenReturn(Optional.of(estado));

		// Ejecutar el método a probar
		boolean resultado = estadoSolicitudService.delete(id);

		// Verificar el resultado
		assertTrue(resultado);
		verify(data, times(1)).deleteById(id);
		// Aquí puedes agregar más verificaciones según sea necesario
	}

}
