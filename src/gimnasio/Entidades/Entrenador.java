
package gimnasio.Entidades;

/**
 *
 * @author Javier
 */
public class Entrenador {
    private int id_entrenador;
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private boolean estado;

    public Entrenador() {
    }

    public Entrenador(String dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Entrenador(int id_entrenador, String dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.id_entrenador = id_entrenador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public int getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(int id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nombre y Apellido = " + nombre +" "+ apellido + " | id_entrenador = " + id_entrenador + " | dni = " + dni + " | especialidad = " + especialidad + " | estado = " + estado + '}';
    }
    
}
