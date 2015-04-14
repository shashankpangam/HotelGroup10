/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ShashankPangam
 */
@Remote
public interface OperationsRemote {

    List getAllRooms();

    List getRoomsByStatus(String status);

    Object getRoomByID(int id);

    List getRoomByView(String view);

    String contact(String name, String email, String phone, String message);

    Object getServiceByID(Integer id);

    List getAllServices();

    void addRoom(Object room);

    void editRoom(Object room);

    void deleteRoom(int room);

    List generateReport(Date startDate, Date endDate);

    List generateStatusReport(short floor, String status);

}
