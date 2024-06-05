
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
        
  
        
      /* //Probando membresia
      Socio nuevoSocio = new Socio("1245678", "Jhon", "Perez", 30, "jhon@example.com", "128456789", 0, true);

    // Crear una instancia de SocioData y guardar el nuevo socio
    SocioData socioData = new SocioData();
    boolean resultadoGuardado = socioData.guardarSocio(nuevoSocio);

    // Verificar si el socio fue guardado correctamente
    if (resultadoGuardado) {
        System.out.println("El socio ha sido guardado con éxito.");
    } else {
        System.out.println("Hubo un error al guardar el socio.");
        return; // Salir del programa si hay un error al guardar el socio
    }

    // Obtener el ID del nuevo socio guardado
    int idNuevoSocio = nuevoSocio.getId_socio();

    // Crear fechas de inicio y fin
    Date fechaInicio = new Date(2024, 5, 5); // Ajusta la fecha según tus necesidades
    Date fechaFin = new Date(fechaInicio.getTime() + (30L * 24 * 60 * 60 * 1000));

    // Crear una nueva membresía utilizando el socio recién guardado
    Membresia nuevaMembresia = new Membresia(nuevoSocio, 12, fechaInicio, fechaFin, new BigDecimal("299.99"), true);

    // Crear una instancia de MembresiaData y registrar la membresía
    MembresiaData membresiaData = new MembresiaData();
    boolean resultadoMembresia = membresiaData.registrarMembresia(nuevaMembresia);

    // Verificar si la membresía fue registrada correctamente
    if (resultadoMembresia) {
        System.out.println("La membresía ha sido registrada con éxito para el socio ID: " + idNuevoSocio);
    } else {
        System.out.println("Hubo un error al registrar la membresía para el socio ID: " + idNuevoSocio);
    }
    */
   
MembresiaData mem = new MembresiaData();
    // Mostrar las membresías obtenidas
    for (Membresia membresia : mem.obtenerMembresiasPorSocio(1)) {
        System.out.println( "Membresias numero " +membresia.getId_membresia()+ ": " + "Desde " + membresia.getFecha_inicio() + " hasta "+ membresia.getFecha_fin());
        // También puedes imprimir más detalles de la membresía si lo deseas
    }
    
    
 MembresiaData membresiaData = new MembresiaData();

   /* // ID de la membresía que deseas renovar
    int idMembresiaRenovar = 1; // Aquí coloca el ID de la membresía que deseas renovar

    // Llamar al método renovarMembresia con el ID de la membresía
   membresiaData.renovarMembresia(idMembresiaRenovar);*/

    // ID de la membresía que deseas cancelar
    int idMembresiaCancelar = 4; // Aquí coloca el ID de la membresía que deseas cancelar

    // Llamar al método cancelarMembresia con el ID de la membresía
    membresiaData.cancelarMembresia(idMembresiaCancelar);

    // Mostrar un mensaje indicando que las operaciones se realizaron correctamente
    System.out.println("Operaciones de renovación y cancelación de membresía realizadas con éxito.");
}
    

       
    }

    
    

