package br.com.vcsouza.sistema_de_cadastro.exception;

public class duplicidadeDeEmailException extends RuntimeException {
    private final String message;

    public duplicidadeDeEmailException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
