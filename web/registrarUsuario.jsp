<%-- 
    Document   : registrarUsuario
    Created on : 6/09/2019, 05:17:15 PM
    Author     : Sena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="http://localhost:8080/java620/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="http://localhost:8080/java620/resources/js/jquery-3.3.1.js" ></script>
        <script src="http://localhost:8080/java620/resources/js/popper.min.js" type="text/javascript"></script>
        <script src="http://localhost:8080/java620/resources/js/bootstrap.js" type="text/javascript"></script>
    </head>
    </head>
    <body>
        <h1>Registrar usuario</h1>

        <a href="ruta">Ruta</a>
        <form method="post" action="./usuario/registrar">
            <div class="form-group">
                <label for="exampleFormControlInput1">Cedula</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="cedula" >
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput1">Nombre</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="nombre" >
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput1">Apellido</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="apellido" >
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput1">Correo</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="correo" >
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput1">Telefono</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="telefono" >
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Rol</label>
                <select class="form-control" name="rol" id="exampleFormControlSelect1">
                    <option value="">Escoja opción</option>
                    <option value="user">Usuario</option>
                    <option value="supervisor">Supervisor</option>
                    <option value="admin">Administrador</option>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput1">Clave</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="clave" >
            </div>            
            <input type="submit" class="btn btn-info" name="REGISTRAR" value="registrar"/>
        </form>

    </body>
</html>
