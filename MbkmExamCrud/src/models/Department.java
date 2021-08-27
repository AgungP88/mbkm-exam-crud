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
    private String Id, Name, Location, Manager;
    
    public Department(){
        
    }
    
    public Department(String Id, String Name, String Location, String Manager){
        this.Id = Id;
        this.Name = Name;
        this.Location = Location;
        this.Manager = Manager;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String Manager) {
        this.Manager = Manager;
    }
    
}
