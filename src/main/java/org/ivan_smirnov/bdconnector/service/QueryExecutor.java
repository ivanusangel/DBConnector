package org.ivan_smirnov.bdconnector.service;

import java.sql.*;

public class QueryExecutor {
    public static ResultSet runSelectQuery(Connection connection, String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public static int runQuery(Connection connection, String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        return 0; //TODO
    }
}
