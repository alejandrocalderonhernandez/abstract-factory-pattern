package com.alejandro.factory;

public class MysqlConnectionfactory extends AbstractJDBCConnectionFactory {

    private static final String PATH = "src/main/resources/mariadb.datasource.properties";

    public MysqlConnectionfactory() {
        super(PATH);
    }

    @Override
    public AbstractJDBCConnection getAbstractJDBCConnection() {
        return new MysqlConnection(super.getConnection());
    }
}
