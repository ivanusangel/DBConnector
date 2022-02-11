package org.ivan_smirnov.bdconnector.service;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Closeable {
    private final static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public String readConsole() {
        return "select * from Persons;";
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
