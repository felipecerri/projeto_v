package com.projeto_integrador_facul.projeto.integrador.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<usuarioEntity, Integer> {
    
    @Query("SELECT u FROM usuarioEntity u WHERE u.usuario = :usuario and u.senha = :senha")
    usuarioEntity findByUsuarioAndSenha(@Param("usuario") String usuario, @Param("senha") String senha);
    
}
