
package gimnasio.Entidades;

import java.sql.Date;

/**
 *
 * @author Javier
 */
public class Membresia {
    private int id_membresia;
    private Socio id_socio;
    private String tipo;
    private Date fecha_inicio;
    private Date fecha_fin;
    private boolean estado;

    public Membresia() {
    }

    public Membresia(Socio id_socio, String tipo, Date fecha_inicio, Date fecha_fin, boolean estado) {
        this.id_socio = id_socio;
        this.tipo = tipo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    public Membresia(int id_membresia, Socio id_socio, String tipo, Date fecha_inicio, Date fecha_fin, boolean estado) {
        this.id_membresia = id_membresia;
        this.id_socio = id_socio;
        this.tipo = tipo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    public int getId_membresia() {
        return id_membresia;
    }

    public void setId_membresia(int id_membresia) {
        this.id_membresia = id_membresia;
    }

    public Socio getId_socio() {
        return id_socio;
    }

    public void setId_socio(Socio id_socio) {
        this.id_socio = id_socio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
