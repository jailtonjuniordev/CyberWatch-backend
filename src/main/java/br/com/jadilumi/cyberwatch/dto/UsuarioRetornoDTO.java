
package br.com.jadilumi.cyberwatch.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRetornoDTO {
    private Long id;
    private String username;
    private String nome;
    private Character genero;
    private String telefone;
}