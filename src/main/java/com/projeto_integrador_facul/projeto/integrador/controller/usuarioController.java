package com.projeto_integrador_facul.projeto.integrador.controller;

import com.projeto_integrador_facul.projeto.integrador.model.usuarioEntity;
import com.projeto_integrador_facul.projeto.integrador.service.usuarioService;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class usuarioController {
    
    @Autowired
    
    usuarioService usuarioService;
    
    @GetMapping("/procurarUsuario/{usuario}/{senha}")
    
    public ResponseEntity<usuarioEntity> getUsuario(@PathVariable String usuario, @PathVariable String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        
        usuarioEntity usuarioEntidade = usuarioService.getVerificarUsuario(usuario, senha);
        
        if(usuarioEntidade.getUsuario() == null){
            
            return new ResponseEntity<>(usuarioEntidade, HttpStatus.NOT_FOUND);
            
        }
        
        return new ResponseEntity<>(usuarioEntidade, HttpStatus.OK);
        
    }
    
    @PostMapping("/adicionar")
    
    public ResponseEntity<usuarioEntity> addUsuario(@RequestBody usuarioEntity usuario) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        
        var novoUsuario = usuarioService.criarUsuario(usuario);
        
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        
    }
    
}
