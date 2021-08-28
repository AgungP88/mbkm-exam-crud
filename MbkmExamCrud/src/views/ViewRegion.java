/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import daos.RegionDAO;
import java.util.Scanner;
import models.Region;
import tools.DBConnection;

/**
 *
 * @author hp
 */
public class ViewRegion {
    
    DBConnection dbc = new DBConnection();
    Scanner inp = new Scanner(System.in);
    RegionDAO rdao = new RegionDAO(dbc.getConnection());
    
    public void crudRegion(int id){
        int idReg;
        String nameReg;
        switch (id) {
            case 1:
                for (Region regions : rdao.getAll()) {
                    System.out.println(regions.getId() + " - "+ regions.getName());
                }
                break;
            case 2:
                System.out.println("Masukan Id Region : ");
                idReg = inp.nextInt();
                Region region = rdao.getById(idReg);
                System.out.println(region.getId() + " - "+ region.getName());
                break;
            case 3:
                System.out.println("Masukan data yang ingin diinput dalam format (Region_Id Region_Name) : ");
                idReg = inp.nextInt();
                nameReg = inp.next();
                System.out.println(rdao.insert(new Region(idReg,nameReg))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 4:
                System.out.println("Masukan data yang ingin diubah dalam format (Region_Id Region_Name) : ");
                idReg = inp.nextInt();
                nameReg = inp.next();
                System.out.println(rdao.update(new Region(idReg,nameReg))
                    ? "Update Berhasil" : "Update Gagal"
                );
                break;
            case 5:
                System.out.println("Masukan Id Region : ");
                idReg = inp.nextInt();
                System.out.println(rdao.delete(idReg) ? "Delete Berhasil" : "Delete Gagal"
                );
                break;
            case 6:
                System.out.println("Masukan data yang ingin diubah dalam format (Region_Id Region_Name) : ");
                idReg = inp.nextInt();
                nameReg = inp.next();
                System.out.println(rdao.insertUpdate(new Region(idReg, nameReg))
                    ? "Update/insert Berhasil" : "Update/insert Gagal"
                );
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
