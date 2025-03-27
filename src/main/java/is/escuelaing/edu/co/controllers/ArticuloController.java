package is.escuelaing.edu.co.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import is.escuelaing.edu.co.models.Articulo;
import is.escuelaing.edu.co.services.ArticuloService;


@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public List<Articulo> obtenerArticulos() {
        return articuloService.obtenerArticulos();
    }

    @PostMapping
    public Articulo crearArticulo(@RequestBody Articulo articulo) {
        return articuloService.crearArticulo(articulo);
    }
}
