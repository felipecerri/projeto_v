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
    private Integer id_original;
    private String about_the_game;
    private String categories;
    private String detailed_description;
    private String developers;
    private String discount;
    private String estimated_owners;
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
    private String publishers;
    private String releaseDate;
    private Integer required_age;
    private String screenshots;
    private String short_description;
    private String supported_languages;
    private String website;
    private String windows;

    public jogEntity() {
    }
    
    
    
}

