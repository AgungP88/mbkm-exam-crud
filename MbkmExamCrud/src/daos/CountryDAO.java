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
import models.Country;

/**
 *
 * @author gabri
 */
public class CountryDAO {

    private Connection connection;

    public CountryDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method yang berfungsi untuk mengambil semua data tabel country yang ada pada database
     * @return method ini mengembalikan sebuah data dalam bentuk arrayList. sehingga untuk pemanggilan dilakukan perulangan
     */
    public List<Country> getAll() {

        List<Country> countrys = new ArrayList<>();

        try {
            ResultSet resultSet = connection.prepareStatement("SELECT *FROM tb_country")
                    .executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegion_id(resultSet.getInt(3));
                countrys.add(new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countrys;
    }
    
    /**
     * Method ini berfungsi untuk menginputkan atau menambahkan data tabel country ke dalam database berdasarkan nilai 
     * yang kita isi pada parameter method
     * @param country -> parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database
     * @return -> nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
    public boolean insert(Country country) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tb_country(country_id, country_name, region_id) VALUES (?, ?,?)");
            preparedStatement.setString(1, country.getId());
            preparedStatement.setString(2, country.getName());
            preparedStatement.setInt(3, country.getRegion_id());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method ini berfungsi untuk mengubah data tabel country yang ada didalam database berdasarkan nilai yang kita isi pada parameter method
     * @param country -> parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database. parameter pertama
     * adalah Id yang merupakan parameter rujukan untuk pengecekan apakah data tersebut ada didalam database atau tidak
     * @return -> nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
    public boolean update(Country country) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tb_country SET country_name=? WHERE country_id=?");
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getId());
            preparedStatement.execute();
            return true;

        } catch (Exception e) {

        }
        return false;
    }

    /**
     * Method ini berfungsi untuk menghapus data pada tabel country berdasarkan parameter yang diinputkan
     * @param id untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin dihapus
     * @return ethod ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil di hapus
     * dan bernilai false apa bila data gagal dihapus
     */
    public boolean delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tb_country WHERE country_id=?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method ini adalah method yang berfungsi untuk mengambil sebuah data pada tabel country berdasarkan parameter yang diinputkan
     * @param id untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diambil
     * @return method ini mengembalikan sebuah data dalam bentuk object
     */
    public Country getById(String id) {
        Country countrys = new Country();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM tb_country WHERE country_id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                countrys = new Country(resultSet.getString(1), resultSet.getString(2), 
                        resultSet.getInt(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return countrys;

    }

    /**
     * Method ini berfungsi untuk memasukan data pada tabel country kedalam database atau mengubah data yang sudah ada didalam database, method ini 
     * akan melakukan pengecekan berdasarkan parameter yang diinputkan, apabila data belum ada maka method akan melakukan insert
     * namun apabila method sudah ada maka akan dilakukan update
     * @param country -> untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diinsert / diupdate
     * @return -> method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil diinput/update
     * dan bernilai false apa bila data gagal diinput/update
     */
    public boolean InsertOrUpdate(Country country) {

        try {
            boolean isInsert = getById(country.getId()) == null;
            System.out.println(isInsert ? "Insert Berhasil" : "Update Berhasil");
            String query = isInsert
                    ? "INSERT INTO tb_country(country_name, region_id, country_id) VALUES (?,?,?)"
                    : "UPDATE tb_country SET country_name=?, region_id=? WHERE country_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getRegion_id());
            preparedStatement.setString(3, country.getId());
            preparedStatement.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
