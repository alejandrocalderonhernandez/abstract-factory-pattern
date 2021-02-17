package com.alejandro.factory;

import java.sql.Connection;

public class PostgresqlConnection extends AbstractJDBCConnection {

    private static final String query = "SELECT datname FROM pg_database LIMIT 1;";
    private static final String databaseEngine = "POSTRGRESQL";

    public PostgresqlConnection(Connection connection) {
        super(databaseEngine, query, connection);
    }
}
