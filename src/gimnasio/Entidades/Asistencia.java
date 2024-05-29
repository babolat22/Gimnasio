
package gimnasio.Entidades;

/**
 *
 * @author Javier
 */
public class Asistencia {
    private int id_asistencia;
    private int cant_asistencias;
    private Socio id_socio;
    private Clase id_clase;
    private boolean estado;

    public Asistencia() {
    }

    public Asistencia(int cant_asistencias, Socio id_socio, Clase id_clase, boolean estado) {
        this.cant_asistencias = cant_asistencias;
        this.id_socio = id_socio;
        this.id_clase = id_clase;
        this.estado = estado;
    }

    public Asistencia(int id_asistencia, int cant_asistencias, Socio id_socio, Clase id_clase, boolean estado) {
        this.id_asistencia = id_asistencia;
        this.cant_asistencias = cant_asistencias;
        this.id_socio = id_socio;
        this.id_clase = id_clase;
        this.estado = estado;
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public int getCant_asistencias() {
        return cant_asistencias;
    }

    public void setCant_asistencias(int cant_asistencias) {
        this.cant_asistencias = cant_asistencias;
    }

    public Socio getId_socio() {
        return id_socio;
    }

    public void setId_socio(Socio id_socio) {
        this.id_socio = id_socio;
    }

    public Clase getId_clase() {
        return id_clase;
    }

    public void setId_clase(Clase id_clase) {
        this.id_clase = id_clase;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
