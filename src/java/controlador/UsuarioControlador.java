/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.dao.UsuarioDAO;
import modelos.vo.UsuarioVO;

/**
 *
 * @author Sena
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/usuario/listar", "/usuario/consultar", "/usuario/actualizar", "/usuario/eliminar", "/usuario/registrar", "/usuario/autenticar"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

//            out.println("<h1>" + request.getServletPath() + "</h1>");
            System.out.println("");

            UsuarioDAO usuDAO;
            UsuarioVO usuVO;
            Gson json = new Gson();
            String mensaje = null;

            String ruta = request.getServletPath();
            switch (ruta) {
                case "/usuario/consultar":
                    break;
                case "/usuario/autenticar":
                    break;
                case "/usuario/registrar":
                    usuVO = new UsuarioVO();
                    usuDAO = new UsuarioDAO(usuVO);

                    usuVO.setCedula(Long.parseLong(request.getParameter("cedula")));
                    usuVO.setNombre(String.valueOf(request.getParameter("nombre")));
                    usuVO.setApellido(String.valueOf(request.getParameter("apellido")));
                    usuVO.setCorreo(String.valueOf(request.getParameter("correo")));
                    usuVO.setRol(String.valueOf(request.getParameter("rol")));
                    usuVO.setTelefono(Long.parseLong(request.getParameter("telefono")));
                    usuVO.setClave(String.valueOf(request.getParameter("clave")));

                    if (usuDAO.registrar()) {
                        mensaje = json.toJson("usuario registrado");
                    } else {
                        mensaje = json.toJson("falla al registrar");
                    }
                    break;
                case "/usuario/listar":
                    usuDAO = new UsuarioDAO();
                    mensaje = json.toJson(usuDAO.listar());
                    break;
                case "/usuario/actualizar":
                    break;
                case "/usuario/eliminar":
                    usuVO = new UsuarioVO();
                    usuVO.setCedula(Long.parseLong(request.getParameter("cedula")));
                    usuDAO = new UsuarioDAO(usuVO);
                    if (usuDAO.eliminar()) {
                        mensaje = json.toJson("Usuario eliminado exitosamente");
                    } else {
                        mensaje = json.toJson("Usuario no existe");
                    }
                    break;
            }

            response.setContentType("Application/json");
            out.print(mensaje);          
            out.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
