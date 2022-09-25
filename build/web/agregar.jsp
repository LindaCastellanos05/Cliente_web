<%-- 
    Document   : agregar
    Created on : 20/09/2022, 09:55:39 AM
    Author     : Linda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    </head>
    <body>
        <div class="container mt-4"></div>
        <h1 class="text-center bg-warning mb-4">Sistema de alumnos intecap</h1>
         <h2 class="text-center mb-2 mt-1">Añadir alumno</h2>
         <div class="card-body">
             <form action="controlador?Accion=guardar"method="POST"enctype="multipart/form-data">
             <div class="form-floating mb-3">
  <input type="text" name="txtnombre" class="form-control" id="floatingInput" placeholder="nombre">
  <label for="">Nombre de Alumno</label>
</div>
<div class="form-floating">
  <input type="text" name="txtapellido" class="form-control" id="floatingPassword" placeholder="apellido">
  <label for="">Apellido de Alumno</label>
</div>
                 <div class="mb-3 mt-4">
  <label for="formFile" class="form-label">Foto Alumno</label>
  <input class="form-control" type="file" id="formFile" name="imagen">
</div>
                 <div class="d-grid gap-2">
                     <button class="btn btn-outline-primary mt-4" name="Accion" value="guardar">GUARDAR ALUMNO</button>
                      <a href="controlador?Accion=index"class="btn btn-primary">Volver a Inicio</a>
                     </div>
             </form>     
         </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</html>
