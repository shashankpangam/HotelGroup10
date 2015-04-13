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

    boolean addService(String service);

    boolean removeRoom(Object obj);

    boolean removeService(String obj);
}
