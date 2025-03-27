package is.escuelaing.edu.co.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import is.escuelaing.edu.co.models.Articulo;
import is.escuelaing.edu.co.models.Pago;
import is.escuelaing.edu.co.models.Usuario;
import is.escuelaing.edu.co.repositories.ArticuloRepository;


@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    public List<Articulo> obtenerArticulos() {
        return articuloRepository.findAll();
    }

    public Articulo crearArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }
}
