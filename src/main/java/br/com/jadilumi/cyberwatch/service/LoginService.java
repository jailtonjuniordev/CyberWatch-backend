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
        boolean userRecuperado = usuarioService.recuperarPorUsername(loginDTO.username());

        if (!userRecuperado) {
            return "Usuario não encontrado!!";
        } else {
            if (userRecuperado) {
                return hashLogado;
            } else {
                return "Senha Incorreta!";
            }
        }
    }
}
