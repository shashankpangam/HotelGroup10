/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ShashankPangam
 */
@Entity
@Table(name = "TBL_SERVICES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServices.findAll", query = "SELECT t FROM TblServices t"),
    @NamedQuery(name = "TblServices.findByServiceid", query = "SELECT t FROM TblServices t WHERE t.serviceid = :serviceid"),
    @NamedQuery(name = "TblServices.findByWifi", query = "SELECT t FROM TblServices t WHERE t.wifi = :wifi"),
    @NamedQuery(name = "TblServices.findByAircondition", query = "SELECT t FROM TblServices t WHERE t.aircondition = :aircondition"),
    @NamedQuery(name = "TblServices.findByConnectingroom", query = "SELECT t FROM TblServices t WHERE t.connectingroom = :connectingroom"),
    @NamedQuery(name = "TblServices.findByCrib", query = "SELECT t FROM TblServices t WHERE t.crib = :crib"),
    @NamedQuery(name = "TblServices.findByBreakfast", query = "SELECT t FROM TblServices t WHERE t.breakfast = :breakfast")})
public class TblServices implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICEID")
    private BigDecimal serviceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WIFI")
    private BigInteger wifi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AIRCONDITION")
    private BigInteger aircondition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONNECTINGROOM")
    private BigInteger connectingroom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CRIB")
    private BigInteger crib;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BREAKFAST")
    private BigInteger breakfast;
    @JoinColumn(name = "BOOKINGID", referencedColumnName = "BOOKINGID")
    @ManyToOne(optional = false)
    private TblBooking bookingid;

    public TblServices() {
    }

    public TblServices(BigDecimal serviceid) {
        this.serviceid = serviceid;
    }

    public TblServices(BigDecimal serviceid, BigInteger wifi, BigInteger aircondition, BigInteger connectingroom, BigInteger crib, BigInteger breakfast) {
        this.serviceid = serviceid;
        this.wifi = wifi;
        this.aircondition = aircondition;
        this.connectingroom = connectingroom;
        this.crib = crib;
        this.breakfast = breakfast;
    }

    public BigDecimal getServiceid() {
        return serviceid;
    }

    public void setServiceid(BigDecimal serviceid) {
        this.serviceid = serviceid;
    }

    public BigInteger getWifi() {
        return wifi;
    }

    public void setWifi(BigInteger wifi) {
        this.wifi = wifi;
    }

    public BigInteger getAircondition() {
        return aircondition;
    }

    public void setAircondition(BigInteger aircondition) {
        this.aircondition = aircondition;
    }

    public BigInteger getConnectingroom() {
        return connectingroom;
    }

    public void setConnectingroom(BigInteger connectingroom) {
        this.connectingroom = connectingroom;
    }

    public BigInteger getCrib() {
        return crib;
    }

    public void setCrib(BigInteger crib) {
        this.crib = crib;
    }

    public BigInteger getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(BigInteger breakfast) {
        this.breakfast = breakfast;
    }

    public TblBooking getBookingid() {
        return bookingid;
    }

    public void setBookingid(TblBooking bookingid) {
        this.bookingid = bookingid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceid != null ? serviceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServices)) {
            return false;
        }
        TblServices other = (TblServices) object;
        if ((this.serviceid == null && other.serviceid != null) || (this.serviceid != null && !this.serviceid.equals(other.serviceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblServices[ serviceid=" + serviceid + " ]";
    }
    
}
