/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import daos.CountryDAO;
import daos.DepartmentDAO;
import daos.EmployeeDAO;
import daos.JobDAO;
import daos.LocationDAO;
import daos.RegionDAO;
import java.util.Scanner;
import models.Country;
import models.Department;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;
import tools.DBConnection;



/**
 *
 * @author hp
 */
public class Menu {
        DBConnection dbc = new DBConnection();
        Scanner inp = new Scanner(System.in);
        //test connection
//        System.out.println(dbc.getConnection()); 
        DepartmentDAO ddao = new DepartmentDAO(dbc.getConnection());
        JobDAO jdao = new JobDAO(dbc.getConnection());
        EmployeeDAO edao = new EmployeeDAO(dbc.getConnection());
        RegionDAO rdao = new RegionDAO(dbc.getConnection());
        CountryDAO cdao = new CountryDAO(dbc.getConnection());
        LocationDAO ldao = new LocationDAO(dbc.getConnection());
        
        
    public void menuUtama(){
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
        System.out.println("| 0. Exit                                                  |");
        System.out.println("| Pilih Modul yang ingin anda gunakan (Pilih No 1 - 5) :   |");
    }
    
}
