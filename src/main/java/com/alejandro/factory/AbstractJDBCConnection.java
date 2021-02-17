package com.alejandro.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractJDBCConnection {

    protected String databaseEngine;
    protected String query;
    protected Connection connection;

    public AbstractJDBCConnection(String databaseEngine, String query, Connection connection) {
        this.databaseEngine = databaseEngine;
        this.query = query;
        this.connection = connection;
    }

    public String getDatabaseEngine() {
        return databaseEngine;
    }

    public String getQuery() {
        return query;
    }

    public Connection getConnection() {
        return connection;
    }

    public void testConnection() {
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(this.query);
            while (rs.next()) {
                System.out.println("Connected to " + this.databaseEngine + " database: " + rs.getString(1));
            }
            this.connection.close();
        } catch (SQLException e) {
            System.err.print("Error to execute query: " + e.getMessage());
        }
    }
}
