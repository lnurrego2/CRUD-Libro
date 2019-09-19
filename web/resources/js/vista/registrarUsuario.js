/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var registrarUsuario={
    init:function(){
        $("#formRegistrarUsuario").submit(function(){
            return false;
        })
        
        $("#btnRegistrarU").click(function(){
            registrarUsuario.validarCampos()
        })
    },
    validarCampos:function(){
      registrarUsuario.registrar()  
    },
    registrar:function(){
        $.ajax({
            url:'./usuario/registrar',
            type:'post',
            dataType:'json',
            data:$("#formRegistrarUsuario").serialize(),
            success:function(resultado){
              registrarUsuario.mostrarMensaje(resultado)  
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
registrarUsuario.init()