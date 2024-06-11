
package gimnasio.AccesoADatos;

import gimnasio.Entidades.Asistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class AsistenciaData {
    private Connection con = null;
     
    public AsistenciaData() {
        con = Conexion.getConexion();
    }
    
    //Inscribir al socio en una clase
    public void registrarAsistencia(Asistencia asistencia){ 
        ResultSet rs;
        PreparedStatement ps;
        String sql = "INSERT INTO asistencia(id_socio, id_clase, fecha_asistencia, hora_asistencia, estado) VALUES(?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, asistencia.getId_socio().getId_socio());
            ps.setInt(2, asistencia.getId_clase().getId_clase());
            ps.setDate(3, asistencia.getFecha_asistencia());
            ps.setTime(4, asistencia.getHora_asistencia());
            ps.setBoolean(5, asistencia.isEstado());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()) {
                asistencia.setId_asistencia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Asistencia ID: "+asistencia.getId_asistencia()+
                "\nSocio: "+asistencia.getId_socio().getNombre()+" "+asistencia.getId_socio().getApellido()+"\nEstado: Asistencia registrada con exito!");   
            }
            ps.close();
        }catch(SQLException ex) {
            if(ex.getErrorCode() == 1062) { // Código de error para clave duplicada
                JOptionPane.showMessageDialog(null, "Error: La Asistencia ya existe en la base de datos");
            }else{
                JOptionPane.showMessageDialog(null, "Error al registrar Asistencia ID: "+asistencia.getId_asistencia()+"\n" + ex.getMessage());
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al registrar Asistencia ID: "+e.getMessage());
        }
    }
     
    public void buscarAsistenciaPorSocio(int idSocio){
    }
    
    public void buscarAsistenciaPorClase(String nombreClase){
    }
    
    public void listarAsistencia(){
    }
    
    public void modificarAsistencia(int idAsistencia){
    }
    
    public void eliminarAsistencia(int idAsistencia){
    }
    
public boolean membresiaActiva(int idSocio) {
    String sql = "SELECT * FROM membresia WHERE id_socio = ? AND fecha_fin >= CURDATE() AND cant_pases > 0";
    boolean memActiva = false;
    PreparedStatement ps;
    ResultSet rs;
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idSocio);
        rs = ps.executeQuery();
        if (rs.next()) {
            memActiva = true;
        }
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Membresia");
    }
    return memActiva;
}

public boolean verificarCapacidadClase(int ID_Clase) {
    String sql = "SELECT COUNT(*) AS Inscritos, Capacidad FROM Asistencia JOIN Clase ON Asistencia.ID_Clase = Clase.ID_Clase WHERE Asistencia.ID_Clase = ?";
    boolean capacidadDisponible = false;
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, ID_Clase);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int inscritos = rs.getInt("Inscritos");
                int capacidad = rs.getInt("Capacidad");
                capacidadDisponible = inscritos < capacidad;
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Membresia");
    }
    return capacidadDisponible;
}

    
    
}
