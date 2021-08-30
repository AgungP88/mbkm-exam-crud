/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import daos.EmployeeDAO;
import java.util.Scanner;
import models.Employee;
import tools.DBConnection;
import tools.MBKM_CRUD;

/**
 *
 * @author hp
 */
public class ViewEmployee {
    DBConnection dbc = new DBConnection();
    Scanner inp = new Scanner(System.in);
    EmployeeDAO edao = new EmployeeDAO(dbc.getConnection());
    MBKM_CRUD menuHR=new MBKM_CRUD();
    
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
