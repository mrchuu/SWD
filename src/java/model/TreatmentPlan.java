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
public class TreatmentPlan {
    private PatientRecord patientRecord;
    private Service service;
    private Date createdDate;
    private Boolean isDone;
    private Date lastupDate;
    private Integer quantity;

    public TreatmentPlan(PatientRecord patientRecord, Service service, Date createdDate, Boolean isDone, Date lastupDate, Integer quantity) {
        this.patientRecord = patientRecord;
        this.service = service;
        this.createdDate = createdDate;
        this.isDone = isDone;
        this.lastupDate = lastupDate;
        this.quantity = quantity;
    }

    public PatientRecord getPatientRecord() {
        return patientRecord;
    }

    public void setPatientRecord(PatientRecord patientRecord) {
        this.patientRecord = patientRecord;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Date getLastupDate() {
        return lastupDate;
    }

    public void setLastupDate(Date lastupDate) {
        this.lastupDate = lastupDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}
