package br.com.jadilumi.cyberwatch.service;

import br.com.jadilumi.cyberwatch.dto.UsuarioDTO;
import br.com.jadilumi.cyberwatch.model.Usuario;
import br.com.jadilumi.cyberwatch.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Optional<Usuario> entity = userRepository.findByUsername(usuarioDTO.getUsername());
        if(entity.isPresent()){
            throw new Exception("Usuário já encontrado!");
        }
        Usuario user = modelMapper.map(usuarioDTO,Usuario.class);
        user.setCreatedBy("System");
       return modelMapper.map((userRepository.save(user)), UsuarioDTO.class);
    }

    public UsuarioDTO getUsuario(String userName) throws Exception {
        Optional<Usuario> entity = userRepository.findByUsername(userName);
        if(entity.isEmpty()){
            throw new Exception("Usuário não encontrado!");
        }
        return modelMapper.map(entity.get(),UsuarioDTO.class) ;
    }

    public boolean recuperarPorUsername(String userName) {
        return userRepository.findByUsername(userName).isPresent();
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Optional<Usuario> entity = userRepository.findByUsername(usuarioDTO.getUsername());
        if(entity.isEmpty()){
            throw new Exception("Usuário não encontrado!");
        }
        entity.get().setUsername(usuarioDTO.getUsername());
        entity.get().setNome(usuarioDTO.getNome());
        entity.get().setSenha(usuarioDTO.getSenha());
        entity.get().setGenero(usuarioDTO.getGenero());
        entity.get().setTelefone(usuarioDTO.getTelefone());

        return modelMapper.map(userRepository.save(entity.get()), UsuarioDTO.class);
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
