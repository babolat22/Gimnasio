
package gimnasio;

import gimnasio.AccesoADatos.Conexion;
import gimnasio.AccesoADatos.EntrenadorData;
import gimnasio.AccesoADatos.MembresiaData;
import gimnasio.AccesoADatos.SocioData;
import gimnasio.Entidades.Entrenador;
import gimnasio.Entidades.Membresia;
import gimnasio.Entidades.Socio;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
//        
//    //Probando guardar socios
//    JOptionPane.showMessageDialog(null, "Carga de Socios");
//    Socio socio1 = new Socio("25987463", "Juan", "Lopez", 28, "juanlopez@gmail.com", "26574315278", 0, true);
//    Socio socio2 = new Socio("38987464", "Lucas", "Palotes", 36, "lucaspalotes@gmail.com", "26574315277", 0, true);
//    Socio socio3 = new Socio("47987465", "Pablo", "Lucero", 24, "pablolucero@gmail.com", "26574315276", 0, true);    
//    Socio socio4 = new Socio("36887463", "Francisco", "Leyes", 61, "franciscoleyes@gmail.com", "26574315548", 0, true);
//    Socio socio5 = new Socio("32487464", "Mateo", "Rodriguez", 39, "mateorodriguez@gmail.com", "26574315246", 0, true);
//    Socio socio6 = new Socio("4577465", "Pablo", "Dominguez", 54, "pablodominguez@gmail.com", "26574315587", 0, true);
//    SocioData sociodata = new SocioData();  
//    Socio[] socioN = {socio1, socio2, socio3, socio4, socio5, socio6};
//        for (Socio socio : socioN) {
//            sociodata.guardarSocio(socio);
//        }
//    
//    //Eliminar Socios por ID con el nombre y apellido
//    JOptionPane.showMessageDialog(null, "Eliminación de 2 Socios existentes y 1 inexistente");
//    Socio socioAEliminar = sociodata.buscarSocio("Lucas", "Palotes");
//    int id = socioAEliminar.getId_socio();
//    if(id != 0) sociodata.eliminarSocio(socioAEliminar.getId_socio());
//    
//    Socio socioAEliminar2 = sociodata.buscarSocio("Francisco", "Leyes");
//    int id2 = socioAEliminar2.getId_socio();
//    if(id2 != 0) sociodata.eliminarSocio(socioAEliminar2.getId_socio());
//    
//    //Intentando ELiminar un socio inexistente
//    Socio socioAEliminar3 = sociodata.buscarSocio("Carlos", "Gardel");
//    int id3 = socioAEliminar3.getId_socio();
//    if(id3 != 0) sociodata.eliminarSocio(socioAEliminar3.getId_socio());
// 
//    //Listar todos los Socios activos
//    JOptionPane.showMessageDialog(null, "Listado de Socios Activos");
//    List<Socio> socios;
//    socios =  sociodata.listarSocios();
//        System.out.println("Listado de Socios Activos:");
//    for (Socio socio : socios) {
//           System.out.println(socio.toString()); 
//        }
//
//    //Registrar 2 membresias mensuales
//    
//    LocalDate fechaActual = LocalDate.now();
//    Date fechaInicio = Date.valueOf(fechaActual);

//    // Sumar un mes a la fecha actual
//    LocalDate fechaMensual = fechaActual.plusMonths(1);
//    Date fechaFin = Date.valueOf(fechaMensual);

//    // Calcular el periodo entre las dos fechas (diferencia en días)
//    long diasDiferencia = ChronoUnit.DAYS.between(fechaActual, fechaMensual);

//    // Calcular el costo como BigDecimal
//    BigDecimal costo =  BigDecimal.valueOf((diasDiferencia-18)*700);

