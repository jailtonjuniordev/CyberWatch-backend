package br.com.jadilumi.cyberwatch.service;

import br.com.jadilumi.cyberwatch.dto.LoginDTO;
import br.com.jadilumi.cyberwatch.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    String hashLogado = "LOGOUGHASKJHFAKJHGKJNAEKFAKJSDNKJ";

    private final UsuarioService usuarioService;

    public String logarUsuario(LoginDTO loginDTO) {
        Usuario userRecuperado = usuarioService.recuperarPorUsername(loginDTO.username());

        if (userRecuperado == null) {
            return "Usuario não encontrado!!";
        } else {
            if (userRecuperado.getUsername().equals(loginDTO.username()) && userRecuperado.getSenha().equals(loginDTO.senha())) {
                return hashLogado;
            } else {
                return "Senha Incorreta!";
            }
        }
    }
}
