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
import models.Employee;


/**
 *
 * @author hp
 */
public class EmployeeDAO {
    private Connection connection;
    
    public EmployeeDAO(Connection connection){
        this.connection = connection;
    }
    
    public List<Employee> getAll(){
        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("SELECT * FROM tb_employee").executeQuery();
            while (resultSet.next()) {
                //style1
                employees.add(new Employee(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7),
                resultSet.getFloat(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    
}
  
    
//cara baru
    public Employee getById(String id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM tb_employee WHERE employee_id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7),
                resultSet.getFloat(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
    
    
public boolean insert(Employee employee){
    try {
        //Parameterized query
        PreparedStatement preparedStatement = 
                connection.prepareStatement("INSERT INTO tb_employee(employee_id, first_name, last_name, email, phone_number, "
                        + "hire_date, salary, comission_pct, job_id, manager_id, department_id) VALUES("
                        + "?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, employee.getId());
        preparedStatement.setString(2, employee.getFirstName());
        preparedStatement.setString(3, employee.getLastName());
        preparedStatement.setString(4, employee.getEmail());
        preparedStatement.setString(5, employee.getPhoneNumber());
        preparedStatement.setString(6, employee.getHireDate());
        preparedStatement.setInt(7, employee.getSalary());
        preparedStatement.setFloat(8, employee.getCommission());
        preparedStatement.setString(9, employee.getJob());
        preparedStatement.setString(10, employee.getManager());
        preparedStatement.setString(11, employee.getDepartment());
        preparedStatement.execute();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }


public boolean update(Employee employee){
    try {
        PreparedStatement preparedStatement = 
                connection.prepareStatement("UPDATE tb_employee SET first_name = ?, last_name = ?, email = ?, "
                        + "phone_number = ?, hire_date = ?, salary = ?, comission_pct = ?, job_id = ?, manager_id = ?,"
                        + "department_id = ? WHERE employee_id = ?");
        preparedStatement.setString(11, employee.getId());
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getEmail());
        preparedStatement.setString(4, employee.getPhoneNumber());
        preparedStatement.setString(5, employee.getHireDate());
        preparedStatement.setInt(6, employee.getSalary());
        preparedStatement.setFloat(7, employee.getCommission());
        preparedStatement.setString(8, employee.getJob());
        preparedStatement.setString(9, employee.getManager());
        preparedStatement.setString(10, employee.getDepartment());
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
                connection.prepareStatement("DELETE FROM tb_employee WHERE employee_id = ?");
        preparedStatement.setString(1, id);
//        preparedStatement.setInt(1, region.getId());
        preparedStatement.execute();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }
}
