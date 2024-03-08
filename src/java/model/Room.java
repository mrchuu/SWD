/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT
 */
public class Room {
    private Integer roomId;
    private String roommCode;
    private Department department;

    public Room(Integer roomId, String roommCode, Department department) {
        this.roomId = roomId;
        this.roommCode = roommCode;
        this.department = department;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoommCode() {
        return roommCode;
    }

    public void setRoommCode(String roommCode) {
        this.roommCode = roommCode;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
}
