package service;

import model.Usuario;

import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    public void gravarCadastro(Usuario usuario) {
        try {
            FileWriter file = new FileWriter(usuario.getNome().replace(" ", "").toUpperCase() + ".txt");
            file.write(usuario.toString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
