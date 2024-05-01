package br.com.jadilumi.cyberwatch.controller;

import br.com.jadilumi.cyberwatch.dto.UsuarioDTO;
import br.com.jadilumi.cyberwatch.dto.UsuarioRetornoDTO;
import br.com.jadilumi.cyberwatch.service.UsuarioService;
import org.hibernate.annotations.NotFound;
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
    public ResponseEntity<?> criarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO) throws Exception {
      try{
          return new ResponseEntity<>(usuarioService.criarUsuario(usuarioDTO),HttpStatus.CREATED);
      }catch (Exception e){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
      }
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<String> deleteUsuario(@PathVariable(value = "userName") String userName) throws Exception {
      try {
          usuarioService.deleteUsuario(userName);
          return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário deletado com sucesso.");
      }catch (Exception e){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
      }
    }

    @GetMapping("/buscar/{userName}")
    public ResponseEntity<?> getUsuario(@PathVariable(value = "userName") String userName) throws Exception {
      try {
          return new ResponseEntity<>(usuarioService.getUsuario(userName), HttpStatus.OK);
      }catch (Exception e){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO) throws Exception {
        try{
            return new ResponseEntity<>(usuarioService.atualizarUsuario(usuarioDTO),HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
