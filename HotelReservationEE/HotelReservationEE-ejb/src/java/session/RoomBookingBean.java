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
    private ArrayList<TblServices> servicesList;

    public RoomBookingBean() {
        shoppingCart = new ArrayList<TblRoom>();
        servicesList = new ArrayList<>();
    }

    @Override
    public ArrayList getContents() {
        return this.shoppingCart;
    }
    
    
    @Override
    public ArrayList getServices() {
        return this.servicesList;
    }
    

    @Override
    public boolean addRoom(Object obj) {
        TblRoom room = (TblRoom) obj;
        return shoppingCart.add(room);
    }

    @Override
    public boolean addService(Object obj) {
        TblServices service=(TblServices) obj;
        if(servicesList.contains(service)){
            return false;
        }
        else
        return servicesList.add(service);
    }
    
    @Override
    public boolean removeService(Object obj){
        TblServices service=(TblServices) obj;
        return this.servicesList.remove(service);
    }
    @Override
     public boolean removeRoom(Object obj){
        TblRoom room=(TblRoom) obj;
        return this.shoppingCart.remove(room);
    }
      @Override
    public void clearCart(){
        shoppingCart.clear();
        servicesList.clear();
    }
     

    
    
}
