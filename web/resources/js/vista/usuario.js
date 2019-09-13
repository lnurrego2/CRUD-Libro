/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var usuario = {

    init: function () {
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
            $("#exampleModal .modal-body").html("Actualizar: " + $(this).attr("data-id"))
            $("#exampleModal").modal()

            
        })
        $(".btnEliminarUsuario").click(function () {
            var cedula= $(this).attr("data-id")
            $("#exampleModal .modal-body").html("¿Desea eliminar al usuario con cédula: " + $(this).attr("data-id")+ " ?")
            $("#exampleModal").modal()
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
            sucess:function(resultado){
                console.log(resultado)
                usuario.init()
            },
            error:function(error){
                console.log(error)
            }
        })
    },

}
usuario.init()
