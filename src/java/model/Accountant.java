/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT
 */
public class Accountant {
    private Integer accounId;
    private String name;
    private Department department;
    private Account account;

    public Accountant() {
    }

    public Accountant(Integer accounId, String name, Department department, Account account) {
        this.accounId = accounId;
        this.name = name;
        this.department = department;
        this.account = account;
    }

    public Integer getAccounId() {
        return accounId;
    }

    public void setAccounId(Integer accounId) {
        this.accounId = accounId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Accountant{" + "accounId=" + accounId + ", name=" + name + ", department=" + department + ", account=" + account + '}';
    }
    
}
