package br.com.jadilumi.cyberwatch.repository;

import br.com.jadilumi.cyberwatch.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

    Optional<Usuario> findByUsernameAndDeletedIsFalse(String username);
    Optional<Usuario> findByUsername(String username);
}
