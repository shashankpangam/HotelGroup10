/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Entities.TblRoom;

/**
 *
 * @author ShashankPangam
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class Operations implements OperationsRemote, OperationsLocal {

    @javax.persistence.PersistenceContext(unitName = "HotelReservationEE-ejbPU")
    private EntityManager em;
    Query query;
    
    @Override
    public List getAllRooms() {
        query = em.createNamedQuery("TblRoom.findAll");
        return query.getResultList();
    }

    @Override
    public List getRoomsByStatus(String status) {
        query = em.createNamedQuery("TblRoom.findByStatus").setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public Object getRoomByID(BigDecimal id) {
        query = em.createNamedQuery("TblRoom.findByRoomnumber").setParameter("roomnumber", id);
        TblRoom room = (TblRoom) query.getSingleResult();
        return room;
    }

    @Override
    public List getRoomByView(String view) {
        query = em.createNamedQuery("TblRoom.findByRoomview").setParameter("roomview", view);
        return query.getResultList();
    }  
}
