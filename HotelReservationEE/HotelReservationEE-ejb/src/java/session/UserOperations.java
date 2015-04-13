/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Entities.TblCreditcard;
import Entities.TblCustomer;
import Entities.TblLogin;
import java.math.BigDecimal;
import java.util.Iterator;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author ShashankPangam
 */
@Stateful
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class UserOperations implements UserOperationsRemote, UserOperationsLocal {

    @javax.persistence.PersistenceContext(unitName = "HotelReservationEE-ejbPU")
    private EntityManager em;
    Query query;

    @Override
    public Object login(String username, String password) {
        query = em.createNamedQuery("TblLogin.findbyLogin").setParameter("email", username).setParameter("password", password);
        try {
            TblLogin userFound = (TblLogin) query.getSingleResult();
            return userFound;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Object getCustomerDetails(BigDecimal CustomerID) {
        query = em.createNamedQuery("TblCustomer.findByCustomerid").setParameter("customerid", CustomerID);
        try {
            TblCustomer user = (TblCustomer) query.getSingleResult();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean insertNewUser(Object user) {
        try {
            TblCustomer customer = (TblCustomer) user;
            em.persist(customer);
            return true;
        } catch (EJBException e) {
            @SuppressWarnings("ThrowableResultIgnored")
            Exception cause = e.getCausedByException();
            if (cause instanceof ConstraintViolationException) {
                @SuppressWarnings("ThrowableResultIgnored")
                ConstraintViolationException cve = (ConstraintViolationException) e.getCausedByException();
                for (Iterator<ConstraintViolation<?>> it = cve.getConstraintViolations().iterator(); it.hasNext();) {
                    ConstraintViolation<? extends Object> v = it.next();
                    System.err.println(v);
                    System.err.println("==>>" + v.getMessage());
                }
            }
            return false;
        }
    }

    @Override
    public boolean insertCreditCard(Object creditCard, Object customer) {
        try {
            TblCreditcard cc = (TblCreditcard) creditCard;
            TblCustomer cust = (TblCustomer) customer;
            cc.setCustomerid(cust);
            em.persist(cc);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public Object getCreditCardDetails(BigDecimal customerID) {
        try {
            query = em.createNamedQuery("TblCreditcard.findByCustomerID").setParameter("customerid", customerID);
            TblCreditcard cc = (TblCreditcard) query.getSingleResult();
            return cc;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
