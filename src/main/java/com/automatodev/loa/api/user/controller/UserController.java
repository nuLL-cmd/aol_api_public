package com.automatodev.loa.api.user.controller;

import java.util.List;

import javax.validation.Valid;

import com.automatodev.loa.api.user.service.UserService;
import com.automatodev.loa.domain.model.entityModel.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



// rota que traz que responde as chamadas relaionadas a manipulação de usuarios
@RestController
@RequestMapping("user")
public class UserController {

    //Injeção da dependencia de serviço para usar nos endpoints
    @Autowired
    private UserService uService;

    // Metodo GET que responde diretamento a rota "user" trazendo todos os usuarios no banco
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(uService.getAllUsers());
    }

    // Metodo GET que responde ao endpoint "user/by_id" com requestParam onde id equivale ao id a ser buscado no banco
    @GetMapping("userId")
    public ResponseEntity<UserEntity> getById(@RequestParam("id") long id) {
        return ResponseEntity.ok(uService.geById(id));
    }

    // Metodo GET que responde ao endpoint "user/by_name" com requestParam onde name equivale ao primeiro nome a ser buscado no banco
    @GetMapping("by_name")
    public ResponseEntity<List<UserEntity>> getByCharName(@RequestParam("name") String firstName) {
        return ResponseEntity.ok(uService.getByCharName(firstName));
    }

    // Metodo GET que responde ao endpoint "user/char_name" com requestParam onde charset equivale a uma letra ou termo correpondente no nome a ser buscado no banco
    @GetMapping("char_name")
    public ResponseEntity<List<UserEntity>> getByCharset(@RequestParam("char")String charset) {
        return ResponseEntity.ok(uService.getByCharset(charset));
    }
    // Metodo GET que responde ao endpoint "user/by_uid" com requestParam onde uid equivale ao uid do usuario a ser buscado no banco
    @GetMapping("userUid")
    public ResponseEntity<UserEntity> getUserByUid(@RequestParam("uid") String uid) {
        return ResponseEntity.ok(uService.getByUid(uid));
    }

    // Metodo POST que realiza a gravação de um novo usuario seguindo as regras de negocio para gravação impostas em na classe de serviço
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserEntity postUser(@Valid @RequestBody UserEntity user) {
       return uService.postUser(user);
    }

    // Metodo PUT que atualiza um usuario verificando se o usuario existes pelo id,
    // caso exista seta o id no usuario passado no corpo e atualiza o usuario
    @PutMapping("{id}")
    public ResponseEntity<UserEntity> putUser(@PathVariable long id, @RequestBody UserEntity user) {
        return ResponseEntity.ok(uService.putUser(user, id));
    }

    //Metodo DELETE que deleta um usuario por id, o padrao de resposta é NO_CONTENT
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Long deletebyId(@PathVariable long id) {
        return uService.deleteById(id);
    }
}