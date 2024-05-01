
package br.com.jadilumi.cyberwatch.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//public record UsuarioDTO(
//        String username,
//        String nome,
//        String senha,
//        Character genero,
//        String telefone ){
//
//}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String username;
    private String nome;
    private String senha;
    private Character genero;
    private String telefone;
}