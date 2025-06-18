package com.projeto_integrador_facul.projeto.integrador.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto_integrador_facul.projeto.integrador.model.jogEntity;
import com.projeto_integrador_facul.projeto.integrador.model.jogoRepository;
import java.util.ArrayList;

@Service
public class jogoService {
    
    @Autowired
    
    jogoRepository jogoRepository;
    
    public List<jogEntity> listarTodosJogos(){
        
        
        return jogoRepository.findall();
        
    }
    public List<jogEntity> listarPaginaJogos(int numeroPagina){
        
        
        List<jogEntity> listaJogos = jogoRepository.findall();
        
        int jogosPorPagina = 10-1;
        
        int indicePrimeiroJogo = jogosPorPagina * (numeroPagina-1);
        int indiceUltimoJogo = jogosPorPagina * numeroPagina;
        
        List<jogEntity> listaJogo = jogoRepository.findAll();
        
        if(indiceUltimoJogo > listaJogo.size()){
            
            indiceUltimoJogo = listaJogo.size();
            
        }
        
        return listaJogo.subList(indicePrimeiroJogo, indiceUltimoJogo);
        
    }
    
    public List<jogEntity> pesquisarJogoCategoria(String categoria){
        
        return jogoRepository.findByCategories(categoria);
        
    }
    
    
    public jogEntity listarJogoId(Integer jogoId){
        
        return jogoRepository.findById(jogoId).orElse(null);
        
    }
    
    //public List<jogoEntity> listarJogoNomeCategoria(String jogoNome, String jogoCategoria){
        
       // return jogoRepository.findByNomeOrCategoria(jogoNome, jogoCategoria);
        
    //}
    
    public jogEntity criarJogo(jogEntity jogo){
        
        jogo.setAppID(null);
        
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
        
        jogoRepository.deleteById(jogo.getAppID());
        
    }
    
}
