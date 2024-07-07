package com.homeWork25.servlet;

import com.homeWork25.model.Operation;
import com.homeWork25.servise.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    private final OperationService operationService = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");

        Operation operation = new Operation(num1, num2, type);

        Operation result = operationService.getResult(operation);

        String formated = "Result = %s".formatted(result.getResult());

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h3>num1 = " + num1 + "</h3>");
        writer.println("<h3>num2 = " + num2 + "</h3>");
        writer.println("<h3>type = " + type + "</h3>");

        writer.println("<h1> " + formated + "</h1");
        writer.println("</body>");
        writer.println("</head>");
    }
}
