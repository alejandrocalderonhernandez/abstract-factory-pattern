package com.alejandro.factory;

public class App {

    public static void main(String[] args) {
        AbstractJDBCConnectionFactory mysqlFactory = new MysqlConnectionfactory();
        AbstractJDBCConnectionFactory postgresqlFactory = new PostgresqlConnectionFactory();

        AbstractJDBCConnection mysql = new MysqlConnection(mysqlFactory.getConnection());
        AbstractJDBCConnection postgresql = new PostgresqlConnection(postgresqlFactory.getConnection());

        mysql.testConnection();
        postgresql.testConnection();
    }
}
