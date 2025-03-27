package is.escuelaing.edu.co.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import is.escuelaing.edu.co.services.UsuarioService;
import is.escuelaing.edu.co.models.Usuario;
import is.escuelaing.edu.co.repositories.UsuarioRepository;
import java.util.Arrays;
import java.util.List;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerUsuarios() {
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Juan Pérez", "juan.perez@example.com"),
                new Usuario("María López", "maria.lopez@example.com")
        );
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> resultado = usuarioService.obtenerUsuarios();

        assertEquals(2, resultado.size());
        assertEquals("Juan Pérez", resultado.get(0).getNombre());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testCrearUsuario() {
        Usuario usuario = new Usuario("Carlos Gómez", "carlos.gomez@example.com");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario resultado = usuarioService.crearUsuario(usuario);

        assertNotNull(resultado);
        assertEquals("Carlos Gómez", resultado.getNombre());
        verify(usuarioRepository, times(1)).save(usuario);
    }
}
