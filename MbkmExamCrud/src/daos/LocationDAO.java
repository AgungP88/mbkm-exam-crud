/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Location;

/**
 *
 * @author gabri
 */
public class LocationDAO {
    
    private Connection connection;
    
    public LocationDAO(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * 
     * @return 
     */
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        
        try {
            ResultSet resultSet = connection.prepareStatement("SELECT *FROM tb_location")
                    .executeQuery();
            while (resultSet.next()) {
                Location location = new Location();
                location.setId(resultSet.getString(1));
                location.setStreet_addres(resultSet.getString(2));
                location.setPostal_code(resultSet.getString(3));
                location.setCity(resultSet.getString(4));
                location.setState_province(resultSet.getString(5));
                location.setCountry_id(resultSet.getString(6));
                locations.add(new Location(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
    
    
    /**
     * 
     * @param location
     * @return 
     */
    public boolean insert(Location location) {
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tb_location(location_id, street_address, postal_code, city, state_province, country_id) VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, location.getId());
            preparedStatement.setString(2, location.getStreet_addres());
            preparedStatement.setString(3, location.getPostal_code());
            preparedStatement.setString(4, location.getCity());
            preparedStatement.setString(5, location.getState_province());
            preparedStatement.setString(6, location.getCountry_id());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    /**
     * 
     * @param location
     * @return 
     */
    public boolean update(Location location) {
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tb_location SET street_address=?, postal_code=?, city=?, state_province=?, country_id=? WHERE location_id=?");
            
            preparedStatement.setString(1, location.getStreet_addres());
            preparedStatement.setString(2, location.getPostal_code());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getState_province());
            preparedStatement.setString(5, location.getCountry_id());
            preparedStatement.setString(6, location.getId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tb_location WHERE location_id=?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return false;
    }

    public Location getById(String id) {
        Location locations = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tb_location WHERE location_id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                locations = new Location(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
    
    
    /**
     * 
     * @param location
     * @return 
     */
    public boolean InsertOrUpdate(Location location) {
        try {
            boolean isInsert = getById(location.getId()) == null;
            System.out.println(isInsert ? "Insert Berhasil" : "Update Berhasil");
            String query = isInsert
                    ? "INSERT INTO tb_location(street_address, postal_code, city, state_province, "
                    + "country_id, location_id) VALUES("
                    + "?,?,?,?,?,?)"
                    : "UPDATE tb_location SET street_address = ?, postal_code= ?, city= ?, "
                    + "state_province = ?, country_id= ?  WHERE location_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location.getStreet_addres());
            preparedStatement.setString(2, location.getPostal_code());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStreet_addres());
            preparedStatement.setString(5, location.getCountry_id());
            preparedStatement.setString(6, location.getId());
            
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
