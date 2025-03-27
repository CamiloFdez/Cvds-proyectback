package is.escuelaing.edu.co.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import is.escuelaing.edu.co.services.PagoService;
import is.escuelaing.edu.co.models.Pago;
import is.escuelaing.edu.co.models.Articulo;
import is.escuelaing.edu.co.models.Usuario;
import is.escuelaing.edu.co.repositories.PagoRepository;
import java.util.*;

class PagoServiceTest {

    @Mock
    private PagoRepository pagoRepository;

    @InjectMocks
    private PagoService pagoService;

    private Usuario usuario;
    private List<Articulo> articulos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario("Juan Pérez", "juan.perez@example.com");
        articulos = Arrays.asList(
                new Articulo("Laptop", 1500.0, 1),
                new Articulo("Mouse", 50.0, 2)
        );
    }

    @Test
    void testRealizarPagoExitoso() {
        Pago pago = new Pago(usuario, articulos, 1600.0, "Pendiente", new Date());
        when(pagoRepository.save(any(Pago.class))).thenReturn(pago);

        Pago resultado = pagoService.realizarPago(pago);

        assertEquals("Aprobado", resultado.getEstado());
        verify(pagoRepository, times(1)).save(pago);
    }

    @Test
    void testRealizarPagoConErrorTotal() {
        Pago pago = new Pago(usuario, articulos, 1500.0, "Pendiente", new Date());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            pagoService.realizarPago(pago);
        });

        assertEquals("El total no coincide con la suma de los artículos", exception.getMessage());
        verify(pagoRepository, never()).save(any(Pago.class));
    }

    @Test
    void testConsultarPagosPorUsuario() {
        List<Pago> pagos = Arrays.asList(new Pago(usuario, articulos, 1600.0, "Aprobado", new Date()));
        when(pagoRepository.findByUsuarioId(anyString())).thenReturn(pagos);

        List<Pago> resultado = pagoService.consultarPagosPorUsuario("12345");

        assertEquals(1, resultado.size());
        assertEquals("Aprobado", resultado.get(0).getEstado());
        verify(pagoRepository, times(1)).findByUsuarioId("12345");
    }
}
