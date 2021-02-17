package com.alejandro.factory;

import java.sql.Connection;

public class MysqlConnection extends AbstractJDBCConnection {

    private static final String query = "SELECT DATABASE();";
    private static final String databaseEngine = "MYSQL";

    public MysqlConnection(Connection connection) {
        super(databaseEngine, query, connection);
    }

}
