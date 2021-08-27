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
import models.Region;

/**
 *
 * @author hp
 */
public class RegionDAO {
    
    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();

        try {
            ResultSet resultSet = connection.prepareStatement("SELECT *FROM tb_region")
                    .executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
                regions.add(new Region(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
    
    public boolean insert(Region region) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tb_region(region_id, region_name) VALUES(?,?)");
            preparedStatement.setInt(1, region.getId());
            preparedStatement.setString(2, region.getName());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    
    public boolean update(Region region) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tb_region SET region_name=? WHERE region_id=?");
            preparedStatement.setString(1, region.getName());
            preparedStatement.setInt(2, region.getId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    
    public boolean InsertOrUpdate(Region region) {
             
        try {
            boolean isInsert = getById(region.getId()) == null;
            System.out.println(isInsert ? "Insert Berhasil" : "Update Berhasil");
            String query = isInsert
                    ? "INSERT INTO tb_region(region_name, region_id) VALUES(?,?)"
                    : "UPDATE tb_region SET region_name = ? WHERE region_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, region.getName());
            preparedStatement.setInt(2, region.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tb_region WHERE region_id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
    
    public List<Region> getById(int id) {
        List<Region> regions = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM tb_region WHERE region_id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
                regions.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
    
    
    
 
    
    
    
    
    
    
    
    
    
    
}
