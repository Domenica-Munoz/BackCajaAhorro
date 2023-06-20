package ec.fin.ups.service;

import ec.fin.ups.modelo.CuentaAhorro;
import ec.fin.ups.repositories.ICuentaAhorro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CuentaAhorroServiceTest{

	@Mock
	private ICuentaAhorro cuentaAhorroRepository;

	@InjectMocks
	private CuentaAhorroService cuentaAhorroService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSave() {
		// Simular datos de prueba
		CuentaAhorro cuentaAhorro = new CuentaAhorro();
		cuentaAhorro.setEstadoCuenta(null);
		cuentaAhorro.setCliente(null);
		cuentaAhorro.setMonto(0);
		cuentaAhorro.setFechaCreacion(null);
		cuentaAhorro.setMovimientos(null);

		// Configurar el comportamiento del mock
		when(cuentaAhorroRepository.save(cuentaAhorro)).thenReturn(cuentaAhorro);

		// Ejecutar el método a probar
		int resultado = cuentaAhorroService.save(cuentaAhorro);

		// Verificar el resultado
		assertEquals(1, resultado);

		// Verificar que se llamó al método adecuado en el mock
		verify(cuentaAhorroRepository, times(1)).save(cuentaAhorro);
	}

	@Test
	public void testDelete() {
		// Simular datos de prueba
		int id = 1;

		// Ejecutar el método a probar
		cuentaAhorroService.delete(id);

		// Verificar que se llamó al método adecuado en el mock
		verify(cuentaAhorroRepository, times(1)).deleteById(id);
	}

}
