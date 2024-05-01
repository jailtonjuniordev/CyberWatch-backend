package br.com.jadilumi.cyberwatch.service;

import br.com.jadilumi.cyberwatch.model.Usuario;
import br.com.jadilumi.cyberwatch.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository userRepository;

    public Usuario recuperarPorUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
