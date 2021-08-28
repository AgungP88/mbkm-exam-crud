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
        Scanner inp = new Scanner(System.in);
        
        Menu menu = new Menu();
        
        int menuAwal;
        int menuReg;
        menu.menuUtama();
        menuAwal = inp.nextInt();
        
        switch (menuAwal) {
            case 1:
                menu.menuCabang();
                menuReg = inp.nextInt();
                menu.crudEmployee(menuReg);
                break;
            case 2:
                menu.menuCabang();
                menuReg = inp.nextInt();
                menu.crudJob(menuReg);
                break;
            case 3:
                menu.menuCabang();
                menuReg=inp.nextInt();
                menu.crudDepartment(menuReg);
                break;
            case 4:
                menu.menuCabang();
                menuReg = inp.nextInt();
                menu.crudLocation(menuReg);
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
            case 0:
                System.exit(0);
            default:
                System.out.println("Maaf Nomor yang anda masukan salah");
                System.exit(0);
        }
//       
    }
    
       
}
        

