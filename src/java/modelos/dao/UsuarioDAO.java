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
public class UsuarioDAO implements InterfaceCRUD {

    private Connection conn;
    private UsuarioVO vo;

    public UsuarioDAO() {
        conn = ConexionSingleton.obtenerConexion();
    }

    public UsuarioDAO(UsuarioVO vo) {
        this.conn = ConexionSingleton.obtenerConexion();
        this.vo = vo;
    }

    @Override
    public Object consultar() {
        try {
            String consulta = "SELECT * FROM usuario WHERE cedula=? AND estado=true";
            PreparedStatement ps = this.conn.prepareStatement(consulta);
            ps.setLong(1, vo.getCedula());
            ResultSet resultSet = ps.executeQuery();

            UsuarioVO temp = new UsuarioVO();
            while (resultSet.next()) {
                temp.setNombre(resultSet.getString("nombre"));
                temp.setApellido(resultSet.getString("apellido"));
                temp.setCorreo(resultSet.getString("correo"));
                temp.setRol(resultSet.getString("rol"));
                temp.setTelefono(resultSet.getLong("telefono"));

            }
            if (temp.getNombre() != null) {
                return temp;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public boolean eliminar() {
        try {
            if (this.consultar() == null) {
                String sentencia = "UPDATE usuario"
                        + "SET estado=false, f_actualizacion=CURRENT_TIMESTAMP "
                        + "WHERE cedula=? ";
                PreparedStatement ps = this.conn.prepareStatement(sentencia);
                ps.setLong(1, vo.getCedula());
                ps.execute();

                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean registrar() {
        try {

            if (this.consultar() == null) {
                String sentencia = "INSERT INTO usuario"
                        + "(cedula, nombre, apellido, correo, rol, telefono,clave, estado, f_actualizacion, f_creacion) "
                        + "VALUES(?,?,?,?,?,?,md5(?),true,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
                PreparedStatement ps = this.conn.prepareStatement(sentencia);
                ps.setLong(1, vo.getCedula());
                ps.setString(2, vo.getNombre());
                ps.setString(3, vo.getApellido());
                ps.setString(4, vo.getCorreo());
                ps.setString(5, vo.getRol());
                ps.setLong(6, vo.getTelefono());
                ps.setString(7, vo.getClave());
                ps.execute();

                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean actualizar() {
        try {
            if (this.consultar() != null) {
                String sentencia = "UPDATE usuario"
                        + "SET nombre=?, apellido=?, correo=?, rol=?, telefono=?, f_actualizacion=CURRENT_TIMESTAMP "
                        + "WHERE cedula=? ";
                PreparedStatement ps = this.conn.prepareStatement(sentencia);
                ps.setLong(6, vo.getCedula());
                ps.setString(1, vo.getNombre());
                ps.setString(2, vo.getApellido());
                ps.setString(3, vo.getCorreo());
                ps.setString(4, vo.getRol());
                ps.setLong(5, vo.getTelefono());
                ps.execute();

                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public ArrayList<Object> listar() {
        try {
            String consulta = "SELECT * FROM usuario WHERE estado = true";
            PreparedStatement ps = this.conn.prepareStatement(consulta);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<UsuarioVO> list = new ArrayList<UsuarioVO>();

            while (resultSet.next()) {
                UsuarioVO temp = new UsuarioVO();
                temp.setCedula(resultSet.getLong("cedula"));
                temp.setNombre(resultSet.getString("nombre"));
                temp.setApellido(resultSet.getString("apellido"));
                temp.setCorreo(resultSet.getString("correo"));
                temp.setRol(resultSet.getString("rol"));
                temp.setTelefono(resultSet.getLong("telefono"));
                list.add(temp);
            }
            return (ArrayList<Object>) (Object) list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        UsuarioVO vo = new UsuarioVO();
        vo.setCedula(5555);
        UsuarioDAO dao = new UsuarioDAO(vo);

        vo.setCedula(3333);
        vo.setNombre("Danilo");
        vo.setApellido("Montero");
        vo.setRol("admin");
        vo.setCorreo("dm@dm.co");
        vo.setTelefono(300300300);
        vo.setClave("123456");
        
        if (dao.registrar()) {
            System.out.println("registrado exitosamente");
        } else {
            System.out.println("error en el registro");
        }

    }

}
