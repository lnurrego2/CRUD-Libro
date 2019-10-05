/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.bd.ConexionSingleton;
import modelos.vo.LibroVO;
import modelos.vo.LibroVO;

/**
 *
 * @author Sena
 */
public class LibroDAO implements InterfaceCRUD {

    private Connection conn;
    private LibroVO vo;

    public LibroDAO() {
        conn = ConexionSingleton.obtenerConexion();
    }

    public LibroDAO(LibroVO vo) {
        this.conn = ConexionSingleton.obtenerConexion();
        this.vo = vo;
    }

    @Override
    public Object consultar() {
        try {
            String consulta = "SELECT * FROM libro WHERE isbn=?";
            PreparedStatement ps = this.conn.prepareStatement(consulta);
            ps.setLong(1, vo.getIsbn());
            ResultSet resultSet = ps.executeQuery();

            LibroVO temp = new LibroVO();
            while (resultSet.next()) {
                temp.setIsbn((int) Long.parseLong(resultSet.getString("isbn")));
                temp.setNombre(resultSet.getString("nombre"));
                temp.setDescripcion(resultSet.getString("descripcion"));
                //temp.setCorreo(resultSet.getString("correo"));
                temp.setGenero(resultSet.getString("genero"));
                temp.setPublicacion((int) resultSet.getLong("publicacion"));

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
            if (this.consultar() != null) {
                String sentencia = "UPDATE libro "
                        + "SET estado=false"
                        + "WHERE isbn=? ";
                PreparedStatement ps = this.conn.prepareStatement(sentencia);
                ps.setLong(1, vo.getIsbn());
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
                String sentencia = "INSERT INTO libro"
                        + "(isbn, nombre, descripcion, genero, publicacion) "
                        + "VALUES(?,?,?,?,?,?,md5(?)";
                PreparedStatement ps = this.conn.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, vo.getIsbn());
                ps.setString(2, vo.getNombre());
                ps.setString(3, vo.getDescripcion());
                //ps.setString(4, vo.getCorreo());
                ps.setString(5, vo.getGenero());
                ps.setLong(6, vo.getPublicacion());
                //ps.setString(7, vo.getClave());
                ps.execute();

                ps.getGeneratedKeys();
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
                String sentencia = "UPDATE libro "
                        + " SET nombre=?, descripcion=?, genero=?, publicacion=? "
                        + " WHERE isbn=? ";
                System.out.println(sentencia);
                PreparedStatement ps = this.conn.prepareStatement(sentencia);                
                ps.setLong(6, vo.getIsbn());
                ps.setString(1, vo.getNombre());
                ps.setString(2, vo.getDescripcion());
                //ps.setString(3, vo.getCorreo());
                ps.setString(4, vo.getGenero());
                ps.setLong(5, vo.getPublicacion());
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
            String consulta = "SELECT * FROM libro WHERE 1";
            PreparedStatement ps = this.conn.prepareStatement(consulta);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<LibroVO> list = new ArrayList<LibroVO>();

            while (resultSet.next()) {
                LibroVO temp = new LibroVO();
                temp.setIsbn(resultSet.getInt("isbn"));
                temp.setNombre(resultSet.getString("nombre"));
                temp.setDescripcion(resultSet.getString("descripcion"));
                //temp.setCorreo(resultSet.getString("correo"));
                temp.setGenero(resultSet.getString("genero"));
                temp.setPublicacion((int) resultSet.getLong("publicacion"));
                list.add(temp);
            }
            return (ArrayList<Object>) (Object) list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        LibroVO vo = new LibroVO();
        vo.setIsbn(001);
        LibroDAO dao = new LibroDAO(vo);

        vo.setIsbn(005);
        vo.setNombre("Volar sobre el pantano");
        vo.setDescripcion("irán entre sí a medida que se va desarrollando la narración. Uno de los personajes es Zahid, un hombre que se ha visto involucrado en una pandilla para ser aceptado por el resto.");
        vo.setGenero("drama");
        //vo.setCorreo("dm@dm.co");
        vo.setPublicacion(1995);
        //vo.setClave("123456");
        
        if (dao.registrar()) {
            System.out.println("registrado exitosamente");
        } else {
            System.out.println("error en el registro");
        }

    }

    public Object autenticar() {
        try {
            String consulta = "SELECT * FROM libro WHERE isbn=?";
            PreparedStatement ps = this.conn.prepareStatement(consulta);
            ps.setLong(1, vo.getIsbn());
            //ps.setString(2, vo.getClave());
            ResultSet resultSet = ps.executeQuery();

            LibroVO temp = new LibroVO();
            while (resultSet.next()) {
                temp.setNombre(resultSet.getString("nombre"));
                temp.setDescripcion(resultSet.getString("descripcion"));
                //temp.setCorreo(resultSet.getString("correo"));
                temp.setGenero(resultSet.getString("genero"));
                temp.setPublicacion((int) resultSet.getLong("publicacion"));

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
    
}
