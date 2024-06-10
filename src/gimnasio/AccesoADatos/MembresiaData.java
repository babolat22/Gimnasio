package gimnasio.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import gimnasio.Entidades.Membresia;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public Boolean registrarMembresia (Membresia membresia){
        Boolean flag=false;
        Membresia membresia1= buscarMembresiaPorSocio(membresia.getId_socio().getId_socio());
        PreparedStatement ps;
        ResultSet rs;
        String sql = "INSERT INTO membresia (id_socio, tipo, cant_pases, fecha_inicio, fecha_fin, costo, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {  
            if(membresia1.getId_membresia()!=0){
                JOptionPane.showMessageDialog(null,"Ya se encuentra registrado con una Membresia: "+membresia.getTipo());
            }
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
        }                 
        return flag;
    }
         
    public Membresia buscarMembresiaPorSocio(int idSocio) {
        PreparedStatement ps;
        ResultSet rs;
        Membresia membresia = new Membresia();
        String sql = "SELECT * FROM Membresia WHERE id_socio = ?";
        try{ 
            ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            rs = ps.executeQuery();
            if(rs.next()) { 
                SocioData sociodata = new SocioData();
                membresia.setId_membresia(rs.getInt("id_membresia"));
                membresia.setId_socio(sociodata.buscarSocioPorId(idSocio));
                membresia.setCant_pases(rs.getInt("cant_pases"));
                membresia.setFecha_inicio(rs.getDate("fecha_inicio"));
                membresia.setFecha_fin(rs.getDate("fecha_fin"));
                membresia.setCosto(rs.getBigDecimal("costo"));
                membresia.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Membresia"+ex.getMessage()); 
        }
        return membresia;
    }
    
     public List<Membresia> buscarMembresiaPorTipo(int tipo_membresia) {
        PreparedStatement ps;
        ResultSet rs;
        List<Membresia> membresias = new ArrayList<>();
        String sql = "SELECT * FROM Membresia WHERE tipo = ?";
        try{ 
            ps = con.prepareStatement(sql);
            ps.setInt(1, tipo_membresia);
            rs = ps.executeQuery();
            while (rs.next()) {
                Membresia membresia = new Membresia();
                membresia.setId_membresia(rs.getInt("id_membresia"));
                membresia.getId_socio();
                membresia.setCant_pases(rs.getInt("cant_pases"));
                membresia.setFecha_inicio(rs.getDate("fecha_inicio"));
                membresia.setFecha_fin(rs.getDate("fecha_fin"));
                membresia.setCosto(rs.getBigDecimal("costo"));
                membresia.setEstado(rs.getBoolean("estado"));
                membresias.add(membresia);
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Membresia"+ex.getMessage()); 
        }
        return membresias;
    }
     
    public void renovarMembresia(int idMembresia, int cantDias) {
        PreparedStatement ps, ps1;
        ResultSet rs;
        Membresia membresia1 = new Membresia();
        //Buscando la fecha de finalizacion de la membresia actual del socio
        String sql1 = "SELECT fecha_fin FROM membresia WHERE id_membresia = ?"; 
        try {
            ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, idMembresia);
            rs = ps1.executeQuery();
            if(rs.next()){   
                membresia1.setFecha_fin(rs.getDate("fecha_fin"));  
            }else{
                JOptionPane.showMessageDialog(null, "Error Imposible renovar Membresia. Consulte tabla de Membresias"); 
            }
            ps1.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Membresia"+ex.getMessage()); 
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error Membresia no existe"); 
        }
        //Renovando un periodo a partir de la finalizacion del mes en curso o a vencer
        String sql = "UPDATE membresia SET fecha_inicio = ?, fecha_fin = ?, estado = ? WHERE id_membresia = ?";
        try{
            ps = con.prepareStatement(sql); 
            ps.setDate(1, membresia1.getFecha_fin());
            ps.setDate(2, Date.valueOf(membresia1.getFecha_fin().toLocalDate().plusDays(cantDias)));
            ps.setBoolean(3, true);  
            ps.setInt(4, idMembresia);
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

