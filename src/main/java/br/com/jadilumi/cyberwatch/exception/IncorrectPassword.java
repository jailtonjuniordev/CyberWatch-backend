package br.com.jadilumi.cyberwatch.exception;

public class IncorrectPassword extends RuntimeException {
    public IncorrectPassword() {
        super("Senha Incorreta!!");
    }

    public IncorrectPassword(String mensagem) {
        super(mensagem);
    }
}
