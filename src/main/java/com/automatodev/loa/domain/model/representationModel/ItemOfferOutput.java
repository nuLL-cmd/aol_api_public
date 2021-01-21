package com.automatodev.loa.domain.model.representationModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.automatodev.loa.domain.model.entityModel.ImageEntity;

public class ItemOfferOutput {
    private Long idAnnouncement;
    private String title;
    private String phone;
    private BigDecimal price;

    private List<ImageEntity> images = new ArrayList<>();

    public void setIdAnnouncement(Long idAnnouncement){
        this.idAnnouncement = idAnnouncement;
    }

    public Long getIdAnnouncement(){
        return this.idAnnouncement;
    }

    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return this.title;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return this.phone;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    public List<ImageEntity> getImages(){
      return this.images;
    }
    
}
