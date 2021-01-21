package com.automatodev.loa.domain.model.representationModel;

import java.util.List;

import com.automatodev.loa.domain.model.entityModel.ImageEntity;
import com.automatodev.loa.domain.model.entityModel.ItemEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class AnnouncementOutput {

    private long idAnnouncement;
    private long dateCad;
    private String title;
    private String description;
    private String situation;
    private double price;
    private String phone;
    private String uf;
    private String city;
    private String uid;
    private Double lat;
    private Double lang;
    private String category;
    private String statusItem;
    private UserOutput userEntity;

    @JsonIgnoreProperties("announcementEntity")
    private List<ImageEntity> images;
    

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public long getDateCad() {
        return this.dateCad;
    }

    public void setDateCad(long dateCad) {
        this.dateCad = dateCad;
    }


    public String getCategory(){
        return this.category;
    }
    
    public void setLat(Double lat){
        this.lat = lat;
    }

    public Double getLat(){
        return this.lat;
    }

    public void setStatusItem(String statusItem){
        this.statusItem = statusItem;
    }

    public String getStatusItem(){
        return this.statusItem;
    }
    
    public void setLang(Double lang){
        this.lang  = lang;
    }

    public Double getLang(){
        return this.lang;
    }

    public String getSituation() {
        return this.situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public long getIdAnnouncement() {
        return this.idAnnouncement;
    }

    public void setIdAnnouncement(long idAnnouncement) {
        this.idAnnouncement = idAnnouncement;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserOutput getUserEntity() {
        return this.userEntity;
    }

    public void setUserEntity(UserOutput userEntity) {
        this.userEntity = userEntity;
    }

    public List<ImageEntity> getImages() {
        return this.images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }




}