package is.escuelaing.edu.co.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import is.escuelaing.edu.co.models.Usuario;

class UsuarioTest {
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan Pérez", "juan.perez@example.com");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("juan.perez@example.com", usuario.getEmail());
    }

    @Test
    void testSetId() {
        usuario.setId("12345");
        assertEquals("12345", usuario.getId());
    }

    @Test
    void testSetNombre() {
        usuario.setNombre("María López");
        assertEquals("María López", usuario.getNombre());
    }

    @Test
    void testSetEmail() {
        usuario.setEmail("maria.lopez@example.com");
        assertEquals("maria.lopez@example.com", usuario.getEmail());
    }
}