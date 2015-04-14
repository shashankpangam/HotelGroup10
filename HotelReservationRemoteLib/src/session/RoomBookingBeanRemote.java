/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author meenakshimehta
 */
@Remote
public interface RoomBookingBeanRemote {

    boolean addRoom(Object room);

    List getContents();

    boolean addService(Object obj);

    ArrayList getServices();

    boolean removeService(Object obj);

    boolean removeRoom(Object obj);

    void clearCart();

    boolean addNewBooking(Object obj);
}
