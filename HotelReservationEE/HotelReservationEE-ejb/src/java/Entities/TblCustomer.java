/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TBL_CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCustomer.findAll", query = "SELECT t FROM TblCustomer t"),
    @NamedQuery(name = "TblCustomer.findByCustomerid", query = "SELECT t FROM TblCustomer t WHERE t.customerid = :customerid"),
    @NamedQuery(name = "TblCustomer.findByTitle", query = "SELECT t FROM TblCustomer t WHERE t.title = :title"),
    @NamedQuery(name = "TblCustomer.findByFname", query = "SELECT t FROM TblCustomer t WHERE t.fname = :fname"),
    @NamedQuery(name = "TblCustomer.findByLname", query = "SELECT t FROM TblCustomer t WHERE t.lname = :lname"),
    @NamedQuery(name = "TblCustomer.findByDob", query = "SELECT t FROM TblCustomer t WHERE t.dob = :dob"),
    @NamedQuery(name = "TblCustomer.findByEmail", query = "SELECT t FROM TblCustomer t WHERE t.email = :email"),
    @NamedQuery(name = "TblCustomer.findByAddressline1", query = "SELECT t FROM TblCustomer t WHERE t.addressline1 = :addressline1"),
    @NamedQuery(name = "TblCustomer.findByAddressline2", query = "SELECT t FROM TblCustomer t WHERE t.addressline2 = :addressline2"),
    @NamedQuery(name = "TblCustomer.findByCity", query = "SELECT t FROM TblCustomer t WHERE t.city = :city"),
    @NamedQuery(name = "TblCustomer.findByProvince", query = "SELECT t FROM TblCustomer t WHERE t.province = :province"),
    @NamedQuery(name = "TblCustomer.findByCountry", query = "SELECT t FROM TblCustomer t WHERE t.country = :country"),
    @NamedQuery(name = "TblCustomer.findByZip", query = "SELECT t FROM TblCustomer t WHERE t.zip = :zip")})
public class TblCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private BigDecimal customerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LNAME")
    private String lname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @Size(max = 50)
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROVINCE")
    private String province;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COUNTRY")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ZIP")
    private String zip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private Collection<TblLogin> tblLoginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private Collection<TblBooking> tblBookingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private Collection<TblCreditcard> tblCreditcardCollection;

    public TblCustomer() {
    }

    public TblCustomer(BigDecimal customerid) {
        this.customerid = customerid;
    }

    public TblCustomer(BigDecimal customerid, String title, String fname, String lname, Date dob, String email, String addressline1, String city, String province, String country, String zip) {
        this.customerid = customerid;
        this.title = title;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.email = email;
        this.addressline1 = addressline1;
        this.city = city;
        this.province = province;
        this.country = country;
        this.zip = zip;
    }

    public BigDecimal getCustomerid() {
        return customerid;
    }

    public void setCustomerid(BigDecimal customerid) {
        this.customerid = customerid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @XmlTransient
    public Collection<TblLogin> getTblLoginCollection() {
        return tblLoginCollection;
    }

    public void setTblLoginCollection(Collection<TblLogin> tblLoginCollection) {
        this.tblLoginCollection = tblLoginCollection;
    }

    @XmlTransient
    public Collection<TblBooking> getTblBookingCollection() {
        return tblBookingCollection;
    }

    public void setTblBookingCollection(Collection<TblBooking> tblBookingCollection) {
        this.tblBookingCollection = tblBookingCollection;
    }

    @XmlTransient
    public Collection<TblCreditcard> getTblCreditcardCollection() {
        return tblCreditcardCollection;
    }

    public void setTblCreditcardCollection(Collection<TblCreditcard> tblCreditcardCollection) {
        this.tblCreditcardCollection = tblCreditcardCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCustomer)) {
            return false;
        }
        TblCustomer other = (TblCustomer) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblCustomer[ customerid=" + customerid + " ]";
    }
    
}
