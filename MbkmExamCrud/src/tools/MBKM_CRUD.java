/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.PrintStream;
import views.Menu;
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
        
        Menu menu = new Menu();
//        menu.menuUtama();
//        menu.menuEmployee();
//        menu.menuCountry();
//        menu.menuDepartment();
//        menu.menuJob();
//        menu.menuLocation();
//        menu.menuRegion();
        JobDAO jdao = new JobDAO(dbc.getConnection());
        
        //test get all
        for (Job jobs : jdao.getAll()) {
            System.out.println(jobs.getId() + " - "+ jobs.getTitle()+" - "+jobs.getMinSalary()+" - "+jobs.getMaxSalary());
        }
        
        Job jobs = jdao.getById("1130001");
        System.out.println(jobs.getId() + " - "+ jobs.getTitle()+" - "+jobs.getMinSalary()+" - "+jobs.getMaxSalary());
        
//        System.out.println(
//                jdao.insert(new Job("1130007","general manager", 9000000, 15000000))
//                ? "Insert Berhasil" : "Insert Gagal"
//        );

//        System.out.println(
//                jdao.update(new Job("1130006","General Manager", 9000000, 15000000))
//                ? "Update Berhasil" : "Update Gagal"
//        );
//
//        System.out.println(
//              jdao.delete("1130007") ? "Delete Berhasil" : "Delete Gagal"
//        );
        

        System.out.println(
                jdao.insertUpdate(new Job("1130007", "Production", 4000000, 7000000))
                ? "Update/Delete Berhasil" : "Update/Delete Gagal"
          );
    }
}
