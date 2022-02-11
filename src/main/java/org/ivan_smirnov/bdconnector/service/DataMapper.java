package org.ivan_smirnov.bdconnector.service;

import org.ivan_smirnov.bdconnector.model.Column;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataMapper {

    public static Map<Integer, Column<?>> convertData(ResultSet rs) throws SQLException {
        Map<Integer, Column<?>> table = new HashMap<>();
        Column<Integer> id = new Column<>("Id");
        Column<String> personName = new Column<>("Name");
        Column<String> city = new Column<>("City");
        while (rs.next()) {
            id.add(rs.getInt("PersonID"));
            personName.add(rs.getString("Name"));
            city.add(rs.getString("City"));
        }
        table.put(1, id);
        table.put(2, personName);
        table.put(3, city);

        return table;
    }
}
