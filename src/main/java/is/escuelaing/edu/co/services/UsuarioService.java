package is.escuelaing.edu.co.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import is.escuelaing.edu.co.models.Articulo;
import is.escuelaing.edu.co.models.Pago;
import is.escuelaing.edu.co.models.Usuario;
import is.escuelaing.edu.co.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
