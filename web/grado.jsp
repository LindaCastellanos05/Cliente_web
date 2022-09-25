<%-- 
    Document   : grado
    Created on : 22/09/2022, 10:36:26 AM
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
        <title>Grados</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
     
        
    </head>
    <body>
        <div class="container mt-4"></div>
        <h1 class="text-center bg-info mb-4">Sistema de alumnos intecap</h1>
        
        <div class="card-header">
               <a href="controlador?Accion=agregarg"class="btn btn-primary">Agregar Grado</a>
            
               <div class="card-body">
                    <table id="mitablaintecap2" class="table table-striped table-hover" style="">
                   
                         <div class="mt-2 mb-2">
                           <input type="text" name="txtnombre" class="form-control" id="txtid" placeholder="ID">
                        <input type="text" name="txtnombre" class="form-control" id="txtnombre" placeholder="grado">
                         
                    </div>
                        
                        
                        
                       <thead>
                    <th>ID</th>
                    <th>GRADO</th>
                        <th>ACCIONES</th>
                        
                    </thead>
                    <tbody>
                        <%
                         GradoModelo grad= new GradoModelo();
                         List<ModeloGrado>datos=grad.Todosgrados();
                         
for(ModeloGrado g:datos){
    

                            %>
                        <tr>
                    <td><%=g.getIdGrado() %> </td>
                    <td><%=g.getDescripcionGrado() %> </td><!-- comment -->
                    
                    <td>
                        <a href="controlador?Accion=editarg&id=<%= g.getIdGrado() %>"class="btn btn-warning">EDITAR</a>
                        <a href="controlador?Accion=eliminarg&id=<%= g.getIdGrado() %>"class="btn btn-danger">ELIMINAR</a>
                    </td>
                        </tr>
                    <%} %>
                    </tbody>
                    
                </table>    
                       
            
            
        </div>
        </div> 
        
    </body>
    
    <script type="text/javascript" charset="utf8" src=" https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    
    <script>
        
        function redireccion(){
        window.location="http://localhost:8080/clienteWSColegioIntecap/controlador?Accion=grado";
        }
        var loc =window.location;
        //alert(window.location);
        if(loc=="http://localhost:8080/clienteWSColegioIntecap/controlador?Accion=grado"){
            
    } else {
            
            var palabra="eliminarg";
           // alert(loc);
            var urltexto=String(loc).indexOf("eliminarg");
            if(urltexto>=0){
               // alert("se elimino");
               
              Swal.fire({
  icon: 'error',
  title: 'Se elimino el Grado',
  text: 'SE PROCEDIO A ELIMINAR EL GRADO!',
  
});
                  setTimeout("redireccion()",2000);
                            }
                            
               var urltexto3=String(loc).indexOf("guardarg");
            if(urltexto3>=0){
               // alert("se elimino");
               
              Swal.fire({
  icon: 'success',
  title: 'Se Guardo Grado',
  text: 'SE PROCEDIO A GUARDAR GRADO!',
  
});
                  setTimeout("redireccion()",2000);
                            }              
            
            
          
        }
        // setTimeout("redireccion()"",500);
        </script>
        
         <script>
        
        $(document).ready(function () {
    $('#mitablaintecap2').DataTable();
});
    </script>
    
</html>
