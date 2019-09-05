/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.vo;

import java.sql.Date;

/**
 *
 * @author Sena
 */
public class UsuarioVO {
    //atributos
    private long cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private long telefono;
    private String rol;
    private boolean estado;
    private String clave;
    private Date f_creacion;
    private Date f_actualizacion;
    
    //constructor

    public UsuarioVO() {
    }
    
    //get y set

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }

    public Date getF_actualizacion() {
        return f_actualizacion;
    }

    public void setF_actualizacion(Date f_actualizacion) {
        this.f_actualizacion = f_actualizacion;
    }
    
    
    
}
