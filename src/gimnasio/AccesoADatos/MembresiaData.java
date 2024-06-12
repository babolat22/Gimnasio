package gimnasio.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import gimnasio.Entidades.Membresia;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */

public class MembresiaData {
    private Connection con = null;
    
    public MembresiaData() {
         con = Conexion.getConexion();
}
    public Boolean registrarMembresia(Membresia membresia){
        Boolean flag=false;
        Membresia membresia1= buscarMembresiaPorSocio(membresia.getId_socio().getId_socio());
        
        PreparedStatement ps;
        ResultSet rs;
        String sql = "INSERT INTO membresia (id_socio, tipo, cant_pases, fecha_inicio, fecha_fin, costo, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {  
            if(membresia1.getId_membresia()!=0) throw new NumberFormatException();
            if(!membresia1.isEstado()) throw new NullPointerException();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, membresia.getId_socio().getId_socio());
            ps.setString(2, membresia.getTipo());
            ps.setInt(3, membresia.getCant_pases());
            ps.setDate(4, membresia.getFecha_inicio());
            ps.setDate(5, membresia.getFecha_fin());
            ps.setBigDecimal(6, membresia.getCosto());
            ps.setBoolean(7, membresia.isEstado()); 
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()) {
                membresia.setId_membresia((rs.getInt(1)));
                JOptionPane.showMessageDialog(null, "Membresia ID: "+membresia.getId_membresia()+"\nEstado: Registrada exitosamente!"); 
                flag=true;
            }else{
                JOptionPane.showMessageDialog(null, "Error al intentar registrar Membresia");
            }
            ps.close();
        }catch(SQLException ex) {
            if(ex.getErrorCode() == 1452) { // Código de error para clave duplicada
                JOptionPane.showMessageDialog(null, "Error: El Socio con el que intentar registar la Membresia no existe!");
            }else{
                JOptionPane.showMessageDialog(null, "Error al registrar la Membresia: "+membresia.getId_socio().getNombre()+" "+membresia.getId_socio().getApellido()+"\n" + ex.getMessage());
            }  
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"El Socio ID: "+membresia1.getId_socio().getId_socio()+"\nSe encuentra registrado con una Membresia: "+membresia.getTipo());
        }catch(NullPointerException exp){
            //Saliendo porque el socio no existe
        }                
        return flag;
    }
    
    //Busca una Membresia activa por ID Socio
    public Membresia buscarMembresiaPorSocio(int idSocio) {
        PreparedStatement ps;
        ResultSet rs;
        Membresia membresia = new Membresia();
        String sql = "SELECT * FROM Membresia WHERE id_socio = ? AND estado = ?";
        try{ 
            ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ps.setBoolean(2, true);
            rs = ps.executeQuery();
            if(rs.next()) { 
                SocioData sociodata = new SocioData();
                membresia.setId_membresia(rs.getInt("id_membresia"));
                membresia.setId_socio(sociodata.buscarSocioPorId(idSocio));
                membresia.setTipo(rs.getString("tipo"));
                membresia.setCant_pases(rs.getInt("cant_pases"));
                membresia.setFecha_inicio(rs.getDate("fecha_inicio"));
                membresia.setFecha_fin(rs.getDate("fecha_fin"));
                membresia.setCosto(rs.getBigDecimal("costo"));
                membresia.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Membresia \n"+ex.getMessage()); 
        }
        return membresia;
    }
    
     public List<Membresia> buscarMembresiaPorTipo(int tipo_membresia) {
        List<Membresia> membresias;
        String sql = "SELECT * FROM Membresia WHERE tipo = ? AND estado = ?";
        String campo = String.valueOf( tipo_membresia);
        membresias = cargarBusquedas(sql, campo);
        return membresias;
    }
     
     public List<Membresia> listarMembresia(){
        List<Membresia> membresias;
        String sql = "SELECT * FROM membresia WHERE estado = ?";
        String campo = "1";
        membresias = cargarBusquedas(sql, campo);
    return membresias;    
    }
     
    public List<Membresia> cargarBusquedas(String sql, String campo){
        PreparedStatement ps;
        ResultSet rs;
        List<Membresia> membresias = new ArrayList<>();
        try{ 
            ps = con.prepareStatement(sql);
            ps.setString(1, campo);
            ps.setBoolean(2, true);
            rs = ps.executeQuery();
            while (rs.next()) {
                Membresia membresia = new Membresia();
                SocioData socioData = new SocioData();
                membresia.setId_membresia(rs.getInt("id_membresia"));
                membresia.setId_socio(socioData.buscarSocioPorId(rs.getInt("id_socio")));
                membresia.setTipo(rs.getString("tipo"));
                membresia.setCant_pases(rs.getInt("cant_pases"));
                membresia.setFecha_inicio(rs.getDate("fecha_inicio"));
                membresia.setFecha_fin(rs.getDate("fecha_fin"));
                membresia.setCosto(rs.getBigDecimal("costo"));
                membresia.setEstado(rs.getBoolean("estado"));
                membresias.add(membresia);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Membresia"+ex.getMessage()); 
        }
    return membresias;
    } 
     
    public void renovarMembresia(int idMembresia, int plan, int pases, Date fechaRenovacion) {
        PreparedStatement ps;
        LocalDate localDate = fechaRenovacion.toLocalDate();
        LocalDate newDate = localDate.plusDays(plan);
        Date nuevaFechaFin = Date.valueOf(newDate);
        String sql = "UPDATE membresia SET fecha_inicio = ?, fecha_fin = ?, cant_pases = ?, estado = ? WHERE id_membresia = ?";
        try{
            ps = con.prepareStatement(sql); 
            ps.setDate(1, fechaRenovacion);
            ps.setDate(2, nuevaFechaFin);
            ps.setInt(3, pases);
            ps.setBoolean(4, true);  
            ps.setInt(5, idMembresia);
            int fila =  ps.executeUpdate();
            if(fila==1){
                 JOptionPane.showMessageDialog(null, "Renovación Membresia ID: "+idMembresia+"\nEstado: Renovada exitosamente!");
            }else{
                JOptionPane.showMessageDialog(null, "Error Imposible renovar Membresia. Consulte tabla de Membresias"); 
            }
          ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Membresia"+ex.getMessage()); 
        }catch(NullPointerException e){
           
        }
    }
    
    public void cancelarMembresia(int idMembresia) {
        PreparedStatement ps;
        String sql = "UPDATE membresia SET estado = ? WHERE id_membresia = ? AND estado = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, idMembresia);
            ps.setBoolean(3, true);
            int fila = ps.executeUpdate();
            if(fila == 1){
                 JOptionPane.showMessageDialog(null, "Cancelación Membresia ID: "+idMembresia+"\nEstado: Cancelada exitosamente!");
            }else{
                JOptionPane.showMessageDialog(null, "Error Imposible cancelar Membresia. Consulte tabla de Membresias"); 
            }
        ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Membresia"+ex.getMessage()); 
        }
    }
    
}

