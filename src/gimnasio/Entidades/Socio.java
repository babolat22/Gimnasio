
package gimnasio.Entidades;

/**
 *
 * @author Javier
 */
public class Socio {
    private int id_socio;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String telefono;
    private boolean estado;

    public Socio() {
    }

    public Socio(String dni, String nombre, String apellido, int edad, String correo, String telefono, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Socio(int id_socio, String dni, String nombre, String apellido, int edad, String correo, String telefono, boolean estado) {
        this.id_socio = id_socio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getId_socio() {
        return id_socio;
    }

    public void setId_socio(int id_socio) {
        this.id_socio = id_socio;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Socio{" + "id_socio=" + id_socio + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", correo=" + correo + ", telefono=" + telefono + ", estado=" + estado + '}';
    }
    
}
