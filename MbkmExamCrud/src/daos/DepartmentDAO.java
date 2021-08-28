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
    
    
    /**
     * Method yang berfungsi untuk mengambil semua data yang ada pada database
     * @return method ini mengembalikan sebuah data dalam bentuk arrayList. sehingga untuk pemanggilan dilakukan perulangan
     */
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
  
    
    /**
     * Method ini adalah method yang berfungsi untuk mengambil sebuah data berdasarkan parameter yang diinputkan
     * @param id untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diambil
     * @return method ini mengembalikan sebuah data dalam bentuk object
     */
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
    
    
    /**
     * Method ini berfungsi untuk menginputkan atau menambahkan data kedalam database berdasarkan nilai 
     yang kita isi pada parameter method
     * @param department parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database
     * @return nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
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


    /**
     * Method ini berfungsi untuk mengubah data yang ada didalam database berdasarkan nilai yang kita isi pada parameter method
     * @param department parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database. parameter pertama
     * adalah Id yang merupakan parameter rujukan untuk pengecekan apakah data tersebut ada didalam database atau tidak
     * @return nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
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


/**
 * Method ini berfungsi untuk menghapus data berdasarkan parameter yang diinputkan
 * @param id untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin dihapus
 * @return method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil di hapus
 * dan bernilai false apa bila data gagal dihapus
 */
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


/**
 * Method ini berfungsi untuk memasukan data kedalam database atau mengubah data yang sudah ada didalam database, method ini 
 * akan melakukan pengecekan berdasarkan parameter yang diinputkan, apabila data belum ada maka method akan melakukan insert
 * namun apabila method sudah ada maka akan dilakukan update
 * @param department untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diinsert / diupdate
 * @return method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil diinput/update
 * dan bernilai false apa bila data gagal diinput/update
 */
public boolean insertUpdate(Department department) {
        try {
            boolean isInsert = getById(department.getId()) == null;
            System.out.println(isInsert ? "Insert Berhasil" : "Update Berhasil");
            String query = isInsert
                    ? "INSERT INTO tb_department(department_name, location_id, manager_id, department_id) VALUES(?,?,?,?)"
                    : "UPDATE tb_department SET department_name = ?, location_id = ?, manager_id = ? "
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

}
