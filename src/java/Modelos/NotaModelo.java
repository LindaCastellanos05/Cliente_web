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
public class NotaModelo {

    public NotaModelo() {
    }
     public static List<ws.ModeloNota>Todosnotas(){
        ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.todosnotas();
    }public static String crear(ws.ModeloNota nota){
        ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.creaNota(nota);
    } public static String eliminar(int idal, int idgr){
       ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.eliminarNota(idal, idgr);
      
     }public static List<ws.ModeloNota>findid(int idal, int idgr){
         ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.buscarNota(idal, idgr);
        
     } public static String actualizar(ws.ModeloNota nota){
         ws.WSColegioIntecap_Service service = new ws.WSColegioIntecap_Service();
        ws.WSColegioIntecap webservicio = service.getWSColegioIntecapPort();
        return webservicio.actualizarNota(nota);
     }
}
