package org.ivan_smirnov.bdconnector.service;

import org.ivan_smirnov.bdconnector.model.Column;

import java.util.*;

public class ScreenViewer {
    public static void print(Map<Integer, Column<?>> table) {
        Set<Integer> headers = table.keySet();

        List<Integer> columnSizes = new ArrayList<>();
        for (Integer column : headers) {
            columnSizes.add((table.get(column).getLongestField()));
        }

        printLine(columnSizes);
        for (Integer columnIndex : headers) {
            Column<?> column = table.get(columnIndex);
            printColumn(column.getColumnName(), column.getLongestField());
        }
        System.out.println("|");
        printLine(columnSizes);

        int rowsNum = table.get(1).getValues().size();
        for (int i = 0; i < rowsNum; i++) {
            for (Integer columnIndex : headers) {
                Column<?> column = table.get(columnIndex);
                printColumn(column.getValues().get(i).toString(), column.getLongestField());
            }
            System.out.println("|");
            printLine(columnSizes);
        }
    }

    private static void printLine(List<Integer> columnSizes) {
        StringBuilder sb = new StringBuilder("+");
        for (Integer size : columnSizes) {
            sb.append("-".repeat(size + 2));
            sb.append("+");
        }
        System.out.println(sb);
    }

    private static void printColumn(String text, int length) {
        System.out.print("| " + text + " ".repeat(length - text.length() + 1));
    }
}
