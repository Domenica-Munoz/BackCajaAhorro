package ec.fin.ups.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ec.fin.ups.modelo.EstadoCuenta;
import ec.fin.ups.repositories.IEstadoCuenta;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EstadoCuentaServiceTest {

    @Mock
    private IEstadoCuenta estadoCuentaRepository;

    @InjectMocks
    private EstadoCuentaService estadoCuentaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListarEstadosCuenta() {
        // Configurar el comportamiento simulado del repositorio
        List<EstadoCuenta> estadosCuenta = new ArrayList<>();
        estadosCuenta.add(new EstadoCuenta(1, "Estado 1"));
        estadosCuenta.add(new EstadoCuenta(2, "Estado 2"));
        when(estadoCuentaRepository.findAll()).thenReturn(estadosCuenta);

        // Ejecutar el método a probar
        List<EstadoCuenta> resultado = estadoCuentaService.listarEstadosCuenta();

        // Verificar el resultado esperado
        assertEquals(2, resultado.size());
        assertEquals("Estado 1", resultado.get(0).getDescripcion());
        assertEquals("Estado 2", resultado.get(1).getDescripcion());

        // Verificar que el método del repositorio se haya llamado correctamente
        verify(estadoCuentaRepository).findAll();
    }

    @Test
    void testGuardarEstadoCuenta() {
        // Crear un objeto de EstadoCuenta
        EstadoCuenta estadoCuenta = new EstadoCuenta(1, "Estado 1");

        // Ejecutar el método a probar
        estadoCuentaService.guardarEstadoCuenta(estadoCuenta);

        // Verificar que el método del repositorio se haya llamado correctamente
        verify(estadoCuentaRepository).save(estadoCuenta);
    }

    @Test
    void testBuscarEstadoCuenta() {
        // Configurar el comportamiento simulado del repositorio
        EstadoCuenta estadoCuenta = new EstadoCuenta(1, "Estado 1");
        when(estadoCuentaRepository.findById(1)).thenReturn(Optional.of(estadoCuenta));

        // Ejecutar el método a probar
        EstadoCuenta resultado = estadoCuentaService.buscarEstadoCuenta(1);

        // Verificar el resultado esperado
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Estado 1", resultado.getDescripcion());

        // Verificar que el método del repositorio se haya llamado correctamente
        verify(estadoCuentaRepository).findById(1);
    }
}

