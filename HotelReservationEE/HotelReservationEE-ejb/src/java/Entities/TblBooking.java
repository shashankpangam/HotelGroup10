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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "TblBooking.findByNoofpeople", query = "SELECT t FROM TblBooking t WHERE t.noofpeople = :noofpeople"),
    @NamedQuery(name = "TblBooking.findByDatefrom", query = "SELECT t FROM TblBooking t WHERE t.datefrom = :datefrom"),
    @NamedQuery(name = "TblBooking.findByDateto", query = "SELECT t FROM TblBooking t WHERE t.dateto = :dateto"),
    @NamedQuery(name = "TblBooking.findByStatus", query = "SELECT t FROM TblBooking t WHERE t.status = :status")})
public class TblBooking implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKINGID")
    private BigDecimal bookingid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOOFPEOPLE")
    private BigInteger noofpeople;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEFROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATETO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STATUS")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingid")
    private Collection<TblServices> tblServicesCollection;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne(optional = false)
    private TblCustomer customerid;
    @JoinColumn(name = "ROOMNUMBER", referencedColumnName = "ROOMNUMBER")
    @ManyToOne(optional = false)
    private TblRoom roomnumber;

    public TblBooking() {
    }

    public TblBooking(BigDecimal bookingid) {
        this.bookingid = bookingid;
    }

    public TblBooking(BigDecimal bookingid, BigInteger noofpeople, Date datefrom, Date dateto, String status) {
        this.bookingid = bookingid;
        this.noofpeople = noofpeople;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.status = status;
    }

    public BigDecimal getBookingid() {
        return bookingid;
    }

    public void setBookingid(BigDecimal bookingid) {
        this.bookingid = bookingid;
    }

    public BigInteger getNoofpeople() {
        return noofpeople;
    }

    public void setNoofpeople(BigInteger noofpeople) {
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

    @XmlTransient
    public Collection<TblServices> getTblServicesCollection() {
        return tblServicesCollection;
    }

    public void setTblServicesCollection(Collection<TblServices> tblServicesCollection) {
        this.tblServicesCollection = tblServicesCollection;
    }

    public TblCustomer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(TblCustomer customerid) {
        this.customerid = customerid;
    }

    public TblRoom getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(TblRoom roomnumber) {
        this.roomnumber = roomnumber;
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
