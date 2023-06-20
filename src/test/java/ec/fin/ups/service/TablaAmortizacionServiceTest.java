package ec.fin.ups.service;

import ec.fin.ups.interfaces.ITablaAmortizacion;
import ec.fin.ups.modelo.Creditos;
import ec.fin.ups.modelo.TablaAmortizacion;
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
class TablaAmortizacionServiceTest {

	@Mock
	private ITablaAmortizacion data;

	@InjectMocks
	private TablaAmortizacionService tablaAmortizacionService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListar() {
		// Crea una lista de ejemplo de TablaAmortizacion
		List<TablaAmortizacion> tablaAmortizacionList = new ArrayList<>();
		tablaAmortizacionList.add(new TablaAmortizacion(1, new Creditos()));
		tablaAmortizacionList.add(new TablaAmortizacion(2, new Creditos()));

		// Configura el comportamiento del objeto mock 'data' para devolver la lista de ejemplo
		when(data.findAll()).thenReturn(tablaAmortizacionList);

		// Llama al método a probar
		List<TablaAmortizacion> resultado = tablaAmortizacionService.listar();

		// Verifica que la lista devuelta sea la misma que la lista de ejemplo
		assertEquals(tablaAmortizacionList, resultado);
	}

	@Test
	public void testFindById() {
		// Crea un objeto de ejemplo de TablaAmortizacion
		TablaAmortizacion tablaAmortizacion = new TablaAmortizacion(1, new Creditos());
		tablaAmortizacion.setId(1);

		// Configura el comportamiento del objeto mock 'data' para devolver el objeto de ejemplo cuando se llama a findById(1)
		when(data.findById(1)).thenReturn(Optional.of(tablaAmortizacion));

		// Llama al método a probar
		TablaAmortizacion resultado = tablaAmortizacionService.findById(1);

		// Verifica que el objeto devuelto sea el mismo que el objeto de ejemplo
		assertEquals(tablaAmortizacion, resultado);
	}

	@Test
	public void testSave() {
		// Crea un objeto de ejemplo de TablaAmortizacion
		TablaAmortizacion tablaAmortizacion = new TablaAmortizacion();
		tablaAmortizacion.setId(1);

		// Configura el comportamiento del objeto mock 'data' para devolver el objeto de ejemplo cuando se llama a save()
		when(data.save(tablaAmortizacion)).thenReturn(tablaAmortizacion);

		// Llama al método a probar
		boolean resultado = tablaAmortizacionService.save(tablaAmortizacion);

		// Verifica que el resultado sea true (indicando que el objeto se guardó correctamente)
		assertTrue(resultado);

		// Verifica que el método save() del objeto mock 'data' fue llamado una vez con el objeto de ejemplo
		verify(data, times(1)).save(tablaAmortizacion);
	}

	@Test
	public void testDelete() {
		// Crea un objeto de ejemplo de TablaAmortizacion con un ID existente
		int id = 1;
		TablaAmortizacion tablaAmortizacion = new TablaAmortizacion();
		tablaAmortizacion.setId(id);

		// Configura el comportamiento del objeto mock 'data' para devolver el objeto de ejemplo cuando se llama a findById()
		when(data.findById(id)).thenReturn(java.util.Optional.of(tablaAmortizacion));

		// Llama al método a probar
		boolean resultado = tablaAmortizacionService.delete(id);

		// Verifica que el resultado sea true (indicando que el objeto se eliminó correctamente)
		assertTrue(resultado);

		// Verifica que el método findById() del objeto mock 'data' fue llamado una vez con el ID proporcionado
		verify(data, times(1)).findById(id);

		// Verifica que el método deleteById() del objeto mock 'data' fue llamado una vez con el ID proporcionado
		verify(data, times(1)).deleteById(id);
	}

}
