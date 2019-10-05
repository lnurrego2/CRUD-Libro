
<form method="post" action="" id="formEditarUsuario">
    <div class="form-group">
        <label for="exampleFormControlInput1" >Isbn</label>
        <input type="text" class="form-control"  id="editarCedula" name="isbn" readonly="readonly">
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Nombre</label>
        <input type="text" class="form-control"  name="nombre" >
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Descripcion</label>
        <input type="text" class="form-control"  name="descripcion" >
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Publicacion</label>
        <input type="text" class="form-control" name="publicacion" >
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Genero</label>
        <select class="form-control" name="rol" >
            <option value="">Escoja opción</option>
            <option value="susp">Suspenso</option>
            <option value="acc">Accion</option>
            <option value="come">Comedia</option>
            <option value="comi">Comics</option>
            <option value="dram">Drama</option>
            <option value="roma">Romance</option>
            <option value="terr">Terror</option>
            <option value="cief">Ciencia Ficcion</option>


        </select>
    </div>          
    <input type="submit" class="btn btn-info" name="ACTUALIZAR" id="btnActualizarL" value="actualizar"/>
</form>

<script src="resources/js/vista/actualizarLibro.js" type="text/javascript"></script>