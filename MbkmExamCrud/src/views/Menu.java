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
        System.out.println("| Pilih Modul yang ingin anda gunakan (Pilih No 1 - 5) :   |");
    }
    
    
    public void crudRegion(int id){
        int idRegion;
        switch (id) {
            case 1:
                for (Region regions : rdao.getAll()) {
                    System.out.println(regions.getId() + " - "+ regions.getName());
                }
                break;
            case 2:
                System.out.println("Masukan Id Region : ");
                idRegion = inp.nextInt();
                Region region = rdao.getById(idRegion);
                System.out.println(region.getId() + " - "+ region.getName());
                break;
            case 3:
                System.out.println(
                    rdao.insert(new Region(11,"Jauh Pake Helm 8"))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 4:
                System.out.println("Masukan Id Region : ");
                idRegion = inp.nextInt();
                System.out.println(
                    rdao.update(new Region(idRegion,"Jauh Pake Helm 8"))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 5:
                System.out.println("Masukan Id Region : ");
                idRegion = inp.nextInt();
                System.out.println(
                    rdao.delete(idRegion) ? "Delete Berhasil" : "Delete Gagal"
                );
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    public void crudCountry(int id){
        String idCountry;
        switch (id) {
            case 1:
                for (Country countrys : cdao.getAll()) {
                    System.out.println(countrys.getId() + " - "+ countrys.getName()+" - "+countrys.getRegionId());
                }
                break;
            case 2:
                System.out.println("Masukan Id Region : ");
                idCountry = inp.next();
                Country countrys = cdao.getById(idCountry);
                System.out.println(countrys.getId() + " - "+ countrys.getName()+" - "+countrys.getRegionId());
                break;
            case 3:
                System.out.println(
                    cdao.insert(new Country("2105","Vietnam", 1))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 4:
                System.out.println("Masukan Id Region : ");
                idCountry = inp.next();
                System.out.println(
                    cdao.update(new Country(idCountry,"Vietnam", 1))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 5:
                System.out.println("Masukan Id Region : ");
                idCountry = inp.next();
                System.out.println(
                    cdao.delete(idCountry) ? "Delete Berhasil" : "Delete Gagal"
                );
                break;
            default:
                throw new AssertionError();
        }
        
    }
}
