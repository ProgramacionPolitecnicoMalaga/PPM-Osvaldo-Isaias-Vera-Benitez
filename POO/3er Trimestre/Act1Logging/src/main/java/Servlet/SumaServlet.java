package Servlet;

import Suma.Suma;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
    name = "sumar",
    urlPatterns = {"/sumar"}
)

public class SumaServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(SumaServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Suma suma = new Suma();
        int n1 = Integer.parseInt(req.getParameter("n1"));
        int n2 = Integer.parseInt(req.getParameter("n2"));
        logger.log(Level.INFO,"Los operadores recibidos son: " + n1 + " y " + n2);
        int resultado = suma.sumar(n1,n2);
        logger.log(Level.INFO,"El resultado de la operacion es: " + resultado);
        RequestDispatcher dispatcher = req.getRequestDispatcher("suma.jsp");
        req.setAttribute("resultado",resultado);
        dispatcher.forward(req,resp);
    }
}
