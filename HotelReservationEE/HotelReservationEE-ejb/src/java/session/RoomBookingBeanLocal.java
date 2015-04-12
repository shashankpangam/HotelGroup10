/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Entities.TblRoom;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author meenakshimehta
 */
@Local
public interface RoomBookingBeanLocal {

    boolean addRoom(Object room);

    List getContents();

    void addService(String service);
}
