package com.alejandro.factory;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractJDBCConnectionFactory {

    protected Properties props;

    public AbstractJDBCConnectionFactory(String propsPath) {
        this.props = new Properties();
        try {
            props.load(new FileReader(propsPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract AbstractJDBCConnection getAbstractJDBCConnection();

    protected Connection getConnection() {
        try {
            Class.forName(props.getProperty("database.driver"));
            return DriverManager.getConnection(
                    props.getProperty("database.url"),
                    props.getProperty("database.user"),
                    props.getProperty("database.pass")
            );
        } catch (SQLException e) {
            System.err.println("Error to create connection: " + e.getMessage());
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            System.err.println("Error to get driver class" + e.getMessage());
            throw new RuntimeException();
        }
      }
}
