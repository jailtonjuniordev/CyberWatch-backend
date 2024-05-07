package br.com.jadilumi.cyberwatch.controller;

import br.com.jadilumi.cyberwatch.dto.LoginDTO;
import br.com.jadilumi.cyberwatch.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(value = "*", maxAge = 3600)
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> logarUsuario(@RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(loginService.logarUsuario(loginDTO), HttpStatus.OK);
    }
}
