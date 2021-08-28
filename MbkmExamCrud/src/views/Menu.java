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
            case 6:
                System.out.println("Masukan data yang ingin diubah dalam format (Region_Id Region_Name) : ");
                idRegion = inp.nextInt();
                nameRegion = inp.next();
                System.out.println(
                    rdao.InsertOrUpdate(new Region(idRegion,nameRegion))
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
            case 6:
                System.out.println("Masukan data yang ingin diubah dalam format (Country_Id Country_Name Region_Id) : ");
                idCountry = inp.next();
                nameCountry = inp.next();
                idRegion = inp.nextInt();
                System.out.println(
                    cdao.InsertOrUpdate(new Country(idCountry,nameCountry,idRegion))
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
    
    
    public void crudJob(int id){
        String idJob, jobTitle;
        int minSalary, maxSalary;
        switch (id) {
            case 1:
                for (Job jobs : jdao.getAll()) {
                    System.out.println(jobs.getId() + " - "+ jobs.getTitle()+" - "+jobs.getMinSalary()
                    +" - "+jobs.getMaxSalary());
                }
                break;
            case 2:
                System.out.println("Masukan Id Job : ");
                idJob = inp.next();
                Job jobs = jdao.getById(idJob);
                System.out.println(jobs.getId() + " - "+ jobs.getTitle()+" - "+jobs.getMinSalary()
                    +" - "+jobs.getMaxSalary());
                break;
            case 3:
                System.out.println("Masukan data yang ingin diinput dalam format (Job_Id Job_Title Min_Salary max_salary): ");
                idJob = inp.next();
                jobTitle = inp.next();
                minSalary = inp.nextInt();
                maxSalary = inp.nextInt();
                System.out.println(
                    jdao.insert(new Job(idJob,jobTitle,minSalary,maxSalary))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 4:
                System.out.println("Masukan data yang ingin diinput dalam format (Job_Id Job_Title Min_Salary max_salary): ");
                idJob = inp.next();
                jobTitle = inp.next();
                minSalary = inp.nextInt();
                maxSalary = inp.nextInt();
                System.out.println(
                    jdao.update(new Job(idJob,jobTitle,minSalary,maxSalary))
                    ? "Update Berhasil" : "Update Gagal"
                );
                break;
            case 5:
                System.out.println("Masukan Id Job : ");
                idJob = inp.next();
                System.out.println(
                    jdao.delete(idJob) ? "Delete Berhasil" : "Delete Gagal"
                );
                break;
            case 6:
                System.out.println("Masukan data yang ingin diinput dalam format (Job_Id Job_Title Min_Salary max_salary): ");
                idJob = inp.next();
                jobTitle = inp.next();
                minSalary = inp.nextInt();
                maxSalary = inp.nextInt();
                System.out.println(
                    jdao.insertUpdate(new Job(idJob,jobTitle,minSalary,maxSalary))
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
                System.out.println(
                    ddao.delete(idDepartment) ? "Delete Berhasil" : "Delete Gagal"
                );
                break;
            case 6:
                System.out.println("Masukan data yang ingin diubah dalam format (Department_Id Department_Name Location_Id "
                        + "Manager_Id ) : ");
                idDepartment = inp.next();
                nameDepartment = inp.next();
                idLocation = inp.next();
                idManager = inp.next();
                System.out.println(                
                    ddao.InsertOrUpdate(new Department(idDepartment,nameDepartment,idLocation,idManager))
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
       
    public void crudEmployee(int id){
        String idEmployee, firstName, lastName, email, phoneNumber, hireDate, idJob, idManager, idDepartment;
        int salary;
        float comissionPct;
        switch (id) {
            case 1:
                for (Employee employees : edao.getAll()) {
                System.out.println(employees.getId() + " - "+ employees.getFirstName()+" - "+employees.getLastName()+" - "+
                    employees.getEmail()+" - "+employees.getPhoneNumber()+" - "+employees.getHireDate()+" - "+
                    employees.getSalary()+" - "+employees.getCommission()+" - "+employees.getJob()+ " - "+
                    employees.getManager()+" - "+employees.getDepartment());
                }
                break;
            case 2:
                System.out.println("Masukan Id Employee : ");
                idEmployee = inp.next();
                Employee employees = edao.getById(idEmployee);
                System.out.println(employees.getId() + " - "+ employees.getFirstName()+" - "+employees.getLastName()+" - "+
                    employees.getEmail()+" - "+employees.getPhoneNumber()+" - "+employees.getHireDate()+" - "+
                    employees.getSalary()+" - "+employees.getCommission()+" - "+employees.getJob()+ " - "+
                    employees.getManager()+" - "+employees.getDepartment());
                break;
            case 3:
                System.out.println("Masukan data yang ingin diinput dalam format (Employee_Id First_Name Last_Name Email "
                        + "Phone_Number Hire_date Salary Comission_Pct Job_Id Manager_Id Department_Id) : ");
                idEmployee = inp.next();
                firstName = inp.next();
                lastName = inp.next();
                email = inp.next();
                phoneNumber = inp.next();
                hireDate = inp.next();
                salary = inp.nextInt();
                comissionPct = inp.nextFloat();
                idJob = inp.next();
                idManager = inp.next();
                idDepartment = inp.next();
                System.out.println(
                    edao.insert(new Employee(idEmployee,firstName,lastName,email,phoneNumber, hireDate, salary,
                    comissionPct, idJob, idManager, idDepartment))
                    ? "Insert Berhasil" : "Insert Gagal"
                );
                break;
            case 4:
                System.out.println("Masukan data yang ingin diinput dalam format (Employee_Id First_Name Last_Name Email "
                        + "Phone_Number Hire_date Salary Comission_Pct Job_Id Manager_Id Department_Id) : ");
                idEmployee = inp.next();
                firstName = inp.next();
                lastName = inp.next();
                email = inp.next();
                phoneNumber = inp.next();
                hireDate = inp.next();
                salary = inp.nextInt();
                comissionPct = inp.nextFloat();
                idJob = inp.next();
                idManager = inp.next();
                idDepartment = inp.next();
                System.out.println(
                    edao.update(new Employee(idEmployee,firstName,lastName,email,phoneNumber, hireDate, salary,
                    comissionPct, idJob, idManager, idDepartment))
                    ? "Update Berhasil" : "Update Gagal"
                );
                break;
            case 5:
                System.out.println("Masukan Id Employe : ");
                idEmployee = inp.next();
                System.out.println(
                    edao.delete(idEmployee) ? "Delete Berhasil" : "Delete Gagal"
                );
                break;
            case 6:
                System.out.println("Masukan data yang ingin diinput dalam format (Employee_Id First_Name Last_Name Email "
                        + "Phone_Number Hire_date Salary Comission_Pct Job_Id Manager_Id Department_Id) : ");
                idEmployee = inp.next();
                firstName = inp.next();
                lastName = inp.next();
                email = inp.next();
                phoneNumber = inp.next();
                hireDate = inp.next();
                salary = inp.nextInt();
                comissionPct = inp.nextFloat();
                idJob = inp.next();
                idManager = inp.next();
                idDepartment = inp.next();
                System.out.println(
                    edao.insertUpdate(new Employee(idEmployee,firstName,lastName,email,phoneNumber, hireDate, salary,
                    comissionPct, idJob, idManager, idDepartment))
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
