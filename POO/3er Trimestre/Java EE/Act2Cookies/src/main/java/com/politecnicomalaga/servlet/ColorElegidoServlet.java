package com.politecnicomalaga.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="color_elegido",
        urlPatterns = {"/elegido"}
)

public class ColorElegidoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("color")) {
                    PrintWriter out = resp.getWriter();
                    resp.setContentType("text/html; charset=utf-8");
                    out.print("{\"status\":\"ok\",\"color\":\"" + cookie.getValue() + "\"}");
                }
            }
        } else {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html; charset=utf-8");
            out.print("{\"status\":\"ok\"}");
        }
    }
}
