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
public class PatientRecord {
    private Integer recordId;
    private RecordStatus recordStatus;
    private Patient patient;
    private Date createdAt;
    private Date lastUpdate;
    private Doctor doctor;

    public PatientRecord(Integer recordId, RecordStatus recordStatus, Patient patient, Date createdAt, Date lastUpdate, Doctor doctor) {
        this.recordId = recordId;
        this.recordStatus = recordStatus;
        this.patient = patient;
        this.createdAt = createdAt;
        this.lastUpdate = lastUpdate;
        this.doctor = doctor;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
}
