package org.ivan_smirnov.bdconnector;

import org.ivan_smirnov.bdconnector.model.Column;
import org.ivan_smirnov.bdconnector.model.SqlType;
import org.ivan_smirnov.bdconnector.service.ConsoleReader;
import org.ivan_smirnov.bdconnector.service.DataMapper;
import org.ivan_smirnov.bdconnector.service.QueryExecutor;
import org.ivan_smirnov.bdconnector.service.ScreenViewer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DBConnector {
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/testbd";
    private static final String USER = "postgres";
    private static final String PASS = "lvenoK1982";
    private String dbUrl;
    private String userName;
    private String userPass;


    public void start() {
        injectConnectionParams();
        try (Connection connection = getConnection();
        ConsoleReader consoleReader = new ConsoleReader()) {
            String input;
             while (!(input = consoleReader.readConsole()).isEmpty()) {
                 try {
                     if(SqlType.SELECT.equals(SqlType.getSqlTypeByQuery(input))) {
                         processSelectQuery(connection, input);
                     } else {
                         processNonSelectQuery(connection, input);
                     }
                 } catch (SQLException e) {
                     System.out.println("Wrong query");
                 }


                 break; //TODO
             }

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found");
        } catch (SQLException e) {
            System.out.println("Connection failed");
        } catch (IOException e) {
            System.out.println("Input from console failed");
        }
    }

    private void processSelectQuery(Connection connection, String input) throws SQLException {
        ResultSet resultSet = QueryExecutor.runSelectQuery(connection, input);
        Map<Integer, Column<?>> table = DataMapper.convertData(resultSet);
        ScreenViewer.print(table);
    }

    private void processNonSelectQuery(Connection connection, String input) {

    }

    private void injectConnectionParams() {
        dbUrl = DB_URL;
        userName = USER;
        userPass = PASS;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = DriverManager.getConnection(dbUrl, userName, userPass);
        System.out.println("You successfully connected to database now");
        return connection;
    }
}
