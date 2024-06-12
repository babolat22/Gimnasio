
package gimnasio;

import gimnasio.AccesoADatos.*;
import gimnasio.Entidades.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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
    SocioData sociodata = new SocioData();  
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

    //Registrar 2 membresias mensuales
//    
//    LocalDate fechaActual = LocalDate.now();
//    Date fechaHoy = Date.valueOf(fechaActual);
//
//    // Sumar un mes a la fecha
//    int CantMeses = 1;
//    LocalDate fechaMensual = fechaActual.plusMonths(CantMeses);
//    Date fechaFin = Date.valueOf(fechaMensual);
//
//    // Calcular el periodo entre las dos fechas (diferencia en días)
//    long diasDiferencia = ChronoUnit.DAYS.between(fechaActual, fechaMensual);
//    BigDecimal costo =  BigDecimal.valueOf((diasDiferencia-18)*700);
//
//    //registro membresia del 1 socio
//    JOptionPane.showMessageDialog(null, "Registro de membresia 1er Socio");
//    Socio socioX;
//    SocioData sociodataX = new SocioData();
//    socioX = sociodataX.buscarSocioPorId(1);
//    Date fechaInicio1 = Date.valueOf("2024-03-28");
//    Date fechaFin1 = Date.valueOf("2024-04-28");
//    Membresia membresia1 = new Membresia(socioX,"Mensual",12,fechaInicio1,fechaFin1, costo, true);
//    MembresiaData membresiadata = new MembresiaData();
//    membresiadata.registrarMembresia(membresia1);
//    
//    //registro membresia del 2 socio
//    BigDecimal costo2 =  BigDecimal.valueOf((diasDiferencia-10)*700);
//    JOptionPane.showMessageDialog(null, "Registro de membresia 2do Socio");
//    Socio socioXI;
//    SocioData sociodataXI = new SocioData();
//    socioXI = sociodataXI.buscarSocioPorId(3);
//    int pases=20;
//    Membresia membresia2 = new Membresia(socioXI,"Mensual",pases,fechaHoy,fechaFin, costo2, true);
//    MembresiaData membresiadata2 = new MembresiaData();
//    membresiadata2.registrarMembresia(membresia2);
//    
//    //Renovar Membresia SocioX
//    int cantDias=0, idMembresia;
//    idMembresia = membresia1.getId_membresia();
//    if(membresia1.getTipo().equals("Mensual")){
//        cantDias = 30;
//    }
//    pases = membresia1.getCant_pases();
//   
//    //Renovacion a partir de la fecha de hoy
//    membresiadata.renovarMembresia(idMembresia, cantDias, pases, fechaHoy);
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
//    EntrenadorData entrenadorData = new EntrenadorData(); 
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
//
//    // Probar modificar un entrenador
//    JOptionPane.showMessageDialog(null, "Modificando entrenador con ID: 3");
//    Entrenador entrenadorAModificar;
//    entrenadorAModificar = entrenadorData.buscarEntrenadorPorId(3);
//    entrenadorAModificar.setNombre("Juan Modificado");
//    entrenadorData.modificarEntrenador(entrenadorAModificar);
//    System.out.println("Entrenador modificado: " + entrenadorData.buscarEntrenadorPorId(3).toString());
//
//    // Probar eliminar un entrenador
//    JOptionPane.showMessageDialog(null, "Eliminar entrenador con ID: 3");
//    Entrenador entrenadorAEliminar;
//    entrenadorAEliminar = entrenadorData.buscarEntrenadorPorId(3);
//    entrenadorData.eliminarEntrenador(entrenadorAEliminar.getId_entrenador());
//    
//    //Guardar clases
//    JOptionPane.showMessageDialog(null, "Registro de 5 Clases");
//    Entrenador entrenadorX1, entrenadorX2, entrenadorX3, entrenadorX4, entrenadorX5;
//    EntrenadorData entrenadorDataX = new EntrenadorData();
//    
//    entrenadorX1 = entrenadorDataX.buscarEntrenadorPorId(1);
//    LocalTime localTime1 = LocalTime.of(8, 0);
//    Time horario1 = Time.valueOf(localTime1); 
//    Clase clase1 = new Clase("Musculación", entrenadorX1, horario1, 50,true);
//    
//    entrenadorX2 = entrenadorDataX.buscarEntrenadorPorId(3);//yoga
//    LocalTime localTime2 = LocalTime.of(9, 0);
//    Time horario2 = Time.valueOf(localTime2); 
//    Clase clase2 = new Clase("Yoga", entrenadorX2, horario2, 10,true);
//
//    entrenadorX3 = entrenadorDataX.buscarEntrenadorPorId(3);
//    LocalTime localTime3 = LocalTime.of(10, 0);
//    Time horario3 = Time.valueOf(localTime3); 
//    Clase clase3 = new Clase("Musculación", entrenadorX3, horario3, 50,true);
//    
//    entrenadorX4 = entrenadorDataX.buscarEntrenadorPorId(2);
//    LocalTime localTime4 = LocalTime.of(10, 0);
//    Time horario4 = Time.valueOf(localTime4); 
//    Clase clase4 = new Clase("Pilates", entrenadorX4, horario4, 8,true);
//  
//    entrenadorX5 = entrenadorDataX.buscarEntrenadorPorId(1);
//    LocalTime localTime5 = LocalTime.of(12, 0);
//    Time horario5 = Time.valueOf(localTime5); 
//    Clase clase5 = new Clase("Musculación", entrenadorX5, horario5, 50,true);
//    
//    ClaseData claseData = new ClaseData();
//    Clase[] claseN ={clase1, clase2, clase3, clase4, clase5};
//        for (Clase clase : claseN) {
//            claseData.guardarClase(clase);
//        }
//    
    //Buscar Clase por entrenador
