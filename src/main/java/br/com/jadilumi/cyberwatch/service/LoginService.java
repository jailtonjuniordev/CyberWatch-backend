package br.com.jadilumi.cyberwatch.service;

import br.com.jadilumi.cyberwatch.dto.LoginDTO;
import br.com.jadilumi.cyberwatch.exception.IncorrectPassword;
import br.com.jadilumi.cyberwatch.exception.UserNotFoundException;
import br.com.jadilumi.cyberwatch.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    String hashLogado = "LOGOUGHASKJHFAKJHGKJNAEKFAKJSDNKJ";
    @Autowired
    private UsuarioService usuarioService;

    public String logarUsuario(LoginDTO loginDTO) {
        Usuario userRecuperado = usuarioService.recuperarPorUsername(loginDTO.username());

        if (userRecuperado == null) {
            throw new UserNotFoundException();
        } else {
            if (userRecuperado.getUsername().equals(loginDTO.username()) && userRecuperado.getSenha().equals(loginDTO.senha())) {
                return hashLogado;
            } else {
                throw new IncorrectPassword();
            }
        }
    }
}
