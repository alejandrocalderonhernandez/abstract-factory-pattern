package com.alejandro.factory;

public class PostgresqlConnectionFactory extends AbstractJDBCConnectionFactory {

    private static final String PATH = "src/main/resources/postgresql.datasource.properties";

    public PostgresqlConnectionFactory() {
        super(PATH);
    }

    @Override
    public AbstractJDBCConnection getAbstractJDBCConnection() {
        return new PostgresqlConnection(super.getConnection());
    }
}
