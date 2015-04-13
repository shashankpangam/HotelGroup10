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
@Table(name = "TBL_SERVICES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServices.findAll", query = "SELECT t FROM TblServices t"),
    @NamedQuery(name = "TblServices.findByServiceid", query = "SELECT t FROM TblServices t WHERE t.serviceid = :serviceid"),
    @NamedQuery(name = "TblServices.findByName", query = "SELECT t FROM TblServices t WHERE t.name = :name"),
    @NamedQuery(name = "TblServices.findByPrice", query = "SELECT t FROM TblServices t WHERE t.price = :price")})
public class TblServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICEID")
    private Integer serviceid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private float price;

    public TblServices() {
    }

    public TblServices(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public TblServices(Integer serviceid, String name, float price) {
        this.serviceid = serviceid;
        this.name = name;
        this.price = price;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
