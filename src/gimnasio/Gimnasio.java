
package gimnasio;

import gimnasio.AccesoADatos.Conexion;
import gimnasio.AccesoADatos.MembresiaData;
import gimnasio.AccesoADatos.SocioData;
import gimnasio.Entidades.Membresia;
import gimnasio.Entidades.Socio;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Javier
 */
public class Gimnasio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        
  
        
      /*Probando membresia
      Socio nuevoSocio = new Socio("1245678", "Jhon", "Perez", 30, "jhon@example.com", "128456789", 0, true);

  
    SocioData socioData = new SocioData();
    boolean resultadoGuardado = socioData.guardarSocio(nuevoSocio);

    
    if (resultadoGuardado) {
        System.out.println("El socio ha sido guardado con éxito.");
    } else {
        System.out.println("Hubo un error al guardar el socio.");
        return; // Salir del programa si hay un error al guardar el socio
    }

    
    int idNuevoSocio = nuevoSocio.getId_socio();

    
    Date fechaInicio = new Date(2024, 5, 5);
    Date fechaFin = new Date(fechaInicio.getTime() + (30L * 24 * 60 * 60 * 1000));

    
    Membresia nuevaMembresia = new Membresia(nuevoSocio, 12, fechaInicio, fechaFin, new BigDecimal("299.99"), true);

    
    MembresiaData membresiaData = new MembresiaData();
    boolean resultadoMembresia = membresiaData.registrarMembresia(nuevaMembresia);

   
    if (resultadoMembresia) {
        System.out.println("La membresía ha sido registrada con éxito para el socio ID: " + idNuevoSocio);
    } else {
        System.out.println("Hubo un error al registrar la membresía para el socio ID: " + idNuevoSocio);
    }
   
   
MembresiaData mem = new MembresiaData();
 
    for (Membresia membresia : mem.obtenerMembresiasPorSocio(1)) {
        System.out.println( "Membresias numero " +membresia.getId_membresia()+ ": " + "Desde " + membresia.getFecha_inicio() + " hasta "+ membresia.getFecha_fin());
     
    }
    
    
 MembresiaData membresiaData = new MembresiaData();

  
    int idMembresiaRenovar = 1;

   
   membresiaData.renovarMembresia(idMembresiaRenovar);

    
    int idMembresiaCancelar = 4; 

    
    membresiaData.cancelarMembresia(idMembresiaCancelar);

    
*/
}
    

       
    }

    
    

