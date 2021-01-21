package com.automatodev.loa.domain.model.representationModel;

public class UserOfferOutput {

    private long idUser;
    private String firstName;
    private String lastName;
    private String urlPhoto;
    private String phone;
    private String email;


    public void setIdUser(long idUser){
        this.idUser = idUser;
    }
    public long getIdUser(){
        return this.idUser;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public void setUrlPhoto(String urlPhoto){
        this.urlPhoto = urlPhoto;
    }

    public String getUrlPhoto(){
        return this.urlPhoto;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
    
}
