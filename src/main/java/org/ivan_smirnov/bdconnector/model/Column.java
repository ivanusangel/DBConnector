package org.ivan_smirnov.bdconnector.model;

import java.util.ArrayList;
import java.util.List;

public class Column<T> {
    private String columnName;
    private int longestField;
    private List<T> values = new ArrayList<>();

    public Column(String columnName) {
        this.columnName = columnName;
        this.longestField = columnName.length();
    }

    public void add(T value) {
        values.add(value);
        int length = value.toString().length();
        longestField = Math.max(longestField, length);
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getLongestField() {
        return longestField;
    }

    public void setLongestField(int longestField) {
        this.longestField = longestField;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
