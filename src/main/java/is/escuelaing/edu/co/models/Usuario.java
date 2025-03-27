package is.escuelaing.edu.co.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import is.escuelaing.edu.co.models.Articulo;
import is.escuelaing.edu.co.models.Pago;


@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String email;

    public Usuario() {}

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
