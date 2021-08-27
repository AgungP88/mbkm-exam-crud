/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

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
    
    }
    
       
}
