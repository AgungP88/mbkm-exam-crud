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
        String nameRegion;
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
                System.out.println("Masukan data yang ingin diinput dalam format (Region_Id Region_Name) : ");
                idRegion = inp.nextInt();
                nameRegion = inp.next();
                System.out.println(
                    rdao.insert(new Region(idRegion,nameRegion))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 4:
                System.out.println("Masukan data yang ingin diubah dalam format (Region_Id Region_Name) : ");
                idRegion = inp.nextInt();
                nameRegion = inp.next();
                System.out.println(
                    rdao.update(new Region(idRegion,nameRegion))
                    ? "Update Berhasil" : "Update Gagal"
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
        String idCountry, nameCountry;
        int idRegion;
        switch (id) {
            case 1:
                for (Country countrys : cdao.getAll()) {
                    System.out.println(countrys.getId() + " - "+ countrys.getName()+" - "+countrys.getRegionId());
                }
                break;
            case 2:
                System.out.println("Masukan Id Country : ");
                idCountry = inp.next();
                Country countrys = cdao.getById(idCountry);
                System.out.println(countrys.getId() + " - "+ countrys.getName()+" - "+countrys.getRegionId());
                break;
            case 3:
                System.out.println("Masukan data yang ingin diinput dalam format (Country_Id Country_Name Region_Id) : ");
                idCountry = inp.next();
                nameCountry = inp.next();
                idRegion = inp.nextInt();
                System.out.println(
                    cdao.insert(new Country(idCountry,nameCountry,idRegion))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 4:
                System.out.println("Masukan data yang ingin diubah dalam format (Country_Id Country_Name Region_Id) : ");
                idCountry = inp.next();
                nameCountry = inp.next();
                idRegion = inp.nextInt();
                System.out.println(
                    cdao.update(new Country(idCountry,nameCountry,idRegion))
                    ? "Update Berhasil" : "Update Gagal"
                );
                break;
            case 5:
                System.out.println("Masukan Id Country: ");
                idCountry = inp.next();
                System.out.println(
                    cdao.delete(idCountry) ? "Delete Berhasil" : "Delete Gagal"
                );
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    
    public void crudLocation(int id){
        String idLocation, streetAddress, postalCode, city, stateProvince, idCountry;
        switch (id) {
            case 1:
                for (Location locations : ldao.getAll()) {
                    System.out.println(locations.getId() + " - "+ locations.getStreetAddres()+" - "+locations.getPostalCode()
                    +" - "+locations.getCity()+" - "+locations.getStateProvince()+" - "+locations.getCountryId());
                }
                break;
            case 2:
                System.out.println("Masukan Id Location : ");
                idLocation = inp.next();
                Location locations = ldao.getById(idLocation);
                System.out.println(locations.getId() + " - "+ locations.getStreetAddres()+" - "+locations.getPostalCode()
                    +" - "+locations.getCity()+" - "+locations.getStateProvince()+" - "+locations.getCountryId());
                break;
            case 3:
                System.out.println("Masukan data yang ingin diinput dalam format (Location_Id Street_Address Postal_Code "
                        + "City State_Province Country_Id) : ");
                idLocation = inp.next();
                streetAddress = inp.next();
                postalCode = inp.next();
                city = inp.next();
                stateProvince = inp.next();
                idCountry = inp.next();
                System.out.println(
                    ldao.insert(new Location(idLocation,streetAddress,postalCode, city, stateProvince, idCountry))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 4:
                System.out.println("Masukan data yang ingin diubah dalam format (Location_Id Street_Address Postal_Code "
                        + "City State_Province Country_Id) : ");
                idLocation = inp.next();
                streetAddress = inp.next();
                postalCode = inp.next();
                city = inp.next();
                stateProvince = inp.next();
                idCountry = inp.next();
                System.out.println(
                    ldao.update(new Location(idLocation,streetAddress,postalCode, city, stateProvince, idCountry))
                    ? "Update Berhasil" : "Update Gagal"
                );
                break;
            case 5:
                System.out.println("Masukan Id Location : ");
                idLocation = inp.next();
                System.out.println(
                    ldao.delete(idLocation) ? "Delete Berhasil" : "Delete Gagal"
                );
                break;
            default:
                throw new AssertionError();
        }
        
    }
}
