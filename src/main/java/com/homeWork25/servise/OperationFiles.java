package com.homeWork25.servise;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.homeWork25.model.Operation;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OperationFiles {
    private final OperationService operationService = new OperationService();

    public void setHistoryFile(String historyFile, double num1, double num2, String type) {
        Operation operation = new Operation(num1, num2, type);
        Operation result = operationService.getResult(operation);

        Gson gson = new Gson();

        List<Operation> list = getHistoryFile(historyFile);
        if (list == null) {
            list = new ArrayList<>();
        }

        list.add(result);

        try (FileWriter writer = new FileWriter(historyFile)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Operation> getHistoryFile(String historyFile) {
        List<Operation> list = null;

        try (FileReader reader = new FileReader(historyFile)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Operation>>() {
            }.getType();
            list = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void printHistory(String historyFile) {
        List<Operation> list = getHistoryFile(historyFile);
        if (list != null) {
            for (Operation operation : list) {

            }
        } else {
            System.out.println("No history found or error reading the file.");
        }
    }
}
