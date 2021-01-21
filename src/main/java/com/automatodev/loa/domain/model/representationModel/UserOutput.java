package com.automatodev.loa.domain.model.representationModel;

public class UserOutput {

    private long idUser;
    private String firstName;
    private String lastName;
    private String urlPhoto;
    private String phone;
    private String uf;
    private String city;
    private long dateSince;


    public long getDateSince() {
        return this.dateSince;
    }

    public void setDateSince(long dateSince) {
        this.dateSince = dateSince;
    }


    public long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUrlPhoto() {
        return this.urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
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

    
}