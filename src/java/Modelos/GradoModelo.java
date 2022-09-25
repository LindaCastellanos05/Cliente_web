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
public class GradoModelo {
    public static List<ws.ModeloGrado>Todosgrados(){
        ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.todosgrados();
    }
     public static String eliminar(int id){
       ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.eliminarGrado(id);
      
     }
     public static String crear(ws.ModeloGrado grado){
        ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.crearGrado(grado);
    }
      public static List<ws.ModeloGrado>findid(int id){
         ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.buscarGrado(id);
     }
      public static String actualizar(ws.ModeloGrado grado){
         ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.actualizarGrado(grado);
     }
    
}
