/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/usuario/listarPrueba","/usuario/listar", "/usuario/consultar", "/usuario/actualizar", "/usuario/eliminar", "/usuario/registrar", "/usuario/autenticar"})
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

            out.println("<h1>" + request.getServletPath() + "</h1>");
            System.out.println("");
            
            UsuarioDAO usuDAO;
            UsuarioVO usuVO;

            String ruta = request.getServletPath();
            switch (ruta) {
                case "/usuario/consultar":
                    break;
                case "/usuario/listarPrueba":
                    UsuarioDAO udao = new UsuarioDAO(); 
                    String temp = "<table border='1'><thead><tr><th>CÉDULA</th><th>NOMBRE</th><th>ROL</th></tr></thead><tbody>";
                    for(Object obj :udao.listar()){
                        UsuarioVO usu = (UsuarioVO) obj;
                        
                        temp+="<tr><td>"+usu.getCedula()+"</td><td>"+usu.getNombre()+"</td><td>"+usu.getRol()+"</td></tr>"; 
                        
                    }
                    temp+="</tbody></table>";
                    out.println(temp);
                    break;
                case "/usuario/listar":
                    UsuarioDAO udao1 = new UsuarioDAO();                                         
                    request.setAttribute("lista",udao1.listar());
                    request.getRequestDispatcher("/listaUsuario.jsp").forward(request, response);
                    break;                    
                case "/usuario/autenticar":
                    break;
                case "/usuario/registrar":
                    usuVO= new UsuarioVO();
                    usuDAO= new UsuarioDAO(usuVO);
                    
                    usuVO.setCedula(Long.parseLong(request.getParameter("cedula")));
                    usuVO.setNombre(String.valueOf(request.getParameter("nombre")));
                    usuVO.setApellido(String.valueOf(request.getParameter("apellido")));
                    usuVO.setCorreo(String.valueOf(request.getParameter("correo")));
                    usuVO.setRol(String.valueOf(request.getParameter("rol")));
                    usuVO.setTelefono(Long.parseLong(request.getParameter("telefono")));
                    usuVO.setClave(String.valueOf(request.getParameter("clave")));
                    
                    if(usuDAO.registrar()){
                        out.println("usuario registrado");
                    }else{
                        out.println("falla al registrar");
                    }
                    
                    
                    
                    break;
                case "/usuario/actualizar":
                    break;
                case "/usuario/eliminar":
                    break;
            }

        }catch(Exception e){
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