package com.homeWork25.servise;

import com.homeWork25.model.Operation;

public class OperationService {
    public Operation getResult(Operation operation) {
        switch (operation.getType()) {
            case "sum":
                operation.setResult(operation.getNum1() + operation.getNum2());
                return operation;
            case "sub":
                operation.setResult(operation.getNum1() - operation.getNum2());
                return operation;
            case "mul":
                operation.setResult(operation.getNum1() * operation.getNum2());
                return operation;
            case "div":
                operation.setResult(operation.getNum1() / operation.getNum2());
                return operation;
        }
        throw new IllegalArgumentException("Operation type not supported");
    }

}
