<%-- 
    Document   : listaLibro
    Created on : 6/09/2019, 03:46:35 PM
    Author     : Sena
--%>

<%@page import="modelos.vo.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="http://localhost:8080/java620/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="http://localhost:8080/java620/resources/js/jquery-3.3.1.js" ></script>
        <script src="http://localhost:8080/java620/resources/js/popper.min.js" type="text/javascript"></script>
        <script src="http://localhost:8080/java620/resources/js/bootstrap.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%
        
            ArrayList<Object>lista=(ArrayList<Object>)request.getAttribute("lista");
        %>

        <table class="table table-hover table-striped" border="1">
            <thead class="table-dark">
                <tr>
                    <th>ISBN</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCIÓN</th>
                    <th>PUBLICACIÓN</th>
                    <th>GENERO</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for(Object obj : lista){
                        UsuarioVO usu=(UsuarioVO)obj;
                %>
                <tr>
                    <td><%=usu.getIsbn() %></td>
                    <td><%=usu.getNombre() %></td>
                    <td><%=usu.getDescripcion()%></td>
                    <td><%=usu.getGenero()%></td>
                </tr>
                <%
                    }
                %>


            </tbody>
        </table>




    </body>
</html>
