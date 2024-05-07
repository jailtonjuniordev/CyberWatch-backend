package br.com.jadilumi.cyberwatch.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
public class Usuario extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 50, unique = true, nullable = false)
    private String username;

    @NonNull
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @NonNull
    @Column(length = 100)
    private String senha;

    @Column(length = 1)
    private Character genero;

    @Column(name = "telefone", length = 15)
    private String telefone;

}
