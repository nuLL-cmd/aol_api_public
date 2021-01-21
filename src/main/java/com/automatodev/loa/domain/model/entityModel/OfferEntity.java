package com.automatodev.loa.domain.model.entityModel;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.springframework.data.annotation.ReadOnlyProperty;

@Entity(name = "tb_offer")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_offer")
    private Long idOffer;

    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "date_offer")
    private Long dateOffer;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private String status;

    @ManyToOne()
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties({"offers","announces"})
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "id_announcement")
    @JsonIgnoreProperties({"offers","userEntity"})
    private ItemEntity item;


    public OfferEntity(){

    }

    public void setIdOffer(Long idOffer){
        this.idOffer= idOffer;

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

    public void setUser(UserEntity user){
        this.user = user;
    }

    public UserEntity getUser(){
        return this.user;
    }

    public void setItem(ItemEntity item){
        this.item= item;
    }

    public ItemEntity getItem(){
        return this.item;
    }



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfferEntity other = (OfferEntity) obj;
		if (idOffer != other.idOffer)
			return false;
        return true;
    }



    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idOffer ^ (idOffer >>> 32));
		return result;
	}

}
