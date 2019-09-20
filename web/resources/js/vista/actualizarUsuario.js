/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var actualizarUsuario={
    init:function(){
        
        actualizarUsuario.consultarUsuario()
        
        
        $("#formEditarUsuario").submit(function(){
            return false;
        })
        
        $("#btnActualizarU").click(function(){
            actualizarUsuario.validarCampos()
        })
    },
    consultarUsuario:function(){
        
        var cedula=localStorage.getItem("cedula")
        
        $.ajax({
            url:'./usuario/consultar',
            type:'post',
            dataType:'json',
            data:{cedula:cedula},
            success:function(resultado){
                console.log(resultado)
                $("input[name='cedula']").val(resultado.cedula);
                $("input[name='nombre']").val(resultado.nombre);
                $("input[name='apellido']").val(resultado.apellido);
                $("input[name='telefono']").val(resultado.telefono);
                $("input[name='correo']").val(resultado.correo);
                $("select[name='rol']").val(resultado.rol);
              //actualizarUsuario.mostrarMensaje(resultado)  
            },
            error:function(){
                
            }
        })
    },
    validarCampos:function(){
      actualizarUsuario.actualizar()  
    },
    actualizar:function(){
        $.ajax({
            url:'./usuario/actualizar',
            type:'post',
            dataType:'json',
            data:$("#formActualizarUsuario").serialize(),
            success:function(resultado){
              actualizarUsuario.mostrarMensaje(resultado)  
            },
            error:function(){
                
            }
        })
    },
    mostrarMensaje:function(resultado){
        $("#exampleModal .modal-body").html(resultado)
        $("#exampleModal").modal('toggle') //desplegar modal
        $(".modal-footer").show()
        usuario.init()
    }
    
}
actualizarUsuario.init()