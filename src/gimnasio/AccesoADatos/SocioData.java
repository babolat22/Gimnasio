
package gimnasio.AccesoADatos;

import gimnasio.Entidades.Socio;
import java.sql.Connection;
import java.sql.Date;
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
public class SocioData {
 private Connection con = null;
 
    public SocioData() {
        con = Conexion.getConexion();
    }
    
    public void guardarSocio(Socio socio){
        
        String sql = "INSERT INTO socio (dni, nombre, apellido, edad, correo, telefono, cont_asistencia, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, socio.getDni());
            ps.setString(3, socio.getNombre());
            ps.setString(2, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.setInt(7, socio.getContador_asistencia());
            ps.setBoolean(8, socio.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                socio.setId_socio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Socio ID: "+socio.getId_socio()+"\nNombre: "+socio.getNombre()+"\nApellido:  "+socio.getApellido()+"\nEstado: Inscripto!"); 
              
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socio: "+ex.getMessage()); 
        } 
    }
    
    public void eliminarSocio(int id){ //Eliminar Socio cambia el estado a 0.
        Socio socio = new Socio();
         
        String sql = "UPDATE socio SET estado = 0 WHERE id_socio = id";
     try {
         PreparedStatement ps = con.prepareStatement(sql);
         int fila = ps.executeUpdate();
         if(fila==1){
            JOptionPane.showMessageDialog(null, "Se elimino el socio: "+socio.getNombre()+" "+socio.getApellido()+" con ID: "+socio.getId_socio()); 
         }
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socio: "+ex.getMessage()); 
     }
        
    }
    
}
