package br.com.jadilumi.cyberwatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.NonNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @NonNull
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(length = 100)
    private String email;

    @NonNull
    @Column(length = 100)
    private String senha;

    @Column(length = 11)
    private String cpf;

    @Column(length = 1)
    private String genero;

    @NonNull
    @Column(name = "aniversario", length = 10)
    private String aniversario;

    @Column(name = "telefone", length = 15)
    private String telefone;

}
