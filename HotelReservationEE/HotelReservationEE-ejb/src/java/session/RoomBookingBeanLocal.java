/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Entities.TblRoom;
import Entities.TblServices;
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

     boolean addService(Object obj);

   Object[] getSelectedServices();
   
  ArrayList getServices() ;

  boolean removeService(Object obj);

   boolean removeRoom(Object obj);
}
