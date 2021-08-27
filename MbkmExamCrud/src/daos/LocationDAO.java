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
     * Method yang berfungsi untuk mengambil semua data pada tabel location yang ada pada database
     * @return -> method ini mengembalikan sebuah data dalam bentuk arrayList. sehingga untuk pemanggilan dilakukan perulangan
     */
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        
        try {
            ResultSet resultSet = connection.prepareStatement("SELECT *FROM tb_location")
                    .executeQuery();
            while (resultSet.next()) {
                Location location = new Location();
                location.setId(resultSet.getString(1));
                location.setStreetAddres(resultSet.getString(2));
                location.setPostalCode(resultSet.getString(3));
                location.setCity(resultSet.getString(4));
                location.setStateProvince(resultSet.getString(5));
                location.setCountryId(resultSet.getString(6));
                locations.add(new Location(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
    
    
    /**
     * Method ini berfungsi untuk menginputkan atau menambahkan data pada tabel location ke dalam database berdasarkan nilai 
     * yang kita isi pada parameter method
     * @param location parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database
     * @return -> ilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
    public boolean insert(Location location) {
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tb_location(location_id, street_address, postal_code, city, state_province, country_id) VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, location.getId());
            preparedStatement.setString(2, location.getStreetAddres());
            preparedStatement.setString(3, location.getPostalCode());
            preparedStatement.setString(4, location.getCity());
            preparedStatement.setString(5, location.getStateProvince());
            preparedStatement.setString(6, location.getCountryId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    /**
     * Method ini berfungsi untuk mengubah data pada tabel location yang ada di dalam database berdasarkan nilai yang kita isi pada parameter method
     * @param location parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database. parameter pertama
     * adalah Id yang merupakan parameter rujukan untuk pengecekan apakah data tersebut ada didalam database atau tidak
     * @return -> nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
    public boolean update(Location location) {
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tb_location SET street_address=?, postal_code=?, city=?, state_province=?, country_id=? WHERE location_id=?");
            
            preparedStatement.setString(1, location.getStreetAddres());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setString(5, location.getCountryId());
            preparedStatement.setString(6, location.getId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }
    
    /**
     * Method ini berfungsi untuk menghapus data pada tabel location berdasarkan parameter yang diinputkan
     * @param id -> untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin dihapus
     * @return -> method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil di hapus
     * dan bernilai false apa bila data gagal dihapus
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

    /**
     * Method ini adalah method yang berfungsi untuk mengambil sebuah data pada tabel location berdasarkan parameter yang diinputkan
     * @param id -> untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diambil
     * @return -> method ini mengembalikan sebuah data dalam bentuk object
     */
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
     * Method ini berfungsi untuk memasukan data pada tabel location ke dalam database atau mengubah data yang sudah ada didalam database, method ini 
     * akan melakukan pengecekan berdasarkan parameter yang diinputkan, apabila data belum ada maka method akan melakukan insert
     * namun apabila method sudah ada maka akan dilakukan update
     * @param location -> untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diinsert / diupdate
     * @return -> method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil diinput/update
     * dan bernilai false apa bila data gagal diinput/update
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
            preparedStatement.setString(1, location.getStreetAddres());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStreetAddres());
            preparedStatement.setString(5, location.getCountryId());
            preparedStatement.setString(6, location.getId());
            
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
