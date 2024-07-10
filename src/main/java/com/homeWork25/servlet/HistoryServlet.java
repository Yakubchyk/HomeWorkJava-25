package com.homeWork25.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File historyFile = new File("/Users/yakubchyk/IdeaProjects/HomeWorkJava-25/history.json");

        if (historyFile.exists() && historyFile.isFile()) {
            try (FileReader reader = new FileReader(historyFile)) {
                Gson gson = new Gson();
                JsonElement jsonElement = JsonParser.parseReader(reader);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().println(gson.toJson(jsonElement));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found");

        }
    }
}
