/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT
 */
public class Bed {
    private Integer bedId;
    private Room room;
    private Boolean isempty;

    public Bed(Integer bedId, Room room, Boolean isempty) {
        this.bedId = bedId;
        this.room = room;
        this.isempty = isempty;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Boolean getIsempty() {
        return isempty;
    }

    public void setIsempty(Boolean isempty) {
        this.isempty = isempty;
    }
    
}
