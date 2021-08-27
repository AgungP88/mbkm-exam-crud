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
import daos.RegionDAO;
import daos.CountryDAO;
import models.Country;
import models.Region;
import daos.LocationDAO;
import models.Location;
import daos.DepartmentDAO;
import models.Department;

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

          System.out.println(dbc.getConnection());
        DepartmentDAO ddao = new DepartmentDAO(dbc.getConnection());
        
        for (Department department : ddao.getAll()) {
            System.out.println(department.getId() + " - "+ department.getName()+ " - " + 
                    department.getLocation()+" - "+ department.getManager());
        }
        
        Department department = ddao.getById("5101");
        System.out.println(department.getId() + " - "+ department.getName()+ " - " + 
                    department.getLocation()+" - "+ department.getManager());
        
//        System.out.println(
//                ddao.insert(new Department("5105","HR Manager","3101","123005"))
//                ? "Insert Berhasil" : "Insert Gagal"
//        );
        
        
//        System.out.println(
//                ddao.update(new Department("5105","HR manager","3101","123005"))
//                ? "Update Berhasil" : "Update Gagal"
//        );

//        System.out.println(
//              ddao.delete("5105") ? "Delete Berhasil" : "Delete Gagal"
//        );
    

        System.out.println(
              ddao.insertUpdate(new Department("5105","HR manager","3101","123005"))
              ? "Update/Delete Berhasil" : "Update/Delete Gagal"
        );
    }
    
       
}
        
 
}}
