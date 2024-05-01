package br.com.jadilumi.cyberwatch.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Usuario não encontrado!");
    }

    public UserNotFoundException(String mensagem) {
        super(mensagem);
    }
}
