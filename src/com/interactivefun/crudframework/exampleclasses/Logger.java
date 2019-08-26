package com.interactivefun.crudframework.exampleclasses;

import com.interactivefun.crudframework.contracts.ILog;

public class Logger implements ILog {
    @Override
    public void logMessage(String message) {

        System.out.println(message);
    }
}
