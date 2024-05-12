package br.com.vcsouza.sistema_de_cadastro.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/sistema_de_cadastro";
        String username = "root";
        String password = "6040";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
