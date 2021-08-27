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
    private String streetAddres;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryId;

    public Location() {
    }

    public Location(String id, String street_addres, String postal_code, String city, String state_province, String country_id) {
        this.id = id;
        this.streetAddres = street_addres;
        this.postalCode = postal_code;
        this.city = city;
        this.stateProvince = state_province;
        this.countryId = country_id;
    }

    public Location(String id, String street_addres, String postal_code, String city, String state_province) {
        this.id = id;
        this.streetAddres = street_addres;
        this.postalCode = postal_code;
        this.city = city;
        this.stateProvince = state_province;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet_addres() {
        return streetAddres;
    }

    public void setStreet_addres(String street_addres) {
        this.streetAddres = street_addres;
    }

    public String getPostal_code() {
        return postalCode;
    }

    public void setPostal_code(String postal_code) {
        this.postalCode = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_province() {
        return stateProvince;
    }

    public void setState_province(String state_province) {
        this.stateProvince = state_province;
    }

    public String getCountry_id() {
        return countryId;
    }

    public void setCountry_id(String country_id) {
        this.countryId = country_id;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", street_addres=" + streetAddres + ", postal_code=" + postalCode + ", city=" 
                + city + ", state_province=" + stateProvince + ", country_id=" + countryId + '}';
    }
    
    

}
