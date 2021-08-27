/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author gabri
 */
public class Location {
    
    private String id;
    private String street_addres;
    private String postal_code;
    private String city;
    private String state_province;
    private String country_id;

    public Location() {
    }

    public Location(String id, String street_addres, String postal_code, String city, String state_province, String country_id) {
        this.id = id;
        this.street_addres = street_addres;
        this.postal_code = postal_code;
        this.city = city;
        this.state_province = state_province;
        this.country_id = country_id;
    }

    public Location(String id, String street_addres, String postal_code, String city, String state_province) {
        this.id = id;
        this.street_addres = street_addres;
        this.postal_code = postal_code;
        this.city = city;
        this.state_province = state_province;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet_addres() {
        return street_addres;
    }

    public void setStreet_addres(String street_addres) {
        this.street_addres = street_addres;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", street_addres=" + street_addres + ", postal_code=" + postal_code + ", city=" 
                + city + ", state_province=" + state_province + ", country_id=" + country_id + '}';
    }
    
    

}
