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
public class Country {
    
    private String id;
    private String name;
    private int regionId;

    public Country() {
    }

    public Country(String id, String name, int region_id) {
        this.id = id;
        this.name = name;
        this.regionId = region_id;
    }

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }
    


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegion_id() {
        return regionId;
    }

    public void setRegion_id(int region_id) {
        this.regionId = region_id;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", region_id=" + regionId + '}';
    }
    
    
    
}
