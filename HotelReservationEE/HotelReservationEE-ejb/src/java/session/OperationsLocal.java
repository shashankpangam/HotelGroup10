/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ShashankPangam
 */
@Local
public interface OperationsLocal {

    List getAllRooms();

    List getRoomsByStatus(String status);

    Object getRoomByID(BigDecimal id);

    List getRoomByView(String view);
    
}