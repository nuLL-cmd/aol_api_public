package com.automatodev.loa.domain.repository;

import java.util.List;

import com.automatodev.loa.domain.model.entityModel.OfferEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long>{

    List<OfferEntity> findByUser_idUser(Long id);
    List<OfferEntity> findByItem_idAnnouncementAndStatus(Long id, String status);
    OfferEntity findByUser_idUserAndItem_idAnnouncement(Long idUser, Long idAnnouncement);

    
}
