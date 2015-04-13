/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ShashankPangam
 */
@Entity
@Table(name = "TBL_ROOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRoom.findAll", query = "SELECT t FROM TblRoom t"),
    @NamedQuery(name = "TblRoom.findByRoomnumber", query = "SELECT t FROM TblRoom t WHERE t.roomnumber = :roomnumber"),
    @NamedQuery(name = "TblRoom.findByFloor", query = "SELECT t FROM TblRoom t WHERE t.floor = :floor"),
    @NamedQuery(name = "TblRoom.findByCapacity", query = "SELECT t FROM TblRoom t WHERE t.capacity = :capacity"),
    @NamedQuery(name = "TblRoom.findByRoomsize", query = "SELECT t FROM TblRoom t WHERE t.roomsize = :roomsize"),
    @NamedQuery(name = "TblRoom.findByRoomview", query = "SELECT t FROM TblRoom t WHERE t.roomview = :roomview"),
    @NamedQuery(name = "TblRoom.findByBedtype", query = "SELECT t FROM TblRoom t WHERE t.bedtype = :bedtype"),
    @NamedQuery(name = "TblRoom.findByNoofbeds", query = "SELECT t FROM TblRoom t WHERE t.noofbeds = :noofbeds"),
    @NamedQuery(name = "TblRoom.findBySmoking", query = "SELECT t FROM TblRoom t WHERE t.smoking = :smoking"),
    @NamedQuery(name = "TblRoom.findByPrice", query = "SELECT t FROM TblRoom t WHERE t.price = :price")})
public class TblRoom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOMNUMBER")
    private Integer roomnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLOOR")
    private short floor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITY")
    private short capacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOMSIZE")
    private int roomsize;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROOMVIEW")
    private String roomview;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "BEDTYPE")
    private String bedtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOOFBEDS")
    private short noofbeds;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SMOKING")
    private boolean smoking;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private float price;

    public TblRoom() {
    }

    public TblRoom(Integer roomnumber) {
        this.roomnumber = roomnumber;
    }

    public TblRoom(Integer roomnumber, short floor, short capacity, int roomsize, String roomview, String bedtype, short noofbeds, boolean smoking, float price) {
        this.roomnumber = roomnumber;
        this.floor = floor;
        this.capacity = capacity;
        this.roomsize = roomsize;
        this.roomview = roomview;
        this.bedtype = bedtype;
        this.noofbeds = noofbeds;
        this.smoking = smoking;
        this.price = price;
    }

    public Integer getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(Integer roomnumber) {
        this.roomnumber = roomnumber;
    }

    public short getFloor() {
        return floor;
    }

    public void setFloor(short floor) {
        this.floor = floor;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public int getRoomsize() {
        return roomsize;
    }

    public void setRoomsize(int roomsize) {
        this.roomsize = roomsize;
    }

    public String getRoomview() {
        return roomview;
    }

    public void setRoomview(String roomview) {
        this.roomview = roomview;
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    public short getNoofbeds() {
        return noofbeds;
    }

    public void setNoofbeds(short noofbeds) {
        this.noofbeds = noofbeds;
    }

    public boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomnumber != null ? roomnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRoom)) {
            return false;
        }
        TblRoom other = (TblRoom) object;
        if ((this.roomnumber == null && other.roomnumber != null) || (this.roomnumber != null && !this.roomnumber.equals(other.roomnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblRoom[ roomnumber=" + roomnumber + " ]";
    }
    
}
