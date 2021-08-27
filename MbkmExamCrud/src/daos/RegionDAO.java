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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;

/**
 *
 * @author hp
 */
public class RegionDAO {
    
    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }
    
    
    
    /**
     * Method yang berfungsi untuk mengambil semua data tb_region yang ada pada database
     * @return -> method ini mengembalikan sebuah data dalam bentuk arrayList
     *              sehingga untuk pemanggilan dilakukan perulangan
     */
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
    
    /**
     * Method ini berfungsi untuk menginputkan atau menambahkan data tabel region ke dalam database berdasarkan nilai 
     * yang kita isi pada parameter method
     * @param region parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database
     * @return nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
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
    
    /**
     * Method ini berfungsi untuk mengubah data tabel region yang ada di dalam database berdasarkan nilai yang kita isi pada parameter method
     * @param region -> parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database. parameter pertama
     * adalah Id yang merupakan parameter rujukan untuk pengecekan apakah data tersebut ada didalam database atau tidak
     * @return ->  nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
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
    
    /**
     * Method ini berfungsi untuk memasukan data tabel region ke dalam database atau mengubah data yang sudah ada didalam database, method ini 
     * akan melakukan pengecekan berdasarkan parameter yang diinputkan, apabila data belum ada maka method akan melakukan insert
     * namun apabila method sudah ada maka akan dilakukan update
     * @param region -> untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diinsert / diupdate
     * @return -> method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil diinput/update
     * dan bernilai false apa bila data gagal diinput/update
     */
    public boolean InsertOrUpdate(Region region) {
             
        try {
            boolean isInsert = getById(region.getId()) == null;
            System.out.println(isInsert ? "Insert Berhasil" : "Update Berhasil");
            
            String query = isInsert
                        ? "INSERT INTO tb_region(region_name, region_id) VALUES ( ?,?)"
                        : "UPDATE tb_region SET region_name= ? WHERE region_id = ?";

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
    
    /**
     * Method ini berfungsi untuk menghapus data tabel region berdasarkan parameter yang diinputkan
     * @param id -> untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin dihapus
     * @return -> method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil di hapus 
     * dan bernilai false apa bila data gagal dihapus
     */
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
    
    /**
     * Method ini adalah method yang berfungsi untuk mengambil sebuah data tabel region berdasarkan parameter yang diinputkan
     * @param id -> untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diambil
     * @return -> method ini mengembalikan sebuah data dalam bentuk object
     */
    public Region getById(int id) {
        Region regions = new Region();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM tb_region WHERE region_id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                regions = new Region(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }    
   
}
