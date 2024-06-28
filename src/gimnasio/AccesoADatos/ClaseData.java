
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public boolean guardarClase(Clase clase){
        Boolean flagGuardar=false;
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
                flagGuardar=true;
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
    return flagGuardar;
    }
    
    public List<Clase> listarClase(){//Todas las clases
        List<Clase> clases;
        String sql = "SELECT * FROM clase WHERE ?";
        String campo = "1";
        clases = cargarBusquedas(sql, campo);
    return clases;    
    }
    
    public List<Clase> listarClase2(int valor){// clases activas/inactivas
        List<Clase> clases;
        String campo;
        String sql = "SELECT * FROM clase WHERE 1 AND estado = ?";
        if(valor==1){campo = "1";}else{campo="0";}
        clases = cargarBusquedas(sql, campo);
    return clases;    
    }
     
    public List<Clase> cargarBusquedas(String sql, String campo){ 
        PreparedStatement ps;
        ResultSet rs;
        List<Clase> clases = new ArrayList<>();
        int i=0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, campo);
            rs = ps.executeQuery();
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
            if(i==0){ JOptionPane.showMessageDialog(null, "Resultado de búsqueda: \nClase y/o Entrenador no existe o fue dado de baja...");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase: \n"+ex.getMessage()); 
        }
    return clases;
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
            if(i==0){ JOptionPane.showMessageDialog(null, "Búsqueda de Clase: "+nombre+"\nClase y/o Entrenador no existe o se encuentra inactiva...");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase: \n"+ex.getMessage()); 
        }
    return clases;
    }
    
    //Listar clases activas por Entrenador 
    public List<Clase> buscarClasePorEntrenador(int id){  
        List<Clase> clases = new ArrayList<>();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT * FROM clase c JOIN entrenador e ON c.id_entrenador = e.id_entrenador\n" +
                     " WHERE e.id_entrenador = ? AND c.estado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setBoolean(2, true);
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
            if(i==0){ JOptionPane.showMessageDialog(null, "Búsqueda de Clases en Horario: "+horario+"\nNo hay Clases disponibles en ese horario...");
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
    
    public List<Time> buscarHorarioPorClase(String nombreClase){
        List<Time> listaHorarios = new ArrayList<>();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT horario FROM clase WHERE nombre = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreClase);
            ps.setBoolean(2, true);
            ps.setInt(4, 0);
            rs = ps.executeQuery();
            while(rs.next()){
                Time hora;
                hora = rs.getTime("horario");
                listaHorarios.add(hora);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase: "+ex.getMessage()); 
        } 
    return listaHorarios;
    }
    
    //Busqueda de Clase por Id de Clase
    public Clase buscarClasePorId(int id){
        Clase clase = new Clase();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT * FROM clase WHERE id_clase = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            //ps.setBoolean(2, true);
            rs = ps.executeQuery();
            if(rs.next()){
                EntrenadorData entrenadordata = new EntrenadorData();
                clase.setId_clase(id);
                clase.setNombre(rs.getString("nombre"));
                clase.setId_entrenador(entrenadordata.buscarEntrenadorPorId((rs.getInt("id_entrenador"))));
                clase.setHorario(rs.getTime("horario"));
                clase.setCapacidad(rs.getInt("capacidad"));
                clase.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "Resultado de búsqueda por ID: \nLa Clase no existe o fue dada de baja...");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase: "+ex.getMessage()); 
        }
    return clase;
    }
    
    //Modificar datos de Clase
    public void modificarClase(Clase clase){
        PreparedStatement ps;
        String sql = "UPDATE clase SET nombre = ?, id_entrenador = ?, horario = ?, capacidad = ? WHERE id_clase = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getId_entrenador().getId_entrenador());
            ps.setTime(3, clase.getHorario());
            ps.setInt(4, clase.getCapacidad());
            ps.setInt(5, clase.getId_clase());
            int fila=ps.executeUpdate();
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Clase ID: "+clase.getId_clase()+"\nNombre: "+clase.getNombre()+"\nDatos Actualizados exitosamente"); 
    
            }else{
                 JOptionPane.showMessageDialog(null, "Error en actualización de Clase: "+clase.getNombre());
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Actualización de datos fallida!\n La Clase: "+clase.getNombre()+"\nNo fue modficada-");    
        }
    }
    
    //Eliminar una clase con el ID de clase
    public void eliminarClase(int id){ 
        ClaseData claseABuscar = new ClaseData();
        Clase clase;
        PreparedStatement ps; 
        try {
            clase = claseABuscar.buscarClasePorId(id);
            String sql = "UPDATE clase SET estado = ? WHERE id_clase = ?";
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
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
    
    public void renovarEntrenador(Clase clase){
        PreparedStatement ps;
        String sql = "UPDATE clase SET estado = ? WHERE id_clase = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, clase.getId_clase());
            int fila =  ps.executeUpdate();
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Renovación de Clase ID:"+clase.getId_clase()+" exitosa!\nEstado de la Clase: Activa"); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en tabla Clase: "+ex.getMessage()); 
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
