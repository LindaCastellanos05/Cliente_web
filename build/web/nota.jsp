<%-- 
    Document   : nota
    Created on : 25/09/2022, 08:58:12 AM
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
         <title>Notas</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
     
  
        
    </head>
    <body>
        
         <div class="container mt-4"></div>
        <h1 class="text-center bg-info mb-4">Sistema de alumnos intecap</h1>
        
        <div class="bg-warning card-header">
               <a href="controlador?Accion=agregarn"class="btn btn-primary">Agregar Nota</a>
               <a href="controlador?Accion=index" class="btn btn-info">Inicio Alumnos</a>
            
               
               <center><div class="container mt-2 mb-2">
                           <input type="text" name="txtnombre" class="form-control" id="txtal" placeholder="alumno"readonly="true">
                        <input type="text" name="txtnombre" class="form-control" id="txtgr" placeholder="grado"readonly="true">
                        <input type="text" name="txtnombre" class="form-control" id="txtno1" placeholder="nota 1"readonly="true">
                        <input type="text" name="txtnombre" class="form-control" id="txtno2" placeholder="nota 2"readonly="true">
                        <input type="text" name="txtnombre" class="form-control" id="txtno3" placeholder="nota 3"readonly="true">
                        <input type="text" name="txtnombre" class="form-control" id="txtno4" placeholder="nota 4"readonly="true">
                         
                    </div></center>
                         </div>
                        
           
                        <div class="card-body">
                   
                  
                    <table id="mitablaintecap3" class="table table-primary" style="width:100%">
                  
                        
                       <thead>
                    <th>ID ALUMNO</th>
                     <th>NOMBRE ALUMNO</th>
                    <th>ID GRADO</th>
                    <th>NOMBRE GRADO</th>
                        <th>NOTA 1</th>
                        <th>NOTA 2</th>
                        <th>NOTA 3</th>
                        <th>NOTA 4</th>
                        <th>ACCIONES</th>
                        
                    </thead>
                    <tbody>
                        <%
                         NotaModelo notas= new NotaModelo();
                         List<ModeloNota>datos=notas.Todosnotas();
                         
for(ModeloNota nt:datos){
    

                            %>
                        <tr id="notasdatos">
                    <td><%=nt.getIdAlumno() %> </td>
                    <td><%=nt.getNombreAlumno() %> </td><!-- comment -->
                    <td><%=nt.getIdGrado() %> </td>
                    <td><%=nt.getNombreGrado() %> </td>
                    <td><%=nt.getNota1() %> </td>
                    <td><%=nt.getNota2() %> </td>
                    <td><%=nt.getNota3() %> </td>
                    <td><%=nt.getNota4() %> </td>
                    <td>
                        <a href="controlador?Accion=editarn&idal=<%= nt.getIdAlumno() %>&idgr=<%= nt.getIdGrado() %>"class="btn btn-warning">EDITAR</a>
                        <a href="controlador?Accion=eliminarn&idal=<%= nt.getIdAlumno() %>&idgr=<%= nt.getIdGrado() %>"class="btn btn-danger">ELIMINAR</a>
                    </td>
                        </tr>
                    <%} %>
                    </tbody>
                    
                </table>    
                       
              </div>
       
         
    </body>
     <script type="text/javascript" charset="utf8" src=" https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
      <script>
        
        function redireccion(){
        window.location="http://localhost:8080/clienteWSColegioIntecap/controlador?Accion=nota";
        }
        var loc =window.location;
        //alert(window.location);
        if(loc=="http://localhost:8080/clienteWSColegioIntecap/controlador?Accion=nota"){
            
    } else {
            
            var palabra="eliminar";
           // alert(loc);
            var urltexto=String(loc).indexOf("eliminar");
            if(urltexto>=0){
               // alert("se elimino");
               
              Swal.fire({
  icon: 'error',
  title: 'Se elimino nota',
  text: 'SE PROCEDIO A ELIMINAR!',
  
});
                  setTimeout("redireccion()",2000);
                            }
                            
               var urltexto3=String(loc).indexOf("guardar");
            if(urltexto3>=0){
               // alert("se elimino");
               
              Swal.fire({
  icon: 'success',
  title: 'Se Guardo nota',
  text: 'SE PROCEDIO A GUARDAR DATOS !',
  
});
                  setTimeout("redireccion()",2000);
                            }
                             var urltexto3=String(loc).indexOf("actualizar");
            if(urltexto3>=0){
               // alert("se elimino");
               
              Swal.fire({
  icon: 'info',
  title: 'Se actualizo nota',
  text: 'SE PROCEDIO A ACTUALIZAR DATOS !',
  
});
                  setTimeout("redireccion()",2000);
                            }              
            
            
          
        }
        // setTimeout("redireccion()"",500);
        </script>
        
         <script>
        
        $(document).ready(function () {
    $('#mitablaintecap3').DataTable();
});
    </script>
    <script>
     
   //getElementById obtengo 
    var table =document.getElementById("mitablaintecap3");
        //por etiqueta getElementsByTagName
        var tbody=document.getElementsByTagName("tbody");
      $("body").on("click","#notasdatos",function(event){
           
          e=event||windows.event;
          var data=[];
          var target=e.srcElement || e.target;
           
          while(target&&target.nodeName !=="TR"){
              target=target.parentNode;
              
          }
           if(target){
              var cells=target.getElementsByTagName("td");
               
              for(var i=0;i<cells.length;i++){
                  data.push(cells[i].innerHTML);
                                    
              }
          }
             
         
               document.getElementById('txtal').value=data[1];
               document.getElementById('txtgr').value=data[3];
               document.getElementById('txtno1').value=data[4];
               document.getElementById('txtno2').value=data[5];
               document.getElementById('txtno3').value=data[6];
               document.getElementById('txtno4').value=data[7];
      });  
        
    </script>
    
</html>