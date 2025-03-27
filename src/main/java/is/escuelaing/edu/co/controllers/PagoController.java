package is.escuelaing.edu.co.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import is.escuelaing.edu.co.models.Pago;
import is.escuelaing.edu.co.services.PagoService;


@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public Pago pagar(@RequestBody Pago pago) {
        return pagoService.realizarPago(pago);
    }

    @GetMapping("/{usuarioId}")
    public List<Pago> consultarPagos(@PathVariable String usuarioId) {
        return pagoService.consultarPagosPorUsuario(usuarioId);
    }
}
