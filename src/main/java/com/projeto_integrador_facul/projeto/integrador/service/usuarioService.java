package com.projeto_integrador_facul.projeto.integrador.service;

import com.projeto_integrador_facul.projeto.integrador.model.usuarioEntity;
import com.projeto_integrador_facul.projeto.integrador.model.usuarioRepository;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class usuarioService {
    
    @Autowired
    
    usuarioRepository usuarioRepository;
    
    public usuarioEntity criarUsuario(usuarioEntity usuario) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        
        usuario.setId(null);
        
        byte[] bytesOfMessage = usuario.getSenha().getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] theMD5digest = md.digest(bytesOfMessage);
        
        usuario.setSenha(Arrays.toString(theMD5digest));
        
        usuarioRepository.save(usuario);
        
        return usuario;
        
    }
    
    public usuarioEntity getVerificarUsuario(String usuario, String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        
        byte[] bytesOfMessage = senha.getBytes("UTF-8");
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] theMD5digest = md.digest(bytesOfMessage);
        
        senha = Arrays.toString(theMD5digest);
        
        System.out.println(senha);
        
        usuarioEntity usuarioEntidade = usuarioRepository.findByUsuarioAndSenha(usuario, senha);
        
        return usuarioEntidade;
        
    }
    
}
