package br.com.vcsouza.sistema_de_cadastro.exception;

public class formatAlturaInvalidException extends RuntimeException {
    private final String message;

    public formatAlturaInvalidException(String formatoDeAlturaInformadaInvalido) {
        this.message = formatoDeAlturaInformadaInvalido;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
