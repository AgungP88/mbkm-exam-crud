/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import daos.LocationDAO;
import java.util.Scanner;
import models.Location;
import tools.DBConnection;

/**
 *
 * @author hp
 */
public class ViewLocation {
    DBConnection dbc = new DBConnection();
    Scanner inp = new Scanner(System.in);
    LocationDAO ldao = new LocationDAO(dbc.getConnection());
    
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
            case 6:
                System.out.println("Masukan data yang ingin diubah dalam format (Location_Id Street_Address Postal_Code "
                        + "City State_Province Country_Id) : ");
                idLocation = inp.next();
                streetAddress = inp.next();
                postalCode = inp.next();
                city = inp.next();
                stateProvince = inp.next();
                idCountry = inp.next();
                System.out.println(
                    ldao.InsertOrUpdate(new Location(idLocation,streetAddress,postalCode, city, stateProvince, idCountry))
                    ? "Update/Insert Berhasil" : "Update/Insert Gagal"
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
