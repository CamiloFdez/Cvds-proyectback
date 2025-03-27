package is.escuelaing.edu.co.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import is.escuelaing.edu.co.models.Articulo;

class ArticuloTest {
    private Articulo articulo;

    @BeforeEach
    void setUp() {
        articulo = new Articulo("Laptop", 1500.0, 10);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Laptop", articulo.getNombre());
        assertEquals(1500.0, articulo.getPrecio());
        assertEquals(10, articulo.getCantidad());
    }

    @Test
    void testSetNombre() {
        articulo.setNombre("Smartphone");
        assertEquals("Smartphone", articulo.getNombre());
    }

    @Test
    void testSetPrecio() {
        articulo.setPrecio(999.99);
        assertEquals(999.99, articulo.getPrecio());
    }

    @Test
    void testSetCantidad() {
        articulo.setCantidad(5);
        assertEquals(5, articulo.getCantidad());
    }

    @Test
    void testSetId() {
        articulo.setId("12345");
        assertEquals("12345", articulo.getId());
    }
}