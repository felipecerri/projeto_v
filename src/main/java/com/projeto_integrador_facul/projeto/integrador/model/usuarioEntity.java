package com.projeto_integrador_facul.projeto.integrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class usuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String usuario;
    private String senha;

    public usuarioEntity() {
    }
    
    
}
