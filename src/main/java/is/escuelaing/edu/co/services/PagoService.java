package is.escuelaing.edu.co.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import is.escuelaing.edu.co.models.Articulo;
import is.escuelaing.edu.co.models.Pago;
import is.escuelaing.edu.co.models.Usuario;
import is.escuelaing.edu.co.repositories.PagoRepository;


@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago realizarPago(Pago pago) {
        double totalCalculado = pago.getArticulos().stream()
                .mapToDouble(a -> a.getPrecio() * a.getCantidad())
                .sum();

        if (totalCalculado != pago.getTotal()) {
            throw new RuntimeException("El total no coincide con la suma de los artículos");
        }

        pago.setEstado("Aprobado");
        pagoRepository.save(pago);
        return pago;
    }

    public List<Pago> consultarPagosPorUsuario(String usuarioId) {
        return pagoRepository.findByUsuarioId(usuarioId);
    }
}
