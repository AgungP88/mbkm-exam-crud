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
import views.ViewCountry;
import views.ViewDepartment;
import views.ViewEmployee;
import views.ViewJob;
import views.ViewLocation;
import views.ViewRegion;

/**
 *
 * @author hp
 */
public class MBKM_CRUD {
    public static void main(String[] args) {
        MBKM_CRUD menuHR=new MBKM_CRUD();
        menuHR.menuUtama();
    }
    public void menuUtama(){
                DBConnection dbc = new DBConnection();
       
        //test connection
        System.out.println(dbc.getConnection()); 
        Scanner inp = new Scanner(System.in);
        
        Menu menu = new Menu();
        ViewCountry viewCountry = new ViewCountry();
        ViewDepartment viewDepartment = new ViewDepartment();
        ViewEmployee viewEmployee = new ViewEmployee();
        ViewJob viewJob = new ViewJob();
        ViewLocation viewLocation = new ViewLocation();
        ViewRegion viewRegion = new ViewRegion();
        
        int menuAwal;
        int menuReg;
        menu.menuUtama();
        menuAwal = inp.nextInt();
        
        switch (menuAwal) {
            case 1:
                menu.menuCabang();
                menuReg = inp.nextInt();
                viewEmployee.crudEmployee(menuReg);
                menuUtama();
                break;
            case 2:
                menu.menuCabang();
                menuReg = inp.nextInt();
                viewJob.crudJob(menuReg);
                menuUtama();
                break;
            case 3:
                menu.menuCabang();
                menuReg=inp.nextInt();
                viewDepartment.crudDepartment(menuReg);
                menuUtama();
                break;
            case 4:
                menu.menuCabang();
                menuReg = inp.nextInt();
                viewLocation.crudLocation(menuReg);
                menuUtama();
                break;
            case 5:
                menu.menuCabang();
                menuReg = inp.nextInt();
                viewCountry.crudCountry(menuReg);
                menuUtama();
                break;
            case 6:
                menu.menuCabang();
                menuReg = inp.nextInt();
                viewRegion.crudRegion(menuReg);
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Maaf Nomor yang anda masukan salah");
                System.exit(0);
        }
//       
    }
    }
    
