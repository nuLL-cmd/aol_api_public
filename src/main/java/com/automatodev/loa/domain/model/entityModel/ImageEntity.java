package com.automatodev.loa.domain.model.entityModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "tb_image")
public class ImageEntity {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private long idImage;

    @NotBlank
    @Column(name = "url_image")
    private  String urlImage;

    @NotBlank
    private String name;


    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    public long getIdImage() {
        return this.idImage;
    }

    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }

    public String getUrlImage() {
        return this.urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idImage ^ (idImage >>> 32));
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
		ImageEntity other = (ImageEntity) obj;
		if (idImage != other.idImage)
			return false;
        return true;
    }




}