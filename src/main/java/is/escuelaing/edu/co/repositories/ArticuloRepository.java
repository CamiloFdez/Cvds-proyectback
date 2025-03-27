package is.escuelaing.edu.co.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import is.escuelaing.edu.co.models.Articulo;

public interface ArticuloRepository extends MongoRepository<Articulo, String> {
}
