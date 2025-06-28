package com.projeto_integrador_facul.projeto.integrador.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_integrador_facul.projeto.integrador.model.jogEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface jogoRepository extends JpaRepository<jogEntity, Integer>{ 
    
    List<jogEntity> findByGenresContaining(String categoria);
    
    List<jogEntity> findByNameContaining(String name);
    
    List<jogEntity> findByOrderByNameAsc();
    
    List<jogEntity> findByOrderByNameDesc();
    
    List<jogEntity> findByOrderByReleaseDateAsc();
    
    List<jogEntity> findByOrderByReleaseDateDesc();
    
    @Query("SELECT g FROM jogEntity g WHERE " +
           "(:categoria IS NULL OR g.genres LIKE CONCAT('%', :categoria, '%')) AND " +
           "(:plataforma IS NULL OR (:plataforma = 'PC' AND g.windows = 'VERDADEIRO') OR (:plataforma = 'Mac' AND g.mac = 'VERDADEIRO') OR (:plataforma = 'Linux' AND g.linux = 'VERDADEIRO')) AND " +
           "(:nome IS NULL OR g.name LIKE CONCAT('%', :nome, '%')) order by g.name ASC")
    List<jogEntity> findByFiltroAsc(@Param("categoria") String categoria,@Param("plataforma") String plataforma, @Param("nome") String nome);
    
    @Query("SELECT g FROM jogEntity g WHERE " +
           "(:categoria IS NULL OR g.genres LIKE CONCAT('%', :categoria, '%')) AND " +
           "(:plataforma IS NULL OR (:plataforma = 'PC' AND g.windows = 'VERDADEIRO') OR (:plataforma = 'Mac' AND g.mac = 'VERDADEIRO') OR (:plataforma = 'Linux' AND g.linux = 'VERDADEIRO')) AND " +
           "(:nome IS NULL OR g.name LIKE CONCAT('%', :nome, '%')) order by g.name DESC")
    List<jogEntity> findByFiltroDesc(@Param("categoria") String categoria,@Param("plataforma") String plataforma, @Param("nome") String nome);
    
}
