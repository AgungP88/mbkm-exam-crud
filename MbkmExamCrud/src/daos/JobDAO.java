/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
}
