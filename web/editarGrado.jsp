<%-- 
    Document   : editarGrado
    Created on : 24/09/2022, 04:28:57 PM
    Author     : Linda
--%>

<%@page import="ws.ModeloGrado"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.GradoModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Grado</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    </head>
    <body>
        
        <div class="container mt-4"></div>
        <h1 class="text-center bg-info mb-4">Sistema de alumnos intecap</h1>
         <h1 class="text-center mb-2 mt-1">Editar Grado</h1>
     

     
          <div class="card">
                <div class="card-header" >
         
                    <%
         int id=Integer.parseInt((String)request.getAttribute("idgrado"));
         GradoModelo grados = new GradoModelo();
         List<ModeloGrado> datos = grados.findid(id);
         
for(ModeloGrado gr: datos){
    

         %>
                    
         <form>
         
         <div class="form-floating mb3">
             <input type="number" name="txtidgrado" class="form-control" id="floatingInput" readonly="true" placeholder="nombre" value="<%= gr.getIdGrado() %>">
                            <label for="">Id Grado</label>
              </div>
                             <div class="form-floating mb-3">
                            <input type="text" name="txtnombregrado" class="form-control" id="floatingInput" placeholder="nombre" value="<%= gr.getDescripcionGrado() %>">
                            <label for="">Nombre del grado</label>
                        </div>
                    <div class="d-grid gap-2">
                            
                            <button class="btn btn-outline-primary" name="Accion" value="actualizarg">Editar Grado</button>
                            <a href="controlador?Accion=grado" class="btn btn-warning" >Regresar a inicio Grado</a>
                            <a href="controlador?Accion=index" class="btn btn-warning" >Regresar a inicio Alumnos</a>
                    </div>
                            

           
         </form>
    <%
        }
    %>           
   
         </div>
     </div>
        
    </body>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</html>
