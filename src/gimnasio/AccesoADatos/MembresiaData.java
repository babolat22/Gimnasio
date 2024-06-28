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
        PreparedStatement ps;
        ResultSet rs;
        String sql = "INSERT INTO membresia (id_socio, tipo, cant_pases, pases_disponibles, fecha_inicio, fecha_fin, costo, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {        
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, membresia.getId_socio().getId_socio());
            ps.setString(2, membresia.getTipo());
            ps.setInt(3, membresia.getCant_pases());
            ps.setInt(4, membresia.getPases_disponibles());
            ps.setDate(5, membresia.getFecha_inicio());
            ps.setDate(6, membresia.getFecha_fin());
            ps.setBigDecimal(7, membresia.getCosto());
            ps.setBoolean(8, true); 
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
    
    //Busca una Membresia activa por ID Socio
    public Membresia buscarMembresiaPorSocio(int idSocio) {
        PreparedStatement ps;
        ResultSet rs;
        Membresia membresia = new Membresia();
        String sql = "SELECT * FROM Membresia WHERE id_socio = ? ORDER BY id_membresia DESC";
        try{ 
            ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            //ps.setBoolean(2, true);
            rs = ps.executeQuery();
            if(rs.next()) { 
                SocioData sociodata = new SocioData();
                membresia.setId_membresia(rs.getInt("id_membresia"));
                membresia.setId_socio(sociodata.buscarSocioPorId(idSocio));
                membresia.setTipo(rs.getString("tipo"));
                membresia.setCant_pases(rs.getInt("cant_pases"));
                membresia.setPases_disponibles(rs.getInt("pases_disponibles"));
                membresia.setFecha_inicio(rs.getDate("fecha_inicio"));
                membresia.setFecha_fin(rs.getDate("fecha_fin"));
                membresia.setCosto(rs.getBigDecimal("costo"));
                membresia.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Membresia \n"+ex.getMessage()); 
        }
        return membresia;
    }
    
     public List<Membresia> buscarMembresiaPorTipo(String tipo_membresia) {
        List<Membresia> membresias;
        String sql = "SELECT * FROM Membresia WHERE tipo = ?";
        String campo = tipo_membresia;
        membresias = cargarBusquedas(sql, campo);
        return membresias;
    }
     
     public List<Membresia> listarMembresia(){ //Lista todos las Membresias
        List<Membresia> membresias;
        String sql = "SELECT * FROM membresia WHERE ?";
        String campo = "1";
        membresias = cargarBusquedas(sql, campo);
    return membresias;    
    }
     
    public List<Membresia> listarMembresia2(int valor){
        List<Membresia> membresias;
        String campo;
        String sql = "SELECT * FROM membresia WHERE 1 AND estado = ?";
        if(valor==1){campo = "1";}else{campo="0";}
        membresias = cargarBusquedas(sql, campo);
    return membresias;    
    }
    
     public List<Membresia> buscarMembresiaPorIDSocio2(int idSocio){
        List<Membresia> membresias;
        String campo;
        String sql = "SELECT * FROM membresia WHERE id_socio = ?";
        campo = String.valueOf(idSocio);
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
                membresia.setPases_disponibles(rs.getInt("pases_disponibles"));
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
    
     public void modificarMembresia(Membresia membresia){
        PreparedStatement ps;
        
        String sql = "UPDATE membresia SET tipo = ?, cant_pases = ?, pases_disponibles = ?, fecha_inicio = ?, fecha_fin = ?, costo = ? "
                + "WHERE id_membresia = ? AND estado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, membresia.getTipo());
            ps.setInt(2, membresia.getCant_pases());
            ps.setInt(3, membresia.getPases_disponibles());
            ps.setDate(4, membresia.getFecha_inicio());
            ps.setDate(5, membresia.getFecha_fin());
            ps.setBigDecimal(6, membresia.getCosto());
            ps.setInt(7, membresia.getId_membresia());
            ps.setBoolean(8, true);
            int fila=ps.executeUpdate();
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Membresia ID: "+membresia.getId_membresia()+"\nSocio ID: "+membresia.getId_socio().getId_socio()+"\nNombre: "+membresia.getId_socio().getNombre()+"\nApellido:  "+membresia.getId_socio().getApellido()+"\nDatos Actualizados exitosamente!"); 
    
            }else{
                 JOptionPane.showMessageDialog(null, "Error en actualización de Membresia ID: "+membresia.getId_membresia()+" Socio ID: "+membresia.getId_socio().getId_socio());
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Actualización de datos fallida!\n La Membresia ID: "+membresia.getId_membresia()+" Socio ID: "+membresia.getId_socio().getId_socio()+"\nNo fue modficada");    
        }
    }
    
    public void renovarMembresia(Membresia membresia) {
        int cantMeses=0;
        String opcion = membresia.getTipo();
         switch(opcion){
            case "Mensual":
                cantMeses = 1;
                break;
            case "Bimestral":
                cantMeses = 2;
                break;
            case "Trimestral":
                cantMeses = 3;
                break;
            case "Semestral":
                cantMeses = 6;
                break;
            case "Anual":
                cantMeses = 12;
                break;
        }
        if(membresia.isEstado()){// Renovacion de Membresias activas
            LocalDate localDate = membresia.getFecha_fin().toLocalDate();
            LocalDate nuevaFecha = localDate.plusDays(cantMeses*30);
            Date nuevaFechaFin = Date.valueOf(nuevaFecha);
            membresia.setFecha_fin(nuevaFechaFin);
            //Pases disponibles se actualiza sumando los que quedaron del plan actual con los nuevos contratados
            membresia.setPases_disponibles(membresia.getPases_disponibles()+membresia.getCant_pases());
            //Cambio la antigua membresia a estado inactivo
            cancelarMembresia(membresia.getId_socio().getId_socio(), true);   
        }else{ //Renovacion de membresias Inactivas
            Membresia membresia2;
            membresia2 = buscarMembresiaPorSocio(membresia.getId_socio().getId_socio());
            if(!membresia2.isEstado()&&membresia2.getPases_disponibles()==0){//Verifico que la ultima membresia este inactiva y la cantidad de pases disponibles es 0
                //Si renueva y la membresia esta vencida, entonces la fecha de inicio es el dia de hoy;
                LocalDate hoy = LocalDate.now();
                Date fechaInicio = Date.valueOf(hoy);
                membresia.setFecha_inicio(fechaInicio);
                //Fecha FIN segun su membresia
                LocalDate localDate = fechaInicio.toLocalDate();
                LocalDate nuevaFecha = localDate.plusDays(cantMeses*30);
                Date nuevaFechaFin = Date.valueOf(nuevaFecha);
                membresia.setFecha_fin(nuevaFechaFin); 
            }
        }      
        registrarMembresia(membresia);
    }
    
    public void cancelarMembresia(int idSocio, boolean renovacion) {
        PreparedStatement ps;
        String sql = "UPDATE membresia SET pases_disponibles = ?, estado = ? WHERE id_socio = ? AND estado = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setBoolean(2, false);
            ps.setInt(3, idSocio);
            ps.setBoolean(4, true);
            int fila = ps.executeUpdate();
            if(fila == 1){
                 if(!renovacion) JOptionPane.showMessageDialog(null, "Cancelación de Membresia\nSocio ID: "+idSocio+"\nEstado: Membresia Cancelada");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error Imposible cancelar Membresia. Consulte tabla de Membresias"); 
            }
        ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Membresia"+ex.getMessage()); 
        }
    }
    
    public void descontarPases(int idSocio){
        PreparedStatement ps;
        ResultSet rs;
        String sql = "UPDATE membresia SET pases_disponibles = pases_disponibles - ? WHERE id_socio = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, idSocio);
            int fila = ps.executeUpdate();
            if(fila == 1){
                JOptionPane.showMessageDialog(null, "Capacidad de Clase descontada exitosamente"); 
            }
            ps.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Actualización de datos fallida! la Capacidad No fue modficada-");    
        }
    }
    
}

