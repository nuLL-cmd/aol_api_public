package com.automatodev.loa.api.user.service;

import java.time.OffsetDateTime;
import java.util.List;

import com.automatodev.loa.api.exceptionHandler.RulesException;
import com.automatodev.loa.domain.model.entityModel.UserEntity;
import com.automatodev.loa.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Injeção do repositorio criado para utilizar os metodos de consulta da jpa
    @Autowired
    private UserRepository uRepository;

    //Service que valida se ja existe um usuario cadastrado com o email contido no body, caso seja false, sava o usuario no banco
    public UserEntity postUser(UserEntity userEntity){
        UserEntity userExists = uRepository.findByEmail(userEntity.getEmail());
        if(userExists != null)
            throw new RulesException("Ja existe um cliente cadastrado com este email",422);
        else{
            userEntity.setDateSince(OffsetDateTime.now().toEpochSecond());
            return uRepository.save(userEntity);
        }
            

    }

    //Service que trara todos os dados da tabela de usuario (para fins de relatorio)
    public List<UserEntity> getAllUsers(){
        return  uRepository.findAll();
    }

    //Service que trara um usuario por id 
    public UserEntity geById(Long id){
        UserEntity userExists = uRepository.findById(id).orElse(null);
        if(userExists != null)
        return userExists;

        throw new RulesException("Usuario não encontrado",404);
    }

    //Service que trara uma lista de usuarios pelo nome digitado (para fins administrativos)
    public List<UserEntity> getByCharName(String firstName){
        List<UserEntity> usersFound = uRepository.findByFirstName(firstName);
        if(usersFound.size() != 0)
            return usersFound;

        throw new RulesException("Nenhuma correspondencia encontrada",404);
    }

    //Service que trara uma lista de usuarios pela letra digitada (para fins administrativos)
    public  List<UserEntity> getByCharset(String charset){
        List<UserEntity> usersFound = uRepository.findByFirstNameContaining(charset);
        if(usersFound.size() != 0)
            return usersFound;

        throw new RulesException("Nenhuma correspondencia encontrada",404);
    }

    //Service que ira deletar um  usuario pelo ID  (para fins administratios)
    public Long deleteById(Long id){
        if(!uRepository.existsById(id))
            throw new RulesException("Usuário nao encontrado",404);
        
        uRepository.deleteById(id);
        return id;
    }

    //Service que valida se  existe um usuario cadastrado, caso seja false, atualiza o usuario no banco
    public UserEntity putUser(UserEntity userEntity, Long id){
        UserEntity userExists = uRepository.findByIdUser(id);
        if(userExists != null){
            userEntity.setIdUser(userExists.getIdUser());
            userEntity.setAnnounces(userExists.getAnnounces());
            return uRepository.save(userEntity);
        }

        throw new RulesException("Usúario informado não existe",404);
    }

    //Service que traara um usuario pelo uid inserido
	public UserEntity getByUid(String uid) {
        UserEntity userExists  = uRepository.findByUid(uid);
        if(userExists != null)
            return userExists;
        
        throw new RulesException("Nenhuma correspondencia encontrada",404);
	}
}