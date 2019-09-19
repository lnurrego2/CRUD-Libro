
<a href="ruta">Ruta</a>
<form method="post" action="" id="formRegistrarUsuario">
    <div class="form-group">
        <label for="exampleFormControlInput1">Cedula</label>
        <input type="text" class="form-control"  name="cedula" >
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Nombre</label>
        <input type="text" class="form-control"  name="nombre" >
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Apellido</label>
        <input type="text" class="form-control"  name="apellido" >
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Correo</label>
        <input type="text" class="form-control"  name="correo" >
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Telefono</label>
        <input type="text" class="form-control" name="telefono" >
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Rol</label>
        <select class="form-control" name="rol" >
            <option value="">Escoja opción</option>
            <option value="user">Usuario</option>
            <option value="supervisor">Supervisor</option>
            <option value="admin">Administrador</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Clave</label>
        <input type="text" class="form-control"  name="clave" >
    </div>            
    <input type="submit" class="btn btn-info" name="REGISTRAR" id="btnRegistrarU" value="registrar"/>
</form>

<script src="resources/js/vista/registrarUsuario.js" type="text/javascript"></script>