package com.automatodev.loa.domain.model.representationModel;

import java.math.BigDecimal;

public class OfferOutput {
    
    private Long idOffer;
    private Long dateOffer;
    private BigDecimal price;
    private String status;
    private UserOfferOutput userEntity;
    private ItemOfferOutput itemEntity;

    public void setIdOffer(Long idOffer){
        this.idOffer = idOffer;
    }
    public Long getIdOffer(){
        return this.idOffer;
    }

    public void setDateOffer(Long dateOffer){
        this.dateOffer = dateOffer;
    }

    public Long getDateOffer(){
        return this.dateOffer;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return this.status;
}

    public void setUser(UserOfferOutput userEntity){
        this.userEntity = userEntity;
    }

    public UserOfferOutput getUser(){
        return this.userEntity;
    }

    public void setItem(ItemOfferOutput itemEntity){
        this.itemEntity  = itemEntity;
    }

    public ItemOfferOutput getItem(){
        return this.itemEntity;
    }

}
