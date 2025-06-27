package com.projeto_integrador_facul.projeto.integrador.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_integrador_facul.projeto.integrador.model.jogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface jogoRepository extends JpaRepository<jogEntity, Integer>{ 
    
    List<jogEntity> findByGenresContaining(String categoria);
    
    List<jogEntity> findByNameContaining(String name);
    
    List<jogEntity> findByOrderByNameAsc();
    
    List<jogEntity> findByOrderByNameDesc();
    
    List<jogEntity> findByOrderByReleaseDateAsc();
    
    List<jogEntity> findByOrderByReleaseDateDesc();
    
}
