/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var usuario = {

    init: function () {
        
        $("#btnRegistrarUsuario").click(function(){
            usuario.desplegarVistaRegistrar()
        })
        $.ajax({
            url: "./usuario/listar",
            dataType: "json",
            type: "post",
            success: function (resultado) {
                
                usuario.dibujartabla(resultado)
                 
            },
            error: function (error) {
                console.log(error)
            }
        })
    },
    dibujartabla: function (resultado) {
        var temp = "";
        resultado.map(fila => {
            temp += `<tr>
                                        <td>${fila.cedula}</td>
                                        <td>${fila.nombre}</td>
                                        <td>${fila.apellido}</td>
                                        <td>${fila.correo}</td>
                                        <td>${fila.rol}</td>
                                        <td>${fila.telefono}</td>
                                        <td><button class='btn btn-info btnActualizarUsuario' data-id='${fila.cedula}'>EDITAR</button></td>
                                        <td><button class='btn btn-danger btnEliminarUsuario' data-id='${fila.cedula}'>ELIMINAR</button></td>
                                    </tr>`
        })
        $("table tbody").html(temp)
        $("table tbody td").css("background", "cyan")
        usuario.agregarEventos()
       
    },
    agregarEventos:function(){        
        $(".btnActualizarUsuario").click(function () {
            //captura la cédula con base en el atributo data-id
            var cedula= $(this).attr("data-id")
            $("#exampleModal .modal-body").load("./actualizarUsuario.jsp")
            $("#exampleModal").modal('toggle') //desplegar modal
            $(".modal-header h5").html("<h2>ACTUALIZAR USUARIO</h2>")
            $(".modal-footer").hide()
            
            localStorage.setItem("cedula",cedula)
            
        })
        $(".btnEliminarUsuario").click(function () {
            //captura la cédula con base en el atributo data-id
            var cedula= $(this).attr("data-id")
            
            //manipulay desplegar modal
            $("#exampleModal .modal-body").html("¿Desea eliminar al usuario con cédula: " + $(this).attr("data-id")+ " ?")
            $("#exampleModal").modal() //desplegar modal
            $(".btnModalAceptar").click(function(){
                console.log("desde eliminar")
                usuario.eliminarUsuario(cedula)
            })
        })
    },
    eliminarUsuario:function(cedula){
        console.log(cedula)
        $.ajax({
            url:'./usuario/eliminar',
            type:'post',
            data:{cedula:cedula},
            dataType:'json',
            success:function(resultado){
                console.log(resultado)
                $("#exampleModal").modal('toggle')
                usuario.init()
            },
            error:function(error){
                console.log(error)
            }
        })
    },
    desplegarVistaRegistrar:function(){
        $("#exampleModal .modal-body").load("./registrarUsuario.jsp")
        $("#exampleModal").modal('toggle') //desplegar modal
        $(".modal-header h5").html("<h2>REGISTRAR USUARIO</h2>")
        $(".modal-footer").hide()
    }

}
usuario.init()
