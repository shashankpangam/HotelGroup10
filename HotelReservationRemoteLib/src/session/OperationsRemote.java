/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.math.BigDecimal;
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

    Object getServiceByID(Integer id);

    String contact(String name, String email, int phone, String message);

    List getAllServices();

}
