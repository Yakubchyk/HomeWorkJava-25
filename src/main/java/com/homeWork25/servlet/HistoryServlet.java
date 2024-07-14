package com.homeWork25.servlet;

import com.google.gson.Gson;
import com.homeWork25.model.Operation;
import com.homeWork25.servise.OperationFiles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String historyFile = "/Users/yakubchyk/IdeaProjects/HomeWorkJava-25/history.json";

        OperationFiles operationFiles = new OperationFiles();

        List<Operation> list = operationFiles.getHistoryFile(historyFile);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String jsonResponse = gson.toJson(list);
        resp.getWriter().write(jsonResponse);
    }
}
