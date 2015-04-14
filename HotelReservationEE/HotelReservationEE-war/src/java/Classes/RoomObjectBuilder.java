/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Entities.TblRoom;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Paramjyot
 */
public class RoomObjectBuilder {
    
    public static Object getRoom(int roomNumber, short floor, int size, String view, String bedType, short bedCount, boolean smoking, float price, String status, short capacity) {
         TblRoom room = new TblRoom();
        room.setRoomnumber(roomNumber);
        room.setFloor(floor);
        room.setRoomsize(size);
        room.setRoomview(view);
        room.setBedtype(bedType);
        room.setNoofbeds(bedCount);
        room.setSmoking(smoking);
        room.setPrice(price);
        room.setStatus(status);
        room.setCapacity(capacity);
        return room;
    }
    
}
