
package gimnasio.AccesoADatos;


import gimnasio.Entidades.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class EntrenadorData {
    
     private Connection con= null;
    
    public EntrenadorData(){
        con = Conexion.getConexion();
    }
    
    public boolean guardarEntrenador (Entrenador entrenador){
        boolean flag=false;  
        PreparedStatement ps;
        ResultSet rs;
        String sql = "INSERT INTO entrenador (dni ,nombre, apellido, especialidad, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setBoolean(5, entrenador.isEstado()); 
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()) {
                entrenador.setId_entrenador((rs.getInt(1)));
                JOptionPane.showMessageDialog(null, "Entrenador ID: "+entrenador.getId_entrenador()+"\nNombre: "+entrenador.getNombre()+"\nApellido:  "+entrenador.getApellido()+"\nEstado: Registrado!");
                flag=true;
            }
            ps.close();
            
          }catch(SQLException ex) {
            if(ex.getErrorCode() == 1062) { // Código de error para clave duplicada
                JOptionPane.showMessageDialog(null, "Error: El dni ya existe en la base de datos. Consulte la lista de Entrenadores.");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar el Entrenador: "+entrenador.getNombre()+" "+entrenador.getApellido()+"\n" + ex.getMessage());
            }
        }
        return flag;
    }
    
    public Entrenador buscarEntrenadorPorId(int id){//Busqueda por numero Id Entrenador
        Entrenador entrenador= new Entrenador();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT * FROM entrenador WHERE id_entrenador = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                entrenador.setId_entrenador(rs.getInt(1));
                entrenador.setDni(rs.getString("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "Resultado de búsqueda por ID: \nEl Entrenador no existe o fue dado de baja...");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socio: "+ex.getMessage()); 
        }
    return entrenador;
    }
    
    public List<Entrenador> buscarEntrenadorPorNombre(String nombre){  
        List<Entrenador> entrenadores;
        String sql = "SELECT * FROM entrenador WHERE nombre = ?";
        entrenadores = cargarBusquedas(sql,nombre);
    return entrenadores;
    }
        
    public List<Entrenador> buscarEntrenadorPorApellido(String apellido){  
        List<Entrenador> entrenadores;
        String sql = "SELECT * FROM entrenador WHERE apellido = ?";
        entrenadores = cargarBusquedas(sql,apellido);
    return entrenadores;
    }
    
    public List<Entrenador> buscarEntrenadorPorNombreYApellido(String nombre, String apellido){  
        String sql = "SELECT * FROM entrenador WHERE nombre = ? AND apellido = ?";
        PreparedStatement ps;
        ResultSet rs;
        List<Entrenador> entrenadores = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            rs = ps.executeQuery();
            while(rs.next()){
                Entrenador entrenador = new Entrenador();
                entrenador.setId_entrenador(rs.getInt(1));
                entrenador.setDni(rs.getString("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(rs.getBoolean("estado"));
                entrenadores.add(entrenador);
            }
            ps.close();  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador: "+ex.getMessage()); 
        }
    return entrenadores;
    }
    
    public List<Entrenador> buscarEntrenadorPorEspecialidad(String especialidad){
        List<Entrenador> entrenadores;
        String sql = "SELECT * FROM entrenador WHERE especialidad = ? ";
        entrenadores = cargarBusquedas(sql,especialidad);
    return entrenadores;
    }
    
    public List<Entrenador> listarEntrenadores(){//lista todos los entrenadores
        List<Entrenador> entrenadores;
        String sql = "SELECT * FROM entrenador WHERE ?";
        String campo = "1";
        entrenadores = cargarBusquedas(sql, campo);
    return entrenadores;    
    }
     
    public List<Entrenador> listarEntrenadores2(int valor){//Lista todos los entrenadores Activos
        List<Entrenador> entrenadores;
        String campo;
        String sql = "SELECT * FROM entrenador WHERE 1 AND estado = ?";
        if(valor == 1){campo = "1";}else{campo = "0";}
        entrenadores = cargarBusquedas(sql, campo);
    return entrenadores;    
    }
    public List<Entrenador> cargarBusquedas(String sql, String campo){ //Metodo reutilizable para las busquedas por nombre, por apellido y Listado completo
        PreparedStatement ps;
        ResultSet rs;
        List<Entrenador> entrenadores = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, campo);
            rs = ps.executeQuery();
            while(rs.next()){
                Entrenador entrenador = new Entrenador();
                entrenador.setId_entrenador(rs.getInt(1));
                entrenador.setDni(rs.getString("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(rs.getBoolean("estado"));
                entrenadores.add(entrenador);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: "+ex.getMessage()); 
        }
        return entrenadores;
    }
        
    public void modificarEntrenador (Entrenador entrenador){
        String sql = "UPDATE entrenador SET dni = ?, nombre = ?, apellido = ?, especialidad = ? WHERE id_entrenador = ?";
        PreparedStatement ps;
        try{           
            ps = con.prepareStatement(sql);
            ps.setString(1, entrenador.getDni());
            ps.setString(2, entrenador.getNombre());
            ps.setString(3, entrenador.getApellido());
            ps.setString(4, entrenador.getEspecialidad());
            ps.setInt(5, entrenador.getId_entrenador());
            int fila = ps.executeUpdate();
            if(fila == 1){
                JOptionPane.showMessageDialog(null, "Entrenador ID: "+entrenador.getId_entrenador()+"\nEstado; Modificado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "El Entrenador no existe");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de entrenador\n"+ ex.getMessage());
        }
    }
    
    public void eliminarEntrenador(int id){
        PreparedStatement ps;
        EntrenadorData entrenadorABuscar = new EntrenadorData();
        Entrenador entrenador;
        try{
            entrenador = entrenadorABuscar.buscarEntrenadorPorId(id);
            String sql = "UPDATE entrenador SET estado = 0 WHERE id_entrenador = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if(fila==1){
               JOptionPane.showMessageDialog(null, "Entrenador ID: "+entrenador.getId_entrenador()+"\nNombre: "+entrenador.getNombre()+" "+entrenador.getApellido()+"\nEstado: Eliminado!"); 
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el Entrenador ID: "+id+"\n"+ex.getMessage()); 
        }
    }

    public void renovarEntrenador(Entrenador entrenador){
        PreparedStatement ps;
        String sql = "UPDATE entrenador SET estado = ? WHERE id_entrenador = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, entrenador.getId_entrenador());
            int fila =  ps.executeUpdate();
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Renovación de Entrenador ID:"+entrenador.getId_entrenador()+" exitosa!\nEstado de Entrenador: Activo"); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en tabla Entrenador: "+ex.getMessage()); 
        }
    }
    
    public List<String> listarEspecialidades(){
       List<String> especialidades = new ArrayList<>();
       
    return especialidades;
    }
}
