package br.com.vcsouza.sistema_de_cadastro.service;

import br.com.vcsouza.sistema_de_cadastro.repository.UsuarioRespository;

import java.io.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Leitura {
    private final File directory = new File(".");

    private File[] getFiles() {
        return directory.listFiles((_, name) -> {
            if (Objects.equals(name, "formulario.txt")) {
                return false;
            }
            return name.toLowerCase().endsWith(".txt");
        });
    }

    public void listarTodosUsuarios() {
//        File[] files = getFiles();
//        assert files != null;
//        int count = 1;
//        for (File file : files) {
//            try {
//                Scanner scanner = new Scanner(file);
//                System.out.println(count + " - " + scanner.nextLine());
//                count++;
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
        List<String> allUsuarios = UsuarioRespository.findAllUsuarios();
        int i = 1;
        for(String usuario: allUsuarios){
            System.out.println(i + " - " + usuario);
            i++;
        }
    }

    public void procuraUsuarios() {
//        File[] files = getFiles();
        Scanner read = new Scanner(System.in);

        System.out.println("Qual usuario deseja buscar: ");
        String user = read.nextLine().toLowerCase();

//        int count = 1;
//        for (File file : files) {
//            try {
//                BufferedReader fileReader = new BufferedReader(new FileReader(file));
//                String extractedUser = fileReader.readLine().toLowerCase();
//                if (extractedUser.startsWith(user)) {
//                    System.out.println(count + " - " + extractedUser);
//                    count++;
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }

        List<String> usuarios = UsuarioRespository.findUsuario(user);

        int i = 1;
        for (String usuario: usuarios){
            System.out.println(i + " - " + usuario);
            i++;
        }
    }

    public boolean verificarEmailUnico(String emailAhSerCadastrado) {
        File[] files = getFiles();

        for (File file : files) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (Objects.equals(emailAhSerCadastrado, line)) {
                        return true;
                    }
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
