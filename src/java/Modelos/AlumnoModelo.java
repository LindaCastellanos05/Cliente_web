/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.List;

/**
 *
 * @author Linda
 */
public class AlumnoModelo {

    public AlumnoModelo() {
    }
    
    public static List<ws.ModeloAlumno>Todosalumnos(){
        ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.todosalumnos();
    }
     public static String crear(ws.ModeloAlumno alumno){
        ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.crearAlumno(alumno);
    }
     public static String eliminar(int id){
       ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.eliminarAlumno(id);
      
     }
     public static List<ws.ModeloAlumno>findid(int id){
         ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.buscarAlumno(id);
     }
     public static String actualizar(ws.ModeloAlumno alumno){
         ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.actualizarAlumno(alumno);
     }
     public static String actualizar2(ws.ModeloAlumno alumno){
         ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.actualizarAlumno2(alumno);
     }
}
