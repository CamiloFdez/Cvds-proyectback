package is.escuelaing.edu.co.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import is.escuelaing.edu.co.models.Pago;

public interface PagoRepository extends MongoRepository<Pago, String> {
    List<Pago> findByUsuarioId(String usuarioId);
}
