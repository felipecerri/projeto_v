package com.projeto_integrador_facul.projeto.integrador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="games")
public class jogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String categories;
    private String detailed_description;
    private String developers;
    private String full_audio_languages;
    private String genres;
    private String header_image;
    private String linux;
    private String mac;
    private String movies;
    private String name;
    private Integer negative;
    private Integer positive;
    private Double price;
    private String releaseDate;
    private String screenshots;
    private String supported_languages;
    private String windows;

    public jogEntity() {
    }
    
    
    
}

