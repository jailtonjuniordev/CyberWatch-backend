package br.com.jadilumi.cyberwatch.service;

import br.com.jadilumi.cyberwatch.dto.UsuarioDTO;
import br.com.jadilumi.cyberwatch.dto.UsuarioMapper;
import br.com.jadilumi.cyberwatch.model.Usuario;
import br.com.jadilumi.cyberwatch.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Optional<Usuario> entity = userRepository.findByUsername(usuarioDTO.username());
        if(entity.isPresent()){
            throw new Exception("Usuário já encontrado!");
        }
        Usuario user = usuarioMapper.toEntity(usuarioDTO);
       return usuarioMapper.toDTO(userRepository.save(user));
    }

    public UsuarioDTO getUsuario(String userName) throws Exception {
        Optional<Usuario> entity = userRepository.findByUsername(userName);
        if(entity.isEmpty()){
            throw new Exception("Usuário não encontrado!");
        }
        return usuarioMapper.toDTO(entity.get()) ;
    }

    public boolean recuperarPorUsername(String userName) {
        return userRepository.findByUsername(userName).isPresent();
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Optional<Usuario> entity = userRepository.findByUsername(usuarioDTO.username());
        if(entity.isEmpty()){
            throw new Exception("Usuário não encontrado!");
        }
        entity.get().setUsername(usuarioDTO.username());
        entity.get().setNome(usuarioDTO.nome());
        entity.get().setSenha(usuarioDTO.senha());
        entity.get().setGenero(usuarioDTO.genero());
        entity.get().setTelefone(usuarioDTO.telefone());

        return usuarioMapper.toDTO(userRepository.save(entity.get()));
    }

    public void deleteUsuario(String userName) throws Exception {
        Optional<Usuario> entity = userRepository.findByUsername(userName);
        if(entity.isEmpty()){
            throw new Exception("Usuário não encontrado!");
        }
        entity.get().setDeleted(true);
        userRepository.save(entity.get());
    }


}
