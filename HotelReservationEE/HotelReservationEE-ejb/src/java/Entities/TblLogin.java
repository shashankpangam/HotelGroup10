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
@Table(name = "TBL_LOGIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblLogin.findAll", query = "SELECT t FROM TblLogin t"),
    @NamedQuery(name = "TblLogin.findByLoginid", query = "SELECT t FROM TblLogin t WHERE t.loginid = :loginid"),
    @NamedQuery(name = "TblLogin.findByEmail", query = "SELECT t FROM TblLogin t WHERE t.email = :email"),
    @NamedQuery(name = "TblLogin.findByPassword", query = "SELECT t FROM TblLogin t WHERE t.password = :password"),
    @NamedQuery(name = "TblLogin.findByLogintype", query = "SELECT t FROM TblLogin t WHERE t.logintype = :logintype"),
    @NamedQuery(name = "TblLogin.findByLastlogin", query = "SELECT t FROM TblLogin t WHERE t.lastlogin = :lastlogin")})
public class TblLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOGINID")
    private Integer loginid;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOGINTYPE")
    private String logintype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LASTLOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogin;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne(optional = false)
    private TblCustomer customerid;

    public TblLogin() {
    }

    public TblLogin(Integer loginid) {
        this.loginid = loginid;
    }

    public TblLogin(Integer loginid, String email, String password, String logintype, Date lastlogin) {
        this.loginid = loginid;
        this.email = email;
        this.password = password;
        this.logintype = logintype;
        this.lastlogin = lastlogin;
    }

    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
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
        hash += (loginid != null ? loginid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLogin)) {
            return false;
        }
        TblLogin other = (TblLogin) object;
        if ((this.loginid == null && other.loginid != null) || (this.loginid != null && !this.loginid.equals(other.loginid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblLogin[ loginid=" + loginid + " ]";
    }
    
}
