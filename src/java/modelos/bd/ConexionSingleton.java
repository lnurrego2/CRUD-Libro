/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.bd;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Instructor
 */
public class ConexionSingleton {
    
    //atributos
    private static Connection conn;
    
    //constructor
    //1. El constructor debe ser privado
    private ConexionSingleton(){       
        try {
            //leer archivos 
            Properties p = new Properties();
            String ruta = getClass().getResource("config.properties").getPath();
            p.load(new FileInputStream(ruta));
            
            
            //crear la conexión
            forName(p.getProperty("driver"));//ocurrir un erro por escritura y que no vincule el driver
            String url=p.getProperty("server")+p.getProperty("database")+p.getProperty("parameter");
            String user=p.getProperty("user");
            String password=p.getProperty("password");
            conn = DriverManager.getConnection(url, user, password);//Que no encuentra la conexión
            //Subir el motor mysql, este mal escrito
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConexionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    
    
    //métodos
    //2. Crear un metodo para retornar la instancia
    public static Connection obtenerConexion(){
        if(conn == null){
            new ConexionSingleton();
        }
        return conn;
    }
    
    public static void main(String[] args) {
      
        try {
            Connection conexion=ConexionSingleton.obtenerConexion();
            
            //PreparedStatement y ResultSet
            //listado
            String consulta = "SELECT * FROM usuario WHERE 1";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ResultSet resultado = ps.executeQuery();
            
            //recorrer el objeto resultado
            while(resultado.next()){
                System.out.println(resultado.getLong("cedula")+" "+resultado.getString("nombre")+" "+resultado.getString("apellido"));
            }
            //consulta filtrada
            System.out.println("listado");
            consulta = "SELECT * FROM usuario WHERE cedula=? AND nombre=?";
            ps= conexion.prepareStatement(consulta);
            ps.setLong(1, 1111);
            ps.setString(2, "Yuliano");
            resultado = ps.executeQuery();
            
            //recorrer el objeto resultado
            System.out.println("consulta única");
            while(resultado.next()){
                System.out.println(resultado.getLong("cedula")+" "+resultado.getString("nombre")+" "+resultado.getString("apellido"));
            }
            
            //inserción, agregación, registro
            System.out.println("inserción");
//            consulta="INSERT INTO usuario(cedula, nombre, apellido, correo, telefono, rol) VALUES(?,?,?,?,?,?)";
//            ps= conexion.prepareStatement(consulta);
//            ps.setLong(1, 5555);
//            ps.setString(2, "Iván");
//            ps.setString(3, "Caviedes");
//            ps.setString(4,"ic@ic.co");
//            ps.setLong(5, 676767);
//            ps.setString(6, "admin");
//            Boolean r= ps.execute();
//            System.out.println(r);
            
            //actualizar
            System.out.println("actualizar");
            consulta="UPDATE usuario SET nombre=?, apellido=?, correo=?, telefono=?, rol=? WHERE cedula=?";
            ps= conexion.prepareStatement(consulta);
            ps.setLong(6, 5555);
            ps.setString(1, "David");
            ps.setString(2, "Duque");
            ps.setString(3,"dd@dd.co");
            ps.setLong(4, 676767);
            ps.setString(5, "admin");
            Boolean r= ps.execute();
            System.out.println(r);
            
            //actualizar solo un campo
            System.out.println("actualizar");
            consulta="UPDATE usuario SET telefono=? WHERE cedula=?";
            ps= conexion.prepareStatement(consulta);
            ps.setLong(2, 5555);
            ps.setLong(1, 8008000);
            r= ps.execute();
            System.out.println(r);
            
            
            //eliminar
            System.out.println("eliminar");
            consulta = "DELETE FROM usuario WHERE cedula=?";
            ps= conexion.prepareStatement(consulta);
            ps.setLong(1, 1111);
            r = ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
    }
}
