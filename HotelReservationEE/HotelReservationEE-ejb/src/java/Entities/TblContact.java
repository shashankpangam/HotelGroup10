/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author meenakshimehta
 */
@Entity
@Table(name = "TBL_CONTACT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblContact.findAll", query = "SELECT t FROM TblContact t"),
    @NamedQuery(name = "TblContact.findByContactid", query = "SELECT t FROM TblContact t WHERE t.contactid = :contactid"),
    @NamedQuery(name = "TblContact.findByName", query = "SELECT t FROM TblContact t WHERE t.name = :name"),
    @NamedQuery(name = "TblContact.findByEmail", query = "SELECT t FROM TblContact t WHERE t.email = :email"),
    @NamedQuery(name = "TblContact.findByPhone", query = "SELECT t FROM TblContact t WHERE t.phone = :phone"),
    @NamedQuery(name = "TblContact.findByMessage", query = "SELECT t FROM TblContact t WHERE t.message = :message")})
public class TblContact implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "CONTACT_SEQ", sequenceName = "CONTACT_SEQ",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_SEQ")
    @Column(name = "CONTACTID")
    private BigDecimal contactid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 10)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 200)
    @Column(name = "MESSAGE")
    private String message;

    public TblContact() {
    }

    public TblContact(BigDecimal contactid) {
        this.contactid = contactid;
    }

    public TblContact(BigDecimal contactid, String name, String email) {
        this.contactid = contactid;
        this.name = name;
        this.email = email;
    }

    public BigDecimal getContactid() {
        return contactid;
    }

    public void setContactid(BigDecimal contactid) {
        this.contactid = contactid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactid != null ? contactid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblContact)) {
            return false;
        }
        TblContact other = (TblContact) object;
        if ((this.contactid == null && other.contactid != null) || (this.contactid != null && !this.contactid.equals(other.contactid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblContact[ contactid=" + contactid + " ]";
    }
    
}
