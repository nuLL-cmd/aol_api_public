package com.automatodev.loa.domain.model.entityModel;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.automatodev.loa.domain.model.ConvertGroupItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tb_user")
public class UserEntity {
	
	@Id
	@NotNull(groups = ConvertGroupItem.UserEntity.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private long idUser;
	
	@NotBlank
	private String uid;
	
	@NotBlank
	@Size(max = 60)
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank
	@Size(max = 60)
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	private String phone;


	private String city;
	@NotBlank
	private String uf;

	@Email
	@NotBlank
	private String email;
	
	@Column(name = "url_photo")
	private String urlPhoto;

	@Column(name = "date_since")
	private long dateSince;
	
	@Column(name = "cat_default")
	private String catDefault;

	@NotNull
	private BigDecimal total;
	 

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	@JsonIgnoreProperties({"userEntity","favourites", "offers"})
	private List<ItemEntity> announces;

	public UserEntity(String phone, String firstName, String lastName, String email, String urlPhoto, String city,
			String uf, long idUser, long dateSince) {

		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.urlPhoto = urlPhoto;
		this.city = city;
		this.uf = uf;
		this.idUser = idUser;
		this.dateSince = dateSince;
	}
	
	public void setCatDefault(String catDefault) {
		this.catDefault = catDefault;
	}
	
	public String getCatDefault() {
		return catDefault;
	}

	public void setTotal(BigDecimal total){
		this.total = total;
	}
	public BigDecimal getTotal(){
		return this.total;
	}
	
	public UserEntity() {
		
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	} 
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public long getDateSince() {
		return dateSince;
	}
	public void setDateSince(long dateSince) {
		this.dateSince = dateSince;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
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
		UserEntity other = (UserEntity) obj;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	

	public List<ItemEntity> getAnnounces() {
		return this.announces;
	}

	public void setAnnounces(List<ItemEntity> announces) {
		this.announces = announces;
	}
	
	
	

}
