package ec.fin.ups.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ec.fin.ups.modelo.EstadoSolicitud;
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
    private IEstadoCuenta data;

    @InjectMocks
    private EstadoCuentaService estadoCuentaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listar() {
        // Configurar el comportamiento del mock
        List<EstadoCuenta> estadoCuentasList = new ArrayList<>();
        estadoCuentasList.add(new EstadoCuenta(1, "Pendiente"));
        estadoCuentasList.add(new EstadoCuenta(2, "Aprobado"));

        // Llamar al método a probar
        List<EstadoCuenta> result = estadoCuentaService.listarEstadosCuenta();

        // Verificar el resultado
        assertNotNull(result);
        assertNotEquals(estadoCuentasList.size(), result.size());
    }

    @Test
    public void save() {
        // Configurar el comportamiento del mock
        EstadoCuenta estadoCuenta = new EstadoCuenta(1, "Pendiente");

        // Llamar al método a probar
        boolean result = estadoCuentaService.guardarEstadoCuenta(estadoCuenta);

        // Verificar el resultado
        assertFalse(result);
    }

    @Test
    void testBuscarEstadoCuenta() {
        // Configurar el comportamiento del mock
        int id = 1;
        EstadoCuenta estadoCuenta = new EstadoCuenta(id, "Pendiente");

        // Llamar al método a probar
        EstadoCuenta result = estadoCuentaService.buscarEstadoCuenta(id);

        // Verificar el resultado
        assertNull(result);
    }
}

