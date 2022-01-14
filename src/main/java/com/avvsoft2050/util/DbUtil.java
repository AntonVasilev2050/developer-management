package com.avvsoft2050.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                String driver = "org.postgresql.Driver";
//                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:postgresql://localhost:5432/test_db";
//                String url = "jdbc:mysql://localhost:3306/test_db?useSSL=false";
                String user = "testuser";
                String password = "testuser";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
