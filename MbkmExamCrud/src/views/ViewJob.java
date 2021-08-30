/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import daos.JobDAO;
import java.util.Scanner;
import models.Job;
import tools.DBConnection;
import tools.MBKM_CRUD;

/**
 *
 * @author hp
 */
public class ViewJob {
    DBConnection dbc = new DBConnection();
    Scanner inp = new Scanner(System.in);
    JobDAO jdao = new JobDAO(dbc.getConnection());
    MBKM_CRUD menuHR=new MBKM_CRUD();
    
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
                System.out.println("Apakah anda yakin ingin hapus? (ya/tidak) ");
                String opsi=inp.next();
                if(opsi.equalsIgnoreCase("ya")){
                    System.out.println(jdao.delete(idJob) ? "Delete Berhasil" : "Delete Gagal"
                    );}
                    else{
                        System.out.println("data gagal dihapus");
                    }                    
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
