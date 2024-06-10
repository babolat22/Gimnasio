
package gimnasio.AccesoADatos;

import gimnasio.Entidades.Clase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */

public class ClaseData {
    private Connection con = null;
    
    public ClaseData() {
        con = Conexion.getConexion();
    }
    
    public void guardarClase (Clase clase){
        PreparedStatement ps;
        ResultSet rs;
        String sql = "INSERT INTO clase (nombre, id_entrenador, horario, capacidad, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getId_entrenador().getId_entrenador());
            ps.setTime(3, clase.getHorario());
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado()); 
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()) {
                clase.setId_clase((rs.getInt(1)));
                JOptionPane.showMessageDialog(null, "Clase ID: "+clase.getId_clase()+"\nNombre: "+clase.getNombre()+"\nEstado: Registrada exitosamente!");
            }
            ps.close();
            
          }catch(SQLException ex) {
            if(ex.getErrorCode() == 1062) { // Código de error para clave duplicada
                JOptionPane.showMessageDialog(null, "Error: La clase ya existe en la base de datos. Consulte la lista de Clases.");
            }
            if(ex.getErrorCode() == 1452) { 
                JOptionPane.showMessageDialog(null, "Error al guardar la Clase: "+clase.getNombre()+"\n" + "Entrenador no existe o dado de baja");
            }     
        }
    }
    //Listar por nombre de clase     
    public List<Clase> buscarClasePorNombre(String nombre){  
        List<Clase> clases = new ArrayList<>();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT * FROM clase WHERE nombre = ? AND estado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setBoolean(2, true);
            rs = ps.executeQuery();
            int i=0;
            while(rs.next()){
                Clase clase = new Clase();
                EntrenadorData entrenadordata = new EntrenadorData();
                clase.setId_clase(rs.getInt("id_clase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setId_entrenador(entrenadordata.buscarEntrenadorPorId((rs.getInt("id_entrenador"))));
                clase.setHorario(rs.getTime("horario"));
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clases.add(clase);
                i++;
            }
            if(i==0){ JOptionPane.showMessageDialog(null, "Resultado de búsqueda de Clases por Nombre: "+nombre+"\nClase y/o Entrenador no existe o fue dado de baja...");
            }else{
                System.out.println("Listado de Clases con Nombre: "+nombre);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase: \n"+ex.getMessage()); 
        }
    return clases;
    }
    
    //Listar clases activas por Entrenador activo    
    public List<Clase> buscarClasePorEntrenador(int id){  
        List<Clase> clases = new ArrayList<>();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT * FROM clase c JOIN entrenador e ON c.id_entrenador = e.id_entrenador\n" +
                     " WHERE e.id_entrenador = ? AND c.estado = ? AND e.estado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setBoolean(2, true);
            ps.setBoolean(3, true);
            rs = ps.executeQuery();
            int i=0;
            while(rs.next()){
                Clase clase = new Clase();
                EntrenadorData entrenadordata = new EntrenadorData();
                clase.setId_clase(rs.getInt("id_clase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setId_entrenador(entrenadordata.buscarEntrenadorPorId(id));
                clase.setHorario(rs.getTime("horario"));
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clases.add(clase);
                i++;
            }
            if(i==0){ JOptionPane.showMessageDialog(null, "Resultado de búsqueda de Clases con Entrenador ID: "+id+"\nClase y/o Entrenador no existe o fue dado de baja...");
            }else{
                System.out.println("Listado de Clases con Entrenador ID: "+id);
            }
            ps.close();
        } catch (SQLException ex) {
             if(ex.getErrorCode() == 1452) { // Código de error para clave duplicada
                JOptionPane.showMessageDialog(null, "Error: El ID Entrenador con el que intenta registrar una Clase no existe o fue dado de baja!");
            }else{
                JOptionPane.showMessageDialog(null, "Error al registrar la Clase: \n" + ex.getMessage());
            } 
        }
    return clases;
    }
    
    //Listar Clases disponibles por horario y capacidad disponible
    public List<Clase> buscarClasePorHorario(Time horario){  
        List<Clase> clases = new ArrayList<>();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT * FROM clase WHERE horario = ? AND estado = ? AND capacidad > ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setTime(1, horario);
            ps.setBoolean(2, true);
            ps.setInt(3, 0);
            rs = ps.executeQuery();
            int i=0;
            while(rs.next()){
                Clase clase = new Clase();
                EntrenadorData entrenadordata = new EntrenadorData();
                clase.setId_clase(rs.getInt("id_clase"));
                clase.setNombre(rs.getString("nombre"));
                clase.setId_entrenador(entrenadordata.buscarEntrenadorPorId((rs.getInt("id_entrenador"))));
                clase.setHorario(rs.getTime("horario"));
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
                clases.add(clase);
                i++;
            }
            if(i==0){ JOptionPane.showMessageDialog(null, "Resultado de búsqueda de Clases con Horario: "+horario+"\nNo hay Clases disponibles en ese horario...");
            }else{
                System.out.println("Listado de Clases disponibles en Horario: "+horario);
            }
            ps.close();
        } catch (SQLException ex) {
//             if(ex.getErrorCode() == 1452) { // Código de error para clave duplicada
//                JOptionPane.showMessageDialog(null, "Error: El ID Entrenador con el que intenta registrar una Clase no existe o fue dado de baja!");
//            }else{
//                JOptionPane.showMessageDialog(null, "Error al registrar la Clase: \n" + ex.getMessage());
//            } 
            JOptionPane.showMessageDialog(null, "Error en tabla Clase: \n" + ex.getMessage());
        }
    return clases;
    }
    
    //Modificar datos de Clase
    public void modificarClase(Clase clase){
        PreparedStatement ps;
        String sql = "UPDATE clase SET (nombre, id_entrenador, horario, capacidad, estado) "
                + "VALUES (?, ?, ?, ?, ?) WHERE id_clase = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getId_entrenador().getId_entrenador());
            ps.setTime(3, clase.getHorario());
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());
            ps.setInt(6, clase.getId_clase());
            int fila=ps.executeUpdate();
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Clase ID: "+clase.getId_clase()+"\nNombre: "+clase.getNombre()+"\nDatos Actualizados existosamente"); 
    
            }else{
                 JOptionPane.showMessageDialog(null, "Error en actualización de Clase: "+clase.getNombre());
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Actualización de datos fallida!\n La Clase: "+clase.getNombre()+"\nNo fue modficada-");    
        }
    }
    
    //Busqueda de Clase por Id de Clase
    public Clase buscarClasePorId(int id){
        Clase clase = new Clase();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT * FROM clase WHERE id_clase = ? AND estado = 1";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                EntrenadorData entrenadordata = new EntrenadorData();
                clase.setId_clase(rs.getInt(1));
                clase.setNombre(rs.getString("nombre"));
                clase.setId_entrenador(entrenadordata.buscarEntrenadorPorId((rs.getInt("id_entrenador"))));
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "Resultado de búsqueda por ID: \nLa Clase no existe o fue dada de baja...");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase: "+ex.getMessage()); 
        }
    return clase;
    }
     
    //Eliminar una clase con el ID de clase
    public void eliminarClase(int id){ 
        ClaseData claseABuscar = new ClaseData();
        Clase clase;
        PreparedStatement ps; 
        try {
            clase = claseABuscar.buscarClasePorId(id);
            String sql = "UPDATE clase SET estado = 0 WHERE id_clase = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if(fila==1){
               JOptionPane.showMessageDialog(null, "Clase ID: "+clase.getId_clase()+"\nNombre: "+clase.getNombre()+"\nEstado: Eliminado exitosamente!"); 
            }else{
                JOptionPane.showMessageDialog(null, "Clase ID: "+clase.getId_clase()+"\nNombre: "+clase.getNombre()+"\nEstado: Eliminación Fallida!");
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar Clase ID: "+id+"\n"+ex.getMessage()); 
        }    
    }
    
    public int ultimoId(){
        int id=0;
        PreparedStatement ps;
        ResultSet rs;
        String sql ="SELECT id_clase FROM clase ORDER BY id_clase DESC LIMIT 1";
     try {
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         if(rs.next()){
           id = rs.getInt(1);
         }
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error en tabla Clase "+ex.getMessage()); 
     }
    return id;
    }   
}
