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
import models.Job;


/**
 *
 * @author hp
 */
public class JobDAO {
    private Connection connection;
    
    public JobDAO(Connection connection){
        this.connection = connection;
    }
    
    
    /**
     * Method yang berfungsi untuk mengambil semua data yang ada pada database
     * @return method ini mengembalikan sebuah data dalam bentuk arrayList. sehingga untuk pemanggilan dilakukan perulangan
     */
    public List<Job> getAll(){
        List<Job> jobs = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("SELECT * FROM tb_job").executeQuery();
            while (resultSet.next()) {
                //style1
                jobs.add(new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    
    }
    
    /**
     * Method ini adalah method yang berfungsi untuk mengambil sebuah data berdasarkan parameter yang diinputkan
     * @param id id untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diambil
     * @return method ini mengembalikan sebuah data dalam bentuk object
     */
    
    public Job getById(String id) {
        Job jobs = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tb_job WHERE job_id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jobs = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }
    
    /**
     * Method ini berfungsi untuk menginputkan atau menambahkan data kedalam database berdasarkan nilai 
     * @param jobs parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database
     * @return nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
    public boolean insert(Job jobs){
    try {
        //Parameterized query
        PreparedStatement preparedStatement = 
                connection.prepareStatement("INSERT INTO tb_job(job_id, job_title, min_salary, max_salary) VALUES(?,?,?,?)");
        preparedStatement.setString(1, jobs.getId());
        preparedStatement.setString(2, jobs.getTitle());
        preparedStatement.setInt(3, jobs.getMinSalary());
        preparedStatement.setInt(4, jobs.getMaxSalary());
        preparedStatement.execute();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }

    /**
     * Method ini berfungsi untuk mengubah data yang ada didalam database berdasarkan nilai yang kita isi pada parameter method
     * @param jobs parameter ini adalah nilai-nllai yang kita ingin masukan kedalam database. parameter pertama
     * adalah Id yang merupakan parameter rujukan untuk pengecekan apakah data tersebut ada didalam database atau tidak
     * @return nilai yang dikembalikan oleh method ini berupa boolean, yaitu true apabila data berhasil dimasukan
     * dan false apabila data gagal dimasukkan
     */
    public boolean update(Job jobs){
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE tb_job SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?");
            preparedStatement.setString(1, jobs.getTitle());
            preparedStatement.setInt(2, jobs.getMinSalary());
            preparedStatement.setInt(3, jobs.getMaxSalary());
            preparedStatement.setString(4, jobs.getId());
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
                    connection.prepareStatement("DELETE FROM tb_job WHERE job_id = ?");
            preparedStatement.setString(1, id);
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
     * @param job untuk mengambil menentukan id mana yang menjadi parameter sebuah data yang ingin diinsert / diupdate
     * @return method ini mengembalikan nilai berupa boolean. yaitu bernilai true apa bila data berhasil diinput/update
     * dan bernilai false apa bila data gagal diinput/update
     */
    public boolean insertUpdate(Job job) {
            try {
                boolean isInsert = getById(job.getId()) == null;
                System.out.println(isInsert ? "Insert Berhasil" : "Update Berhasil");
                String query = isInsert
                        ? "INSERT INTO tb_job(job_title, min_salary, max_salary, job_id) VALUES(?,?,?,?)"
                        : "UPDATE tb_job SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, job.getTitle());
                preparedStatement.setInt(2, job.getMinSalary());
                preparedStatement.setInt(3, job.getMaxSalary());
                preparedStatement.setString(4, job.getId());
                preparedStatement.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
}
