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

    public List<Country> getById(String id) {
        List<Country> countrys = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM tb_country WHERE country_id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegion_id(resultSet.getInt(3));
                countrys.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return countrys;

    }

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
