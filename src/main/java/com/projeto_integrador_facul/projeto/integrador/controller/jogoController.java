package com.projeto_integrador_facul.projeto.integrador.controller;

import java.util.List;
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
import com.projeto_integrador_facul.projeto.integrador.model.jogEntity;
import com.projeto_integrador_facul.projeto.integrador.service.jogoService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/jogo")

public class jogoController {
    
    @Autowired
    
    jogoService jogoService;
    
    @GetMapping("/listar")
    
    public ResponseEntity<List> getAllJogos(){
        
        List<jogEntity> jogos = jogoService.listarTodosJogos();
        
        return new ResponseEntity<>(jogos, HttpStatus.OK);
        
    }
    
    @GetMapping("/listarPagina/{numeroPagina}")
    
    public ResponseEntity<List> getPaginaJogos(@PathVariable Integer numeroPagina){
        
        List<jogEntity> jogos = jogoService.listarPaginaJogos(numeroPagina);
        
        return new ResponseEntity<>(jogos, HttpStatus.OK);
        
    }
    
    @GetMapping("/listarPagina/{numeroPagina}/ordemAlfabetico/{ordem}")
    
    public ResponseEntity<List> getPaginaJogosOrdemAlfabetica(@PathVariable Integer numeroPagina, @PathVariable String ordem){
        
        List<jogEntity> jogos = jogoService.listarPaginaJogosOrdenadoNome(numeroPagina, ordem);
        
        return new ResponseEntity<>(jogos, HttpStatus.OK);
        
    }
    
    @GetMapping("/listarPagina/{numeroPagina}/ordemData/{ordem}")
    
    public ResponseEntity<List> getPaginaJogosOrdemData(@PathVariable Integer numeroPagina, @PathVariable String ordem){
        
        List<jogEntity> jogos = jogoService.listarPaginaJogosOrdenadoData(numeroPagina, ordem);
        
        return new ResponseEntity<>(jogos, HttpStatus.OK);
        
    }
    
    @GetMapping("/pesquisar/{id}")
    
    public ResponseEntity<jogEntity> getJogoById(@PathVariable Integer id){
        
        jogEntity jogo = jogoService.listarJogoId(id);
        
        return new ResponseEntity<>(jogo, HttpStatus.OK);
        
    }
    
    @GetMapping("/pesquisarCategoria/{categoria}")
    
    public ResponseEntity<List> getJogoByCategory(@PathVariable String categoria){
        
        List<jogEntity> listaJogo = jogoService.pesquisarJogoCategoria(categoria);
        
        return new ResponseEntity<>(listaJogo, HttpStatus.OK);
        
    }
    
    @GetMapping("/pesquisarNome/{nome}")
    
    public ResponseEntity<List> getJogoByName(@PathVariable String nome){
        
        List<jogEntity> listaJogo = jogoService.pesquisarJogoNome(nome);
        
        return new ResponseEntity<>(listaJogo, HttpStatus.OK);
        
    }
    
    @PostMapping("/adicionar")
    
    public ResponseEntity<jogEntity> addJogo(@RequestBody jogEntity jogo){
        
        var nogoJogo = jogoService.criarJogo(jogo);
        
        return new ResponseEntity<>(nogoJogo, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/atualizar/{id}")
    
    public ResponseEntity<jogEntity> atualizaJogo(@PathVariable Integer id, @RequestBody jogEntity jogo){
        
        var jogoAtualizado = jogoService.atualizarJogo(id, jogo);
        
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
    @DeleteMapping("/deletar/{id}")
    
    public ResponseEntity deletarJogo(@PathVariable Integer id){
        
        jogoService.deletarJogo(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
    @GetMapping("/filtrar")
    
    public ResponseEntity<Map<String, Object>> getJogosComFiltros(@RequestParam int numeroPagina, @RequestParam(required = false) String nomeJogo, @RequestParam(required = false) String categoria, @RequestParam(required = false) String plataforma, @RequestParam(required = false) String direcaoOrdem){
        
        if("".equals(categoria) || "All".equals(categoria)){
            
            categoria = null;
            System.out.println(categoria);
        }
        if("".equals(plataforma) || "All".equals(plataforma)){
            
            plataforma = null;
            
        }
        
        System.out.println(categoria);
        
        List<jogEntity> listaJogo = jogoService.listarJogosComFiltro(numeroPagina, nomeJogo, categoria, plataforma, direcaoOrdem);
        
        Map<String, Object> response = new HashMap<>();
        response.put("jogos", listaJogo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

