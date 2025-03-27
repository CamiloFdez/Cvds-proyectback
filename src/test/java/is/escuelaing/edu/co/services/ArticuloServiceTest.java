package is.escuelaing.edu.co.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import is.escuelaing.edu.co.services.ArticuloService;
import is.escuelaing.edu.co.models.Articulo;
import is.escuelaing.edu.co.repositories.ArticuloRepository;
import java.util.Arrays;
import java.util.List;

class ArticuloServiceTest {

    @Mock
    private ArticuloRepository articuloRepository;

    @InjectMocks
    private ArticuloService articuloService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerArticulos() {
        List<Articulo> articulos = Arrays.asList(
                new Articulo("Laptop", 1500.0, 10),
                new Articulo("Mouse", 50.0, 20)
        );
        when(articuloRepository.findAll()).thenReturn(articulos);

        List<Articulo> resultado = articuloService.obtenerArticulos();

        assertEquals(2, resultado.size());
        assertEquals("Laptop", resultado.get(0).getNombre());
        verify(articuloRepository, times(1)).findAll();
    }

    @Test
    void testCrearArticulo() {
        Articulo articulo = new Articulo("Teclado", 100.0, 15);
        when(articuloRepository.save(articulo)).thenReturn(articulo);

        Articulo resultado = articuloService.crearArticulo(articulo);

        assertNotNull(resultado);
        assertEquals("Teclado", resultado.getNombre());
        verify(articuloRepository, times(1)).save(articulo);
    }
}
