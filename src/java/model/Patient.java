/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author FPT
 */
public class Patient {
    private Integer patientId;
    private String name;
    private String socialId;
    private String address;
    private String phone;
    private Date createdAt;
    private Account account;

    public Patient(Integer patientId, String name, String socialId, String address, String phone, Date createdAt, Account account) {
        this.patientId = patientId;
        this.name = name;
        this.socialId = socialId;
        this.address = address;
        this.phone = phone;
        this.createdAt = createdAt;
        this.account = account;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Patient{" + "patientId=" + patientId + ", name=" + name + ", socialId=" + socialId + ", address=" + address + ", phone=" + phone + ", createdAt=" + createdAt + ", account=" + account + '}';
    }
    
}
