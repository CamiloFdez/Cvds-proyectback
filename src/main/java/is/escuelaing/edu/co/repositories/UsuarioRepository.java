package is.escuelaing.edu.co.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import is.escuelaing.edu.co.models.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
