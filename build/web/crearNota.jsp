<%-- 
    Document   : crearNota
    Created on : 25/09/2022, 08:45:17 AM
    Author     : Linda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear nota</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
        
    </head>
    <body>
        
        <div class="container mt-4"></div>
        <h1 class="text-center bg-warning mb-4">Sistema de alumnos intecap</h1>
         <h2 class="text-center mb-2 mt-1">Añadir Nota nueva</h2>
         <div class="card-body">
             <form>
             <div class="form-floating mb-3">
  <input type="text" name="txtidal" class="form-control" id="floatingInput" placeholder="ID alumno">
  <label for="">ID del Alumno</label>
</div>
                 <div class="form-floating mb-3">
  <input type="text" name="txtidgr" class="form-control" id="floatingInput" placeholder="ID grado">
  <label for="">ID del Grado</label>
</div>
                 <div class="form-floating mb-3">
  <input type="text" name="txtnota1" class="form-control" id="floatingInput" placeholder="nota 1">
  <label for="">Nota #1</label>
</div>
                  <div class="form-floating mb-3">
  <input type="text" name="txtnota2" class="form-control" id="floatingInput" placeholder="nota 2">
  <label for="">Nota #2</label>
</div>
                  <div class="form-floating mb-3">
  <input type="text" name="txtnota3" class="form-control" id="floatingInput" placeholder="nota 3">
  <label for="">Nota #3</label>
</div>
   <div class="form-floating mb-3">
  <input type="text" name="txtnota4" class="form-control" id="floatingInput" placeholder="nota 4">
  <label for="">Nota #4</label>
</div>
                 <div class="mb-3 mt-4">
</div>
                 <div class="d-grid gap-2">
                     <button class="btn btn-outline-primary mt-4" name="Accion" value="guardarn">GUARDAR NOTA</button>
                      <a href="controlador?Accion=notas"class="btn btn-primary">Volver a Inicio NOTAS</a>
                      <a href="controlador?Accion=index"class="btn btn-primary">Volver a Inicio Alumnos</a>
                     </div>
             </form>     
         </div>
        
        
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</html>
