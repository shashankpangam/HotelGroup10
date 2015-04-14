/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Entities.TblCreditcard;
import Entities.TblCustomer;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ShashankPangam
 */
@Local
public interface UserOperationsLocal {

    Object login(String username, String password);

    Object getCustomerDetails(BigDecimal CustomerID);

    int insertNewUser(Object user);

    boolean insertCreditCard(Object creditCard, Object customer);

    Object getCreditCardDetails(BigDecimal customerID);

    boolean insertNewLogin(Object user);

    Object getCustomerById(int id);

    List getBookingsByCustomerId(Object customerid);

    Object getBookingById(int id);

    boolean deleteBooking(int bookingid);
    
}
