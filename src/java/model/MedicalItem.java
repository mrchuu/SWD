/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT
 */
public class MedicalItem {
    private Integer medicalItemId;
    private String name;
    private String image;
    private String provider;
    private Storage storage;
    private Integer quantity;

    public MedicalItem(Integer medicalItemId, String name, String image, String provider, Storage storage, Integer quantity) {
        this.medicalItemId = medicalItemId;
        this.name = name;
        this.image = image;
        this.provider = provider;
        this.storage = storage;
        this.quantity = quantity;
    }
    public MedicalItem(Integer medicalItemId, String name, String image, String provider, Integer quantity) {
        this.medicalItemId = medicalItemId;
        this.name = name;
        this.image = image;
        this.provider = provider;
        this.storage = null;
        this.quantity = quantity;
    }

    public Integer getMedicalItemId() {
        return medicalItemId;
    }

    public void setMedicalItemId(Integer medicalItemId) {
        this.medicalItemId = medicalItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MedicalItem{" + "medicalItemId=" + medicalItemId + ", name=" + name + ", image=" + image + ", provider=" + provider + ", storage=" + storage + ", quantity=" + quantity + '}';
    }
    
}
