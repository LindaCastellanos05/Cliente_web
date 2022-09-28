<%-- 
    Document   : index
    Created on : 20/09/2022, 09:48:16 AM
    Author     : Linda
--%>

<%@page import="java.util.List"%>
<%@page import="ws.ModeloAlumno"%>
<%@page import="Modelos.AlumnoModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>
        
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
     
  
    
    </head>
    
    <body>
        <div class="container mt-4"></div>
        <h1 class="text-center bg-info mb-4">Sistema de alumnos intecap</h1>
        
        <div class="card">
           
            <div class="bg-warning card-header">
               <a href="controlador?Accion=agregar"class="btn btn-primary">Agregar Usuario</a>
               <a href="controlador?Accion=grado"class="btn btn-info">Grados</a>
               <a href="controlador?Accion=notas"class="btn btn-success">Notas</a>
                
            
               <center><div class="container mt-2">
                
               <div class="bg-info mt-2 mb-2">
                   
                   <input type="text" name="txtidalumnobuscar" class="form-control" id="txtid" placeholder="ID" readonly="true">
                        <input type="text" name="txtnombre" class="form-control" id="txtnombre" placeholder="nombre" readonly="true">
                         <input type="text" name="txtnombre" class="form-control" id="txtapellido" placeholder="apellido" readonly="true">
                         <div id="imagen" name="imagenal"></div>
                         
                 </div>          
                         
                         
                   </div>
                       </center> 
            </div>
               <div class="card-body">
                <table id="mitablaintecap" class="table table-success table-striped" style="width:100%">
                   
                       <thead>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                        <th>FOTO</th>
                        <th>ACCIONES</th>
                        
                    </thead>
                    <tbody>
                        <%
                         AlumnoModelo alumnos = new AlumnoModelo();
                         List<ModeloAlumno>datos=alumnos.Todosalumnos();
                         
for(ModeloAlumno al:datos){
    

                            %>
                        <tr id="alumnosdatos">
                    <td><%=al.getIdAlumno() %> </td>
                    <td><%=al.getNombreAlumno() %> </td><!-- comment -->
                    <td><%=al.getApellidoAlumno() %> </td>
                    <%
                    if(al.getFoto()!=null){
                    %> 
                    <td><img src="data:image/jpeg;base64,<%=al.getFoto() %> "alt="Red dot" widht="120" height="120"/></td>
<%
                     }else{ 

%>
                    <td>no hay foto</td>
                   <%
                       } 
                   %>
                    <td>
                        <a href="controlador?Accion=editar&id=<%= al.getIdAlumno() %>"class="btn btn-warning">EDITAR</a>
                        <a href="controlador?Accion=eliminar&id=<%= al.getIdAlumno() %>"class="btn btn-danger">ELIMINAR</a>
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
   <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script type="text/javascript" charset="utf8" src=" https://code.jquery.com/jquery-3.5.1.js"></script>
     <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
   
   <script>
        
        function redireccion(){
        window.location="http://localhost:8080/clienteWSColegioIntecap/";
        }
        var loc =window.location;
        //alert(window.location);
        if(loc=="http://localhost:8080/clienteWSColegioIntecap/"){
            
    } else {
            
            var palabra="eliminar";
           // alert(loc);
            var urltexto=String(loc).indexOf("eliminar");
            if(urltexto>=0){
               // alert("se elimino");
               
              Swal.fire({
  icon: 'error',
  title: 'Se elimino Alumno',
  text: 'SE PROCEDIO A ELIMINAR!',
  
});
                  setTimeout("redireccion()",2000);
                            }
                            
               var urltexto3=String(loc).indexOf("guardar");
            if(urltexto3>=0){
               // alert("se elimino");
               
              Swal.fire({
  icon: 'success',
  title: 'Se Guardo Alumno',
  text: 'SE PROCEDIO A Guardar DATOS!',
  
});
                  setTimeout("redireccion()",2000);
                            }
                             var urltexto3=String(loc).indexOf("actualizar");
            if(urltexto3>=0){
               // alert("se elimino");
               
              Swal.fire({
  icon: 'info',
  title: 'Se actualizo Alumno',
  text: 'SE PROCEDIO A ACTUALIZAR DATOS !',
  
});
                  setTimeout("redireccion()",2000);
                            }              
            
            
          
        }
        // setTimeout("redireccion()"",500);
        </script>
        
         <script>
        
        $(document).ready(function () {
    $('#mitablaintecap').DataTable();
});
    </script>
    <script>
     
   //getElementById obtengo 
    var table =document.getElementById("mitablaintecap");
        //por etiqueta getElementsByTagName
        var tbody=document.getElementsByTagName("tbody");
      $("body").on("click","#alumnosdatos",function(event){
           //alert("le dio un click a la tabla");
          e=event||windows.event;
          var data=[];
           var data2=[];
          var target=e.srcElement || e.target;
         var target2=e.srcElement || e.target;
           
          while(target&&target.nodeName !=="TR"){
              target=target.parentNode;
              
          }
           if(target){
              var cells=target.getElementsByTagName("td");
               
              for(var i=0;i<cells.length;i++){
                  data.push(cells[i].innerHTML);
                 
              
                                    
              }
              
          }
             
       
          
               document.getElementById('txtid').value=data[0];
          document.getElementById('txtnombre').value=data[1];
               document.getElementById('txtapellido').value=data[2];
            document.getElementById('imagen').innerHTML=data[3];
      });  
        
    </script>
</html>
