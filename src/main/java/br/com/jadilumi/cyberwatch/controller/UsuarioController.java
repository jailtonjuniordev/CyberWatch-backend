package br.com.jadilumi.cyberwatch.controller;

import br.com.jadilumi.cyberwatch.dto.UsuarioDTO;
import br.com.jadilumi.cyberwatch.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO) throws Exception {
        return new ResponseEntity<>(usuarioService.criarUsuario(usuarioDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "userName") String userName) throws Exception {
        usuarioService.deleteUsuario(userName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário deletado com sucesso.");
    }
}
