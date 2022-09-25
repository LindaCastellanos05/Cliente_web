/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelos.AlumnoModelo;
import Modelos.GradoModelo;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ws.ModeloAlumno;
import ws.ModeloGrado;

/**
 *
 * @author Linda
 */
 
public class controlador extends HttpServlet {
 String agregar="agregar.jsp";
 String editar="editar.jsp";
 String index="index.jsp";
 String grado="grado.jsp";
 String creargrado ="crearGrado.jsp";
 String editargrado ="editarGrado.jsp";
 String nota="notas.jsp";
 String acceso ="";
 AlumnoModelo am = new AlumnoModelo();
 GradoModelo gm = new GradoModelo();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String accion=request.getParameter("Accion");
       
       if(accion.equals("agregar")){
           acceso=agregar;
       }else if (accion.equals("editar")){
           acceso=editar;
            request.setAttribute("idalumno", request.getParameter("id"));
       }else if (accion.equals("index")){
           acceso=index;
       }else if (accion.equals("guardar")){
          //sin foto
         /*  String nombre = request.getParameter("txtnombre");
           String apellido = request.getParameter("txtapellido");
           ModeloAlumno modal = new ModeloAlumno();
           modal.setNombreAlumno(nombre);
           modal.setApellidoAlumno(apellido);
           modal.setFoto("rf");
          am.crear(modal);*/
         
         //con foto
         
         try {
                 ArrayList<String> lista = new ArrayList<>();
                ModeloAlumno modalumno = new ModeloAlumno();
                FileItemFactory file = new DiskFileItemFactory();
                ServletFileUpload fileupload=new ServletFileUpload(file);
                List Elemntosinput= fileupload.parseRequest(request);
                
                for(int i=0; i<Elemntosinput.size();i++){
                    FileItem fileelemento= (FileItem) Elemntosinput.get(i);
                    
                    if(!fileelemento.isFormField()){
                         if(fileelemento.getName().equals("")){
                             modalumno.setFoto("C:\\imagenesproyectointecap\\sinpic.jpg");
                         }else{
                        
                        File archivo=new File("C:\\imagenesproyectointecap\\"+fileelemento.getName());
                        try {
                            fileelemento.write(archivo);
                        } catch (Exception ex) {
                            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        modalumno.setFoto("C:\\imagenesproyectointecap\\"+fileelemento.getName());
                         } 
                    }
                    else{
                    lista.add(fileelemento.getString());
                    }
                }
                
                  modalumno.setNombreAlumno(lista.get(0));
                modalumno.setApellidoAlumno(lista.get(1));
                                
                am.crear(modalumno);
                
                acceso = index;
            } catch (FileUploadException ex) {
                Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
       }else if(accion.equals("eliminar")){
           
           String id = request.getParameter("id");
           am.eliminar(Integer.parseInt(id));
           acceso=index;
       } else if (accion.equals("actualizar")) {
           /*sin foto
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            String id = request.getParameter("txtid");
            
            ModeloAlumno modal = new ModeloAlumno();
            modal.setNombreAlumno(nombre);
            modal.setApellidoAlumno(apellido);
            modal.setIdAlumno(Integer.parseInt(id));
            
            am.actualizar(modal);*/
            //con foto
         
          ///////////////////////////////////  
            /*
             try {
                 ArrayList<String> lista = new ArrayList<>();
                ModeloAlumno modalumno = new ModeloAlumno();
                FileItemFactory file = new DiskFileItemFactory();
                ServletFileUpload fileupload=new ServletFileUpload(file);
                List Elemntosinput= fileupload.parseRequest(request);
                
                for(int i=0; i<Elemntosinput.size();i++){
                    FileItem fileelemento= (FileItem) Elemntosinput.get(i);
                    
                    if(!fileelemento.isFormField()){
                       
                        File archivo=new File("C:\\imagenesproyectointecap\\"+fileelemento.getName());
                        try {
                            fileelemento.write(archivo);
                        } catch (Exception ex) {
                            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        modalumno.setFoto("C:\\imagenesproyectointecap\\"+fileelemento.getName());
                         System.out.println("esto"+modalumno.getFoto());
                                        
                    }
                    else{
                    lista.add(fileelemento.getString());
                    }
                }
                modalumno.setIdAlumno(Integer.parseInt(lista.get(0)));
                  modalumno.setNombreAlumno(lista.get(1));
                modalumno.setApellidoAlumno(lista.get(2));
                                
                am.actualizar(modalumno);
                
                acceso = index;
            } catch (FileUploadException ex) {
                Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            /* String url=null;
            try {
                 ArrayList<String> lista = new ArrayList<>();
                ModeloAlumno modalumno = new ModeloAlumno();
                ModeloAlumno moda = new ModeloAlumno();
                FileItemFactory file = new DiskFileItemFactory();
                ServletFileUpload fileupload=new ServletFileUpload(file);
                List Elemntosinput= fileupload.parseRequest(request);
                
                for(int i=0; i<Elemntosinput.size();i++){
                    FileItem fileelemento= (FileItem) Elemntosinput.get(i);
                    
                    if(!fileelemento.isFormField()){
                        
                        if(fileelemento.getName().equals("")){
                            
                          // modalumno.setImagen("C:\\imagenesproyectointecap\\Sin_Foto.png");   
                        }
                        else{
                        
                        File archivo=new File("C:\\imagenesproyectointecap\\"+fileelemento.getName());
                        try {
                            fileelemento.write(archivo);
                        } catch (Exception ex) {
                            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        url="C:\\imagenesproyectointecap\\"+fileelemento.getName();
                        System.out.println("lo que se tiene que guardar"+url);
                          }              
                    }
                    else{
                    lista.add(fileelemento.getString());
                    }
                }
                 
                /* ModeloAlumno modalumnoco = new ModeloAlumno();
                 List<ModeloAlumno> datos = am.findid(Integer.parseInt(lista.get(0)));
                
                 for (ModeloAlumno al : datos) {
                     
                     System.out.println(al.getIdAlumno());
                      System.out.println(al.getFoto());
                 if(al.getFoto()==null  ){
                  //modalumno.setFoto("C:\\imagenesproyectointecap\\rarrro.png"); 
                    moda.setIdAlumno(Integer.parseInt(lista.get(0)));
                  moda.setNombreAlumno(lista.get(1));
                moda.setApellidoAlumno(lista.get(2));
                   am.actualizar2(moda);
                 }else if(al.getFoto()!=null){
                     System.out.println("lo que se va a guardar"+url);
                      modalumno.setFoto(url);
                  modalumno.setIdAlumno(Integer.parseInt(lista.get(0)));
                  modalumno.setNombreAlumno(lista.get(1));
                modalumno.setApellidoAlumno(lista.get(2));
                  am.actualizar(modalumno);
                 }
                 
                 }*/
              String url=null;
            try {
                 ArrayList<String> lista = new ArrayList<>();
                ModeloAlumno modalumno = new ModeloAlumno();
                FileItemFactory file = new DiskFileItemFactory();
                ServletFileUpload fileupload=new ServletFileUpload(file);
                List Elemntosinput= fileupload.parseRequest(request);
                
                for(int i=0; i<Elemntosinput.size();i++){
                    FileItem fileelemento= (FileItem) Elemntosinput.get(i);
                    
                    if(!fileelemento.isFormField()){
                        
                        if(fileelemento.getName().equals("")){
                             modalumno.setIdAlumno(Integer.parseInt(lista.get(0)));
                  modalumno.setNombreAlumno(lista.get(1));
                modalumno.setApellidoAlumno(lista.get(2));
                  am.actualizar2(modalumno);
                  System.out.println("sin foto");
                         
                        }
                        else{
                        
                        File archivo=new File("C:\\imagenesproyectointecap\\"+fileelemento.getName());
                        try {
                            fileelemento.write(archivo);
                        } catch (Exception ex) {
                            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        url="C:\\imagenesproyectointecap\\"+fileelemento.getName();
                        modalumno.setFoto(url);
                  modalumno.setIdAlumno(Integer.parseInt(lista.get(0)));
                  modalumno.setNombreAlumno(lista.get(1));
                modalumno.setApellidoAlumno(lista.get(2));
                am.actualizar(modalumno);
                System.out.println("lo que se va a guardar "+url);
                          }              
                    }
                    else{
                    lista.add(fileelemento.getString());
                    }
                }
                
                acceso = index;
            } catch (FileUploadException ex) {
                Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
        }else if (accion.equals("nota")){
            acceso = nota;
            
            
            //grados acciones
        }else if (accion.equals("grado")){
            acceso = grado;
        }else if (accion.equals("eliminarg")){
            String id = request.getParameter("id");
           gm.eliminar(Integer.parseInt(id));
           acceso=grado;
        }else if(accion.equals("agregarg")){
            acceso=creargrado;
        }else if(accion.equals("guardarg")){
           String nombregrado = request.getParameter("txtnombregrado");
           ModeloGrado modgrad = new ModeloGrado();
           modgrad.setDescripcionGrado(nombregrado);
           
          gm.crear(modgrad);
          acceso = grado;
        }else if(accion.equals("editarg")){
            request.setAttribute("idgrado", request.getParameter("id"));
            acceso=editargrado;
            
        }else if(accion.equals("actualizarg")){
            
            String id = request.getParameter("txtidgrado");
            System.out.println("esto es el nombre "+request.getParameter("txtnombregrado"));
            System.out.println("esto es el id "+request.getParameter("txtidgrado"));
            String nombre = request.getParameter("txtnombregrado");
            System.out.println("esto es lo que se guarda en id"+id);
            ModeloGrado modgrad = new ModeloGrado();
            modgrad.setDescripcionGrado(nombre);
            modgrad.setIdGrado(Integer.parseInt(id));
            gm.actualizar(modgrad);
            
            acceso=grado;
            
              /*sin foto
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            String id = request.getParameter("txtid");
            
            ModeloAlumno modal = new ModeloAlumno();
            modal.setNombreAlumno(nombre);
            modal.setApellidoAlumno(apellido);
            modal.setIdAlumno(Integer.parseInt(id));
            
            am.actualizar(modal);*/
        }
            
       
       
       RequestDispatcher dispatcher = request.getRequestDispatcher(acceso);
       dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
