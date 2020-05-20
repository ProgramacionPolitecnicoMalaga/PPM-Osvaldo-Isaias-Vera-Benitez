package com.politecnicomalaga.servlet;

import com.politecnicomalaga.modelo.Persona;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet(
        name="personas",
        urlPatterns = {"/personas"}
)

public class CookiePersonas extends HttpServlet {
    private RequestDispatcher dispatcher = null;
    Logger logger = Logger.getLogger(CookiePersonas.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Persona> personas = (List<Persona>) session.getAttribute("personas");
        if (personas == null){
            logger.info("GET, la lista es null");
            dispatcher = req.getRequestDispatcher("sinSesion.jsp");
        } else {
            req.setAttribute("personas",personas);
            dispatcher = req.getRequestDispatcher("conSesion.jsp");
        }
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Persona> personas = (List<Persona>) session.getAttribute("personas");
        if (personas == null) personas = new ArrayList<>();
        String json = req.getReader().lines().collect(Collectors.joining());
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonRecibido = (JSONObject) parser.parse(json);
            String nombre = (String) jsonRecibido.get("nombre");
            int edad = Integer.parseInt((String) jsonRecibido.get("edad"));
            logger.info(nombre + " " + edad);
            personas.add(new Persona(nombre,edad));
        } catch (Exception e){
            personas.add(new Persona("sin nombre",0));
        }

        session.setAttribute("personas",personas);
        req.setAttribute("personas",personas);

        dispatcher = req.getRequestDispatcher("conSesion.jsp");
        dispatcher.forward(req,resp);
    }
}
