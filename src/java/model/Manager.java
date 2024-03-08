/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT
 */
public class Manager {
    private Integer managerId;
    private String name;
    private Department department;
    private Account account;

    public Manager(Integer managerId, String name, Department department, Account account) {
        this.managerId = managerId;
        this.name = name;
        this.department = department;
        this.account = account;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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
        return "Manager{" + "managerId=" + managerId + ", name=" + name + ", department=" + department + ", account=" + account + '}';
    }
    
}
