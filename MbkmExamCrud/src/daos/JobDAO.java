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
     * @getAll Method untuk Get(mengambil semua data)
     * 
     * @return 
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
     * 
     * @param id
     * @return 
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
     * 
     * @param jobs
     * @return 
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
     * 
     * @param jobs
     * @return 
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
     * 
     * @param id
     * @return 
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
     * 
     * @param job
     * @return 
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