//    //registro membresia del 1 socio
//    JOptionPane.showMessageDialog(null, "Registro de membresia 1er Socio");
//    Socio socioX;
//    SocioData sociodataX = new SocioData();
//    socioX = sociodataX.buscarSocioPorId(1);
//    Membresia membresia1 = new Membresia(socioX,"Mensual",12,fechaInicio,fechaFin, costo, true);
//    MembresiaData membresiadata = new MembresiaData();
//    membresiadata.registrarMembresia(membresia1);
//    
//    //registro membresia del 2 socio
//    BigDecimal costo2 =  BigDecimal.valueOf((diasDiferencia-10)*700);
//    JOptionPane.showMessageDialog(null, "Registro de membresia 2do Socio");
//    Socio socioXI;
//    SocioData sociodataXI = new SocioData();
//    socioXI = sociodataXI.buscarSocioPorId(3);
//    Membresia membresia2 = new Membresia(socioXI,"Mensual",20,fechaInicio,fechaFin, costo2, true);
//    MembresiaData membresiadata2 = new MembresiaData();
//    membresiadata2.registrarMembresia(membresia2);
//    
//    //Renovar Membresia SocioX
//    int cantDias=0, idMembresia = 1;
//    if(membresia1.getTipo().equals("Mensual")){
//        cantDias = 30;
//    }
//    membresiadata.renovarMembresia(idMembresia, cantDias);
//    
//    //Cancelar Membresia Socio7
//    membresiadata.cancelarMembresia(idMembresia);
//    
//    //Guardar 3 entrenadores
//    JOptionPane.showMessageDialog(null, "Guardando Entrenadores");
//    Entrenador entrenador1 = new Entrenador("23566454", "Marcos", "Miranda", "Musculación","Lunes de 9hs a 10hs", true);
//    Entrenador entrenador2 = new Entrenador("32546789", "Jorge", "Molina", "Pilates","Miercoles de 8hs a 9hs", true);
//    Entrenador entrenador3 = new Entrenador("35478963", "Gustavo", "Perez", "Yoga","Viernes de 11hs a 12hs", true);
//    Entrenador entrenador4 = new Entrenador("15546449", "Jorge", "Araoz", "Fitness","Jueves de 7hs a 8hs", true);
//    Entrenador[] entrenadorN= {entrenador1, entrenador2, entrenador3, entrenador4};
    EntrenadorData entrenadorData = new EntrenadorData(); 
//        for (Entrenador entrenador : entrenadorN) {
//             entrenadorData.guardarEntrenador(entrenador);
//        }
//   
//    // Probar buscar entrenador 2 por ID
//    JOptionPane.showMessageDialog(null, "Buscar entrenador por ID");
//    
//    int idEntrenador = 1;
//        System.out.println("Entrenador con ID: "+idEntrenador+"\n"+entrenadorData.buscarEntrenadorPorId(idEntrenador).toString());
//    
//    //Probar Listar todos los entrenadores
//    JOptionPane.showMessageDialog(null, "Listado de entrenadores");
//    System.out.println("Listado de Entrenadores:");
//    List<Entrenador> entrenadorX = entrenadorData.listarEntrenadores();
//        for (Entrenador entrenadorx : entrenadorX) {
//            System.out.println(entrenadorx.toString());
//        }
//       
//    // Probar buscar entrenador por nombre
//    JOptionPane.showMessageDialog(null, "Listado de entrenadores de Nombre Jorge");
//    System.out.println("Listado de entrenadores de Nombre Jorge");
//    List<Entrenador> entrenadoresPorNombre = entrenadorData.buscarEntrenadorPorNombre("Jorge");
//        for (Entrenador entrenadorz : entrenadoresPorNombre) {
//            System.out.println("Entrenador encontrado por nombre: " + entrenadorz.toString());
//        }

    // Probar modificar un entrenador
    JOptionPane.showMessageDialog(null, "Modificando entrenador con ID: 3");
    Entrenador entrenadorAModificar;
    entrenadorAModificar = entrenadorData.buscarEntrenadorPorId(3);
    entrenadorAModificar.setNombre("Juan Modificado");
    entrenadorData.modificarEntrenador(entrenadorAModificar);
    System.out.println("Entrenador modificado: " + entrenadorData.buscarEntrenadorPorId(3).toString());

//        // Probar eliminar un entrenador
//        entrenadorData.eliminarEntrenador(entrenador.getId_entrenador());
//        System.out.println("Entrenador eliminado: " + entrenadorData.buscarEntrenadorPorId(entrenador.getId_entrenador()));
//    
    

    }
}//FIN MAIN

    
    

