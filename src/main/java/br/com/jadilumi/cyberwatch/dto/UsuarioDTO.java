
package br.com.jadilumi.cyberwatch.dto;


public record UsuarioDTO(
        String username,
        String nome,
        String senha,
        Character genero,
        String telefone ){

}