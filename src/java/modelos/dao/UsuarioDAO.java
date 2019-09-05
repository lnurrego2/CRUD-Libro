/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.bd.ConexionSingleton;
import modelos.vo.UsuarioVO;

/**
 *
 * @author Sena
 */
public class UsuarioDAO  implements InterfaceCRUD{

    private Connection conn;
    private UsuarioVO vo;
    
    public UsuarioDAO(){
        conn=ConexionSingleton.obtenerConexion();
    }
    public UsuarioDAO(UsuarioVO vo){
        this.conn=ConexionSingleton.obtenerConexion();
        this.vo=vo;
    }
    
    @Override
    public Object consultar() {
        try{
           String consulta="SELECT * FROM usuario WHERE cedula=? AND estado=true";
           PreparedStatement ps = this.conn.prepareStatement(consulta);
           ps.setLong(1, vo.getCedula());
           ResultSet resultSet = ps.executeQuery();
           
           while(resultSet.next()){
               vo.setNombre(resultSet.getString("nombre"));
               vo.setApellido(resultSet.getString("apellido"));
               vo.setCorreo(resultSet.getString("correo"));
               vo.setRol(resultSet.getString("rol"));
               vo.setTelefono(resultSet.getLong("telefono"));
               
           }
           return vo;
        }catch(SQLException ex){
            System.out.println(ex.getMessage()); 
        }        
        return null;        
    }

    @Override
    public boolean eliminar() {
        return false;
    }

    @Override
    public boolean registrar() {
        return false;
    }

    @Override
    public boolean actualizar() {
        return false;
    }

    @Override
    public ArrayList<Object> listar() {
        try{
           String consulta="SELECT * FROM usuario WHERE estado = true";
           PreparedStatement ps = this.conn.prepareStatement(consulta);
           ResultSet resultSet = ps.executeQuery();
           
           ArrayList<UsuarioVO> list = new ArrayList<UsuarioVO>();
           
           while(resultSet.next()){
               UsuarioVO temp = new UsuarioVO();
               temp.setCedula(resultSet.getLong("cedula"));
               temp.setNombre(resultSet.getString("nombre"));
               temp.setApellido(resultSet.getString("apellido"));
               temp.setCorreo(resultSet.getString("correo"));
               temp.setRol(resultSet.getString("rol"));
               temp.setTelefono(resultSet.getLong("telefono"));  
               list.add(temp);
           }
           return (ArrayList<Object>)(Object)list;
        }catch(SQLException ex){
            System.out.println(ex.getMessage()); 
        }        
        return null;   
    }
    
    public static void main(String[] args) {
        UsuarioVO vo = new UsuarioVO();
        vo.setCedula(2222);
        UsuarioDAO dao= new UsuarioDAO(vo);
        
        for(Object o : dao.listar()){
            
            UsuarioVO o1=(UsuarioVO)o;
            System.out.println(o1.getCedula()+" "+o1.getNombre());
        }
    }
    
    
    
}
