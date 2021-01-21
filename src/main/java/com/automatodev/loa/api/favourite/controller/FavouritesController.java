package com.automatodev.loa.api.favourite.controller;

import java.util.List;

import com.automatodev.loa.api.favourite.service.FavouriteService;
import com.automatodev.loa.domain.model.entityModel.FavouriteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Classe controladora que detem os endpoints referente ao crudo e ações do dos Anuncios publicados
@RestController //Anotação que indica que esta classe é um controlador rest
@RequestMapping("favourites") //Atende tudo que vier com origem deste endpoint
public class FavouritesController {

    //Injetando a dependencia de FavouritesService que possui os metodos de ações jpa para os favoritos com base no repositorio da classe
    @Autowired
    private FavouriteService fService;

    //Metodo http GET que listara todos os anuncios (nao é necessario colocar o endpoint, pois ele atende direto ao endpoint de RequestMapping no escopo da classe)
    //Apenas para fins de relatorios
    @GetMapping
    public List<FavouriteEntity> getAllFav(){
        return fService.getAll();
    }

    //Metodo http GET que recupera um dado atraves do id no endpoint "favourites" declarado em RequestMapping no escopo da classe
    @GetMapping("{id}") 
    public List<FavouriteEntity> getAnnounces(@PathVariable long id){
        return fService.getAllByUser(id);
    }

    //Metodo http POST que realiza a persistencia (gravação) de dados na tabela / tabelas, atendendo ao endpoint "favourites" declarado em RequestMapping no escopo da classe
    @PostMapping()
    public ResponseEntity<Long> postFavourites(@RequestBody FavouriteEntity fav){
        return ResponseEntity.ok().body(fService.postFavourite(fav));
    }

    //Metodo http DELETE que realiza a deleção de um favorito tendo como prarametro o id atendendo ao endpoint "favourites" declarado em RequestMapping no escopo da classe
    @DeleteMapping("{id}") 
    public  ResponseEntity<Long> deleteById(@PathVariable Long id){
         return ResponseEntity.ok(fService.deleteById(id));
    
    }
  //Metodo http DELETE que realiza a deleção de tdos os favoritos atendendo ao endpoint "favourites" declarado em RequestMapping no escopo da classe
    @DeleteMapping()
    public ResponseEntity<Long> deleteAll(@RequestParam() Long id){
         return ResponseEntity.ok(fService.deleteAll(id));
    }
}       