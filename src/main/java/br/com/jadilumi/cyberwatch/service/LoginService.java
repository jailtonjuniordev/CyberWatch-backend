package br.com.jadilumi.cyberwatch.service;

import br.com.jadilumi.cyberwatch.dto.LoginDTO;
import br.com.jadilumi.cyberwatch.exception.IncorrectPassword;
import br.com.jadilumi.cyberwatch.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    String hashLogado = "LOGOUGHASKJHFAKJHGKJNAEKFAKJSDNKJ";
    @Autowired
    private UsuarioService usuarioService;

    public String logarUsuario(LoginDTO loginDTO) {
        boolean userRecuperado = usuarioService.recuperarPorUsername(loginDTO.username());

        if (!userRecuperado) {
            throw new UserNotFoundException();
        } else {
            if (userRecuperado) {
                return hashLogado;
            } else {
                throw new IncorrectPassword();
            }
        }
    }
}
