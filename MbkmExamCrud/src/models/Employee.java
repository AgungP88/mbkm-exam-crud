/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class Employee {
    private int salary;
    private String id, firstName, lastName, email, phoneNumber, job, manager, department, hireDate;
    private float commission;
    
    public Employee(){
        
    }
    
    public Employee(String Id, String FirstName, String LastName, String Email, String PhoneNumber,
            String HireDate, int Salary, float Commission, String Job, String Manager, String Department){
        this.id = Id;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.email = Email;
        this.phoneNumber = PhoneNumber;
        this.hireDate = HireDate;
        this.salary = Salary;
        this.commission = Commission;
        this.job = Job;
        this.manager = Manager;
        this.department = Department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int Salary) {
        this.salary = Salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.phoneNumber = PhoneNumber;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String Job) {
        this.job = Job;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String Manager) {
        this.manager = Manager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String Department) {
        this.department = Department;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String HireDate) {
        this.hireDate = HireDate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float Commission) {
        this.commission = Commission;
    }
    
}
