package com.app.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLconnector {
    public static Connection getConnection(MySQLconnectorModel connModel ) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connModel.getConnString(), connModel.getUserName(), connModel.getPassword());
    }
    
    public static void closeResources(AutoCloseable closeable ) {
        try {
            if(closeable != null) {
                closeable.close();
                System.out.println(closeable.getClass().getName() + " closed!");
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
}
