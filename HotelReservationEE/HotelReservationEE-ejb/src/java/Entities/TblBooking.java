/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ShashankPangam
 */
@Entity
@Table(name = "TBL_BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBooking.findAll", query = "SELECT t FROM TblBooking t"),
    @NamedQuery(name = "TblBooking.findByBookingid", query = "SELECT t FROM TblBooking t WHERE t.bookingid = :bookingid"),
    @NamedQuery(name = "TblBooking.findByRoomnumber", query = "SELECT t FROM TblBooking t WHERE t.roomnumber = :roomnumber"),
    @NamedQuery(name = "TblBooking.findByServices", query = "SELECT t FROM TblBooking t WHERE t.services = :services"),
    @NamedQuery(name = "TblBooking.findByNoofpeople", query = "SELECT t FROM TblBooking t WHERE t.noofpeople = :noofpeople"),
    @NamedQuery(name = "TblBooking.findByDatefrom", query = "SELECT t FROM TblBooking t WHERE t.datefrom = :datefrom"),
    @NamedQuery(name = "TblBooking.findByDateto", query = "SELECT t FROM TblBooking t WHERE t.dateto = :dateto"),
    @NamedQuery(name = "TblBooking.findByStatus", query = "SELECT t FROM TblBooking t WHERE t.status = :status"),
    @NamedQuery(name = "TblBooking.findByTotal", query = "SELECT t FROM TblBooking t WHERE t.total = :total")})
public class TblBooking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKINGID")
    private Integer bookingid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROOMNUMBER")
    private String roomnumber;
    @Size(max = 100)
    @Column(name = "SERVICES")
    private String services;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOOFPEOPLE")
    private short noofpeople;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEFROM")
    @Temporal(TemporalType.DATE)
    private Date datefrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATETO")
    @Temporal(TemporalType.DATE)
    private Date dateto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private float total;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne(optional = false)
    private TblCustomer customerid;

    public TblBooking() {
    }

    public TblBooking(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public TblBooking(Integer bookingid, String roomnumber, short noofpeople, Date datefrom, Date dateto, String status, float total) {
        this.bookingid = bookingid;
        this.roomnumber = roomnumber;
        this.noofpeople = noofpeople;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.status = status;
        this.total = total;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public short getNoofpeople() {
        return noofpeople;
    }

    public void setNoofpeople(short noofpeople) {
        this.noofpeople = noofpeople;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public TblCustomer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(TblCustomer customerid) {
        this.customerid = customerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBooking)) {
            return false;
        }
        TblBooking other = (TblBooking) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblBooking[ bookingid=" + bookingid + " ]";
    }
    
}
