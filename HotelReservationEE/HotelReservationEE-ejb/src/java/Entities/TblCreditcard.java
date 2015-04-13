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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TBL_CREDITCARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCreditcard.findAll", query = "SELECT t FROM TblCreditcard t"),
    @NamedQuery(name = "TblCreditcard.findByCreditcardid", query = "SELECT t FROM TblCreditcard t WHERE t.creditcardid = :creditcardid"),
    @NamedQuery(name = "TblCreditcard.findByCardtype", query = "SELECT t FROM TblCreditcard t WHERE t.cardtype = :cardtype"),
    @NamedQuery(name = "TblCreditcard.findByCardnumber", query = "SELECT t FROM TblCreditcard t WHERE t.cardnumber = :cardnumber"),
    @NamedQuery(name = "TblCreditcard.findByExpmonth", query = "SELECT t FROM TblCreditcard t WHERE t.expmonth = :expmonth"),
    @NamedQuery(name = "TblCreditcard.findByExpyear", query = "SELECT t FROM TblCreditcard t WHERE t.expyear = :expyear")})
public class TblCreditcard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CREDITCARDID")
    private Integer creditcardid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CARDTYPE")
    private String cardtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CARDNUMBER")
    private String cardnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXPMONTH")
    private short expmonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXPYEAR")
    private short expyear;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne(optional = false)
    private TblCustomer customerid;

    public TblCreditcard() {
    }

    public TblCreditcard(Integer creditcardid) {
        this.creditcardid = creditcardid;
    }

    public TblCreditcard(Integer creditcardid, String cardtype, String cardnumber, short expmonth, short expyear) {
        this.creditcardid = creditcardid;
        this.cardtype = cardtype;
        this.cardnumber = cardnumber;
        this.expmonth = expmonth;
        this.expyear = expyear;
    }

    public Integer getCreditcardid() {
        return creditcardid;
    }

    public void setCreditcardid(Integer creditcardid) {
        this.creditcardid = creditcardid;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public short getExpmonth() {
        return expmonth;
    }

    public void setExpmonth(short expmonth) {
        this.expmonth = expmonth;
    }

    public short getExpyear() {
        return expyear;
    }

    public void setExpyear(short expyear) {
        this.expyear = expyear;
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
        hash += (creditcardid != null ? creditcardid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCreditcard)) {
            return false;
        }
        TblCreditcard other = (TblCreditcard) object;
        if ((this.creditcardid == null && other.creditcardid != null) || (this.creditcardid != null && !this.creditcardid.equals(other.creditcardid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblCreditcard[ creditcardid=" + creditcardid + " ]";
    }
    
}
