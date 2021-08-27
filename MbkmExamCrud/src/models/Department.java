/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hp
 */
public class Department {
    private String id, name, location, manager;
    
    public Department(){
        
    }
    
    public Department(String Id, String Name, String Location, String Manager){
        this.id = Id;
        this.name = Name;
        this.location = Location;
        this.manager = Manager;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String Location) {
        this.location = Location;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String Manager) {
        this.manager = Manager;
    }
    
}
