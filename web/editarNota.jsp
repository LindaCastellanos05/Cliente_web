<%-- 
    Document   : editarNota
    Created on : 25/09/2022, 09:45:24 AM
    Author     : Linda
--%>

<%@page import="ws.ModeloNota"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.NotaModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar nota</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    </head>
    <body>
         <div class="container mt-4"></div>
        <h1 class="text-center bg-info mb-4">Sistema de alumnos intecap</h1>
         <h1 class="text-center mb-2 mt-1">Editar Nota</h1>
         
         <div class="card">
                <div class="card-header" >
         
                    <%
         int id=Integer.parseInt((String)request.getAttribute("idal"));
         int id2=Integer.parseInt((String)request.getAttribute("idgr"));
         NotaModelo notas = new NotaModelo();
         List<ModeloNota> datos = notas.findid(id,id2);
         
for(ModeloNota nt: datos){
    

         %>
                    
         <form>
         
         <div class="form-floating mb3">
             <input type="text" name="txtal" class="form-control" id="floatingInput" readonly="true" placeholder="nombre" value="<%= nt.getNombreAlumno() %>">
                            <label for="">Alumno</label>
                            <input type="text" name="txtidalu" class="form-control" id="floatingInput" readonly="true" placeholder="nombre" value="<%= nt.getIdAlumno() %>">
                            
              </div>
                            <div class="form-floating mb3">
             <input type="text" name="txtgr" class="form-control" id="floatingInput" readonly="true" placeholder="nombre" value="<%= nt.getNombreGrado() %>">
                            <label for="">Grado</label>
                             <input type="text" name="txtidgra" class="form-control" id="floatingInput" readonly="true" placeholder="nombre" value="<%= nt.getIdGrado() %>">
                            
              </div>
                             <div class="form-floating mb-3">
                            <input type="text" name="txtnota1" class="form-control" id="floatingInput" placeholder="nombre" value="<%= nt.getNota1() %>">
                            <label for="">Nota #1</label>
                        </div>
                            <div class="form-floating mb-3">
                            <input type="text" name="txtnota2" class="form-control" id="floatingInput" placeholder="nombre" value="<%= nt.getNota2() %>">
                            <label for="">Nota #2</label>
                        </div>
                            <div class="form-floating mb-3">
                            <input type="text" name="txtnota3" class="form-control" id="floatingInput" placeholder="nombre" value="<%= nt.getNota3() %>">
                            <label for="">Nota #3</label>
                            </div>
                            <div class="form-floating mb-3">
                            <input type="text" name="txtnota4" class="form-control" id="floatingInput" placeholder="nombre" value="<%= nt.getNota4() %>">
                            <label for="">Nota #4</label>
                        </div>
                    <div class="d-grid gap-2">
                            
                            <button class="btn btn-outline-primary" name="Accion" value="actualizarn">Editar Nota</button>
                            <a href="controlador?Accion=notas" class="btn btn-warning" >Regresar a inicio Nota</a>
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
