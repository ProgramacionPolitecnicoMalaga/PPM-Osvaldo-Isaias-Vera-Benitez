package com.politecnicomalaga.servlet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet(
        name="color",
        urlPatterns = {"/color"}
)

public class CookieColorServlet extends HttpServlet{
    Logger logger = Logger.getLogger(CookieColorServlet.class.getName());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonResultado;
        String json = req.getReader().lines().collect(Collectors.joining());
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
            String color = (String) jsonObject.get("color");
            logger.info("Color recibido" + color);
            Cookie cookie = new Cookie("color",color);
            resp.addCookie(cookie);
            jsonResultado = "{\"status\":\"ok\",\"color\":\""+color+"\"}";
        } catch (ParseException e) {
            jsonResultado = "{\"status\":\"ko\"}";
        }
        logger.info("jsonResultado es: " +jsonResultado);
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonResultado);
    }
}
