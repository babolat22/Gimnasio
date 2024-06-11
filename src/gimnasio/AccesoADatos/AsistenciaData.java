
package gimnasio.AccesoADatos;

import gimnasio.Entidades.Asistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                "\nSocio: "+asistencia.getId_socio().getNombre()+" "+asistencia.getId_socio().getApellido()+"\nEstado: ASsitencia registrada con exito!");   
            }
            ps.close();
        }catch(SQLException ex) {
            if(ex.getErrorCode() == 1062) { // Código de error para clave duplicada
                JOptionPane.showMessageDialog(null, "Error: La Asistencia ya existe en la base de datos");
            }else{
                JOptionPane.showMessageDialog(null, "Error al registrar Asistencia ID: "+asistencia.getId_asistencia()+"\n" + ex.getMessage());
            }
        }
        
        
    }
    
    
    
    
    
    public void buscarAsistenciaPorSocio(){
    }
    public void buscarAsistenciaPorClase(){
    }
    public void eliminarAsistencia(){
    }
    
    
    
}
