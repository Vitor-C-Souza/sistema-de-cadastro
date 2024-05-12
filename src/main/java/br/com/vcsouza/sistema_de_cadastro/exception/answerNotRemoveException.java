package br.com.vcsouza.sistema_de_cadastro.exception;

public class answerNotRemoveException extends RuntimeException {
    private final String message;

    public answerNotRemoveException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
