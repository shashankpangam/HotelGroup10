<%-- 
    Document   : bookingSidebar
    Created on : 27-Mar-2015, 12:15:37 AM
    Author     : meenakshimehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="box maxheight">
          <div class="inner">
            <h3>Reservation:</h3>
            <form action="RoomBooking.jsp" id="reservation-form">
              <fieldset>
              <div class="field">
                <label>Check In:</label>
                <input type="date" name="checkIndate" style="width:120px;" />        
              </div><br/>
              <div class="field">
                <label>Check Out:</label>
                <input type="date" name="checkOutdate" style="width:120px;" />     
              </div><br/>
              <div class="field"> 
                  <label>No. of Persons: </label>
                <input type="text" name="person" style="width:120px;" />
              </div>
             
              <input type="submit" name="action" value="Check Availability" style="width:150px"/>
              </fieldset>
            </form>
          </div>
        </div>
