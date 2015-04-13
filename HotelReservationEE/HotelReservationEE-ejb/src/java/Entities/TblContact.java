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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONTACTID")
    private Integer contactid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private Integer phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "MESSAGE")
    private String message;

    public TblContact() {
    }

    public TblContact(Integer contactid) {
        this.contactid = contactid;
    }

    public TblContact(Integer contactid, String name, String email, String message) {
        this.contactid = contactid;
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
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
