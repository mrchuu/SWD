/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT
 */
public class Storage {
    private Integer storageId;
    private String storageCode;
    private Department department;

    public Storage(Integer storageId, String storageCode, Department department) {
        this.storageId = storageId;
        this.storageCode = storageCode;
        this.department = department;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Storage{" + "storageId=" + storageId + ", storageCode=" + storageCode + ", department=" + department + '}';
    }
    
}
