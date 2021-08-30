/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import daos.CountryDAO;
import java.util.Scanner;
import models.Country;
import tools.DBConnection;
import tools.MBKM_CRUD;

/**
 *
 * @author hp
 */
public class ViewCountry {
    DBConnection dbc = new DBConnection();
    Scanner inp = new Scanner(System.in);
    CountryDAO cdao = new CountryDAO(dbc.getConnection());
    MBKM_CRUD menuHR=new MBKM_CRUD();
    
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
                System.out.println("Apakah anda yakin ingin hapus? (ya/tidak) ");
                String opsi=inp.next();
                if(opsi.equalsIgnoreCase("ya")){
                    System.out.println(cdao.delete(idCountry) ? "Delete Berhasil" : "Delete Gagal"
                    );}
                    else{
                        System.out.println("data gagal dihapus");
                    }              
                break;
            case 6:
                System.out.println("Masukan data yang ingin diubah dalam format (Country_Id Country_Name Region_Id) : ");
                idCountry = inp.next();
                nameCountry = inp.next();
                idRegion = inp.nextInt();
                System.out.println(
                    cdao.insertUpdate(new Country(idCountry,nameCountry,idRegion))
                    ? "Update/Insert Berhasil" : "Update/Insert Gagal"
                );
                break;
            case 7:
                menuHR.menuUtama();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Maaf Nomor yang anda masukan salah");
                System.exit(0);
        }
        
    }
}
