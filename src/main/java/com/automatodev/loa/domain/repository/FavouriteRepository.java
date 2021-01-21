package com.automatodev.loa.domain.repository;

import java.util.List;

import com.automatodev.loa.domain.model.entityModel.FavouriteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FavouriteRepository extends JpaRepository<FavouriteEntity, Long>{

    List<FavouriteEntity> findByUserEntity_idUser(long id);
    FavouriteEntity findByUserEntity_idUserAndAnnouncementEntity_idAnnouncement(long idUser, long idAnnouncement);
    
}