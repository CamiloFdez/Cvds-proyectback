package is.escuelaing.edu.co.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import is.escuelaing.edu.co.models.Pago;
import is.escuelaing.edu.co.models.Usuario;
import is.escuelaing.edu.co.models.Articulo;
import java.util.*;

class PagoTest {
    private Pago pago;
    private Usuario usuario;
    private List<Articulo> articulos;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        articulos = Arrays.asList(
                new Articulo("Laptop", 1500.0, 1),
                new Articulo("Mouse", 50.0, 2)
        );
        pago = new Pago(usuario, articulos, 1600.0, "Aprobado", new Date());
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(usuario, pago.getUsuario());
        assertEquals(articulos, pago.getArticulos());
        assertEquals(1600.0, pago.getTotal());
        assertEquals("Aprobado", pago.getEstado());
        assertNotNull(pago.getFecha());
    }

    @Test
    void testSetId() {
        pago.setId("12345");
        assertEquals("12345", pago.getId());
    }

    @Test
    void testSetUsuario() {
        Usuario nuevoUsuario = new Usuario();
        pago.setUsuario(nuevoUsuario);
        assertEquals(nuevoUsuario, pago.getUsuario());
    }

    @Test
    void testSetArticulos() {
        List<Articulo> nuevosArticulos = Collections.singletonList(new Articulo("Teclado", 100.0, 1));
        pago.setArticulos(nuevosArticulos);
        assertEquals(nuevosArticulos, pago.getArticulos());
    }

    @Test
    void testSetTotal() {
        pago.setTotal(1700.0);
        assertEquals(1700.0, pago.getTotal());
    }

    @Test
    void testSetEstado() {
        pago.setEstado("Declinado");
        assertEquals("Declinado", pago.getEstado());
    }

    @Test
    void testSetFecha() {
        Date nuevaFecha = new Date();
        pago.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, pago.getFecha());
    }
}
