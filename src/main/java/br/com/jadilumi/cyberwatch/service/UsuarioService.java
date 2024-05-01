package br.com.jadilumi.cyberwatch.service;

import br.com.jadilumi.cyberwatch.dto.LoginDTO;
import br.com.jadilumi.cyberwatch.model.Usuario;
import br.com.jadilumi.cyberwatch.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    String hashLogado = "LOGOUGHASKJHFAKJHGKJNAEKFAKJSDNKJ";

    private final UsuarioRepository userRepository;

    public String logarUsuario(LoginDTO loginDTO) {
        Usuario userRecuperado = userRepository.findByUsername(loginDTO.username());

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
