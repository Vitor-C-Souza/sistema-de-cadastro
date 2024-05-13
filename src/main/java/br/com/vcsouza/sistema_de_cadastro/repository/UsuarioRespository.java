package br.com.vcsouza.sistema_de_cadastro.repository;

import br.com.vcsouza.sistema_de_cadastro.conn.ConnectionFactory;
import br.com.vcsouza.sistema_de_cadastro.model.Usuario;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class UsuarioRespository {
    public static void save(Usuario usuario) {
        String sql = "INSERT INTO `sistema_de_cadastro`.`usuario` (`nome`, `email`, `idade`, `altura`) VALUES ('" + usuario.getNome() + "',\n" +
                "'" + usuario.getEmail() + "',\n" +
                "'" + usuario.getIdade() + "',\n" +
                "'" + usuario.getAltura() + "');";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected);
            System.out.println("Usuario cadastrado com sucesso!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> findAllUsuarios() {
        log.info("Finding all Users");
        String sql = "SELECT nome\n" +
                "FROM `sistema_de_cadastro`.`usuario`;";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            List<String> usuarios = new ArrayList<>();
            while (rs.next()) {
                String nome = rs.getString("nome");
                usuarios.add(nome);
            }

            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> findUsuario(String typedUser) {
        log.info("Finding all {}", typedUser);
        String sql = "SELECT nome\n" +
                "FROM `sistema_de_cadastro`.`usuario` WHERE nome LIKE '" + typedUser + "%';";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            List<String> usuarios = new ArrayList<>();
            while (rs.next()) {
                String nome = rs.getString("nome");
                usuarios.add(nome);
            }

            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
