<%-- 
    Document   : login
    Created on : 26/09/2022, 10:02:38 AM
    Author     : Linda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
   
    </head>
    <body>
        <div class="container mt-4"></div>
        <h1 class="text-center bg-info mb-4">Sistema de alumnos intecap</h1>
         <h2 class="text-center mb-2 mt-1">Login</h2>
    <center><div class="container">
              
            <div class="card mt-4" style="width: 50rem;">
              
                <form  action="controlador?Accion=login" method="POST"  >
            <div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Nombre Usuario</label>
  <input type="text" name="txtnombre" class="form-control" id="" placeholder="usuario">
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Contraseña</label>
  <input type="password" name="txtpass" class="form-control" id="" placeholder="contraseña">
</div>
             <button class="btn btn-outline-danger" name="Accion" value="login">Ingresar</button>
                     </form>
                
                
            </div>
            
         </div>
    </center>
    </body>
    
   <script type="text/javascript" charset="utf8" src=" https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
     <script>
    function redireccion() {
            window.location = "http://localhost:8080/clienteWSColegioIntecap/login.jsp";

        }

        var loc = window.location;
        //alert(window.location);
        if (loc == "http://localhost:8080/clienteWSColegioIntecap/login.jsp") {


        } else {

            var urltexto = String(loc).indexOf("login");
            if (urltexto >= 0) {

                Swal.fire({
                    icon: 'error',
                    title: 'contraseña o usuario inconrrectos',
                    text: 'Prueba de nuevo por favor',

                });
                setTimeout("redireccion()", 2000);
            }

         

        }
        // 

    </script>
</html>