//    JOptionPane.showMessageDialog(null, "Busqueda de clases Activas por entrenador Activo");
//    int idABuscar = 3;
//    List<Clase> listaClases;
//    listaClases = claseData.buscarClasePorEntrenador(idABuscar);
//        for (Clase listaClase : listaClases) {
//            System.out.println(listaClase.toString());
//        }
//    //Listado de clases por nombre
//    JOptionPane.showMessageDialog(null, "Busqueda de clases Activas por Nombre de Clase");    
//    listaClases = claseData.buscarClasePorNombre("Musculación");
//        for (Clase listaClase : listaClases) {
//            System.out.println(listaClase.toString());
//        }
////    
//    //Buscar Clase por horario
//    JOptionPane.showMessageDialog(null, "Busqueda de clases disponibles por horario y estado activo");
//    int horaABuscar = 10;
//    LocalTime localTime6 = LocalTime.of(horaABuscar, 0);
//    Time horario6 = Time.valueOf(localTime6);
//    List<Clase> listaClases6;
//    listaClases6 = claseData.buscarClasePorHorario(horario6);
//        for (Clase clase : listaClases6) {
//            System.out.println(clase.toString());
//        }
//    
    //Probar registrar asistencia del Socio ID 1 en la clase de Musculacion ID CLase; 5
//    JOptionPane.showMessageDialog(null, "Registrar una asistencia");
//    int iDSocio = 1;
//    Membresia membresiaA;
//    MembresiaData membresiaDataA = new MembresiaData();
//    membresiaA = membresiaDataA.buscarMembresiaPorSocio(iDSocio);
//    ClaseData claseDataA = new ClaseData();
//    Clase claseA = claseDataA.buscarClasePorId(5);
//    if((membresiaA.getCant_pases())>0 && (membresiaA.isEstado()) && (membresiaA.getId_socio().isEstado())){//Quedan clases y esta activo
//        if(claseA.isEstado() && claseA.getId_entrenador().isEstado() && claseA.getCapacidad() > 0){//Clase y enetrenador activos y hay capacidad
//            Asistencia asistencia = new Asistencia();
//            SocioData socioData = new SocioData();
//            asistencia.setId_socio((socioData.buscarSocioPorId(iDSocio)));
//            asistencia.setId_clase(claseA);
//            LocalDate localDate = LocalDate.now();
//            Date fecha_asistencia = Date.valueOf(localDate);
//            asistencia.setFecha_asistencia(fecha_asistencia);
//            LocalTime localTime = LocalTime.of(15, 0);
//            Time horario = Time.valueOf(localTime); 
//            asistencia.setHora_asistencia(horario);
//            asistencia.setEstado(true);
//            AsistenciaData asistenciadata = new AsistenciaData();
//            asistenciadata.registrarAsistencia(asistencia);
//        }
//    }else{
//          System.out.println("Estado membresia: "+(membresiaA.isEstado()));
//    }
    
    //probando listar asistencias
//    List<Asistencia> listaAsistenciaN;
//    AsistenciaData asistenciaDataN = new AsistenciaData();
//    listaAsistenciaN = asistenciaDataN.listarAsistencia();
//        for (Asistencia asistencia : listaAsistenciaN) {
//            System.out.println(asistencia.toString());
//        }
//    



    }//FIN MAIN
    
}//FIN CLASE

    
    

