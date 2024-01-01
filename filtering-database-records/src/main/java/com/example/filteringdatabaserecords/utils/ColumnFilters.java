package com.example.filteringdatabaserecords.utils;

import java.util.List;

public class ColumnFilters {
    private String columnName;
    private List<String> values;

    public ColumnFilters() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
