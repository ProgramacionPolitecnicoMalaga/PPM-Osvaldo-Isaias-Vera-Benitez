<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.util.logging.Level" %><%--
  Created by IntelliJ IDEA.
  User: Isaias Vera
  Date: 02/05/2020
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sumar</title>
</head>
<body>
<h4>Escribe los dos números a sumar:</h4>
<form method="post" action="sumar">
    <input type="text" name="n1"><br>
    <input type="text" name="n2">
    <input type="submit">
</form>
<p>El resultado es: <% out.print(request.getAttribute( "resultado")); %></p>

<%
    Logger logger = Logger.getLogger("suma.jsp");
    logger.log(Level.INFO,"Autor: Osvaldo Isaias Vera Benitez");
%>
</body>
</html>
