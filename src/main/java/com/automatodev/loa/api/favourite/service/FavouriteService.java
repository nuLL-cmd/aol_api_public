package com.automatodev.loa.api.favourite.service;

import java.util.List;

import com.automatodev.loa.api.exceptionHandler.RulesException;
import com.automatodev.loa.domain.model.entityModel.FavouriteEntity;
import com.automatodev.loa.domain.repository.FavouriteRepository;
import com.automatodev.loa.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteService {

    //Injetando a dependencia de FavouritesRepository que possui os metodos de ações jpa para os favoritos
    @Autowired 
    private FavouriteRepository fRepository;

    @Autowired
    private UserRepository uRepository;
    //Serviço para persistir um novo favorito no banco de dados
    public Long postFavourite(FavouriteEntity fav){
        if(uRepository.existsById(fav.getUserEntity().getIdUser())){
            FavouriteEntity fEntity = fRepository.findByUserEntity_idUserAndAnnouncementEntity_idAnnouncement(fav.getUserEntity().getIdUser(),fav.getAnnouncementEntity().getIdAnnouncement());
            if(fEntity == null){
                return fRepository.save(fav).getIdFavourite();
            }
            
            throw new RulesException("Já existe um favorito associado a este anúncio!",422);
            
        }
           
        throw new RulesException("Usuário não encontrado",404);
    }

    //Service para listar todos os favoritos da plataforma, ja convertendo para uma lista de itens como saida. (apens para fins de relatorio)
    public List<FavouriteEntity> getAll(){
       List<FavouriteEntity> favlist = fRepository.findAll();
       return favlist;
    }

    //Service para listar os favoritos pelo id do usuario, ja convertendo para uma lista de itens como saida.
    public List<FavouriteEntity> getAllByUser(Long id){
        List<FavouriteEntity> favList = fRepository.findByUserEntity_idUser(id);
        return favList;
    }

    //Service para deletar um item na lista de favoritos
    public Long deleteById(Long id){
        if(fRepository.existsById(id)){
            fRepository.deleteById(id);
            return id;
        }
        throw new RulesException("Item não encontrado",404);

    }

    //Service para deletar todos os itens da lista de favoritos
    public Long deleteAll(Long id){
        List<FavouriteEntity> favs = fRepository.findByUserEntity_idUser(id);
        if(favs.size() != 0){
            fRepository.deleteAll(favs);
            return id;
        }
        throw new RulesException("Usuário não encontrado",404);
    }
}