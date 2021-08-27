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
import models.Department;

/**
 *
 * @author hp
 */
public class DepartmentDAO {
    private Connection connection;
    
    public DepartmentDAO(Connection connection){
        this.connection = connection;
    }
    
    public List<Department> getAll(){
        List<Department> departments = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("SELECT * FROM tb_department").executeQuery();
            while (resultSet.next()) {
                //style1
                departments.add(new Department(resultSet.getString(1), 
                        resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    
}
  
    
    public Department getById(String id) {
        Department department = null;
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT *FROM tb_department WHERE department_id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                department = new Department(resultSet.getString(1), 
                        resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }
    
    public boolean insert(Department department){
    try {
        //Parameterized query
        PreparedStatement preparedStatement = 
                connection.prepareStatement("INSERT INTO tb_department(department_id, department_name, location_id, manager_id) VALUES(?,?,?,?)");
        preparedStatement.setString(1, department.getId());
        preparedStatement.setString(2, department.getName());
        preparedStatement.setString(3, department.getLocation());
        preparedStatement.setString(4, department.getManager());
        preparedStatement.execute();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }


public boolean update(Department department){
    try {
        PreparedStatement preparedStatement = 
                connection.prepareStatement("UPDATE tb_department SET department_name = ?, location_id = ?, manager_id = ? WHERE department_id = ?");
        preparedStatement.setString(4, department.getId());
        preparedStatement.setString(1, department.getName());
        preparedStatement.setString(2, department.getLocation());
        preparedStatement.setString(3, department.getManager());
        preparedStatement.execute();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }


public boolean delete(String id){
    try {
        PreparedStatement preparedStatement = 
                connection.prepareStatement("DELETE FROM tb_department WHERE department_id = ?");
        preparedStatement.setString(1, id);
//        preparedStatement.setInt(1, region.getId());
        preparedStatement.execute();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }

public boolean insertUpdate(Department department) {
        try {
            boolean isInsert = getById(department.getId()) == null;
            System.out.println(isInsert ? "Insert Berhasil" : "Update Berhasil");
            String query = isInsert
                    ? "INSERT INTO tb_department(department_name, location_id, manager_id, department_id) VALUES(?,?,?,?)"
                    : "UPDATE tb_department SET department_name = ?, location_id = ?, department_id = ? "
                    + "WHERE department_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getLocation());
            preparedStatement.setString(3, department.getManager());
            preparedStatement.setString(4, department.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
