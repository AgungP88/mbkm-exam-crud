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
    
    /**
     * Method yang berfungsi untuk mengambil semua data yang ada pada database
     * @return method ini mengembalikan sebuah data dalam bentuk arrayList. sehingga untuk pemanggilan dilakukan perulangan
     */
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
    /**
     * Method ini adalah method yang berfungsi untuk mengambil sebuah data berdasarkan parameter yang diinputkan
     * @param id untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diambil
     * @return method ini mengembalikan sebuah data dalam bentuk object
     */
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
    
    /**
     * Method ini berfungsi untuk menginputkan atau menambahkan data kedalam database berdasarkan nilai 
     yang kita isi pada parameter method
     * @param employee parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database
     * @return nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
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

/**
 * Method ini berfungsi untuk mengubah data yang ada didalam database berdasarkan nilai yang kita isi pada parameter method
 * @param employee parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database. parameter pertama
 * adalah Id yang merupakan parameter rujukan untuk pengecekan apakah data tersebut ada didalam database atau tidak
 * @return nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
 * dan false apabila data gagal dimasukkan
 */
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

/**
 * Method ini berfungsi untuk menghapus data berdasarkan parameter yang diinputkan
 * @param id untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin dihapus
 * @return method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil di hapus
 * dan bernilai false apa bila data gagal dihapus
 */
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


/**
 * Method ini berfungsi untuk memasukan data kedalam database atau mengubah data yang sudah ada didalam database, method ini 
 * akan melakukan pengecekan berdasarkan parameter yang diinputkan, apabila data belum ada maka method akan melakukan insert
 * namun apabila method sudah ada maka akan dilakukan update
 * @param employee untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diinsert / diupdate
 * @return method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil diinput/update
 * dan bernilai false apa bila data gagal diinput/update
 */
    public boolean insertUpdate(Employee employee) {
            try {
                boolean isInsert = getById(employee.getId()) == null;
                System.out.println(isInsert ? "Insert Berhasil" : "Update Berhasil");
                String query = isInsert
                        ? "INSERT INTO tb_employee(first_name, last_name, email, phone_number, "
                            + "hire_date, salary, comission_pct, job_id, manager_id, department_id, employee_id) VALUES("
                            + "?,?,?,?,?,?,?,?,?,?,?)"
                        : "UPDATE tb_employee SET first_name = ?, last_name = ?, email = ?, "
                            + "phone_number = ?, hire_date = ?, salary = ?, comission_pct = ?, job_id = ?, manager_id = ?,"
                            + "department_id = ? WHERE employee_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
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
                preparedStatement.setString(11, employee.getId());
                preparedStatement.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
}
