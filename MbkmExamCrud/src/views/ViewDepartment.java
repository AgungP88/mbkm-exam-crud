/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import daos.DepartmentDAO;
import java.util.Scanner;
import models.Department;
import tools.DBConnection;
import tools.MBKM_CRUD;

/**
 *
 * @author hp
 */
public class ViewDepartment {
    
    DBConnection dbc = new DBConnection();
    Scanner inp = new Scanner(System.in);
    DepartmentDAO ddao = new DepartmentDAO(dbc.getConnection());
    MBKM_CRUD menuHR=new MBKM_CRUD();
    
        public void crudDepartment(int id){
        String idDepartment, nameDepartment, idLocation, idManager;

        switch (id) {
            case 1:
                for (Department departments : ddao.getAll()) {
                    System.out.println(departments.getId() + " - "+ departments.getName()+" - "+departments.getLocation()
                    +" - "+departments.getManager());
                }
                break;
            case 2:
                System.out.println("Masukan Id Department : ");
                idDepartment = inp.next();
                Department departments = ddao.getById(idDepartment);
                System.out.println(departments.getId() + " - "+ departments.getName()+" - "+departments.getLocation()
                    +" - "+departments.getManager());
                break;
            case 3:              
                System.out.println("Masukan data yang ingin diinput dalam format (Department_Id Department_Name "
                        + "Location_id Manager_Id): ");

                idDepartment = inp.next();
                nameDepartment = inp.next();
                idLocation = inp.next();
                idManager = inp.next();
                System.out.println(                 
                    ddao.insert(new Department(idDepartment,nameDepartment,idLocation,idManager))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 4:
                System.out.println("Masukan data yang ingin diubah dalam format (Department_Id Department_Name Location_Id "
                        + "Manager_Id ) : ");
                idDepartment = inp.next();
                nameDepartment = inp.next();
                idLocation = inp.next();
                idManager = inp.next();
                System.out.println(                
                    ddao.update(new Department(idDepartment,nameDepartment,idLocation,idManager))
                    ? "Update Berhasil" : "Update Gagal"
                );
                break;
            case 5:
                System.out.println("Masukan Id Department : ");
                idDepartment = inp.next();
                System.out.println("Apakah anda yakin ingin hapus? (ya/tidak) ");
                String opsi=inp.next();
                if(opsi.equalsIgnoreCase("ya")){
                    System.out.println(ddao.delete(idDepartment) ? "Delete Berhasil" : "Delete Gagal"
                    );}
                    else{
                        System.out.println("data gagal dihapus");
                    }                            
                break;
            case 6:
                System.out.println("Masukan data yang ingin diubah dalam format (Department_Id Department_Name Location_Id "
                        + "Manager_Id ) : ");
                idDepartment = inp.next();
                nameDepartment = inp.next();
                idLocation = inp.next();
                idManager = inp.next();
                System.out.println(                
                    ddao.insertUpdate(new Department(idDepartment,nameDepartment,idLocation,idManager))
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
