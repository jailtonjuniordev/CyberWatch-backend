package br.com.jadilumi.cyberwatch.controller;

import br.com.jadilumi.cyberwatch.dto.LoginDTO;
import br.com.jadilumi.cyberwatch.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class UsuarioController {

    private final UsuarioService userService;

    @PostMapping("/")
    public ResponseEntity<String> logarUsuario(@RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(userService.logarUsuario(loginDTO), HttpStatus.OK);
    }
}
