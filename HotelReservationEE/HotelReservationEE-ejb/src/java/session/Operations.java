/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Entities.TblContact;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Entities.TblRoom;
import Entities.TblServices;
import java.util.ArrayList;
import java.util.Date;

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
    public Object getRoomByID(int id) {
        query = em.createNamedQuery("TblRoom.findByRoomnumber").setParameter("roomnumber", id);
        TblRoom room = (TblRoom) query.getSingleResult();
        return room;
    }

    @Override
    public Object getServiceByID(Integer id) {
        query = em.createNamedQuery("TblServices.findByServiceid").setParameter("serviceid", id);
        TblServices service = (TblServices) query.getSingleResult();
        return service;
    }

    @Override
    public List getRoomByView(String view) {
        query = em.createNamedQuery("TblRoom.findByRoomview").setParameter("roomview", view);
        return query.getResultList();
    }  
    
    

    @Override
    public String contact(String name, String email,String phone, String message) {
           TblContact contact = new TblContact();
           try {
            contact.setName(name);
            contact.setEmail(email);
            contact.setPhone(phone);
            contact.setMessage(message);
            em.persist(contact);
            return null;
        } catch (Exception ex) {
            return ex.toString();
        }

    }

    @Override
    public List getAllServices() {
        query = em.createNamedQuery("TblServices.findAll");
        return query.getResultList();
    }

    @Override
    public void addRoom(Object room) {
        em.persist((TblRoom) room);
    }

    @Override
    public void editRoom(Object room) {
        em.merge((TblRoom) room);
    }

    @Override
    public void deleteRoom(int roomNumber) {
        TblRoom room = em.find(TblRoom.class, roomNumber);
        em.remove(room);
    }

    @Override
    public List generateReport(Date startDate, Date endDate) {
        query = em.createNamedQuery("TblBooking.findByDateRange").setParameter("startDate", startDate).setParameter("endDate", endDate);
        return query.getResultList();
    }

    @Override
    public List generateStatusReport(short floor, String status) {
//        query = em.createNamedQuery("TblBooking.findByStatusFloor").setParameter("floor",floor).setParameter("status",status);
        query = em.createNamedQuery("TblBooking.findByStatus").setParameter("status", status);
        return query.getResultList();
    }
}
