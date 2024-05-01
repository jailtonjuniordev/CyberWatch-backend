package br.com.jadilumi.cyberwatch.dto;

import br.com.jadilumi.cyberwatch.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Objects;
import java.util.Optional;

@Mapper
public interface UsuarioMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "senha", target = "senha")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "telefone", target = "telefone")
    UsuarioDTO toDTO(Usuario usuario);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "senha", target = "senha")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "telefone", target = "telefone")
    Usuario toEntity(UsuarioDTO usuarioDTO);

}