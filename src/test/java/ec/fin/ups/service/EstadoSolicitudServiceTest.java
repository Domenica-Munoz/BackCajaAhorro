package ec.fin.ups.service;

import ec.fin.ups.interfaceServices.IEstadoSolicitudService;
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

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class EstadoSolicitudServiceTest {

	@Mock
	private IEstadoSolicitudService estadoSolicitudRepository;

	@InjectMocks
	private EstadoSolicitudService estadoSolicitudService;

	@BeforeEach
	void setUp() {MockitoAnnotations.initMocks(this);}

	public void testListar() {
		// Datos de prueba
		EstadoSolicitud estado1 = new EstadoSolicitud();
		EstadoSolicitud estado2 = new EstadoSolicitud();
		List<EstadoSolicitud> estados = Arrays.asList(estado1, estado2);

		// Configurar el comportamiento del mock
		when(estadoSolicitudRepository.listar()).thenReturn(estados);

		// Ejecutar el método a probar
		List<EstadoSolicitud> resultado = estadoSolicitudService.listar();

		// Verificar el resultado
		assertEquals(estados, resultado);
		verify(estadoSolicitudRepository, times(1)).listar();
	}

	@Test
	public void testFindById() {
		// Datos de prueba
		int id = 1;
		EstadoSolicitud estado = new EstadoSolicitud();

		// Configurar el comportamiento del mock
		when(estadoSolicitudRepository.findById(id)).thenReturn(estado);

		// Ejecutar el método a probar
		EstadoSolicitud resultado = estadoSolicitudService.findById(id);

		// Verificar el resultado
		assertEquals(estado, resultado);
		verify(estadoSolicitudRepository, times(1)).findById(id);
		// Aquí puedes agregar más verificaciones según sea necesario
	}

	@Test
	public void testSave() {
		// Datos de prueba
		EstadoSolicitud estado = new EstadoSolicitud();

		// Configurar el comportamiento del mock
		when(estadoSolicitudRepository.save(estado)).thenReturn(true);

		// Ejecutar el método a probar
		boolean resultado = estadoSolicitudService.save(estado);

		// Verificar el resultado
		assertTrue(resultado);
		verify(estadoSolicitudRepository, times(1)).save(estado);
		// Aquí puedes agregar más verificaciones según sea necesario
	}

	@Test
	public void testDelete() {
		// Datos de prueba
		int id = 1;
		EstadoSolicitud estado = new EstadoSolicitud();
		estado.setId(id);

		// Configurar el comportamiento del mock
		when(estadoSolicitudRepository.findById(id)).thenReturn(estado);

		// Ejecutar el método a probar
		boolean resultado = estadoSolicitudService.delete(id);

		// Verificar el resultado
		assertTrue(resultado);
		verify(estadoSolicitudRepository, times(1)).delete(id);
		// Aquí puedes agregar más verificaciones según sea necesario
	}

}
