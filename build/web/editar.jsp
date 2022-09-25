<%-- 
    Document   : editar
    Created on : 20/09/2022, 11:11:50 AM
    Author     : Linda
--%>

<%@page import="ws.ModeloAlumno"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.AlumnoModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    </head>
    <body>
        <div class="container mt-4"></div>
        <h1 class="text-center bg-info mb-4">Sistema de alumnos intecap</h1>
         <h1 class="text-center mb-2 mt-1">Editar alumno</h1>
     
          <div class="card">
                <div class="card-header" >
         
         <%
         int id=Integer.parseInt((String)request.getAttribute("idalumno"));
         AlumnoModelo alumnos = new AlumnoModelo();
         List<ModeloAlumno> datos = alumnos.findid(id);
         
for(ModeloAlumno al: datos){
    

         %>
        
         <form action="controlador?Accion=actualizar"method="POST"enctype="multipart/form-data" >
         <div class="form-floating mb3">
             <input type="number" name="txtid" class="form-control" id="floatingInput" readonly="true" placeholder="nombre" value="<%= al.getIdAlumno()%>">
                            <label for="">Id Alumno</label>
              </div>
                             <div class="form-floating mb-3">
                            <input type="text" name="txtnombre" class="form-control" id="floatingInput" placeholder="nombre" value="<%= al.getNombreAlumno() %>">
                            <label for="">Nombre de Alumno</label>
                        </div>
                        <div class="form-floating">
                            <input type="text" name="txtapellido" class="form-control" id="floatingPassword" placeholder="apellido" value="<%= al.getApellidoAlumno()%>">
                            <label for="">Apellido de Alumno</label>
                        </div>
                            <div class="d-grid gap-2">
                            <div class="mb-3">
                                <label for="formFile" class="form-label">Default file input example</label>
                                <input class="form-control" type="file" id="formFile" name="imagen">

                            </div>
                            <button class="btn btn-outline-primary" name="Accion" value="actualizar">Editar Alumno</button>
                            <a href="controlador?Accion=index" class="btn btn-warning" >regresar</a>
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
