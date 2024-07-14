package com.homeWork25.servlet;

import com.google.gson.Gson;
import com.homeWork25.model.Operation;
import com.homeWork25.servise.OperationFiles;
import com.homeWork25.servise.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator", loadOnStartup = 0)
public class CalculatorServlet extends HttpServlet {

    private final OperationService operationService = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OperationFiles operationFiles = new OperationFiles();

        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");

        Operation operation = new Operation(num1, num2, type);
        Operation result = operationService.getResult(operation);

        String formatted = "Result = %s".formatted(result.getResult());

        String filePath = "/Users/yakubchyk/IdeaProjects/HomeWorkJava-25/history.json";

        operationFiles.setHistoryFile(filePath, num1, num2, type);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h3>num1 = " + num1 + "</h3>");
        writer.println("<h3>num2 = " + num2 + "</h3>");
        writer.println("<h3>type = " + type + "</h3>");
        writer.println("<h1>" + formatted + "</h1>");

        List<Operation> historyList = operationFiles.getHistoryFile(filePath);
        if (historyList != null) {
            writer.println("<h2>Operation History:</h2>");
            writer.println("<ul>");
            for (Operation op : historyList) {
                writer.println("<li>" + op + "</li>");
            }
            writer.println("</ul>");
        } else {
            writer.println("<p>No history found or error reading the file.</p>");
        }

        String myName = (String) req.getServletContext().getAttribute("myName");
        if (myName != null) {
            writer.println("<h2>" + myName + "</h2>");
        }

        writer.println("</body>");
        writer.println("</html>");
    }
}
