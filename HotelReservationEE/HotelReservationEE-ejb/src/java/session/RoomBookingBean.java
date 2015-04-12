/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Entities.TblRoom;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author meenakshimehta
 */
@Stateful
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class RoomBookingBean implements RoomBookingBeanRemote, RoomBookingBeanLocal {

    @javax.persistence.PersistenceContext(unitName = "HotelReservationEE-ejbPU")
    private EntityManager em;
    Query query;
    private ArrayList<TblRoom> shoppingCart;
    private ArrayList servicesList;

    public RoomBookingBean() {
        shoppingCart = new ArrayList<TblRoom>();
        servicesList = new ArrayList();
    }

    @Override
    public List getContents() {
        Query shop = em.createNamedQuery("TblRoom.findByRoomnumber", TblRoom.class);
        return shop.getResultList();
    }

    @Override
    public boolean addRoom(Object obj) {
        TblRoom room = (TblRoom) obj;
        return shoppingCart.add(room);
    }

    @Override
    public void addService(String service) {
        servicesList.add(service);
    }

}
