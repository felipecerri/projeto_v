package com.projeto_integrador_facul.projeto.integrador.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto_integrador_facul.projeto.integrador.model.jogEntity;
import com.projeto_integrador_facul.projeto.integrador.model.jogoRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class jogoService {
    
    @Autowired
    
    jogoRepository jogoRepository;
    
    
    public List<jogEntity> listarTodosJogos(){
        
        
        return jogoRepository.findAll();
        
    }
    public List<jogEntity> listarPaginaJogos(int numeroPagina){
        
        
        List<jogEntity> listaJogos = jogoRepository.findAll();
        
        int jogosPorPagina = 10-1;
        
        int indicePrimeiroJogo = jogosPorPagina * (numeroPagina-1);
        int indiceUltimoJogo = jogosPorPagina * numeroPagina;
        
        List<jogEntity> listaJogo = jogoRepository.findAll();
        
        if(indiceUltimoJogo > listaJogo.size()){
            
            indiceUltimoJogo = listaJogo.size();
            
        }
        
        return listaJogo.subList(indicePrimeiroJogo, indiceUltimoJogo);
        
    }
    
    public List<jogEntity> listarPaginaJogosOrdenadoNome(int numeroPagina, String ordem){
        
        List<jogEntity> listaJogo = new ArrayList<>();
        
        ordem = ordem.toUpperCase();
        
        if("ASC".equals(ordem)){
            
            listaJogo = jogoRepository.findByOrderByNameAsc();
            
        }else{
            
            listaJogo = jogoRepository.findByOrderByNameDesc();
            
        }
        
        int jogosPorPagina = 10-1;
        
        int indicePrimeiroJogo = jogosPorPagina * (numeroPagina-1);
        int indiceUltimoJogo = jogosPorPagina * numeroPagina;
        
        if(indiceUltimoJogo > listaJogo.size()){
            
            indiceUltimoJogo = listaJogo.size();
            
        }
        
        return listaJogo.subList(indicePrimeiroJogo, indiceUltimoJogo);
        
    }
    
    public List<jogEntity> listarPaginaJogosOrdenadoData(int numeroPagina, String ordem){
        
        List<jogEntity> listaJogo = new ArrayList<>();
        
        ordem = ordem.toUpperCase();
        
        if("ASC".equals(ordem)){
            
            listaJogo = jogoRepository.findByOrderByReleaseDateAsc();
            
        }else{
            
            listaJogo = jogoRepository.findByOrderByReleaseDateDesc();
            
        }
        
        int jogosPorPagina = 10;
        
        int indicePrimeiroJogo = jogosPorPagina * (numeroPagina-1);
        int indiceUltimoJogo = jogosPorPagina * numeroPagina;
        
        if(indiceUltimoJogo > listaJogo.size()){
            
            indiceUltimoJogo = listaJogo.size();
            
        }
        
        return listaJogo.subList(indicePrimeiroJogo, indiceUltimoJogo);
        
    }
    
    public List<jogEntity> listarJogosComFiltro(int numeroPagina, String nomeJogo,String categoria, String plataforma, String direcaoOrdem){
        
        
        List<jogEntity> listaJogo = new ArrayList<>();
        
        if(direcaoOrdem == null || "ASC".equals(direcaoOrdem.toUpperCase())){
            
            listaJogo = jogoRepository.findByFiltroAsc(categoria, plataforma, nomeJogo);
            
        }else{
            
            listaJogo = jogoRepository.findByFiltroDesc(categoria, plataforma, nomeJogo);
            
        }
        
        int jogosPorPagina = 25;
        
        int indicePrimeiroJogo = jogosPorPagina * (numeroPagina-1);
        int indiceUltimoJogo = jogosPorPagina * numeroPagina;
        
        if(indiceUltimoJogo > listaJogo.size()){
            
            indiceUltimoJogo = listaJogo.size();
            
        }
        
        return listaJogo.subList(indicePrimeiroJogo, indiceUltimoJogo);
    }
    
    public List<jogEntity> pesquisarJogoCategoria(String categoria){
        
        return jogoRepository.findByGenresContaining(categoria);
        
    }
    
    public List<jogEntity> pesquisarJogoNome(String nome){
        
        return jogoRepository.findByNameContaining(nome);
        
    }
    
    
    public jogEntity listarJogoId(Integer jogoId){
        
        return jogoRepository.findById(jogoId).orElse(null);
        
    }
    
    //public List<jogoEntity> listarJogoNomeCategoria(String jogoNome, String jogoCategoria){
        
       // return jogoRepository.findByNomeOrCategoria(jogoNome, jogoCategoria);
        
    //}
    
    public jogEntity criarJogo(jogEntity jogo){
        
        jogo.setId(null);
        
        jogoRepository.save(jogo);
        
        return jogo;
        
    }
    
    public jogEntity atualizarJogo(Integer jogoId, jogEntity jogoRequest){
        
        jogEntity jogo = listarJogoId(jogoId);
        
        jogo.setName(jogoRequest.getName());
        
        jogoRepository.save(jogo);
        
        return jogo;
        
    }
    
    public void deletarJogo(Integer jogoId){
        
        jogEntity jogo = listarJogoId(jogoId);
        
        jogoRepository.deleteById(jogo.getId());
        
    }
    
}
