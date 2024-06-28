
package gimnasio.AccesoADatos;

import gimnasio.Entidades.Socio;
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
public class SocioData {
 private Connection con = null;
 
    public SocioData() {
        con = Conexion.getConexion();
    }
    
    public boolean guardarSocio(Socio socio){
        Boolean flag=false;
        PreparedStatement ps;
        String sql = "INSERT INTO socio (dni, nombre, apellido, edad, correo, telefono, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.setBoolean(7, socio.isEstado());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                socio.setId_socio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Socio ID: "+socio.getId_socio()+"\nNombre: "+socio.getNombre()+"\nApellido:  "+socio.getApellido()+"\nEstado: Inscripto!"); 
                flag=true;
            }
            ps.close();
        }catch(SQLException ex) {
            if(ex.getErrorCode() == 1062) { // Código de error para clave duplicada
                JOptionPane.showMessageDialog(null,"El dni ya existe en la base de datos", "Imposible guardar Socio", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar el socio: "+socio.getNombre()+" "+socio.getApellido()+"\n" + ex.getMessage());
            }
        }
        return flag;
    }
    
      
    public Socio buscarSocioPorId(int id){//Busqueda por numero de Socio
        Socio socio = new Socio();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT * FROM socio WHERE id_socio = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                socio.setId_socio(id);
                socio.setDni(rs.getString("dni"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(rs.getBoolean("estado"));
            }
            else{
                JOptionPane.showMessageDialog(null, "Resultado de búsqueda por ID: "+id+"\nEl Socio no existe");
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en tabla Socio: "+ex.getMessage());
        }
    return socio;
    }
    
        
    public List<Socio> buscarSocioPorNombre(String nombre){  
        List<Socio> socios;
        boolean flag = false;
        String sql = "SELECT * FROM socio WHERE nombre = ?";
        socios = cargarBusquedas(sql,nombre);
        for (Socio socio : socios) {
            if(socio.getId_socio() != 0) flag = true; 
        }
        if(!flag) JOptionPane.showMessageDialog(null, "El Socio: "+nombre+" no existe");
    return socios;
    }
    
    public List<Socio> listarSocio(){//Lista todos los Socios
        List<Socio> socios;
        String sql = "SELECT * FROM socio WHERE ?";
        String campo = "1";
        socios = cargarBusquedas(sql, campo);
    return socios;    
    }
    
    public List<Socio> listarSocios2(int valor){ //Lista todos los Socios Activos o Inactivos
        List<Socio> socios;
        String sql = "SELECT * FROM socio WHERE estado = ? ORDER BY nombre ASC";
        String campo;
        if(valor==1){campo = "1";}else{campo="0";}
        socios = cargarBusquedas(sql, campo);
    return socios;    
    }
      
    public List<Socio> cargarBusquedas(String sql, String campo){ //Metodo reutilizable para las busquedas por nombre, por apellido y Listado completo
        PreparedStatement ps;
        ResultSet rs;
        List<Socio> socios = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, campo);
            ps.setBoolean(2, true);
            rs = ps.executeQuery();
            while(rs.next()){
                Socio socio = new Socio();
                socio.setId_socio(rs.getInt(1));
                socio.setDni(rs.getString("dni"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(rs.getBoolean("estado"));
                socios.add(socio);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: "+ex.getMessage()); 
        }
        return socios;
    }
    
     public void modificarSocio(Socio socio){
        PreparedStatement ps;
        String sql = "UPDATE socio SET dni = ?, nombre = ?, apellido = ?, edad = ?, correo = ?, telefono = ? WHERE id_socio = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, socio.getDni());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setInt(4, socio.getEdad());
            ps.setString(5, socio.getCorreo());
            ps.setString(6, socio.getTelefono());
            ps.setInt(7, socio.getId_socio());
            int fila=ps.executeUpdate();
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Socio ID: "+socio.getId_socio()+"\nNombre: "+socio.getNombre()+"\nApellido:  "+socio.getApellido()+"\nDatos Actualizados: Ok!"); 
    
            }else{
                 JOptionPane.showMessageDialog(null, "Error en actualización de datos del Socio: "+socio.getId_socio());
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Actualización de datos fallida!\n El socio: "+socio.getNombre()+" "+socio.getApellido()+"\nNo fue modficado-");    
        }
    }
     
    public void eliminarSocio(int id){ //Eliminar Socio cambia el estado a 0.
        SocioData socioABuscar = new SocioData();
        Socio socio;
        PreparedStatement ps; 
        try { 
            MembresiaData membresiaData = new MembresiaData();
            boolean membresiaABuscar = false;
            if((membresiaData.buscarMembresiaPorSocio(id)).isEstado()) membresiaABuscar = true;
            socio = socioABuscar.buscarSocioPorId(id); 
            String sql = "UPDATE socio SET estado = ? WHERE id_socio = ?";
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            int fila = ps.executeUpdate();
            if(fila==1){
               JOptionPane.showMessageDialog(null, "Socio ID: "+socio.getId_socio()+"\nNombre: "+socio.getNombre()+" "+socio.getApellido()+"\nEstado: Eliminado"); 
               if(membresiaABuscar) membresiaData.cancelarMembresia(id, false);
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el Socio ID: "+id+"\n"+ex.getMessage()); 
        }
    }
    
    public int ultimoId(){
        int id=0;
        PreparedStatement ps;
        ResultSet rs;
        String sql ="SELECT id_socio FROM socio ORDER BY id_socio DESC LIMIT 1";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
              id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en tabla Socio: "+ex.getMessage()); 
        }
    return id;
    }
    
    public void renovarSocio(Socio socio){
        PreparedStatement ps;
        String sql = "UPDATE socio SET estado = ? WHERE id_socio = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, socio.getId_socio());
            int fila =  ps.executeUpdate();
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Renovación Socio ID:"+socio.getId_socio()+" exitosa!\nEstado de Socio: Activo"); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en tabla Socio: "+ex.getMessage()); 
        }
    }
}
