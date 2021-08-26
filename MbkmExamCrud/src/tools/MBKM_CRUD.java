/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.JobDAO;
import models.Job;

/**
 *
 * @author hp
 */
public class MBKM_CRUD {
    public static void main(String[] args) {
        DBConnection dbc = new DBConnection();
       
        //test connection
        System.out.println(dbc.getConnection());
        
        JobDAO jdao = new JobDAO(dbc.getConnection());
        
        //test get all
        for (Job jobs : jdao.getAll()) {
            System.out.println(jobs.getId() + " - "+ jobs.getTitle()+" - "+jobs.getMinSalary()+" - "+jobs.getMaxSalary());
        }
    }
}
