
package gimnasio.AccesoADatos;

import gimnasio.Entidades.Asistencia;
import java.sql.Connection;

/**
 *
 * @author Javier
 */
public class AsistenciaData {
    private Connection conexion = null;
     
    public AsistenciaData() {
        conexion = Conexion.getConexion();
    }
    
    public boolean guardarAsistencia(Asistencia asistencia){ //Recibe el id Socio el id Clase la fecha de asistencia 
    return true;
    }
    public void buscarAsistenciaPorSocio(){
    }
    public void buscarAsistenciaPorClase(){
    }
    public void eliminarAsistencia(){
    }
    
    
    
}
