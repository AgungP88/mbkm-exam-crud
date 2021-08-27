/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.EmployeeDAO;
import models.Employee;

/**
 *
 * @author hp
 */
public class MBKM_CRUD {
    public static void main(String[] args) {
        DBConnection dbc = new DBConnection();
        
        //test connection
        System.out.println(dbc.getConnection());
        
        EmployeeDAO edao = new EmployeeDAO(dbc.getConnection());
        
        //test get all
        for (Employee employees : edao.getAll()) {
            System.out.println(employees.getId() + " - "+ employees.getFirstName()+" - "+employees.getLastName()+" - "+
                    employees.getEmail()+" - "+employees.getPhoneNumber()+" - "+employees.getHireDate()+" - "+
                    employees.getSalary()+" - "+employees.getCommission()+" - "+employees.getJob()+ " - "+
                    employees.getManager()+" - "+employees.getDepartment());
        }
        
        Employee employees = edao.getById("123005");
        System.out.println(employees.getId() + " - "+ employees.getFirstName()+" - "+employees.getLastName()+" - "+
                    employees.getEmail()+" - "+employees.getPhoneNumber()+" - "+employees.getHireDate()+" - "+
                    employees.getSalary()+" - "+employees.getCommission()+" - "+employees.getJob()+ " - "+
                    employees.getManager()+" - "+employees.getDepartment());
        
//        System.out.println(
//                edao.insert(new Employee("123031","asep","subagia","asep@mail.com","08987654321","1999-07-07", 
//                        10000000, (float) 3.2,"1130005","123005","5102"))
//                ? "Insert Berhasil" : "Insert Gagal"
//        );

//        System.out.println(
//                edao.update(new Employee("123031","Asep","Subagia","asep@mail.com","08987654321","1999-07-07", 
//                        10000000, (float) 3.2,"1130005","123005","5102"))
//                ? "Update Berhasil" : "Update Gagal"
//        );

//        System.out.println(
//              edao.delete("123031") ? "Delete Berhasil" : "Delete Gagal"
//        );

//        System.out.println(
//              edao.insertUpdate(new Employee(10, "Jauh bawa stnk 5"))
//              ? "Update Berhasil" : "Update Gagal"
//        );
        System.out.println(
                edao.insertUpdate(new Employee("123031","Asep","Subagia","asep@mail.com","08987654321","1999-07-07", 
                        10000000, (float) 3.2,"1130005","123005","5102"))
                ? "Update/Delete Berhasil" : "Update/Delete Gagal"
          );
    }
}
