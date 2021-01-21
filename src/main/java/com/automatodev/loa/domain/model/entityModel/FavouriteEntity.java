package com.automatodev.loa.domain.model.entityModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity(name = "tb_favourites")
public class FavouriteEntity {

    @Id
    @Column(name = "id_favourite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFavourite;

    @ManyToOne()
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties("announces")
    private UserEntity userEntity;

    @ManyToOne()
    @JoinColumn(name = "id_announcement")
    @JsonIgnoreProperties("favourites")
    private ItemEntity announcementEntity;
    
    public void setIdFavourite(long idFavourite){
        this.idFavourite = idFavourite;
    }
    public long getIdFavourite(){
        return this.idFavourite;
    }


    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ItemEntity getAnnouncementEntity() {
        return this.announcementEntity;
    }

    public void setAnnouncementEntity(ItemEntity announcementEntity) {
        this.announcementEntity = announcementEntity;
    }


}