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

    public Location(String id, String streetAddres, String postalCode, String city, String stateProvince, String countryIid) {
        this.id = id;
        this.streetAddres = streetAddres;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryIid;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreetAddres() {
        return streetAddres;
    }

    public void setStreetAddres(String streetAddres) {
        this.streetAddres = streetAddres;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", street_addres=" + streetAddres + ", postal_code=" + postalCode + ", city=" 
                + city + ", state_province=" + stateProvince + ", country_id=" + countryId + '}';
    }
    
    

}
