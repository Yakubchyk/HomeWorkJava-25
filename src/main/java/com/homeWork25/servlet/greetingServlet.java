package com.homeWork25.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "greetingServlet", value = "/greeting", loadOnStartup = 1)
public class greetingServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Hello World !");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h3>greeting</h3>");
        out.println("<h2>Hello " + name + "</h2>");
        out.println("</body>");

        req.setAttribute("greeting", "Hello " + name + "!");
        req.getServletContext().setAttribute("myName", name);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy All !!!");
    }
}
