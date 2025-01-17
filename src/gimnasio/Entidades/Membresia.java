
package gimnasio.Entidades;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Javier
 */
public class Membresia {
    private int id_membresia;
    private Socio id_socio;
    private String tipo;
    private int cant_pases;
    private int pases_disponibles;
    private Date fecha_inicio;
    private Date fecha_fin;
    private BigDecimal costo;
    private boolean estado;

    public Membresia() {
    }

    public Membresia(Socio id_socio, String tipo, int cant_pases, int pases_disponibles, Date fecha_inicio, Date fecha_fin, BigDecimal costo, boolean estado) {
        this.id_socio = id_socio;
        this.tipo = tipo;
        this.cant_pases = cant_pases;
        this.pases_disponibles = pases_disponibles;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.costo = costo;
        this.estado = estado;
    }

    public Membresia(int id_membresia, Socio id_socio, String tipo, int cant_pases, int pases_disponibles, Date fecha_inicio, Date fecha_fin, BigDecimal costo, boolean estado) {
        this.id_membresia = id_membresia;
        this.id_socio = id_socio;
        this.tipo = tipo;
        this.cant_pases = cant_pases;
        this.pases_disponibles = pases_disponibles;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.costo = costo;
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

    public int getCant_pases() {
        return cant_pases;
    }

    public void setCant_pases(int cant_pases) {
        this.cant_pases = cant_pases;
    }

    public int getPases_disponibles() {
        return pases_disponibles;
    }

    public void setPases_disponibles(int pases_disponibles) {
        this.pases_disponibles = pases_disponibles;
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

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Membresia{" + "id_membresia=" + id_membresia + ", id_socio=" + id_socio.getId_socio() + ", tipo=" + tipo + ", cant_pases=" + cant_pases + ", pases_disponibles=" + pases_disponibles + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", costo=" + costo + ", estado=" + estado + '}';
    }

    
    
}
