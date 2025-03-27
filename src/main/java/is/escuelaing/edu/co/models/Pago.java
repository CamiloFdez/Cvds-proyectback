package is.escuelaing.edu.co.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;
import is.escuelaing.edu.co.models.Articulo;
import is.escuelaing.edu.co.models.Usuario;


@Document(collection = "pagos")
public class Pago {
    @Id
    private String id;
    private Usuario usuario;
    private List<Articulo> articulos;
    private double total;
    private String estado;  // "Aprobado" o "Declinado"
    private Date fecha;

    public Pago() {}

    public Pago(Usuario usuario, List<Articulo> articulos, double total, String estado, Date fecha) {
        this.usuario = usuario;
        this.articulos = articulos;
        this.total = total;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Articulo> getArticulos() { return articulos; }
    public void setArticulos(List<Articulo> articulos) { this.articulos = articulos; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}
