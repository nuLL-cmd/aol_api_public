package com.automatodev.loa.domain.model.entityModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.automatodev.loa.domain.model.ConvertGroupItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity(name = "tb_announcement")
public class ItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_announcement")
    private Long idAnnouncement;
    
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private String situation;
    @NotNull
    private BigDecimal price;
    @NotBlank
    private String uf;
    @NotBlank
    private String city;
    @NotBlank
    private String phone;
    @NotBlank
    private String uid;
    @NotNull
    private Double lat;
    @NotNull
    private Double lang;
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "status_item")
    private String statusItem;
    @NotBlank
    private String category;
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "date_cad")
    private Long dateCad;
    
    @Valid()
    @ConvertGroup(from = Default.class, to = ConvertGroupItem.UserEntity.class)
    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties("announces")
    private UserEntity userEntity;
    
    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_announcement")
    @JsonIgnoreProperties("itemEntity")
    private List<ImageEntity> images = new ArrayList<>();
    
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_announcement", updatable = false)
    @JsonIgnoreProperties("announcementEntity")
    private List<FavouriteEntity> favourites = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_announcement", updatable = false)
    private List<OfferEntity> offers;
    
    // //Metodos getters e setters nao sao necessarios, coloquei apenas para padronização.
    // //Pois a instancia de favorotis nessa classe se da apenas para fins de deleçaõ do anuncio
    // public void setOffers(List<OfferEntity> offers){
    //     this.offers = offers;
    // }
    // public List<OfferEntity> getOffers(){
    //     return this.offers;
    // }
    
    // //Metodos getters e setters nao sao necessarios, coloquei apenas para padronização.
    // //Pois a instancia de favorotis nessa classe se da apenas para fins de deleçaõ do anuncio
    // public void setFavourites(List<FavouriteEntity> favourites){
    //     this.favourites = favourites;
    // }
    // public List<FavouriteEntity> getFavourites(){
    //     return this.favourites;
    // }
    
    public void setUid(String uid){
        this.uid = uid;
    }
    
    public String getUid(){
        return this.uid;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public String getCategory(){
        return this.category;
    }
    public void setStatusItem(String statusItem){
        this.statusItem = statusItem;
    }
    
    public String getStatusItem(){
        return this.statusItem;
    }
    
    public Long getDateCad() {
        return this.dateCad;
    }
    
    public void setDateCad(Long dateCad) {
        this.dateCad = dateCad;
    }
    
    public void setLat(Double lat){
        this.lat = lat;
    }
    
    public Double getLat(){
        return this.lat;
    }
    
    public void setLang(Double lang){
        this.lang = lang;
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
    
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    
    public Long getIdAnnouncement() {
        return this.idAnnouncement;
    }
    
    public void setIdAnnouncement(Long idAnnouncement) {
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
    
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
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
    
    public UserEntity getUserEntity() {
        return this.userEntity;
    }
    
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    
    public List<ImageEntity> getImages() {
        return images;
    }
    
    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idAnnouncement ^ (idAnnouncement >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;
        if (obj == null)
        return false;
        if (getClass() != obj.getClass())
        return false;
        ItemEntity other = (ItemEntity) obj;
        if (idAnnouncement != other.idAnnouncement)
        return false;
        return true;
    }
    
    
    
    
} 