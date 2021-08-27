/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.CountryDAO;
import models.Country;
import models.Region;

/**
 *
 * @author hp
 */
public class MBKM_CRUD {
    public static void main(String[] args) {
        DBConnection dbc = new DBConnection();
        
        //test connection
        System.out.println(dbc.getConnection());
        
     CountryDAO cdao=new CountryDAO(dbc.getConnection());
     
//     for(Country country:cdao.getAll()){
//         System.out.println(country.getId()+" - "+country.getName()+"- "+country.getRegion_id());
//     }
     
//        System.out.println(
//                cdao.insert(new Country("2105", "Kanada", 9))
//        ? "insert berhasil" :"insert gagal");
        
//        System.out.println(
//                cdao.update(new Country("2104", "Indonesiaaaaa"))
//        ? "update berhasil" :"update gagal");

//         cdao.delete("2105");
         
//         System.out.println(cdao.getById("2104"));

//           System.out.println(cdao.InsertOrUpdate(new Country("2107", "India"))
//                        ?"berhasil" : "gagal");
 


    }
}
