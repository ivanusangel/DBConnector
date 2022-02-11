package org.ivan_smirnov.bdconnector.model;

public enum SqlType {
    SELECT,
    UPDATE,
    DELETE,
    INSERT;

    public static SqlType getSqlTypeByQuery(String query) {
        String[] arr = query.split(" ");
        return SqlType.valueOf(arr[0].toUpperCase());
    }
}
