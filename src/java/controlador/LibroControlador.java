/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
import modelos.dao.LibroDAO;
import modelos.vo.LibroVO;

/**
 *
 * @author Sena
 */
@WebServlet(name = "LibroControlador", urlPatterns = {"libro/consultar","libro/listar"})
public class LibroControlador extends HttpServlet {

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
         //            out.println("<h1>" + request.getServletPath() + "</h1>");
            System.out.println("");

            LibroDAO libDAO;
            LibroVO libVO;
            Gson json = new Gson();
            String mensaje = null;

            String ruta = request.getServletPath();
            switch (ruta) {
                case "/libro/consultar":
                    libVO = new LibroVO();
                    libVO.setIsbn(Long.parseLong(request.getParameter("isbn")));
                    libDAO = new LibroDAO(libVO);
                    Object obj=libDAO.consultar();
                    if(obj != null){
                        mensaje = json.toJson(obj);
                    }else{
                        mensaje=json.toJson("libro no existe");
                    }
                    break;
                case "/libro/autenticar":
                    break;
                case "/libro/registrar":
                    libVO = new LibroVO();
                    libDAO = new LibroDAO(libVO);

                    libVO.setIsbn(Long.parseLong(request.getParameter("isbn")));
                    libVO.setNombre(String.valueOf(request.getParameter("nombre")));
                    libVO.setDescripcion(String.valueOf(request.getParameter("descripcion")));
                    //libVO.setCorreo(String.valueOf(request.getParameter("correo")));
                    libVO.setGenero(String.valueOf(request.getParameter("rol")));
                    libVO.setPublicacion(Long.parseLong(request.getParameter("telefono")));
                    //libVO.setClave(String.valueOf(request.getParameter("clave")));

                    if (libDAO.registrar()) {
                        mensaje = json.toJson("libro registrado");
                    } else {
                        mensaje = json.toJson("falla al registrar");
                    }
                    break;
                case "/libro/listar":
                    libDAO = new LibroDAO();
                    mensaje = json.toJson(libDAO.listar());
                    break;
                case "/libro/actualizar":
                    libVO = new LibroVO();
                    libDAO = new LibroDAO(libVO);

                    libVO.setIsbn(Long.parseLong(request.getParameter("isbn")));
                    libVO.setNombre(String.valueOf(request.getParameter("nombre")));
                    libVO.setDescripcion(String.valueOf(request.getParameter("descripcion")));
                    //libVO.setCorreo(String.valueOf(request.getParameter("correo")));
                    libVO.setGenero(String.valueOf(request.getParameter("rol")));
                    libVO.setPublicacion(Long.parseLong(request.getParameter("telefono")));
                    //libVO.setClave(String.valueOf(request.getParameter("clave")));

                    if (libDAO.actualizar()) {
                        mensaje = json.toJson("libro editado");
                    } else {
                        mensaje = json.toJson("falla al editar");
                    }
                    break;
                case "/libro/eliminar":
                    libVO = new LibroVO();
                    libVO.setIsbn(Long.parseLong(request.getParameter("isbn")));
                    libDAO = new LibroDAO(libVO);
                    if (libDAO.eliminar()) {
                        mensaje = json.toJson("Libro eliminado exitosamente");
                    } else {
                        mensaje = json.toJson("Libro no existe");
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
