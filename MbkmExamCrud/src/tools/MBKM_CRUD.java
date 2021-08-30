/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.PrintStream;
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
    
    public void mainMenu(){
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|              SELAMAT DATANG DI MENU UTAMA                |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println("| Daftar Modul yang Bisa Anda Gunakan :                    |");
        System.out.println("| 1. Employee                                              |");
        System.out.println("| 2. Job                                                   |");
        System.out.println("| 3. Department                                            |");
        System.out.println("| 4. Location                                              |");
        System.out.println("| 5. Country                                               |");
        System.out.println("| 6. Regions                                               |");
        System.out.println("| 0. Exit                                                  |");
        System.out.println("| Pilih Modul yang ingin anda gunakan (Pilih No 1 - 6) :   |");
    }
    
    
    public void menuCabang(){      
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|             SELAMAT DATANG DI SUB MENU                   |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println("| Daftar Modul yang Bisa Anda Gunakan :                    |");
        System.out.println("| 1. Lihat Semua Data                                      |");
        System.out.println("| 2. Lihat Data berdasarkan Id Data                        |");
        System.out.println("| 3. Tambah Data                                           |");
        System.out.println("| 4. Ubah data berdasarkan Id data                         |");
        System.out.println("| 5. Hapus data berdasarkan Id data                        |");
        System.out.println("| 6. Tambah/Ubah data (Menggunakan 1 Method)               |");
        System.out.println("| 7. Kembali ke menu utama                                 |");
        System.out.println("| 0. Exit                                                  |");
        System.out.println("| Pilih Modul yang ingin anda gunakan (Pilih No 1 - 5) :   |");
    }
    
    public void menuUtama(){
                DBConnection dbc = new DBConnection();
       
        //test connection
        System.out.println(dbc.getConnection()); 
        Scanner inp = new Scanner(System.in);
        
        ViewCountry viewCountry = new ViewCountry();
        ViewDepartment viewDepartment = new ViewDepartment();
        ViewEmployee viewEmployee = new ViewEmployee();
        ViewJob viewJob = new ViewJob();
        ViewLocation viewLocation = new ViewLocation();
        ViewRegion viewRegion = new ViewRegion();
        
        int menuAwal;
        int menuReg;
        mainMenu();
        menuAwal = inp.nextInt();
        menuCabang();
        menuReg = inp.nextInt();
        
        switch (menuAwal) {
            case 1:
                viewEmployee.crudEmployee(menuReg);
                menuUtama();
                break;
            case 2:
                viewJob.crudJob(menuReg);
                menuUtama();
                break;
            case 3:
                viewDepartment.crudDepartment(menuReg);
                menuUtama();
                break;
            case 4:
                viewLocation.crudLocation(menuReg);
                menuUtama();
                break;
            case 5:
                viewCountry.crudCountry(menuReg);
                menuUtama();
                break;
            case 6:
                viewRegion.crudRegion(menuReg); 
                menuUtama();
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
    
