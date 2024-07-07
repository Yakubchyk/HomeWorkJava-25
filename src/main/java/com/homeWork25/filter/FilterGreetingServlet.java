package com.homeWork25.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"greetingServlet"})
public class FilterGreetingServlet extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String name = req.getParameter("name");
        if (name == null) {
            res.setStatus(400);
            res.setContentType("text/plain");
            res.getWriter().println("Greetings from Filter");

        } else {
            chain.doFilter(req, res);
        }
    }
}
