<%-- 
    Document   : crearGrado
    Created on : 24/09/2022, 03:51:51 PM
    Author     : Linda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Grado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    </head>
    <body>
        
         <div class="container mt-4"></div>
        <h1 class="text-center bg-warning mb-4">Sistema de alumnos intecap</h1>
         <h2 class="text-center mb-2 mt-1">Añadir Grado nuevo</h2>
         <div class="card-body">
             <form>
             <div class="form-floating mb-3">
  <input type="text" name="txtnombregrado" class="form-control" id="floatingInput" placeholder="nombre grado">
  <label for="">Nombre del grado</label>
</div>
                 <div class="mb-3 mt-4">
</div>
                 <div class="d-grid gap-2">
                     <button class="btn btn-outline-primary mt-4" name="Accion" value="guardarg">GUARDAR GRADO</button>
                      <a href="controlador?Accion=grado"class="btn btn-primary">Volver a Inicio Grado</a>
                      <a href="controlador?Accion=index"class="btn btn-primary">Volver a Inicio Alumnos</a>
                     </div>
             </form>     
         </div>
        
    </body>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</html>
