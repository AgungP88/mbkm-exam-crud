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
import daos.EmployeeDAO;
import java.util.List;
import java.util.Scanner;
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
        DepartmentDAO ddao = new DepartmentDAO(dbc.getConnection());
        JobDAO jdao = new JobDAO(dbc.getConnection());
        EmployeeDAO edao = new EmployeeDAO(dbc.getConnection());
        RegionDAO rdao = new RegionDAO(dbc.getConnection());
        CountryDAO cdao = new CountryDAO(dbc.getConnection());
        LocationDAO ldao = new LocationDAO(dbc.getConnection());
        Scanner inp = new Scanner(System.in);
        
        Menu menu = new Menu();
        
        int menuAwal;
        int menuReg;
        menu.menuUtama();
        menuAwal = inp.nextInt();
        
        switch (menuAwal) {
            case 1:
                menu.menuCabang();
                break;
            case 2:
                menu.menuCabang();
                break;
            case 3:
                menu.menuCabang();
                break;
            case 4:
                menu.menuCabang();
                break;
            case 5:
                menu.menuCabang();
                menuReg = inp.nextInt();
                menu.crudCountry(menuReg);
                break;
            case 6:
                menu.menuCabang();
                menuReg = inp.nextInt();
                menu.crudRegion(menuReg);
                break;
            default:
                throw new AssertionError();
        }
//        menu.menuUtama();
//        menu.menuEmployee();
//        menu.menuCountry();
//        menu.menuDepartment();
//        menu.menuJob();
//        menu.menuLocation();
//        menu.menuRegion();
        
        
        //test get all
//        for (Job jobs : jdao.getAll()) {
//            System.out.println(jobs.getId() + " - "+ jobs.getTitle()+" - "+jobs.getMinSalary()+" - "+jobs.getMaxSalary());
//        }
//        
//        Job jobs = jdao.getById("1130001");
//        System.out.println(jobs.getId() + " - "+ jobs.getTitle()+" - "+jobs.getMinSalary()+" - "+jobs.getMaxSalary());
        
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
        

//        System.out.println(
//                jdao.insertUpdate(new Job("1130007", "Production", 4000000, 7000000))
//                ? "Update/Delete Berhasil" : "Update/Delete Gagal"
//          );
//
//          System.out.println(dbc.getConnection());
//        
//        
//        for (Department department : ddao.getAll()) {
//            System.out.println(department.getId() + " - "+ department.getName()+ " - " + 
//                    department.getLocation()+" - "+ department.getManager());
//        }
//        
//        Department department = ddao.getById("5101");
//        System.out.println(department.getId() + " - "+ department.getName()+ " - " + 
//                    department.getLocation()+" - "+ department.getManager());
        
//        System.out.println(
//                ddao.insert(new Department("5105","HR Manager","3101","123005"))
//                ? "Insert Berhasil" : "Insert Gagal"
//        );
        
        
//        System.out.println(
//                ddao.update(new Department("5105","HR manager","3101","123005"))
        
        
        //test get all
//        for (Employee employees : edao.getAll()) {
//            System.out.println(employees.getId() + " - "+ employees.getFirstName()+" - "+employees.getLastName()+" - "+
//                    employees.getEmail()+" - "+employees.getPhoneNumber()+" - "+employees.getHireDate()+" - "+
//                    employees.getSalary()+" - "+employees.getCommission()+" - "+employees.getJob()+ " - "+
//                    employees.getManager()+" - "+employees.getDepartment());
//        }
//        
//        Employee employees = edao.getById("123005");
//        System.out.println(employees.getId() + " - "+ employees.getFirstName()+" - "+employees.getLastName()+" - "+
//                    employees.getEmail()+" - "+employees.getPhoneNumber()+" - "+employees.getHireDate()+" - "+
//                    employees.getSalary()+" - "+employees.getCommission()+" - "+employees.getJob()+ " - "+
//                    employees.getManager()+" - "+employees.getDepartment());
        
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
//              ddao.delete("5105") ? "Delete Berhasil" : "Delete Gagal"
//        );
    

//        System.out.println(
//              ddao.insertUpdate(new Department("5105","HR manager","3101","123005"))
//              ? "Update/Delete Berhasil" : "Update/Delete Gagal"
//        );
//              edao.delete("123031") ? "Delete Berhasil" : "Delete Gagal"
//        );

//        System.out.println(
//              edao.insertUpdate(new Employee(10, "Jauh bawa stnk 5"))
//              ? "Update Berhasil" : "Update Gagal"
//        );
//        System.out.println(
//                edao.insertUpdate(new Employee("123031","Asep","Subagia","asep@mail.com","08987654321","1999-07-07", 
//                        10000000, (float) 3.2,"1130005","123005","5102"))
//                ? "Update/Delete Berhasil" : "Update/Delete Gagal"
//          );
    }
    
       
}
        

