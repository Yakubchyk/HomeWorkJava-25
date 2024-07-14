package com.homeWork25.filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"CalculatorServlet"})
public class FilterOperation extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String type = req.getParameter("type");

        if (num1 == null || num2 == null || type == null ||
                num1.trim().isEmpty() || num2.trim().isEmpty() || type.trim().isEmpty()) {

            res.setStatus(400);
            res.getWriter().write("400 - Bad Request");
        } else {
            try {
                Integer.parseInt(num1);
                Integer.parseInt(num2);

                chain.doFilter(req, res);
            } catch (NumberFormatException e) {
                res.setStatus(400);
                res.getWriter().write("Invalid number format");
            }
        }
    }
}
