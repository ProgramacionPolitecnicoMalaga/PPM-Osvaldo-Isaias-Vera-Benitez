<%@ page import="java.util.List" %>
<%@ page import="com.politecnicomalaga.modelo.Persona" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.logging.Logger" %><%--
  Created by IntelliJ IDEA.
  User: Isaias Vera
  Date: 20/05/2020
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Logger logger = Logger.getLogger("JSP");
    List<Persona> personas = (List<Persona>) request.getAttribute("personas");
    out.println("<tr>");
    out.println("\t<th>Nombre</th>");
    out.println("\t<th>Edad</th>");
    out.println("</tr>");
    logger.info(String.valueOf(personas.isEmpty()));
    for (Persona p : personas) {
        out.println("<tr>");
        out.println("\t<td>" + p.getNombre() + "</td>");
        out.println("\t<td>" + p.getEdad() + "</td>");
        out.println("</tr>");
    }
%>