/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "TblRoom.findByRoomsize", query = "SELECT t FROM TblRoom t WHERE t.roomsize = :roomsize"),
    @NamedQuery(name = "TblRoom.findByRoomview", query = "SELECT t FROM TblRoom t WHERE t.roomview = :roomview"),
    @NamedQuery(name = "TblRoom.findByBedtype", query = "SELECT t FROM TblRoom t WHERE t.bedtype = :bedtype"),
    @NamedQuery(name = "TblRoom.findByNoofbeds", query = "SELECT t FROM TblRoom t WHERE t.noofbeds = :noofbeds"),
    @NamedQuery(name = "TblRoom.findByConnecting", query = "SELECT t FROM TblRoom t WHERE t.connecting = :connecting"),
    @NamedQuery(name = "TblRoom.findBySmoking", query = "SELECT t FROM TblRoom t WHERE t.smoking = :smoking"),
    @NamedQuery(name = "TblRoom.findByPrice", query = "SELECT t FROM TblRoom t WHERE t.price = :price")})
public class TblRoom implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOMNUMBER")
    private BigDecimal roomnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLOOR")
    private BigInteger floor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOMSIZE")
    private BigInteger roomsize;
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
    private BigInteger noofbeds;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONNECTING")
    private BigInteger connecting;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SMOKING")
    private BigInteger smoking;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomnumber")
    private Collection<TblBooking> tblBookingCollection;

    public TblRoom() {
    }

    public TblRoom(BigDecimal roomnumber) {
        this.roomnumber = roomnumber;
    }

    public TblRoom(BigDecimal roomnumber, BigInteger floor, BigInteger roomsize, String roomview, String bedtype, BigInteger noofbeds, BigInteger connecting, BigInteger smoking, double price) {
        this.roomnumber = roomnumber;
        this.floor = floor;
        this.roomsize = roomsize;
        this.roomview = roomview;
        this.bedtype = bedtype;
        this.noofbeds = noofbeds;
        this.connecting = connecting;
        this.smoking = smoking;
        this.price = price;
    }

    public BigDecimal getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(BigDecimal roomnumber) {
        this.roomnumber = roomnumber;
    }

    public BigInteger getFloor() {
        return floor;
    }

    public void setFloor(BigInteger floor) {
        this.floor = floor;
    }

    public BigInteger getRoomsize() {
        return roomsize;
    }

    public void setRoomsize(BigInteger roomsize) {
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

    public BigInteger getNoofbeds() {
        return noofbeds;
    }

    public void setNoofbeds(BigInteger noofbeds) {
        this.noofbeds = noofbeds;
    }

    public BigInteger getConnecting() {
        return connecting;
    }

    public void setConnecting(BigInteger connecting) {
        this.connecting = connecting;
    }

    public BigInteger getSmoking() {
        return smoking;
    }

    public void setSmoking(BigInteger smoking) {
        this.smoking = smoking;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<TblBooking> getTblBookingCollection() {
        return tblBookingCollection;
    }

    public void setTblBookingCollection(Collection<TblBooking> tblBookingCollection) {
        this.tblBookingCollection = tblBookingCollection;
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
