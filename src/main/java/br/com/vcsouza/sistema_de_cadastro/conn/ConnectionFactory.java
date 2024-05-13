package br.com.vcsouza.sistema_de_cadastro.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sistema_de_cadastro";
        String username = "root";
        String password = "6040";
        return DriverManager.getConnection(url, username, password);


    }
}
